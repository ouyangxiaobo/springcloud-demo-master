package com.springboot.authentication.config;

import com.springboot.authentication.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class LoadResourceDefine {

    @Autowired
    private IResourceService resourceService;

    @Bean
    public Map<RequestMatcher, ConfigAttribute> resourceConfigAttributes() {
        return resourceService.loadResource();
    }
}
