package com.itpkm.springmvclog4j2.rmi;

/**
 * 远程代码执行类
 *
 * @author itpkm
 * @date 2021年12月14日
 */
public class EvillObj {

    static {
        System.out.println("哈哈哈，演示该区域代码执行位置");
        System.out.println("哈哈哈，删掉你的应用，干掉你的服务器");
    }

    public EvillObj() {
        //TODO：do something
    }

    @Override
    public String toString() {
        System.out.println("=========【破坏能力演示】======");
        System.out.println("root>rm -rf /");
        System.out.println("=========删除服务器根目录======");

        return "Hi,你的服务器已停止呼吸！！！";
    }
}
