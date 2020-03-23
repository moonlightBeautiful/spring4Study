package com.ims.c01noCache.service.impl;

import com.ims.c01noCache.service.BankService;

/*@Cacheable(value = "myCache")*/
public class BankServiceImpl implements BankService {


    private static int num = 1;


    /**
     * 无事物管理，需要把@Cacheable注释掉
     *
     * @param count
     * @return
     */
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
