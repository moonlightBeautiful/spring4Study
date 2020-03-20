1.InitializingBean
    为bean提供了初始化方法的方式，它只包括afterPropertiesSet方法，
    凡是继承该接口的类，在初始化bean的时候都会执行该方法。
    init-method 执行afterPropertiesSet之后执行的方法。可以为空
    如果调用afterPropertiesSet方法时出错，则不调用init-method指定的方法。