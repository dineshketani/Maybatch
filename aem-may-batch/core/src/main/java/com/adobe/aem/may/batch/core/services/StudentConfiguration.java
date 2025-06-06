package com.adobe.aem.may.batch.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name = "Student Details", description = "Taking data from student")
public @interface StudentConfiguration {

    @AttributeDefinition(
        name = "Student Name",
        description = "Enter Student Name Here",
        type = AttributeType.STRING)
    String studentName() default "shasrith";  // ✅ removed "get"

    @AttributeDefinition(
        name = "Roll Number",
        description = "Enter The Roll Number Here",
        type = AttributeType.INTEGER)
    int rollNumber() default 5;

    @AttributeDefinition(
        name = "Regular",
        description = "Is Student Regular",
        type = AttributeType.BOOLEAN)
    boolean regular() default true;

    @AttributeDefinition(
        name = "Subjects",
        description = "See your subjects",
        type = AttributeType.STRING)
    String[] subjects() default { "Maths", "Science", "English" };

    @AttributeDefinition(
        name = "Countries",
        description = "Select country",
        type = AttributeType.STRING,
        options = {
            @Option(label = "India", value = "india"),
            @Option(label = "Russia", value = "russia"),
            @Option(label = "France", value = "france"),
            @Option(label = "America", value = "america")
        })
    String countries() default "india";
}
