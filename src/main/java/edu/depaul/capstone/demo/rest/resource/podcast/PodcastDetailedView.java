package edu.depaul.capstone.demo.rest.resource.podcast;

import org.glassfish.hk2.api.AnnotationLiteral;
import org.glassfish.jersey.message.filtering.EntityFiltering;

import java.lang.annotation.*;

/**
 * Created by Tomislav S. Mitic on 1/25/15.
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EntityFiltering
public @interface PodcastDetailedView {

    /**
     * Factory class for creating instances of {@code ProjectDetailedView} annotation.
     */
    public static class Factory extends AnnotationLiteral<PodcastDetailedView> implements PodcastDetailedView {

        private Factory() {
        }

        public static PodcastDetailedView get() {
            return new Factory();
        }
    }
}
