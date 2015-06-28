package com.ola.Topic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ola.subscriber.Subscriber;

public abstract class Topic {

    protected String name;
   	
	private ConcurrentHashMap<Integer, List<Subscriber>> subscriberMap = new ConcurrentHashMap<Integer, List<Subscriber>>();
	private CopyOnWriteArrayList<String> msgList = new  CopyOnWriteArrayList<String>();
	private ConcurrentHashMap<Integer, String> sweeper = new ConcurrentHashMap<Integer, String>();

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
	
	public void register(Subscriber subscriber) {
		List<Subscriber> list = subscriberMap.get(subscriber.getGroupID());
		if(list == null){
			list = new ArrayList<Subscriber>();
		}
		list.add(subscriber);
		subscriberMap.put(subscriber.getGroupID(), list);
	}
	
	public Topic(String topicName) {
		this.name = topicName;
	}
	
	public String getName() {
		return name;
	}

}
