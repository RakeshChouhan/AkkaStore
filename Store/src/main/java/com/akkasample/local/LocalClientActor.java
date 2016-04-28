package com.akkasample.local;

import akka.actor.ActorSelection;
import akka.actor.UntypedActor;

import com.akkasample.local.helper.OrderUtil;

/**
 * Local client actor which place order to order tracker remote system.
 * @author rakeshc
 *
 */
public class LocalClientActor extends UntypedActor {

	@Override
	public void onReceive(Object object) throws Exception {
		if(object instanceof String){
			String msg = (String)object;
			if(msg.equals("placeOrder")){
				ActorSelection orderTracker= getContext().actorSelection("akka.tcp://OrderTrackerSystem@127.0.0.1:2554/user/OrderTrackerActor");
				orderTracker.tell(OrderUtil.getOrder(), getSelf());
			}else{ // get message from the Order tracker
				System.out.println("---------------------------------");
				System.out.printf("| Got Status from Order Tracker :: %s|",msg);
				System.out.println();
				System.out.println("---------------------------------");
				
			}
		}
	}

}
