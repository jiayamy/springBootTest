package com.servant.wiki.common.design.factory;

import com.servant.wiki.common.design.MailSender;
import com.servant.wiki.common.design.Sender;
import com.servant.wiki.common.design.SmsSender;

public class SendFactory {

	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型!");
			return null;
		}
	}

	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender producdeSms() {
		return new SmsSender();
	}

	public static void main(String[] args) {
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produce("mail");
		sender.send();
		SendFactory.producdeSms();
	}
}
