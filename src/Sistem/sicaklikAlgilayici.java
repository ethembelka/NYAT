package Sistem;

import java.util.*;

public class sicaklikAlgilayici {
	public int sicaklikGetir()
	{
		Random r = new Random();
		
		int sicaklik = r.nextInt(100)+-60;
		
		return sicaklik;
	}
	
	public void islemYap(IIslem islem)
	{
		islem.islemYap();
	}
}
