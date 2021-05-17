package AkilliCihaz;

import java.sql.SQLException;
import Kullanici.*;
import Observer.IObserver;
import Sistem.*;
import VeriTabani.*;

public class Program {
	
	static Kullanici getKullanici(AgArayuzu agArayuzu)
	{
		
		agArayuzu.mesajGoruntule("Kullanici Adi..: ");
		String kullAd = agArayuzu.bilgiAl();
		agArayuzu.mesajGoruntule("Sifre..: ");
		String sifre = agArayuzu.bilgiAl();

		
		Kullanici tmp = new Kullanici.Builder().kullaniciAdi(kullAd).sifre(sifre).build();
		
		return tmp;
	}

	static void KullaniciMenu(AgArayuzu agArayuzu, IVeriTabani vt) throws SQLException
	{
		IKIslem KullaniciIslemi;
		int islem = 0;
		do
		{
			agArayuzu.mesajGoruntule("Seciminizi Yapýn..:");
			agArayuzu.mesajGoruntule("1) Kullanici Ekle\n"
					+ "2) Kullanici Sil\n"
					+ "3) Kullanici Guncelle\n"
					+ "4) Kullanici Ara\n"
					+ "5) Exit");
			String deger = agArayuzu.bilgiAl();
			if(deger.equals("1"))
			{
				agArayuzu.mesajGoruntule("Kullanici Bilgilerini Gir..:");
				Kullanici tmp = getKullanici(agArayuzu);
				KullaniciIslemi = new KullaniciEkle(vt);
				KullaniciIslemi.KIslem(tmp);
			}
			
			else if(deger.equals("2"))
			{
				agArayuzu.mesajGoruntule("Hangi Kullaniciyi Silemk Istiyorsunuz?..");
				vt.veritabaniYazdir();
				Kullanici tmp = getKullanici(agArayuzu);
				KullaniciIslemi = new KullaniciSil(vt);
				KullaniciIslemi.KIslem(tmp);
			}
			
			else if(deger.equals("3"))
			{
				agArayuzu.mesajGoruntule("Hangi Kullaniciyi Guncellemek Istiyorsunuz?..");
				vt.veritabaniYazdir();
				Kullanici tmp = getKullanici(agArayuzu);
				KullaniciIslemi = new KullaniciGuncelle(vt);
				KullaniciIslemi.KIslem(tmp);
			}
			
			else if(deger.equals("4"))
			{
				agArayuzu.mesajGoruntule("Aramak Istediginiz Kullanici?..");
				KullaniciIslemi = new KullaniciAra(vt);
				KullaniciIslemi.KIslem(getKullanici(agArayuzu));
			}
			
			else if(deger.equals("5"))
			{
				islem++;
			}
		}while(islem == 0);
	}

	static void SistemMenu(AgArayuzu agArayuzu, sogutucu s1, eyleyici e1, sicaklikAlgilayici si1) throws SQLException
	{
		int islem = 0;
		IIslem Sislem;
		do
		{
			agArayuzu.mesajGoruntule("Seciminizi Yapiniz...");
			agArayuzu.mesajGoruntule("1) Sogutucu Ac\n"
					+ "2) Sogutucu Kapat\n"
					+ "3) Sicaklik Goruntule\n"
					+ "4) Exit");
			String value = agArayuzu.bilgiAl();
			
			if(value.equals("1"))
			{
				Sislem = new sogutucuAc(s1);
				e1.islemYap(Sislem);
			}
			
			else if(value.equals("2"))
			{
				Sislem = new sogutucuKapat(s1);
				e1.islemYap(Sislem);
			}
			
			else if(value.equals("3"))
			{
				Sislem = new sicaklikGoruntule(si1.sicaklikGetir());
				si1.islemYap(Sislem);
			}
			
			else if(value.equals("4"))
			{
				islem++;
			}
			
		}while(islem == 0);
	}
	
	public static void main(String[] args) throws SQLException {
		
		IVeriTabani postgresql = new PostgreSql();
		sicaklikAlgilayici sicaklikAlgilayicisi = new sicaklikAlgilayici();
		sogutucu s1 = new sogutucu();
		eyleyici e1 = new eyleyici();
		AgArayuzu agArayuzu = new AgArayuzu();
		s1.ekle(agArayuzu);
		//IKIslem kIslem;
		
		boolean kontrol = false;
		do
		{			
			agArayuzu.mesajGoruntule("Bilgilerinizi Giriniz");
			
			
			Kullanici k1 = getKullanici(agArayuzu);
			
			kontrol = postgresql.KullaniciDogrula(k1);
			
		}while(!kontrol);
		
		int islem = 0;
		
		do
		{
			agArayuzu.mesajGoruntule("Seçiminizi Yapin..\n");
			agArayuzu.mesajGoruntule("1) Kullanici Islemleri\n2) Sistem Islemleri\n3) Cikis");
			String deger = agArayuzu.bilgiAl();
			
			if(deger.equals("1"))
			{
				KullaniciMenu(agArayuzu, postgresql);
			}
			
			else if(deger.equals("2"))
			{
				SistemMenu(agArayuzu, s1, e1, sicaklikAlgilayicisi);
			}
			
			else if(deger.equals("3"))
			{
				islem++;
			}
			
		}while(islem == 0);
	}
		
	

}
