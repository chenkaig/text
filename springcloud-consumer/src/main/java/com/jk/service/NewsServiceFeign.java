package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "springcloud-provider",fallback = NewsServiceError.class)
public interface NewsServiceFeign extends NewsService{
}
