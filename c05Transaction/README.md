Spring对事务的支持
    事务简介：
        一次完整操作，一般是service层的一个方法。
    特性：4个
        1.原子性
        2.一致性
        3.隔离性
        4.持久性
    Spring事物的实现：需要数据源
        1.编程式
            Spring支持事务的类：
                1.TransactionTemplate类
                2.DataSourceTransactionManager类 ， 作为 TransactionTemplate属性
            实现：
                1.service实现类添加属性TransactionTemplate
                2.service的方法里使用TransactionTemplate实现事务管理：
                    public void service方法(final 参数要添加final...) {
                        // TransactionTemplate实现事务管理
                        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                            @Override
                            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                                // 事务操作代码这里写
                            }
                        });
                    }
                3.xml IOC 事务模板TransactionTemplate和事务管理器DataSourceTransactionManager
                    <!-- 事务管理器 -->
                    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                        <property name="dataSource" ref="dataSource"></property>
                    </bean>
                    <!-- 事务管模板 -->
                    <bean id="transactionTemplate" class="org.springframework.transaction.support.TransactionTemplate">
                        <property name="transactionManager" ref="transactionManager"></property>
                    </bean>
        2.XML中AOP式
            1.xml文件中添加命名空间
                xmlns:tx="http://www.springframework.org/schema/tx"
                xsi:schemaLocation添加值  
                    http://www.springframework.org/schema/tx 
                    http://www.springframework.org/schema/tx/spring-tx.xsd
            2.xml文件中AOP+事务通知
                <!-- 配置事务管理器 -->
                <bean id="myTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                    <property name="dataSource" ref="dataSource"></property>
                </bean>
                <!-- 配置事务通知 -->
                <tx:advice id="txAdvice" transaction-manager="myTransactionManager">
                    <tx:attributes>
                        <tx:method name="insert*" propagation="REQUIRED"/>
                        <tx:method name="update*" propagation="REQUIRED"/>
                        <tx:method name="edit*" propagation="REQUIRED"/>
                        <tx:method name="save*" propagation="REQUIRED"/>
                        <tx:method name="add*" propagation="REQUIRED"/>
                        <tx:method name="new*" propagation="REQUIRED"/>
                        <tx:method name="set*" propagation="REQUIRED"/>
                        <tx:method name="remove*" propagation="REQUIRED"/>
                        <tx:method name="delete*" propagation="REQUIRED"/>
                        <tx:method name="change*" propagation="REQUIRED"/>
                        <tx:method name="get*" propagation="REQUIRED" read-only="true"/>
                        <tx:method name="find*" propagation="REQUIRED" read-only="true"/>
                        <tx:method name="load*" propagation="REQUIRED" read-only="true"/>
                        <tx:method name="*" propagation="REQUIRED" read-only="true"/>
                    </tx:attributes>
                </tx:advice>
                <!-- 配置事务切面 -->
                <aop:config>
                    <!-- 配置切点 -->
                    <aop:pointcut id="serviceMethod" expression="execution(* com.ims.com.ims.service.*.*(..))"/>
                    <!-- 配置事务通知 -->
                    <aop:advisor advice-ref="txAdvice" pointcut-ref="serviceMethod"/>
                </aop:config>
        3.注解式AOP
            1.service的实现类上使用注解Transactional    
            2.xml文件中，配置事务管理器和开启事务注解驱动
                <!-- 配置事务管理器 -->
                <bean id="myTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
                    <property name="dataSource" ref="dataSource"></property>
                </bean>
                <!-- 启动事务管理注解 -->
                <tx:annotation-driven transaction-manager="myTransactionManager"/>
        4.三种方式的建议：
            1.不要使用编程式，严重代码侵入。    
            2.注解式还OK，还算是方便，但是如果有上千个service，稍微算是麻烦。
            3.xml方式最好，一个表达式解决。不过多少个service。
    事务的传播行为propagation
        当一个service方法A调用另一个service方法B，产生了service方法的嵌套，service方法B如何使用事务。
            事务的传播行为：内部service方法B的事务如何处理。定义service方法B的propagation属性。
            ServiceA {
                 void methodA() {
                     ServiceB.methodB();
                     ServiceC.methodC();
                 }
            }
            ServiceB {
                 void methodB() {
                 }
            }
            ServiceC {
                 void methodC() {
                 }
            }
        1.PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。
            ServiceA存在事务，ServiceB和ServiceC的事务传播行为是PROPAGATION_REQUIRED时。
                ServiceA、B、C，共用一个事务。ServiceA中(包含B和C)任何地方发生异常，则ServiceA全部回滚。
            ServiceA不存在事务，ServiceB和ServiceC的事务传播行为是PROPAGATION_REQUIRED时。
                ServiceB新建一个事务自己使用。ServiceC新建一个事务自己使用。
                ServiceB和ServiceC的事务独立，互不影响。
                ServiceB发生异常，只回滚ServiceB。
                ServiceA发生异常，只回滚ServiceA。
                ServiceA和ServiceB之外发生异常，不回回滚。
        2.PROPAGATION_SUPPORTS--支持当前事务，如果当前没有事务，就以非事务方式执行。
        3.PROPAGATION_MANDATORY--支持当前事务，如果当前没有事务，就抛出异常。
        4.PROPAGATION_REQUIRES_NEW--新建事务，如果当前存在事务，把当前事务挂起。
        5.PROPAGATION_NOT_SUPPORTED--以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
        6.PROPAGATION_NEVER--以非事务方式执行，如果当前存在事务，则抛出异常
    事务的其他属性学习
        1.read-only：它只是一个“暗示”，提示JDBC驱动程序和数据库，这个事务并不包含更改数据的操作，
            那么JDBC驱动程序和数据库就有可能根据这种情况对该事务进行一些特定的优化，以减轻事务对数据库的压力，
            毕竟事务也是要消耗数据库的资源的。 
        2.rollbackFor属性
            默认情况下，声明式事务或者注解式事务在遇到运行时异常RuntimeException和Error，Spring事务会进行回滚，而遇到非运行时异常Exception则不会回滚。
            rollbackFor指定需要回滚的异常类型，指定异常之后，被指定的异常和该异常的子类都会得到回滚，并且运行时异常和Error异常仍然会得到回滚。
            说明：
                但是方法需要抛出异常，让spring捕获到。如果自己try catch，不抛出捕获到的异常，spring捕获不到，事务是不会回滚的。
            经常见到的3种事务不回滚的产生原因：
                （1）声明式事务配置切入点表达式写错了，没切中Service中的方法。
                （2）Service方法中，把异常给try catch了，但catch里面只是打印了异常信息，没有手动抛出RuntimeException异常。
                        catch (Exception e) {
                            throw new RuntimeException();
                            或者 throw e;
                        }
                （3）Service方法中，抛出的异常不属于运行时异常（如IO异常），因为Spring默认情况下是捕获到运行时异常就回滚
                        catch (Exception e) {
                            throw new Exception(e);  //跑出的异常不是运行时异常，
                        }