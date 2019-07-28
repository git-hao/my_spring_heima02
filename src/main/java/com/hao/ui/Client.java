package com.hao.ui;

import com.hao.service.UserService;
import com.hao.service.UserServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @Describe com.hao.ui
 * @Auther wenhao chen
 * @CreateDate 2019/7/28
 * @Version 1.0
 * 模拟表现层，调用业务层
 * 获取spring的ioc核心容器，根据id获取对象
 * ApplicationContext的三个常用实现类
 *      ClassPathXmlApplicationContext
 *          加载类路径下的配置文件
 *      FileSystemApplicationContext
 *          加载磁盘任意路径下的配置文件
 *      AnnotationConfigApplicationContext
 *          读取注解创建容器
 *
 * 核心容器的两个接口：
 * ApplicationContext:单例对象适用，常用
 *      构建核心容器时，创建对象采用立即加载
 * BeanFactory:多例对象适用
 *      构建核心容器，延迟加载，根据id获取对象时，开始创建对象
 *
 */
public class Client {
    public static void main(String[] args){
            //获取核心容器对象----此处断点，验证核心容器加载对象方式
            ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
            //根据id获取bean对象
                //强转
            UserService us = (UserService) ac.getBean("userService");
                //传字节码，自动转型
            UserService us2 = ac.getBean("userService",UserService.class);
            System.out.println("us1="+us+"...us2="+us2+"...us == us2?"+(us == us2));

            us.saveUser();


           //BeanFactory,断点验证创建对象方式
           /*
            Resource resource = new ClassPathResource("ApplicationContext.xml");
            BeanFactory factory = new XmlBeanFactory(resource);

            UserService us = (UserService) factory.getBean("userService");
            System.out.println(us);
            */
        }

}
