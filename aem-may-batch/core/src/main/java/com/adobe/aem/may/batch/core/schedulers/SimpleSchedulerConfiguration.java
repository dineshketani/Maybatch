package com.adobe.aem.may.batch.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "SimpleSchedulerConfiguration OCD",
    description = "SimpleSchedulerConfiguration OCD description"
)
public @interface SimpleSchedulerConfiguration {
    

    @AttributeDefinition(
            name = "Scheduler name",
            description = "Scheduler name",
            type = AttributeType.STRING)
   public String scheduler_name() default "practice";

    @AttributeDefinition(
        name = "Cron job expression",
        description = "Cron job expression",
        type = AttributeType.STRING)
   public String scheduler_expression() default "0 * * * * ?";

    @AttributeDefinition(
        name = "Enable Scheduler",
        description = "Enable Scheduler",
        type = AttributeType.BOOLEAN)
    public boolean enable_scheduler() default true;

    @AttributeDefinition(
        name = "Concurrent Scheduler",
        description = "Concurrent Scheduler",
        type = AttributeType.BOOLEAN)
    public boolean concurrent_scheduler() default false;

    @AttributeDefinition(
        name = "Custom Property",
        description = "Custom Property",
        type = AttributeType.STRING)
    public String customProperty() default "Test";

    

}
