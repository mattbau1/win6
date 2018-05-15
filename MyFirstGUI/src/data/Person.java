package data;

import java.util.ArrayList;

public class Person {
	
	
	private String vorname;
	private String nachname;
	private String adresse;
	private int plz;
	
	private static  ArrayList<Person> personenliste= new ArrayList<>();
	
		public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public static ArrayList<Person> getPersonenliste() {
		return personenliste;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
