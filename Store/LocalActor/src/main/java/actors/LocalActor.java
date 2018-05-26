/**
 * 
 */
package actors;

import akka.actor.AbstractActor;

/**
 * @author Rakesh
 *
 */
public class LocalActor extends AbstractActor{

	@Override
	public Receive createReceive() {
		Receive receive = receiveBuilder().match(String.class, (msg)->{
			System.out.println("Got message from system "+msg);
		}).build();
		return receive;
	}

}
