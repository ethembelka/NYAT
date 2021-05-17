package VeriTabani;

import java.sql.SQLException;

import Kullanici.*;

public interface IVeriTabani {
	void baglanti() throws SQLException;
	boolean KullaniciDogrula(Kullanici kullanici) throws SQLException;
	void veritabaniYazdir() throws SQLException;
	void sorguCalistir(String query) throws SQLException;
}
