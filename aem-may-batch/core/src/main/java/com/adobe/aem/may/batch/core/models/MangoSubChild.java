package com.adobe.aem.may.batch.core.models;

import java.util.Date;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MangoSubChild {

    @ValueMapValue
    public String writername;

    @ValueMapValue
    public String writerinfo;

    @ValueMapValue
    public int writernum;

    @ValueMapValue
    public Date writerdob;

    public String getWritername() {
        return writername;
    }

    public String getWriterinfo() {
        return writerinfo;
    }

    public int getWriternum() {
        return writernum;
    }

    public Date getWriterdob() {
        return writerdob;
    }

    

}
