package edu.depaul.capstone.demo.rest.service;

import edu.depaul.capstone.demo.rest.resource.soda.Station;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class QueryServiceTest {

    @Autowired
    QueryService queryService;

    @Test
    public void testQueryService() throws LongRunningQueryException, SodaError, InterruptedException {
        String results = queryService.executeQuery("z8bn-74gv", SoqlQuery.SELECT_ALL);
        junit.framework.Assert.assertNotNull(results);
        System.out.println(results);
        List<Station> stations = queryService.executeQuery("z8bn-74gv", SoqlQuery.SELECT_ALL, Station.LIST_TYPE);
        junit.framework.Assert.assertNotNull(stations);
        junit.framework.Assert.assertTrue("0 values returned", stations.size() > 0);
    }


}
