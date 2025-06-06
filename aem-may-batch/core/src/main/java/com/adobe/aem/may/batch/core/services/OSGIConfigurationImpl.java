package com.adobe.aem.may.batch.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = OSGIConfigurationMethods.class)

@Designate(ocd=StudentConfiguration.class)
public class OSGIConfigurationImpl implements OSGIConfigurationMethods {

private String studentName;
private int rollNumber;
private boolean regular;
private String[] subjects;
private String countries;

    @Activate()
    protected void start(StudentConfiguration config){
       studentName = config.studentName();
       rollNumber = config.rollNumber();
       regular = config.regular();
       subjects = config.subjects();
       countries = config.countries();
    }

    @Override
    public String getStudentName() {
        
        return studentName;
    }

    @Override
    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public boolean getRegular() {
        return regular;
    }

    @Override
    public String[] getSubjects() {
        return subjects;
    }

    @Override
    public String getCountries() {
        return countries;
    }

    
    
}
