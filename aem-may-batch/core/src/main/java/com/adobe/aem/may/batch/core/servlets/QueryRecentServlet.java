package com.adobe.aem.may.batch.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;

@Component(service = Servlet.class, immediate = true)

// @SlingServletResourceTypes(resourceTypes = {"CapStone/components/teaser","CapStone/components/page"},
// selectors = {"sub","add"},extensions = {"json","txt"})
@SlingServletPaths(value = "/bin/recent/querypath")
public class QueryRecentServlet extends SlingAllMethodsServlet {

    @Reference
    QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        
        // Create query predicate
        Map<String, String> predicate = new HashMap<>();
        predicate.put("type", "cq:page");
        predicate.put("path", "/content/we-retail/us/en"); 
        predicate.put("orderby", "@jcr:content/cq:lastModified");
        predicate.put("orderby.sort", "desc");
        predicate.put("p.limit", "10");

     
        Query query = queryBuilder.createQuery(PredicateGroup.create(predicate), request.getResourceResolver().adaptTo(Session.class));
        SearchResult result = query.getResult();
        List<Hit> resourceList = result.getHits();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        
        for (Hit hit : resourceList) {
            try {
                Resource resource = hit.getResource();
                Page page = resource.adaptTo(Page.class);
                JsonObjectBuilder job = Json.createObjectBuilder();
                job.add("title", page.getTitle());
                job.add("path", page.getPath());
                jab.add(job);
            } catch (RepositoryException e) {               
                e.printStackTrace();
            }
            
        }
        response.getWriter().write(jab.build().toString());
    }        
}





