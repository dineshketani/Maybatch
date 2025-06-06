
package com.adobe.aem.may.batch.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.adobe.aem.may.batch.core.services.OSGIConfigurationMethods;

@Model(adaptables = SlingHttpServletRequest.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OSGIConfigurationModel {

    @OSGiService
    OSGIConfigurationMethods osgiConfig;

   public String getStudentName() {
        return osgiConfig.getStudentName();
    }

    public int getRollNumber() {
        return  osgiConfig.getRollNumber();
    }

    public boolean getRegular() {
        return osgiConfig.getRegular();
    }

    public String[] getSubjects() {
        return  osgiConfig.getSubjects();
    }

    public String getCountries() {
        return osgiConfig.getCountries();
    }
}
