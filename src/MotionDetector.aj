import com.bezirk.middleware.addressing.ZirkEndPoint;
import com.bezirk.middleware.messages.Event;

import zirk.events.MotionDetectionEvent;

public aspect MotionDetector {

	pointcut motionDetected() : execution(void MotionDetectionAssistantZirk.receiveEvent(Event, ZirkEndPoint));
	
	void around(Event event, ZirkEndPoint sender) : motionDetected(event, sender){
		
		//Check if this event is of interest
        if (event instanceof MotionDetectionEvent) {
        	proceed(event, sender);
        }
        else System.err.println("Invalid event detected");
	}
}