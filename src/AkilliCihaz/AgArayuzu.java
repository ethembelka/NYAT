package AkilliCihaz;

import java.util.Scanner;

import Observer.Observerable;
import Observer.IObserver;
import Sistem.sogutucu;

public class AgArayuzu implements IObserver {
	public void mesajGoruntule(String mesaj)
	{
		System.out.println(mesaj);
	}
	
	public String bilgiAl()
	{
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	
	public void guncelle(Observerable observable)
	{
		sogutucu s1 = (sogutucu) observable;
		System.out.println("girdi");
		if(s1.getSogutucuDurum() == true)
			System.out.println("Sogutucu Acildi");
		else if(s1.getSogutucuDurum() == false)
			System.out.println("Sogutucu Kapatildi");
	}
}
