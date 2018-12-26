package com.servant.wiki.common.design.factory;

import com.servant.wiki.common.design.Sender;
import com.servant.wiki.common.design.SmsSender;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
