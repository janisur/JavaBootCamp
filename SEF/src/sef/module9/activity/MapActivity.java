package sef.module9.activity;
//Needs to be completed

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import sef.module9.sample.MapSample;


public class MapActivity {

		public static void main(String[] args) {
			//1 - Type code to create a HashMap of key value pair
			//where key is id of type String and value is a name
			
			Map keyvalues = new HashMap();
			
			keyvalues.put("1", "This");
			keyvalues.put("2", "is a value");
			keyvalues.put("3", "of multiple ");
			keyvalues.put("4", "Strings.");
			
			//System.out.println(keyvalues.get("1"));
			//System.out.println(" = ");
			//System.out.println(keyvalues.get("4"));
		
			
			//2 - Call print method to print the map passed as its parameter.
			new MapActivity().print(keyvalues);
		}
		
		void print(Map map)
		{
			//3 - Type code to print this map
			
			Set keySet = map.keySet();
			
			System.out.println("*************************************");
			System.out.println("Key\tValue"); // \t = tab
			System.out.println("*************************************");
			Iterator forreal=keySet.iterator();
			while(forreal.hasNext())
			{
				String key=(String)forreal.next();
				System.out.println(key+"\t"+map.get(key));
			}
			
			System.out.println("*************************************");
			
		
		}
	}
