package com.adobe.aem.may.batch.core.models;


import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MangoParent {

    @ValueMapValue
    public String text;

    @ValueMapValue
    public String des;

    @ValueMapValue
    public int num;

    @ChildResource
    public List<MangoChild> bookdetailswithmap;

    public String getText() {
        return text;
    }

    public String getDes() {
        return des;
    }

    public int getNum() {
        return num;
    }

    public List<MangoChild> getBookdetailswithmap() {
        return bookdetailswithmap;
    }

    
    

}
