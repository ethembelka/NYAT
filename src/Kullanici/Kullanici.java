package Kullanici;
import AkilliCihaz.AgArayuzu;


public class Kullanici {
	private String kullaniciAdi;
	private String sifre;
	private AgArayuzu agArayuzu;
	
	public Kullanici(Builder builder)
	{
		this.kullaniciAdi = builder.kullaniciAdi;
		this.sifre = builder.sifre;
		
		agArayuzu = new AgArayuzu();
	}
	
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}


	public String getSifre() {
		return sifre;
	}
	
	/*BUILDER*/
	public static class Builder
	{
		private String kullaniciAdi;
		private String sifre;
		
		public Builder kullaniciAdi(String kullaniciAdi)
		{
			this.kullaniciAdi = kullaniciAdi;
			return this;
		}
		
		public Builder sifre(String sifre)
		{
			this.sifre = sifre;
			return this;
		}
		
		public Kullanici build()
		{
			return new Kullanici(this);
		}
	}
	/*(BUILDER)*/

	@Override
	public String toString()
	{
		return "Kullanicinin Adi..: "+kullaniciAdi+"\n"+"Sifresi..: "+sifre+"\n";
	}
	
	public Kullanici getKullanici()
	{
		agArayuzu.mesajGoruntule("Kullanici Adini Gir: ");
		String tmpKAd = agArayuzu.bilgiAl();
		
		agArayuzu.mesajGoruntule("Þifreyi Gir: ");
		String tmpSifre = agArayuzu.bilgiAl();
		
		Kullanici tmpKullanici = new Kullanici.Builder().kullaniciAdi(tmpKAd).sifre(tmpSifre).build();
		
		return tmpKullanici;
	}
}
