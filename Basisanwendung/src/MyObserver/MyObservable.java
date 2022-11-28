package MyObserver;

public interface MyObservable {
	
	public void addObserver(MyObserver obs );
	public void removeObserver(MyObserver obs);
	public void notifyObservers();

}
