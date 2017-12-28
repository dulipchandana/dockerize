package com.smart.map.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.smart.map.api.resources.EventResource;

public class EventApplication extends Application<EventConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EventApplication().run(args);
    }

    @Override
    public String getName() {
        return "Event";
    }

    @Override
    public void initialize(final Bootstrap<EventConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final EventConfiguration configuration,
                    final Environment environment) {
        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
    	environment.getObjectMapper().setDateFormat(eventDateFormat);

    	EventResource eventResource = new EventResource();
    	environment.jersey().register(eventResource);
    }

}
