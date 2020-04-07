#项目说明
(1).属性注入
	1).@ConfigurationProperties注解对象注入
	1).@Value注解属性注入
(1).Web-拦截器
(1).Web-过滤器
(1).Web-统一异常管理
(1).Web-转换器


	
#spring-boot-demo说明
    SpringBoot入门示例,主要包含的内容有:
    (1).springboot security测试说明:
     1).pom.xml需要加入的模块:
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
     2).yml配置:
                         需要指定以下属性:
        server.port=8443
        server.ssl.key-store=classpath:tomcat.keystore
        server.ssl.key-store-password=sjm2017
        server.ssl.key-password=sjm2017
                 端口号需要指定为8443,其次证书"tomcat.keystore"注意过期时间,
                还有就是请求访问前会跳转到登陆页面,需要账号密码,账号默认"user",密码需要在控制台里面找"Using generated security password:"字符串后面输出的密码
     3).security模块是在SpringBoot2.0后才支持的

#关于SpringBoot的打包
    SrpingBoot的maven打包是很简单的,只需"mvn package"命令即可打包,
    至于打包成jar包还是war包取决于你的pom.xml配置文件的packaging属性指定的是什么包
    
    
    
    
