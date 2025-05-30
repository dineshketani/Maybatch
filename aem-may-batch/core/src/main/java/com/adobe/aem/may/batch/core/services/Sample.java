package com.adobe.aem.may.batch.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Component(immediate = true,enabled = true,name = "SampleService")
public class Sample {

    private static final Logger LOG=LoggerFactory.getLogger(Sample.class);

    @Activate
    public void activateContent(){

        LOG.info("this info from activate()");
    }

    @Deactivate
     public void DeActivate(){

        LOG.info("this info from deactivate()");

        
     }

     @Modified
     public void Update(){

        LOG.info("this info from modified()");

        
     }
}
