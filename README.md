#Study
    1.hello
        简介：
            由Rod Johnson创建的轻量级的JAVA开源框架，解决企业级应用开发的复杂性，代替EJB，	     
        2个核心思想：
            IOC（控制反转）和AOP（面向切面）。
        下载地址
            http://repo.springsource.org/libs-release-local/org/springframework/spring/
        实例化bean：
            1.xml中
            2.注解，使用注解的话，要开始组件扫描
                @Component  entity
                @Service：业务层
                @Controller：WEB层
                @Repository：持久层
              虽然分了层，但目前这四个注解的功能是一样的。实例化的默认值值是类名的开头小写
    2.ioc
        