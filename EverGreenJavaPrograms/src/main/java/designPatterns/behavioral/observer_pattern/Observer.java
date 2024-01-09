package designPatterns.behavioral.observer_pattern;

public interface Observer {
// All potential observers need to implement the observer interface. This interface has just one method, update()
// that gets called when the subject's state changes.
	 public void update();
	
}
