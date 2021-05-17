package Kullanici;
import VeriTabani.IVeriTabani;

public class KullaniciAra implements IKIslem {
	private IVeriTabani postgresql;
	
	

	public KullaniciAra(IVeriTabani postgresql) {
		
		this.postgresql = postgresql;
	}



	@Override
	public void KIslem(Kullanici kullanici) {
		
		
		
	}
}
