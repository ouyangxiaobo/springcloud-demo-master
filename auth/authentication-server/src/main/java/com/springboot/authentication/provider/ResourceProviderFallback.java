package com.springboot.authentication.provider;

import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.cloud.sysadmin.organization.entity.po.Resource;

import java.util.HashSet;
import java.util.Set;

public class ResourceProviderFallback implements ResourceProvider {
    @Override
    public Result<Set<Resource>> resources() {
        return Result.success(new HashSet<Resource>());
    }

    @Override
    public Result<Set<Resource>> resources(String username) {
        return Result.success(new HashSet<Resource>());
    }
}
