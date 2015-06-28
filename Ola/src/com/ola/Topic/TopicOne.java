package com.ola.Topic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.ola.subscriber.Subscriber;


public class TopicOne extends Topic {
	private ConcurrentHashMap<Integer, List<Subscriber>> subscriberMap = new ConcurrentHashMap<Integer, List<Subscriber>>();
	private List<String> msgList = new  LinkedList<String>();
	private ConcurrentHashMap<Integer, String> sweeper = new ConcurrentHashMap<Integer, String>();
	
	public TopicOne(String topicName){
    	  super(topicName);
      }

	@Override
	public void publish(String msg) {
		msgList.add(msg);
		Set<Integer> groupSet = subscriberMap.keySet();
		Iterator<Integer> it = groupSet.iterator();
		boolean flag = false;
		while(it.hasNext()){
			List<Subscriber> list = subscriberMap.get(it.next());
			for(Subscriber sub: list){
				if(sub.send(msg)){
					flag = true;
					break;
				}
			}
			if(!flag){
				sweeper.put(list.get(0).getGroupID(), msg);
			}
		}
		
	}

	@Override
	public void register(Subscriber subscriber) {
		List<Subscriber> list = subscriberMap.get(subscriber.getGroupID());
		if(list == null){
			list = new ArrayList<Subscriber>();
		}
		list.add(subscriber);
		subscriberMap.put(subscriber.getGroupID(), list);
	}
	
	
}
