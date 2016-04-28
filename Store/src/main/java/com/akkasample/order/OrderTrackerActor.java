package com.akkasample.order;

import com.akkasample.bean.Order;

import akka.actor.UntypedActor;
/**
 * Order traker actor which communicate with local actor after tracking the requested order.
 * @author rakeshc
 *
 */
public class OrderTrackerActor extends UntypedActor {

	@Override
	public void onReceive(Object obj) throws Exception {
		if(obj instanceof Order){
			Order order = (Order)obj;
			System.out.println("======================================");
			System.out.printf("| Item name : %s|",order.getItemName());
			System.out.println();
			System.out.printf("| Item price : %f|",order.getPrice());
			System.out.println();
			
			System.out.println("======================================");
			getSender().tell("Tracked your order", getSelf());
		}else{
			unhandled(obj); // pass this object to system to handle.
			
		}
	}

}
