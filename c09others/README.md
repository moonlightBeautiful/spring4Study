1.InitializingBean接口
    凡是继承该接口的类，在初始化bean的时候都会执行InitializingBean接口的afterPropertiesSet方法。
    init-method 执行afterPropertiesSet之后执行的方法。可以为空。
    如果调用afterPropertiesSet方法时出错，则不调用init-method指定的方法。
2.ThreadPoolTaskExecutor线程池
    1.xml配置线程池
    2.ThreadPoolTaskExecutorExecute(线程类)