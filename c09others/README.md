1.InitializingBean接口
    凡是继承该接口的类，在初始化bean的时候都会执行InitializingBean接口的afterPropertiesSet方法。
    init-method 执行afterPropertiesSet之后执行的方法。可以为空。
    如果调用afterPropertiesSet方法时出错，则不调用init-method指定的方法。
2.ThreadPoolTaskExecutor线程池
    1.xml配置线程池
    2.ThreadPoolTaskExecutorExecute(线程类)
3.注解
    1.@Resource有两个常用属性name、type，所以分4种情况
        指定name和type：通过name找到唯一的bean，找不到抛出异常；如果type和字段类型不一致，也会抛出异常。
        指定name：通过name找到唯一的bean，找不到抛出异常。
        指定type：通过tpye找到唯一的bean，如果不唯一，则抛出异常：NoUniqueBeanDefinitionException。
        都不指定：通过字段名作为key去查找，找到则赋值；找不到则再通过字段类型去查找，如果不唯一，则抛出异常：NoUniqueBeanDefinitionException。
    2.@Autowired
        @Autowired只有一个属性required，默认值为true，为true时，找不到就抛异常，为false时，找不到就赋值为null。
        @Autowired按类型查找，如果该类型的bean不唯一，则抛出异常；