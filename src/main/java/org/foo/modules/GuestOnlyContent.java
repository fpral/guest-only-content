package org.foo.modules;

import org.jahia.services.render.RenderContext;
import org.jahia.services.render.Resource;
import org.jahia.services.render.filter.AbstractFilter;
import org.jahia.services.render.filter.RenderChain;
import org.jahia.services.render.filter.RenderFilter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(service = RenderFilter.class)
public class GuestOnlyContent extends AbstractFilter {


    @Activate
    public void activate() {
        setPriority(45);
        setDescription("Filter hiding content for non-guests users");
        setApplyOnNodeTypes("jmix:droppableContent");
        setSkipOnConfigurations("include,wrapper");
        setSkipOnModes("studio");
    }

    @Override
    public String prepare(RenderContext renderContext, Resource resource, RenderChain chain) throws Exception {

        if (resource.getNode().getNodeTypes().contains("jmix:guestOnlyContent")) {
            resource.pushWrapper("wrapper");
        }
        return null;
    }

}
