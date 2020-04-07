#SpringBoot框架
	SpringBoot主要的特点就是可以从主方法启动web程序,而无需打包成war包.
	因为SpringBoot将Tomcat嵌入其中了.其次就是SpringBoot简化了配置,
	简单来说就是你只需配置你需要更改的一些配置,而不需要每个都配置.SpringBoot
	有默认配置.这也是SpringBoot什么都不配置也能运行起来的原因.
	
	(1).自动化配置
	通过检查依赖包,自动配置所需功能的默认依赖
	(2).起步依赖
	引入SpringBoot的父项目,功能模块时,会自动将适宜兼容的版本依赖一起携带到当前项目中 
	(3).SpringBootCli
	Spring自己提供的一种开发Spring项目的方式,一种命令行开发
	(4).Actuator
	用于监控Spring项目的一种方式(比如各种属性,依赖,线程状态等等).
	
Spring Boot运行环境
Spring Boot最近（2017-08-18）版本Spring Boot 1.5.6运行环境，Spring官方建议使用JDK1.8
Name 			Servlet Version 	Java Version
Tomcat 8 		3.1 				Java 7+
Tomcat 7 		3.0 				Java 6+
Jetty 9 		3.1 				Java 7+
Jetty 8 		3.0 				Java 6+
Undertow 1.1 	3.1 				Java 7+

SpringBoot的作用类似于maven 整合了所有的 jar 包，Spring Boot 整合了所有的框架（不知道这样比喻是否合适）

Spring Boot 的核心思想就是约定大于配置，多数 Spring Boot 应用只需要很少的 Spring 配置。
采用 Spring Boot 可以大大的简化你的开发模式，所有你想集成的常用框架，它都有对应的组件支持

Spring Boot 特性
    使用 Spring 项目引导页面可以在几秒构建一个项目
    方便对外输出各种形式的服务，如 REST API、WebSocket、Web、Streaming、Tasks
    非常简洁的安全策略集成
    支持关系数据库和非关系数据库
    支持运行期内嵌容器，如 Tomcat、Jetty
    强大的开发包，支持热启动
    自动管理依赖
    自带应用监控
    支持各种 IED，如 IntelliJ IDEA 、NetBeans

Spring Boot 使测试变得更简单,Spring Boot 对测试的支持不可谓不强大，Spring Boot 内置了7种强大的测试框架：
    JUnit： 一个 Java 语言的单元测试框架
    Spring Test & Spring Boot Test：为 Spring Boot 应用提供集成测试和工具支持
    AssertJ：支持流式断言的 Java 测试框架
    Hamcrest：一个匹配器库
    Mockito：一个 java mock 框架
    JSONassert：一个针对 JSON 的断言库
    JsonPath：JSON XPath 库

SpringBoot组件说明:
(1).spring-boot-start-test
	对数据库、Mock、Web 等各种情况进行测试
(2).Spring Boot Actuator
	Spring Boot Actuator 是 Spring Boot 提供的对应用系统监控的集成功能，
	可以查看应用配置的详细信息，例如自动化配置信息、创建的 Spring beans 以及一些环境属性等
(3).

开发环境的调试
热启动在正常开发项目中已经很常见了吧，虽然平时开发web项目过程中，
改动项目启重启总是报错；但springBoot对调试支持很好，修改之后可以实时生效，需要添加以下的配置：
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
   </dependency>
</dependencies>
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <fork>true</fork>
            </configuration>
        </plugin>
   </plugins>
</build>
注意：该模块在完整的打包环境下运行的时候会被禁用。如果你使用java -jar启动应用
或者用一个特定的classloader启动，它会认为这是一个“生产环境”。


Spring Boot Admin 是一个管理和监控 Spring Boot 应用程序的开源软件。每个应用都认为是一个客户端，
通过 HTTP 或者使用 Eureka 注册到 admin server 中进行展示，Spring Boot Admin UI 部分使用 AngularJs 将数据展示在前端。
Spring Boot Admin 是一个针对 spring-boot 的 actuator 接口进行UI美化封装的监控工具。
他可以：在列表中浏览所有被监控 spring-boot 项目的基本信息，详细的 Health 信息、
内存信息、JVM 信息、垃圾回收信息、各种配置信息（比如数据源、缓存列表和命中率）等，
还可以直接修改 logger 的 level

Spring Cloud 是一系列框架的有序集合。它利用 Spring Boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，
如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 Spring Boot 的开发风格做到一键启动和部署	

