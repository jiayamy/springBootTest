package com.servant.wiki.common.design.build;

import java.util.ArrayList;
import java.util.List;

import com.servant.wiki.common.design.MailSender;
import com.servant.wiki.common.design.Sender;
import com.servant.wiki.common.design.SmsSender;

public class Builder {

	private List<Sender> list = new ArrayList<>();

	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender());
		}
	}
	
	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceMailSender(10);
		for(Sender sender : builder.list){
			sender.send();
		}
	}
}
