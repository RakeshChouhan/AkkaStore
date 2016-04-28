package com.akkasample.local;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;

public class LocalClient {
	public static void main(String args[]){
		startLocalClient();
	}
	
	public static void startLocalClient(){
		ActorSystem localsystem = ActorSystem.create("LocalClientSystem",ConfigFactory.load("local"));
		ActorRef localActor = localsystem.actorOf(Props.create(LocalClientActor.class),"LocalClientActor");
		localActor.tell("placeOrder", ActorRef.noSender());
	}

	

}
