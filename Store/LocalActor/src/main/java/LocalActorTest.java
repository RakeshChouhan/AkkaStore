import actors.LocalActor;
import akka.actor.ActorPath;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;

public class LocalActorTest {
	
	public static void main(String args[]) {
		 ActorSystem system = ActorSystem.create("LocalActorSystem");
		 ActorRef ref = system.actorOf(Props.create(LocalActor.class),"MyLocalActor");
		 ref.tell("Hello Akka", ActorRef.noSender());
		 System.out.println(ref.path());
		 
		 ActorSelection ref2 = system.actorSelection("akka://LocalActorSystem/user/MyLocalActor");
		 ref2.tell("Call by Actor Selection 1", ActorRef.noSender());
		 
		 ActorSelection ref3 = system.actorSelection(ActorPath.fromString("akka://LocalActorSystem/user/MyLocalActor"));
		 ref3.tell("Call by Actor Selection 2", ActorRef.noSender());
		 
		 ActorRef ref4 = system.actorOf(Props.create(LocalActor.class),"MyNewActor");
		 Inbox inbox =Inbox.create(system);
		 inbox.send(ref4, "Send Message through Inbox");
		 system.terminate();
		
	}

}
