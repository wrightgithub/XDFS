/**
 * 
 */
package com.xdfs.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wanggengqi
 * @email wanggengqi@chinasofti.com
 * @date 2014��10��23�� ����1:56:05
 */
public class Main {

	/**
	 * @author wanggengqi
	 * @date 2014��10��23�� ����1:56:05
	 * @param args
	 * @return void
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationProvider.xml" });
		context.start();
		System.out.println("��������˳�");
		System.in.read();
	}

}
