package stackoverflow.entities.observer;

import stackoverflow.entities.Event;

public interface PostObserver 
{
	void onPostEvent(Event event);
}
