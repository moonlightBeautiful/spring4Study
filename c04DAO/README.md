Spring对DAO的支持
    支持：
        1.jdbcTemplate
        2.JdbcDaoSupport
        3.NamedParameterJdbcTemplate
    dbcp简介：
        数据库打开连接非常费时，而且为每一个用户打开一个连接对于网络应用来说是不现实的，
        因此开发者希望能够让所有用户共享一个“连接池”，内存中保存一定的数据库连接，
        当用户请求的时候就分配一个给他，当用户不需要的时候就将连接放回池中。
    需要jar包2个
        commons-dbcp
        commons-pool
        顺便提一下，
            jdbc驱动+spring-jdbc+spring-tx的jar包是必须的
    xml中配置数据源：
        1.properties文件记录数据库连接信息
            jdbc.driverClassName=com.mysql.jdbc.Driver
            jdbc.url=jdbc:mysql://127.0.0.1:3306/db_spring?characterEncoding=utf8
            jdbc.username=root
            jdbc.password=root
        2.xml中配置数据源
            <context:property-placeholder location="jdbc.properties"/>
            <bean id="dataSource"
                  class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
                <property name="driverClassName" value="${jdbc.driverClassName}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </bean>
1.JdbcTemplate使用，使用 ？作为占位符
    daoImpl类使用JdbcTemplate作为属性进行增删改查
    daoImpl类需要注入jdbcTemplate
2.JdbcDaoSupport使用，其实使用的还是JdbcTemplate
    daoImpl类继承JdbcDaoSupport，JdbcDaoSupport有JdbcTemplate属性，可以直接使用继承来的JdbcTemplate作为属性进行增删改查           
    daoImpl类需要注入dataSource
3.NamedParameterJdbcTemplate的使用，使用 :变量名 作为占位符
    daoImpl类使用NamedParameterJdbcTemplate作为属性进行增删改查
    daoImpl类需要注入NamedParameterJdbcTemplate
    