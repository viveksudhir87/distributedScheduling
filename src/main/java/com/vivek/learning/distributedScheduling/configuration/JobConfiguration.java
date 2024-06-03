package com.vivek.learning.distributedScheduling.configuration;


import com.vivek.learning.distributedScheduling.jobs.SendingEmailJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class JobConfiguration {


    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(SendingEmailJob.class)
                .storeDurably(true)
                .withIdentity("Sending_Email_to_VP")
                .withDescription("Invoke Scheduler to send emails to VP")
                .requestRecovery()
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withIdentity("Qrtz_Trigger")
                .withDescription("Sample trigger")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInHours(1))
                .build();
    }


}
