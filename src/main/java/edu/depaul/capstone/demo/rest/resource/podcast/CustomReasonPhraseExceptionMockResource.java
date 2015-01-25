package edu.depaul.capstone.demo.rest.resource.podcast;

import edu.depaul.capstone.demo.rest.errorhandling.CustomReasonPhraseException;
import edu.depaul.capstone.demo.rest.service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Tomislav S. Mitic on 1/25/15.
 */
@Path("/mocked-custom-reason-phrase-exception")
public class CustomReasonPhraseExceptionMockResource {

    @Autowired
    private PodcastService podcastService;

    @GET
    public void testReasonChangedInResponse() throws CustomReasonPhraseException {
        podcastService.generateCustomReasonPhraseException();
    }
}
