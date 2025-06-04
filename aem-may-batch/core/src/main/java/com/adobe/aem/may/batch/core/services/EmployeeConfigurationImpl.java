package com.adobe.aem.may.batch.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.LoggerFactory;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;

@Component(immediate = true,enabled = true,service = EmployeeConfigurationImpl.class)

@Designate(ocd = EmpConfiguration.class)
public class EmployeeConfigurationImpl {



    public String empName;

    public int empId;

    public double empSal;

    @Reference
    EmpConfiguration empConfiguration;

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeConfigurationImpl.class);

    @Activate
    public void activate(EmpConfiguration empConfiguration)
    {
        updateConfiguration(empConfiguration);
    
    }

    @Deactivate
    public void deactivate(EmpConfiguration empConfiguration)
    {
        updateConfiguration(empConfiguration);

    }

    @Modified
    public void modified(EmpConfiguration empConfiguration)
    {
        updateConfiguration(empConfiguration);

    }

    public void updateConfiguration(EmpConfiguration empConfiguration)
    {
        this.empName = empConfiguration.empName();

        this.empId = empConfiguration.empId();

        this.empSal = empConfiguration.empSal();

        LOG.info("name {}, id {}, sal {} ",empName,empId,empSal);

    }

}
