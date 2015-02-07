package edu.depaul.capstone.demo.rest.resource.soda;

import edu.depaul.capstone.demo.rest.service.QueryService;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.OrderByClause;
import com.socrata.model.soql.SoqlQuery;
import com.socrata.model.soql.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by adampodraza on 2/3/15.
 *
 * Resource controller takes requests and returns either a List of java objects or a Json string
 *
 */
@Component
@Path("/soda")
public class SodaResource {

    private SoqlQuery soqlQuery;

    @Autowired
    private QueryService queryService;


    //Get method to return all food inspections as json string
    @GET
    @Path("food_inspection")
    @Produces(value = {"text/plain"})
    public String getFoodInspectionQuery() throws InterruptedException, SodaError, LongRunningQueryException {

        System.out.println(queryService);
//        //I had to hard code these values because the uri builder was angry with the references to app.properties
//        queryService = new QueryServiceImpl("https://data.cityofchicago.org",
//                "tomislavmitic2012@u.northwestern.edu",
//                "mun1ak0t!",
//                "65wCRYQKFBPj7OPFrNrG821Yr");

        return queryService.executeQuery("4ijn-s7e5", SoqlQuery.SELECT_ALL);
    }

    //returns a list of food inspection objects, takes parameter "limit" to specify how many are returned
    @GET
    @Path("food_inspection_list")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<FoodInspection> getFoodInspectionListQuery(


            @DefaultValue("5") @QueryParam("limit") Integer limit) throws InterruptedException, SodaError {


        soqlQuery = new SoqlQueryBuilder()
                .setLimit(limit)
                .addOrderByPhrase(new OrderByClause(SortOrder.Descending, "inspection_date"))
                .build();

        //hardcoded parameters for query service
//        queryService = new QueryServiceImpl("https://data.cityofchicago.org",
//                "tomislavmitic2012@u.northwestern.edu",
//                "mun1ak0t!",
//                "65wCRYQKFBPj7OPFrNrG821Yr");

        return queryService.executeQuery("4ijn-s7e5", soqlQuery, FoodInspection.LIST_TYPE);

    }

    //get method to return all crimes as json string
    @GET
    @Path("crime")
    @Produces(value = {"text/plain"})
    public String getCrimeQuery() throws LongRunningQueryException, SodaError {

        //hardcoded
//        queryService = new QueryServiceImpl("https://data.cityofchicago.org",
//                "tomislavmitic2012@u.northwestern.edu",
//                "mun1ak0t!",
//                "65wCRYQKFBPj7OPFrNrG821Yr");

        return queryService.executeQuery("ijzp-q8t2", SoqlQuery.SELECT_ALL);
    }

    //returns a list of crime objects, takes parameter "limit" to specify how many objects are returned
    @GET
    @Path("crime_list")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public List<Crime> getCrimeListQuery(
            @DefaultValue("5") @QueryParam("limit") Integer limit) throws InterruptedException, SodaError {

        soqlQuery = new SoqlQueryBuilder()
                .setLimit(limit)
                .addOrderByPhrase(new OrderByClause(SortOrder.Descending, "date"))
                .build();

        //hardcoded
//        queryService = new QueryServiceImpl("https://data.cityofchicago.org",
//                "tomislavmitic2012@u.northwestern.edu",
//                "mun1ak0t!",
//                "65wCRYQKFBPj7OPFrNrG821Yr");

        return queryService.executeQuery("ijzp-q8t2", soqlQuery, Crime.LIST_TYPE);
    }

}
