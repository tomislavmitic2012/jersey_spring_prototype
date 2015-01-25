package edu.depaul.capstone.demo.rest.resource.manifest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.Attributes;

/**
 * Created by Tomislav S. Mitic on 1/25/15.
 */
@Path("/manifest")
public class ManifestResource {

    @Autowired
    ManifestService manifestService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getManifestAttributes() throws FileNotFoundException, IOException {
        Attributes manifestAttributes = manifestService.getManifestAttributes();

        return Response.status(Response.Status.OK)
                .entity(manifestAttributes)
                .build();
    }

    @Path("/implementation-details")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getVersion() throws FileNotFoundException, IOException{
        ImplementationDetails implementationVersion = manifestService.getImplementationVersion();

        return Response.status(Response.Status.OK)
                .entity(implementationVersion)
                .build();
    }
}
