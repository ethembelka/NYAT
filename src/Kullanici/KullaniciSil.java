package Kullanici;
import java.sql.SQLException;
import VeriTabani.IVeriTabani;

public class KullaniciSil implements IKIslem{
	private IVeriTabani postgresql;
	String sorgu;

	public KullaniciSil(IVeriTabani postgresql) {
		
		this.postgresql = postgresql;
	}

	@Override
	public void KIslem(Kullanici kullanici) throws SQLException {
		
		sorgu = "delete from public.kullanici where isim ='"+kullanici.getKullaniciAdi()+"';";
		postgresql.sorguCalistir(sorgu);
		
	}
}
