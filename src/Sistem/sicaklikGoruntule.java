package Sistem;

public class sicaklikGoruntule implements IIslem {
	
	private int sicaklik;
	
	
	public sicaklikGoruntule(int sicaklik) {
		this.sicaklik = sicaklik;
	}

	
	
	@Override
	public void islemYap() {
		System.out.println("Sicaklik: " + sicaklik);
		
	}

}
