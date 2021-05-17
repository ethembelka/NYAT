package VeriTabani;

import java.sql.*;
import Kullanici.Kullanici;
import AkilliCihaz.AgArayuzu;

public class PostgreSql implements IVeriTabani{
	private Connection bgl;
	private String url;
	private AgArayuzu agArayuzu;
	
	public PostgreSql() throws SQLException {
		this.bgl = null;
		this.url = "jdbc:postgresql://localhost:5432/NYATOdev2";
		agArayuzu = new AgArayuzu();
		this.baglanti();
	}
	
	public boolean KullaniciDogrula(Kullanici kullanici) throws SQLException {
		boolean bagliMi = false;
		//String sql = "SELECT * FROM \"kullanici\" WHERE \"isim\"=$kullanici.getKullaniciAdi() AND sifre=$kullanici.getSifre";
		String sql = "SELECT * FROM kullanici";
		Statement st = bgl.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			String isim = rs.getString("isim");
			String sifre = rs.getString("sifre");
			if(isim.equals(kullanici.getKullaniciAdi()) && sifre.equals(kullanici.getSifre())) {
				return true;
				
			}
				
		}
		rs.close();
		
		return bagliMi;
	}
	
	@Override
	public void baglanti() throws SQLException {
		bgl = DriverManager.getConnection(url, "postgres", "Ethem.2151");
		System.out.println("Veritabanina Baglandi...:)");
		
	}

	public void veritabaniYazdir() throws SQLException {
		
		Statement st = bgl.createStatement();
		ResultSet rs = st.executeQuery("select * from public.kullanici;");
		while(rs.next())
		{
			System.out.println("Kullanicinin..: \nAdi..: "+ rs.getString("isim")+", Sifresi..: "+ rs.getString("sifre")
			+", id'si..: "+ rs.getInt("id")+"\n");
		}
		
	}
	
	@Override
	public void sorguCalistir(String sorgu) throws SQLException {
		Statement st = bgl.createStatement();
		st.executeUpdate(sorgu);
	}

}
