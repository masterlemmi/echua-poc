package com.bdo.esoa.schedule;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.quartz.SchedulerException;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@WebListener
public class EsoaSchedulerListener extends QuartzInitializerListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
       /* ServletContext ctx = sce.getServletContext();
        StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QUARTZ_FACTORY_KEY);
        try {
            Scheduler scheduler = factory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(EsoaJob.class).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("ESOA_FILE_IDENTITY", "ESOA_GROUP").withSchedule(
                    CronScheduleBuilder.cronSchedule("0/10 * 22 * * ?")).startNow().build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (Exception e) {
            ctx.log("There was an error scheduling the job.", e);
        }*/
        
       SchedulerFactoryBean factorybean = new SchedulerFactoryBean();
       try {
		factorybean.getScheduler().start();
	} catch (SchedulerException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}
    }

}
/*
ServletContext ctx = request.getServletContext();
StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QuartzListener.QUARTZ_FACTORY_KEY);
Scheduler scheduler = factory.getScheduler();
Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple").withSchedule(
        CronScheduleBuilder.cronSchedule(newCronExpression)).startNow().build();
Date date = scheduler.rescheduleJob(new TriggerKey("simple"), trigger);*/


