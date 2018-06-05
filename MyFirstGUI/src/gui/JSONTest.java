package gui;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import data.Person;


public class JSONTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try{
		
		
			
			
			Writer writer=new FileWriter("C:\\temp\\output.json");
		
		Gson gson=new GsonBuilder().serializeNulls().create();
		//
//		gson.toJson("Hallo",writer);
//		gson.toJson(1234,writer);
		
				
		Person p=new Person();
		p.setVorname("MAX");
		p.setNachname("mUSTERMANN");
		//
        ArrayList<Person> personen= new ArrayList<>();
		personen.add(p);
		personen.add(p);
		personen.add(p);
		gson.toJson(p,writer);
		
		writer.flush();
		writer.close();		
		
		
		
		
		
		Reader r= new FileReader("C:\\temp\\output.json");
		ArrayList<Person> personenread = new ArrayList<>() ;
		java.lang.reflect.Type listType= new TypeToken <ArrayList<Person>>() {}.getType();
		personenread =gson.fromJson(r, listType);
		for(Person p2: personenread )
			System.out.println(p2);
		
		
		
		
		
		}catch (IOException e) {
		e.printStackTrace();
		}
		}
	}


