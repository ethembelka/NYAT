package Sistem;

import Observer.Observerable;

public class sogutucu extends Observerable {
	private boolean sogutucuDurum;
	
	public sogutucu() {
		sogutucuDurum = false;
	}
	
	public boolean getSogutucuDurum() {
		return sogutucuDurum;
	}
	
	public void setSogutucuDurum(boolean sogutucuDurumAyarla) {
		sogutucuDurum = sogutucuDurumAyarla;
		bildirimYolla();
	}
	
}
