package com.xdfs.client.dubbo.action;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xdfs.server.dubbo.service.DemoServer;

public class ChatAction {
    /**
     * 
     * @author wanggengqi
     * @date 2014年10月23日 下午3:13:04
     */
    public void SayHello(){ 
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationConsumer.xml" });
	context.start();
	DemoServer demoServer = (DemoServer) context.getBean("demoService");
	System.out.println("client:"+demoServer.sayHello("Wanggq"+"1:"+new Date())+"3:"+new Date());
    }

}
