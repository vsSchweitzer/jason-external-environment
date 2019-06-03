import java.util.Iterator;
import java.util.Queue;
import jason.asSemantics.Agent;
import jason.asSemantics.Event;
import jason.asSyntax.Trigger;

// This class complements the Cleaning Robots agent.
//  It's main change is giving higher priority to "forget" actions so that it doesn't goes to clean trash.
public class CleaningAgent extends Agent {
	
	static Trigger focus = Trigger.parseTrigger("+forget(_,_)");

	@Override
	public Event selectEvent(Queue<Event> events) {
		Iterator<Event> i = events.iterator();
		while (i.hasNext()) {
			Event e = i.next();
			if (isFocus(e)) {
				i.remove();
				return e;
			}
		}
		return super.selectEvent(events);
	}

	private boolean isFocus(Event e) {
		return e.getTrigger().getLiteral().getFunctor().equals(focus.getLiteral().getFunctor());
	}

}
