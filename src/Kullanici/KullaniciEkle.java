package Kullanici;

import java.sql.SQLException;
import VeriTabani.IVeriTabani;

public class KullaniciEkle implements IKIslem {
	
	private IVeriTabani postgresql;
	String query;

	public KullaniciEkle(IVeriTabani postgresql) {
		
		this.postgresql = postgresql;
	}

	@Override
	public void KIslem(Kullanici kullanici) throws SQLException {
		
		query = "insert into public.kullanici(isim, sifre) values ('"+kullanici.getKullaniciAdi()+
				"','"+kullanici.getSifre()+"')";
		postgresql.sorguCalistir(query);
		
	}

}
