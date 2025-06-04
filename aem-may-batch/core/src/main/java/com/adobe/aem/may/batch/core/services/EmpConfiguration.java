package com.adobe.aem.may.batch.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "EmpConfiguration")
public @interface EmpConfiguration {

 @AttributeDefinition(

 name = "EmployeeName",
            description = "suresh from surge",
                    required = true,
                    defaultValue = "suresh"
 )
 public String empName();

@AttributeDefinition(
  name = "Employeeid",
                    description = "Surge Employee id",
                    required = true,
                    defaultValue = "99"
 )
 public int empId();

 @AttributeDefinition(

 name = "Employeesalary",
                    description = "Surge Employee salary",
                    required = true,
                    defaultValue = "50000"
 )
 public double empSal();

 
}
