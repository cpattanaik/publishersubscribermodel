package com.ola.subscriber;

import com.ola.Topic.Topic;


public class SubscriberOne extends Subscriber {

	public SubscriberOne(Topic topicOne, int groupID) {
		super(groupID);
		topicOne.register(this);
	}

}
