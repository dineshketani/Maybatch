package com.adobe.aem.may.batch.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(service = PracticeSchedulers.class,immediate=true, enabled=true)
@Designate(ocd = SimpleSchedulerConfiguration.class)
public class PracticeSchedulers implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(PracticeSchedulers.class);

    @Reference
    Scheduler scheduler;

    @Activate
    protected void activate(final SimpleSchedulerConfiguration config) {

        LOG.info(" PracticeScheduledTask activate method called");

    
        addScheduler(config);

    }

    public void addScheduler(SimpleSchedulerConfiguration config) {
        LOG.info("Scheduler added successfully >>>>>>>   ");
        if (config.enable_scheduler()) {
            ScheduleOptions options = scheduler.EXPR(config.scheduler_expression());
            options.name(config.scheduler_name());
            options.canRunConcurrently(config.concurrent_scheduler());

            // Add scheduler to call depending on option passed.
            scheduler.schedule(this, options);
            LOG.info("Scheduler added successfully name='{}'", config.scheduler_name());
        } else {
            LOG.info("SimpleScheduledTask disabled");
        }
    }


    public void removeScheduler(SimpleSchedulerConfiguration config) {
        scheduler.unschedule(config.scheduler_name());
    }


    @Deactivate
    protected void deactivate(SimpleSchedulerConfiguration config) {
        removeScheduler(config);
    }


    @Modified
    protected void modified(SimpleSchedulerConfiguration config) {
        removeScheduler(config);
        addScheduler(config);
    }

    @Override
    public void run() {
        LOG.info("PracticeScheduledTask run >>>>>>>>>>>");
    }

    

}
