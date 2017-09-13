package com.iceDarron.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.iceDarron.core.service.IUserService;
import com.iceDarron.data.mysql.pojo.User;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
  
public class TestMyBatis {  
	
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private IUserService userService = null;  
  
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    public void test1() {
        User user = userService.getUserById(1);  
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(user));  
    }
    
}  
