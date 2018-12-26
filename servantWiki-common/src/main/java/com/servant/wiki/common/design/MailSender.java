package com.servant.wiki.common.design;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("this is mailsender!");
	}

}
