1      og4j.rootCategory=INFO, stdout , R

此句为将等级为INFO的日志信息输出到stdout和R这两个目的地，stdout和R的定义在下面的代码，可以任意起名。等级可分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL，如果配置OFF则不打出任何信息，如果配置为INFO这样只显示INFO, WARN, ERROR的log信息，而DEBUG信息不会被显示，具体讲解可参照第三部分定义配置文件中的logger。

3       log4j.appender.stdout=org.apache.log4j.ConsoleAppender

此句为定义名为stdout的输出端是哪种类型，可以是

org.apache.log4j.ConsoleAppender（控制台），

org.apache.log4j.FileAppender（文件），

org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），

org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）

org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）

具体讲解可参照第三部分定义配置文件中的Appender。

4       log4j.appender.stdout.layout=org.apache.log4j.PatternLayout

此句为定义名为stdout的输出端的layout是哪种类型，可以是

org.apache.log4j.HTMLLayout（以HTML表格形式布局），

org.apache.log4j.PatternLayout（可以灵活地指定布局模式），

org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），

org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）

具体讲解可参照第三部分定义配置文件中的Layout。

5       log4j.appender.stdout.layout.ConversionPattern= [QC] %p [%t] %C.%M(%L) | %m%n

如果使用pattern布局就要指定的打印信息的具体格式ConversionPattern，打印参数如下：

%m 输出代码中指定的消息

%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL

%r 输出自应用启动到输出该log信息耗费的毫秒数

%c 输出所属的类目，通常就是所在类的全名

%t 输出产生该日志事件的线程名

%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”

%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921

%l 输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。

[QC]是log信息的开头，可以为任意字符，一般为项目简称。

输出的信息

[TS] DEBUG [main] AbstractBeanFactory.getBean(189) | Returning cached instance of singleton bean 'MyAutoProxy'

具体讲解可参照第三部分定义配置文件中的格式化日志信息。

7       log4j.appender.R=org.apache.log4j.DailyRollingFileAppender

此句与第3行一样。定义名为R的输出端的类型为每天产生一个日志文件。

8       log4j.appender.R.File=D:\\Tomcat 5.5\\logs\\qc.log

此句为定义名为R的输出端的文件名为D:\\Tomcat 5.5\\logs\\qc.log可以自行修改。

9       log4j.appender.R.layout=org.apache.log4j.PatternLayout

与第4行相同。

10     log4j.appender.R.layout.ConversionPattern=%d-[TS] %p %t %c - %m%n

与第5行相同。

12     log4j.logger.com. neusoft =DEBUG

指定com.neusoft包下的所有类的等级为DEBUG。

可以把com.neusoft改为自己项目所用的包名。

13     log4j.logger.com.opensymphony.oscache=ERROR

14     log4j.logger.net.sf.navigator=ERROR

这两句是把这两个包下出现的错误的等级设为ERROR，如果项目中没有配置EHCache，则不需要这两句。

15     log4j.logger.org.apache.commons=ERROR

16     log4j.logger.org.apache.struts=WARN

这两句是struts的包。

17     log4j.logger.org.displaytag=ERROR

这句是displaytag的包。（QC问题列表页面所用）

18     log4j.logger.org.springframework=DEBUG

此句为Spring的包。

24     log4j.logger.org.hibernate.ps.PreparedStatementCache=WARN

25     log4j.logger.org.hibernate=DEBUG


------------------------------------------------------------------------------------------------------------------------
关于idea日志和控制台如何输出日志及乱码问题解决方案

配置log4j需要在web.xml增加两处配置：
 <!-- Log4j配置 -->
<context-param>
    <param-name>log4jConfigLocation</param-name>
    <param-value>
        classpath:properties/log4j.properties
    </param-value>
</context-param>
<!-- 加载log4j配置文件 -->
<listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
</listener>
并需要注意org.springframework.web.util.Log4jConfigListener要在org.springframework.web.util.IntrospectorCleanupListener之前方可保证读取的配置文件可以不再src下

中文乱码需要修改四个部分：
1.idea安装目录下的bin/idea64.exe.vmoptions和bin/idea.exe.vmoptions追加-Dfile.encoding=UTF-8
2.log4j对应的properties文件中需要增加log4j.appender.F.Encoding=utf-8（其中F是自定义的）
3.idea--》setting--》File encoding--》修改三处编码集为UTF-8
4.发布服务器修改，edit configuration--》VM options=-Dfile.encoding=UTF-8
注意大小写，注意所有配置文件后面不要有空格！不要有空格！不要有空格！

------------------------------------------------------------------------------------------------------------------------
关于解决配置mysql和redis的问题

1.web.xml中加载一个总的xml配置文件：
<!-- Spring和mybatis的配置文件 -->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
        classpath:config/application-top.xml
    </param-value>
</context-param>

2.在这个总的xml文件中加载mybatis和jedis的连接池及参数配置
<!-- 引入配置文件 -->
<bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="locations">
        <list>
            <!-- 这里支持多种寻址方式：classpath和file -->
            <value>classpath:properties/redis.properties</value>
            <value>classpath:properties/jdbc.properties</value>
        </list>
    </property>
</bean>
<import resource="jedis.xml"/>
<import resource="spring-mybatis.xml"/>

3.每个连接池的配置方式无特殊，需要注意的是参数标识的写法，调用的连接池参数类正确，自动扫描包下带有注解的类，通过spring加载类。
  对应的实体类需要通过注释标注，如Controller，Service， Repository