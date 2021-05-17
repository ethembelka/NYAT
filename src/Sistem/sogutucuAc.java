package Sistem;

public class sogutucuAc implements IIslem{

	private sogutucu s1;
	public sogutucuAc(sogutucu s1) {
		super();
		this.s1 = s1;
	}
	
	
	@Override
	public void islemYap() {
		if(s1.getSogutucuDurum() == true) {
			System.out.println("Sogutucu Zaten Acik");
		}
		else {
			s1.setSogutucuDurum(true);
			//System.out.println("dene");
		}
	}
	
}
