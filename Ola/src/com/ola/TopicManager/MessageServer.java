package com.ola.TopicManager;

import java.util.concurrent.CopyOnWriteArrayList;
import com.ola.Topic.Topic;

public class MessageServer {
	CopyOnWriteArrayList <Topic>  topicList= new CopyOnWriteArrayList<Topic>();

	public void addTopic(Topic topicOne) {
		topicList.add(topicOne);
	}
}
