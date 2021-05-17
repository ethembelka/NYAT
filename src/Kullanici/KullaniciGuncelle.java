package Kullanici;

import java.sql.SQLException;
import java.util.Scanner;
import VeriTabani.IVeriTabani;

public class KullaniciGuncelle implements IKIslem {
	private IVeriTabani postgresql;
	String sorgu;

	public KullaniciGuncelle(IVeriTabani postgresql) {
		
		this.postgresql = postgresql;
	}

	@Override
	public void KIslem(Kullanici kullanici) throws SQLException {
		System.out.println("Yeni Kullanici Adini Girin:");

		Scanner in = new Scanner(System.in);
		String tmpKullanici_adi = in.nextLine();
		System.out.println("Yeni Sifre Giriniz:");
		String tmpSifre = in.nextLine();
		
		//sorgu = "update kullanici set isim=" + tmpKullanici_adi + ", sifre=" + tmpSifre + "where isim=ethem";
		
		sorgu = "update kullanici set isim = '"+tmpKullanici_adi+
				"', sifre = '"+tmpSifre+"' where isim = '"+kullanici.getKullaniciAdi()+"';";
		postgresql.sorguCalistir(sorgu);
		
	}
}
