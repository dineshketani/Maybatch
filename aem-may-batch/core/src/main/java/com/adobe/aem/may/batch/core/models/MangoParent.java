package com.adobe.aem.may.batch.core.models;


import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import javax.inject.Named;

import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MangoParent {

    @ValueMapValue
    public String text;

    @ValueMapValue
    public String des;

    @ValueMapValue
    public int num;

    @ScriptVariable
    Page currentPage;

    @ValueMapValue
    @Named(value = "jcr:primaryType")
    public String primary;

    public String getArticlePrimaryName()
    {
        return primary;
        
    }

    @Inject 
    ResourceResolver resolver;

    public String getArticleTitle()
    {
        return currentPage.getTitle();
    }

    public String getArticlePagePath()
    {
        return currentPage.getPath();
    }

    public Page ArticlePageParent()
    {
        return currentPage.getParent();
    }

    public String getWebContentNode()
    {
        return resolver.getUserID();
        
    }


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
