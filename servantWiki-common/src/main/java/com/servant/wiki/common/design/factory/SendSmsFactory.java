package com.servant.wiki.common.design.factory;

import com.servant.wiki.common.design.Sender;
import com.servant.wiki.common.design.SmsSender;

public class SendSmsFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}

	public static void main(String[] args) {
		Provider provider = new SendSmsFactory();
		Sender sender = provider.produce();
		sender.send();
	}
}
