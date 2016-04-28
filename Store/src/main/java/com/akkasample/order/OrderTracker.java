package com.akkasample.order;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


/**
 * Tracker program to get the orders from the client program.
 * @author rakeshc
 *
 */
public class OrderTracker {

	public static void main(String[] args) {
		ActorSystem orderTrackerSystem = ActorSystem.create("OrderTrackerSystem", ConfigFactory.load("order"));
		ActorRef ref = orderTrackerSystem.actorOf(Props.create(OrderTrackerActor.class),"OrderTrackerActor");
	}

}