#SpringBoot常用的起步依赖
	SpringBoot起步依赖是引入已整合好的框架模块,这个框架模块会自动将相关jar依赖也携带进来,包括各jar包的版本,它们是跟随SpringBoot的版本号,所以你不需要为
	这些依赖jar包的版本号而苦恼了,另外这些框架模块包含有默认的配置文件,可以说你引入了这个模块就能用这个模块框架了.
	SpringBoot通过继承父pom来实现jar包的依赖导入,即在导入maven依赖前需要一个父pom作为基础,其他的通过模块化的导入实现各模块的jar包依赖.
	需要说明的是,SpringBoot的导入的依赖中有默认的一些配置.即便不配置任何配置文件,SpringBoot程序也能正常启动.也就是说SpringBoot有默认配置,我们只需更改
	我们需要更改的配置即可.

	SpringBoot的父pom依赖(基础),每个SpringBoot项目pom.xml文件中必须有的配置的东西
	<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.1.RELEASE</version>
    </parent>
    
##SpringBoot起步依赖
	(1).web模块
	    <dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-web</artifactId>
	    </dependency>
	    包含的内容:
	    1).SpringMVC
	    2).内置Tomcat模块,可以打包成运行jar包直接启动

	(2).Web表单请求参数校验模块
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
	    包含的内容:
	    1).包含hibernate-validator的表单校验
	 Tips:
	 	此模块需配合Web模块使用
	 	
	(3).SpringBoot 单元测试
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
	    包含的内容:
	    1).SpringBoot Junit单元测试
	 
	(4).Mybatis
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
    </dependency>
	    包含的内容:
	    1).Mybatis框架
	Tips:
		需要数据库连接池以及数据库驱动需要额外添加依赖包

	(5).spring-data-redis
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-redis</artifactId>
    </dependency>
	    包含的内容:
	    1).spring-data-redis
	    
	(6).RPC框架dubbo
    <dependency>
        <groupId>io.dubbo.springboot</groupId>
        <artifactId>spring-boot-starter-dubbo</artifactId>
    </dependency>
	    包含的内容:
	    1).dubbo
	    
	(7).分布式搜索elasticsearch
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
    </dependency>
	    包含的内容:
	    1).elasticsearch
    
#SpringBoot注解说明
##().@SpringBootApplication
	@SpringBootApplication是一个组合注解,它包含了@Configuration、@EnableAutoConfiguration、@ComponentScan这三个注解，
	这个组合注解的功能就是开启自动化配置(@Configuration) + 主键扫描(@EnableAutoConfiguration) + 引入配置(@ComponentScan)
     
     Tips:
     	1).@SpringBootApplication注解标注在启动类上,并不是它用于标注启动类,而是它是一个组合注解
     	2).@SpringBootApplication注解标注的启动类默认扫描启动类所在包下的所有子包(启动类同包下的兄弟包及其所有子包)

##().@Configuration
	表示标注的类是一个配置类,相当于Spring配置文件的beans节点,这个是javaConfig配置必不可少的注解
	
	在类上使用,标识当前类是SpringBoot的上下文配置类.所有自定义,需要覆盖SpringBoot默认配置的都可以
	通过@Configuration注解类中的@Bean注解的方法返回的配置类来覆写.

##@Bean
	作用于方法,配合@Configuration注解使用,标注在方法上,方法的返回值对象是要注入Spring容器的Bean
    @Configuration相当于Spring配置文件的哦beans节点,而@Bean则相当于bean节点.
    
##().@ComponentScan
	扫描Spring的组件,这些组件指的是使用@Controller,@Component,@Repository,@Service注解的类,将这些类注册到Spring的容器中.
		
