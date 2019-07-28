# my_spring_heima02
spring黑马教程练习02
# spring bean
[原视频](https://www.bilibili.com/video/av47952931/?p=12)

## 耦合：
    程序间的依赖关系
        类，方法
## 解耦：
    降低程序间的依赖关系
    实际开发中：编译期不依赖，运行时开始依赖
    解耦思路：
        1，创建对象是使用反射，避免使用new
        2，通过读取配置文件获取要创建的对象的全限定类名

## Bean:
    计算机语言中，指代可重用组件
## JavaBean:
    用java语言编写的可重用组件
## 范围：
    javabean > 实体类
    
## BeanFactory创建JavaBean：

- 第一步
    需要一个配置文件配置service和dao
    唯一标识 = 全限定类名（key = value）
- 第二步
    通过读取配置文件，使用反射创建对象
## 配置文件格式：
*.xml  .properties*

## 核心容器接口：
- ApplicationContext:单例对象适用（实际开发常用）
    构建核心容器时，创建对象立即加载，只有读取了配置文件，就立即创建文件中的对象
- BeanFactory:多例对象适用
    构建核心容器时，创建对象延迟加载，根据id获取对象时，才会创建对象

### ApplicationContext常用实现类
*ClassPathXmlApplicationContext:*
    加载类路径下的配置文件，要求配置文件必须在类路径下
*FileSystemXmlApplicationContext:*
    加载磁盘任意可访问路径下的文件
*AnnotationConfigApplicationContext:*
    读取注解创建容器

### bean的三种创建方式
    ![bean三种创建方式](C:\Users\Claire Dong\Pictures\Camera Roll "bean三种创建方式")

### bean的作用范围
    bean标签scope属性：
    singleton:单例（默认）
    prototypr:多例
    request:web请求范围
    session:web会话范围
    golbal-session:集群环境的会话范围（全局会话范围），若不是集群环境，等于session

