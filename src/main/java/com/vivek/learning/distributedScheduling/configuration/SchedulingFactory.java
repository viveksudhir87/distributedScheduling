package com.vivek.learning.distributedScheduling.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedulingFactory {

    public Scheduler getScheduler() {
        return scheduler;
    }

    Scheduler scheduler;

    private static final Logger LOGGER = LogManager.getLogger(SchedulerFactory.class);
    @Bean
    SchedulerFactory  instantiateSchedulerFactory() throws SchedulerException {
        LOGGER.info("@Bean -- instantiateSchedulerFactory -- Instantiating Scheduler Factory");
        return new StdSchedulerFactory(new ClassPathResource("quartz.properties").getFilename());
    }

    @Bean
    Scheduler  instantiateScheduler() throws SchedulerException {
        LOGGER.info("@Bean -- instantiateScheduler -- Instantiating Scheduler Object");
        scheduler = instantiateSchedulerFactory().getScheduler();
        return getScheduler();
    }
}
