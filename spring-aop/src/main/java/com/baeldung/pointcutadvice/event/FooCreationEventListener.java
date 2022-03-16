package com.baeldung.pointcutadvice.event;

import org.springframework.context.ApplicationListener;

import java.util.logging.Logger;

public class FooCreationEventListener implements ApplicationListener<FooCreationEvent> {

    private static Logger logger = Logger.getLogger(FooCreationEvent.class.getName());
    @Override
    public void onApplicationEvent(FooCreationEvent event) {
        logger.info("Created foo instance " + event.getSource().toString());
    }
}
