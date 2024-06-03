package com.vivek.learning.distributedScheduling.jobs;

import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class SendingEmailJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Sending an email ");
    }

}
