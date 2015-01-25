package edu.depaul.capstone.demo.rest;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

/**
 * Created by Tomislav S. Mitic on 1/24/15.
 */
public class RestDemoJaxRsApplication extends ResourceConfig {

    /*
     * Register JAX-RS application components
     */
    public RestDemoJaxRsApplication() {

        // Import everything from this package i.e. the enitre application
        packages("edu.depaul.capstone.demo.rest");

        // Other componenets that are needed by JAX/RS
        register(EntityFilteringFeature.class);
        EncodingFilter.enableFor(this, GZipEncoder.class);
    }
}
