事务：
    事务仅与数据库相关，是一组原子操作单元。事务是为解决数据安全操作提出的，事务控制实际上就是控制数据的安全访问。
    事务的四个条件：
        1.原子性：不可再拆分。
        2.一致性：事务全部完成才算完成，如果发生错误，则全部回滚。
        3.隔离性：事物之间隔离。
        4.持久性：持久化数据。
    Spring实现事务管理有2种方式：
        不管哪种方式，都要注入事务管理器
            <context:property-placeholder location="jdbc.properties"/>
            <!-- 数据源 -->
            <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
                <property name="driverClassName" value="${jdbc.driverClassName}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </bean>
            <!-- jdbc事务管理器 -->
            <bean id="myTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                <property name="dataSource" ref="dataSource"></property>
            </bean>
        1.编程式事务管理(不建议使用)
            xml中注入TransactionTemplate
            类中使用TransactionTemplate，一定要set一下，然后在service方法中使用下面完成事务操作
                myTransactionTemplate.execute(new TransactionCallbackWithoutResult() { //在重写的方法中写事务操作}  
        2.声明式（切面和注解）事务管理：XML方式最常用
            2.1xml切面式
                
            2.2注解式
                在xml中启动事务驱动就可以
                <tx:annotation-driven transaction-manager="myTransactionManager"/>
                
        