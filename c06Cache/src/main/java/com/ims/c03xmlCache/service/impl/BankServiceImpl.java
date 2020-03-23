package com.ims.c03xmlCache.service.impl;

import com.ims.c03xmlCache.service.BankService;

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


    public void deleteCache() {
        System.out.println("移除所有缓存！");
    }

}
