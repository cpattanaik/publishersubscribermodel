package com.ola.publisher;

import com.ola.Topic.Topic;
import com.ola.TopicManager.MessageServer;

public class Publisher {
	private Topic topicOne;
    private MessageServer messageServer =  new MessageServer();
	public Publisher(Topic topicOne) {
		messageServer.addTopic(topicOne);
		this.topicOne = topicOne;
	}

	public void publish(String msg) {
		topicOne.publish(msg);
	}

}