##().@EnableAutoConfiguration
	开启SpringBoot的自动化配置.启用此注解就启用了Spring对各模块的默认配置.(@Abracadabra咒语,像魔法一样)
	自动配置中使用的条件化注解
	条件化注解                                                                            配置生效条件
	@ConditionalOnBean              配置了某个特定Bean 
	@ConditionalOnMissingBean       没有配置特定的Bean 
	@ConditionalOnClass             Classpath里有指定的类
	@ConditionalOnMissingClass      Classpath里缺少指定的类
	@ConditionalOnExpression        给定的Spring Expression Language（SpEL）表达式计算结果为true
	@ConditionalOnJava              Java的版本匹配特定值或者一个范围值
	@ConditionalOnJndi              参数中给定的JNDI位置必须存在一个，如果没有给参数，则要有JNDI InitialContext
	@ConditionalOnProperty          指定的配置属性要有一个明确的值
	@ConditionalOnResource          Classpath里有指定的资源
	@ConditionalOnWebApplication    这是一个Web应用程序
	@ConditionalOnNotWebApplication 这不是一个Web应用程序
	
    作用在类上,同时是放在SpringBoot的启动类(即包含主方法的那个启动类).
    SpringBoot的最大好处就是可以免去复杂的配置,达到开箱即用.那么这个注解的目的就是让SpringBoot
    根据你pom.xml的jar包依赖来猜想你要干什么,以便给出相应默认的配置.比如你使用了SpringBoot的web模块,
    那么加了这个注解就会同时引入SpringBoot的通用Web模块的相应配置,进而不用去管具体的配置.

##().@ConfigurationProperties
	属性注入注解,作用在类上,作用是将properties配置文件或者yml配置文件中自定义属性注入到当前标注的类的成员变量中,
	成员变量名需要与属性名一一对应才能将相应的属性值注入到类的成员变量中.(关于这个的使用方法有具体的例子)

	开启配置属性 从技术上来说，@ConfigurationProperties注解不会生效，除
	非先向Spring配置类添加@EnableConfigurationProperties注解。但通常无需这么
	做，因为Spring Boot自动配置后面的全部配置类都已经加上了@EnableConfigura- 
	tionProperties注解。因此，除非你完全不使用自动配置（那怎么可能？），否则就
	无需显式地添加@EnableConfigurationProperties。
	还有一点需要注意，Spring Boot的属性解析器非常智能，它会自动把驼峰规则的属性和使用
	连字符或下划线的同名属性关联起来。换句话说，amazon.associateId这个属性和
	amazon.associate_id以及amazon.associate-id都是等价的。用你习惯的命名规则就好

##().@MapperScan
	在类上使用,value属性指定一个包名,用于扫描Mybatis的Dao包接口下的接口,
	SpringBoot与Mybatis整合jar包下的注解(org.mybatis.spring.annotation.MapperScan)
	在主程序启动类(main方法的那一个)上使用.
	
##().@RestController
		在类上使用,标识当前类是一个请求处理类,且请求返回的响应结果全是JSON数据,
	@RestController实际上是SpringMVC的注解,Rest是Restful的前缀.也即是遵循
	restful编程风格,@RestController注解相当于同时添加@ResponseBody + @Controller注解.

##().@RestControllerAdvice
	在类上使用,标识当前类用于统一处理Controller成抛出的异常,Controller处理方法
	的返回的数据最好是JSON数据.因为这个Rest表示要返回JSON数据,而不是页面之类的.
	
##().@ControllerAdvice
	包含@Component,可以被扫描到,统一处理异常.

##().@ExceptionHandler
	在方法前使用,其value值是一个异常类类型对象.当controller抛出的异常对象
	是这个类类型或其子类,则使用@ExceptionHandler注解标注的方法对这个异常进行处理.
	举例说明:
	@ExceptionHandler(value = Exception.class)


##().@Profiles
    Spring Profiles提供了一种隔离应用程序配置的方式，并让这些配置只能在特定的环境下生效。
    任何@Component或@Configuration都能被@Profile标记，从而限制加载它的时机。
    @Configuration  
    @Profile("production")  
    public class ProductionConfiguration {  
        // ...  
    }
	
#SpringBoot单元测试
	SpringBoot单元测试需要单元测试模块,上面的maven依赖中提到过.
	这里再说下,需要加入下面的maven依赖:
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    
        其次,单元测试类@RunWith注解的运行类是SpringRunner类,
        同时需要添加@SpringBootTest注解,用于标识这是SpringBoot的单元测试类.
        就像下面这样:
	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class className {...}

