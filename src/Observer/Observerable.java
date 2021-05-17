package Observer;

import java.util.*;

public abstract class Observerable {
	private List<IObserver> observerlist;
	
	public Observerable() {
		observerlist = new ArrayList<>();
	}
	
	public void ekle(IObserver observer) {
		observerlist.add(observer);
	}
	
	public void sil(IObserver observer) {
		observerlist.remove(observer);
	}
	
	public void bildirimYolla() {
		for(IObserver observer : observerlist) {
			observer.guncelle(this);
		}
	}
	
}
