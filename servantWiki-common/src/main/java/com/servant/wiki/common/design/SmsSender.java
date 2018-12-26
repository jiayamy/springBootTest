package com.servant.wiki.common.design;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is sms sender!"); 
	}

}