#SpringBoot配置项
		SpringBoot启动时会在classpath下查找application.properties配置文件,
	如果找不到就查找application.yml配置文件.如果这两个配置文件都没有,就使用
	SpringBoot的默认配置.
	SpringBoot配置文件可以使用properties和yml配置文件,如果二者同时使用则使用二者配置合集,冲突的以application.properties为主
	使用yml或properties作为配置文件都是可以的,但要统一,不要混用.
	SpringBoot的属性名不能以驼峰命名法以及下划线命名法命名属性,会报错.(这个真心没想到,测试出的bug)
	
	1.生产环境测试环境切换
		在SpringBoot读取application主配置文件时,可指定读取某个配置文件来加载
	配置.生产环境与测试环境各有一个配置文件.在主配置文件中通过指定读取那个配置文件
	来进行生产环境和测试环境配置文件的切换.
	
	spring.profiles.active 配置文件名称.注意这个名称不是完整的名称.
	举例说明:
		主配置文件名: application.properties
		生产环境配置文件名: application-prod.properties
		测试环境配置文件名: application-dev.properties
	现在如果要使用生产环境的配置,配置如下:
	spring.profiles.active=prod
	所谓的非完整名称,指的是application-后面连缀的字符串名.这也说明配置文件名不能随意
	定义,而是有规则的.
		
	2.数据源配置项
	(1).spring.datasource.url 数据源的url
	(2).spring.datasource.username 数据库用户名
	(3).spring.datasource.password 数据库密码
	(4).spring.datasource.driver-class-name 数据库驱动类完整类名
	示例:
		spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb?useUnicode=true&characterEncoding=utf8
		spring.datasource.username=root
		spring.datasource.password=123456
		spring.datasource.driver-class-name=com.mysql.jdbc.Driver
		
	3.Mybatis全局配置项
		(1).mybatis.typeAliasesPackage 数据库表对应的实体类(POJO)的父包,完整POJO类名的别名(首字母小写的类名)
			以便在mapper配置文件中,可用来替代实体类的完整类名.
		(2).mybatis.mapperLocations Mybatis的mapper映射配置文件classpath下的路径
		示例:
		mybatis.typeAliasesPackage=org.spring.springboot.domain
		mybatis.mapperLocations=classpath:mapper/*.xml

	4.Redis配置
		## Redis 配置
		## Redis数据库索引（默认为0）
		spring.redis.database=0
		## Redis服务器地址
		spring.redis.host=127.0.0.1
		## Redis服务器连接端口
		spring.redis.port=6379
		## Redis服务器连接密码（默认为空）
		spring.redis.password=
		## 连接池最大连接数（使用负值表示没有限制）
		spring.redis.pool.max-active=8
		## 连接池最大阻塞等待时间（使用负值表示没有限制）
		spring.redis.pool.max-wait=-1
		## 连接池中的最大空闲连接
		spring.redis.pool.max-idle=8
		## 连接池中的最小空闲连接
		spring.redis.pool.min-idle=0
		## 连接超时时间（毫秒）
		spring.redis.timeout=0

#yml配置
		yml属性配置与propeties属性配置文件作用都是一样的,只是配置方式不一样.
	yml通过严格的缩进来表示一个属性下的子属性.而properties则是通过点来表示这种
	层级关系.况且properties的属性可以不写在一块.但yml的具有层级关系的属性是需要
	写在一起的.
	举例说明:
	同样表示spring的子属性数据源datasource下的url属性:
	properties:
	spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb
	
	yml:
	spring
		datasource
			url: jdbc:mysql://localhost:3306/springbootdb
	注意url后面的冒号后面还有一个空格.
	
	yml配置文件在配置属性的时候还能引用属性值,也是通过"${父属性名.子属性名}"
	的方式来进行属性的引用.这里主要说一下SpringBoot随机属性的使用方式:
	${random.long} 返回长整数范围内的任意一个数字.
	${random.int[1,200]} 返回一个1到200的整数.
	${random.uuid} 返回一个UUID.

	举例说明:	
	user:
	  id: ${random.long}
	  age: ${random.int[1,200]}
	  desc: 泥瓦匠叫做${random.value}
	  uuid: ${random.uuid}
	  
	  
	yml的一些配置示例:
	(1).
	home:
	  province: 浙江省
	  city: 温岭松门
	  desc: 我家住在${home.province}的${home.city}
	 
#Web表单参数校验
	这个应该是web方面的知识,在这里稍啰嗦下.
		在Controller中在参数前添加@Valid注解表示要对这个参数进行校验,
	这个参数如果是个POJO对象,则可以把校验的注解写在POJO的属性上.如果是基本类型
	可直接将校验注解写在这个参数上.
	POJO上的表单校验注解:	
	
	@Entity
	public class User implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 8, message = "姓名长度必须大于 2 且小于 20 字")
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄大于 0")
    @Max(value = 300, message = "年龄不大于 300")
    private Integer age;

    /**
     * 出生时间
     */
    @NotEmpty(message = "出生时间不能为空")
    private String birthday;
	}
	
