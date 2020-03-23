package com.ims.c02annotationCache.service.impl;

import com.ims.c02annotationCache.service.BankService;
import org.springframework.cache.annotation.Cacheable;

@Cacheable(value = "myCache")
public class BankServiceImpl implements BankService {


    private static int num = 1;

    @Override
    public int serviceA(int count) {
        System.out.println("serviceA调用" + num + "次！");
        serviceB(count);
        return num++;
    }


    @Override
    public int serviceB(int count) {
        System.out.println("serviceB调用" + num + "次！");
        return num;
    }

}
