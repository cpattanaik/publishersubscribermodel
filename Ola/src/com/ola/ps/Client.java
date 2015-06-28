package com.ola.ps;

import com.ola.Topic.Topic;
import com.ola.Topic.TopicOne;
import com.ola.publisher.Publisher;
import com.ola.publisher.PublisherOne;
import com.ola.subscriber.Subscriber;
import com.ola.subscriber.SubscriberOne;

public class Client {
		@SuppressWarnings("unused")
		public static void main(String[] args){
		
		Topic topicOne = new TopicOne("xyz");
		int groupID = 7;
		
		Subscriber subscriber1 = new SubscriberOne(topicOne, groupID);
		Subscriber subscriber2 = new SubscriberOne(topicOne, groupID);
		Publisher publisher = new PublisherOne(topicOne);
		
		String msg = "hi";
		publisher.publish(msg);
	}
}
