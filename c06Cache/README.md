Spring对缓存的支持
    缓存简介：
        Spring Cache的核心就是对某个方法进行缓存，
        其实质就是缓存方法的返回结果，并把方法参数和结果用键值对的方式存放到缓存中，当再次调用该方法使用相应的参数时，
        就会直接从缓存里面取出指定的结果进行返回。所以在使用Cache的时候我们要保证我们缓存的方法对于相同的参数要有相同的返回结果。
        Spring Cache使用方法与Spring对事务管理的配置相似。
    两种方法实现Cache的支持
        1.基于注解的配置
        2.基础XML配置
    基于注解使用Cache
        1.注解学习 
            @Cacheable-------使用这个注解的方法在执行后会缓存其返回结果。下次同样参数来执行该方法的时候可以从缓存中返回结果，而不需要再次执行此方法。
                可以注解在方法上也可以注解在类上。
                @Cacheable可以指定三个属性：value、key、condition。
                    value值是必须指定的，其表示该方法缓存的返回结果是被缓存在哪个Cache上的，对应Cache的名称。其值可以是一个也可以是多个
                        @Cache(value="Cx") 或者 @Cache(value={"Cx","Cx1"})   
                    key值非必须，支持两种策略，一种是默认策略，一种是自定义策略该属性支持EL表达式。当我们没有指定key时，使用默认策略生成key。
                        EL表达式，可以使用方法参数或者方法参数对应的属性
                            @Cacheable(value="users", key="#id")    入参为(Integer id) 
                            @Cacheable(value="users", key="#user.id")    入参为(User user) 
                        EL表达式，还可以使用root对象可以生成key
                            1.methodName  当前方法名    #root.methodName
                            2.method       当前方法  #root.method.name
                            3.target   当前被动用对象 #root.target
                            4.targetClass      当前被调用对象Class#root.targetClass
                            5.args    当前方法参数组成的数组 #root.args[0]
                            6.caches    当前被调用方法所使用的Cache #root.caches[0],name
                    condition：默认为true，指定发生条件。EL表达式来指定
                        condition="#user.id%2==0"  入参为(User user)  当用户id为偶数的时候才会缓存
                注意：一个支持缓存的方法，在另一个方法内部被调用是不会触发缓存功能的。
            @CacheEvict--------使用这个注解的方法在其执行前或执行后移除Cache中的某些结果
                @CacheEvict可以指定的属性有value、key、condition、allEntries和beforeInvocation。
                    value表示清除缓存作用在哪个Cache上
                    key是表示需要清除的是哪个key
                    allEntries是表示是否需要清除缓存中所有的元素
                    beforeInvocation清除操作，默认是false，在方法成功执行之后触发的，设置为true之后，则在调用该方法之前进行缓存的清除。
            @CachePut：与@Cacheable不同，它虽然也可以声明一个方法支持缓存，但它执行方法前是不会去检查缓存中是否存在之前执行过的结果，而是每次都执行该方法，并将执行结果放入指定缓存中。
                可以注解在方法上也可以注解在类上。 
            @Caching：可以让我们在一个方法或者类上同时指定多个Spring Cache相关注解，其中拥有属性：cacheable、put、evict。   
                例如：@Caching(cacheable=@Cacheable("users"),evict={@CacheEvict("cache2"),@CacheEvict(value="cache3",allEntries=true)})
        2.配置Spring对Cache的支持,使用ehcache作为cache管理器
            1.在pom.xml中添加依赖
               <!-- https://mvnrepository.com/artifact/net.sf.ehcache/ehcache -->
               <dependency>
                   <groupId>net.sf.ehcache</groupId>
                   <artifactId>ehcache</artifactId>
                   <version>2.10.6</version>
               </dependency>
            2.在classPath下增加ehcache配置文件ehcache.xml
                <?xml version="1.0" encoding="UTF-8"?>
                <ehcache updateCheck="false">
                    <diskStore path="java.io.tmpdir"/>
                    <defaultCache
                        maxElementsInMemory="10000"
                        eternal="false"
                        timeToIdleSeconds="120"
                        timeToLiveSeconds="120"
                        overflowToDisk="true"
                        diskPersistent="false"
                        diskExpiryThreadIntervalSeconds="120"
                        memoryStoreEvictionPolicy="LRU"/> 
                    <cache name="myCache"　　　　　　
                       maxElementsInMemory="10000"
                       eternal="false"
                       overflowToDisk="true"
                       timeToIdleSeconds="30"
                       timeToLiveSeconds="60"
                       memoryStoreEvictionPolicy="LFU"/> 
                </ehcache>
            3.spring配置
                1.开启缓存的注解功能
                    <cache:anotation-driven cache-manager="myDefaultEhcacheManager"/>
                3.根据ehcache.xml文件生成缓存工厂类
                    <bean id="ehCacheFactory" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean">
                        <property name="configLocation" value="classpath:ehcache.xml"/>
                    </bean>
                3.缓存管理器
                    <bean id="myDefaultEhcacheManager" class="org.springframework.cache.ehcache.EhCacheCacheManager">
                        <property name="cacheManager" ref="ehCacheFactory"></property>
                    </bean>
            2.在service层添加注解
                @Cacheable(value="myCache")　 //这个名称就是ehcache.xml文件中的name属性的值 
    基于xml使用Cache
        1.xml文件中添加命名空间
        2.配置CacheManager
            通过指定的ehcache配置文件来生成的一个Ehcache的CacheManager。若未指定则默认规则取classpath路径下的ehcache文件，若还是不存在则取Ehcache对应包的ehcache-failsafe.xml文件作为配置文件。
            <bean id="cacheManager" class="org.springframework.cache.ehcache.EhCacheCacheManager" p:cache-manager-ref="cacheFactory"/>  
            <bean id="cacheFactory" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean" p:config-location="ehcache-spring.xml"/>  
        3.缓存通知
            <cache:advice id="cacheAdvice" cache-manager="cacheManager">  
                <cache:caching cache="users">  
                    <cache:cacheable method="findById" key="#p0"/>  
                    <cache:cacheable method="find" key="#user.id"/>  
                    <cache:cache-evict method="deleteAll" all-entries="true"/>  
                </cache:caching>  
            </cache:advice>  
        4.缓存AOP
            <aop:config proxy-target-class="false">  
                <aop:advisor advice-ref="cacheAdvice" pointcut="execution(* com.xxx.UserService.*.*(..))"/>  
            </aop:config> 
            proxy-target-class：无意义 扫描接口还是实现类 都可以
            expose-proxy="false":是否拦截类中方法1内部中调用的方法2
    属性配置学习
        mode属性，可以选择值proxy和aspectj。默认使用proxy。
            当mode为proxy时，
                一个类中，缓存方法调用缓存方法缓存OK。缓存方法必须是public。
                一个类中，非缓存方法调用缓存方法缓存OK。缓存方法必须是public。
                note：以下会报错
                        ApplicationContext ac = new ClassPathXmlApplicationContext("02annotationCache.xml");
                        BankServiceImpl bankService = (BankServiceImpl) ac.getBean("bankService");
                    proxy使用的是aop，aop应该是使用了JDK Proxy。不能用接口的实现类来转换Proxy的实现类，它们是同级，应该用共同的接口来转换。应该如下：
                        ApplicationContext ac = new ClassPathXmlApplicationContext("02annotationCache.xml");
                        BankService bankService = (BankService) ac.getBean("bankService");
                    使用proxy，必须为被代理的目标实现一个接口。
            当mode为aspectj时，
                一个类中，缓存方法调用缓存方法缓存not OK。缓存方法可以是非public。
                一个类中，非缓存方法调用缓存方法缓存OK。缓存方法可以是非public。
            用在spring事务、缓存驱动启动标签上。
        proxy-target-class：决定是基于接口的还是基于类的代理被创建。默认true。
            其实就是在接口上起不起作用
                为true则是基于类的代理：缓存注解用在类上管用，但是缓存注解用在类的接口上不管用。
                为false则是基于接口的代理：缓存注解用在类上管用，而且缓存注解用在类的接口上也管用。
            用在spring事务、aop、缓存xml标签上。例子如下：
                <tx:annotation-driven transaction-manager="transactionManager" proxy-target-class="true"/>
                <aop:config proxy-target-class="true">
                <cache:annotation-driven proxy-target-class="true"/>
            