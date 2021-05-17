package Sistem;

public class sogutucuKapat implements IIslem {

	private sogutucu s1;
	
	public sogutucuKapat(sogutucu s1) {
		super();
		this.s1 = s1;
		
	}
	
	@Override
	public void islemYap() {
		if(s1.getSogutucuDurum() == false) {
			System.out.println("Sogutucu Zaten Kapali");
		}
		else {
			s1.setSogutucuDurum(false);
			//System.out.println("kapa");
		}
		
	}

}
