package com.adobe.aem.may.batch.core.models;



import java.util.Date;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MangoChild {

    @ValueMapValue
    public String bookname;

    @ValueMapValue
    public String bookdes;

    @ValueMapValue
    public int booknum;

    @ValueMapValue
    public Date bookpublishdate;

    public String getBookname() {
        return bookname;
    }

    public String getBookdes() {
        return bookdes;
    }

    public int getBooknum() {
        return booknum;
    }

    public Date getBookpublishdate() {
        return bookpublishdate;
    }

    

}
