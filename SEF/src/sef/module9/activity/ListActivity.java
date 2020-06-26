package sef.module9.activity;
//Needs to be completed

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sef.module9.sample.ListSample;

public class ListActivity {

	public static void main(String[] args) {
		//1 - Type code to create a list of names. Use ArrayList.
		
		List names = new ArrayList();
		
	    names.add("Andris");
	    names.add("Bruno");
	    names.add("Cimze");
		
		//2 - Call print method to print the list passed as its parameter.
		
		ListActivity obj=new ListActivity();
	    obj.print(names);
	    

		
	}
	
	void print(List names)
	{
		//3 - Type code to print this list
		//Notice the order in which elements get printed.
		
		Iterator i = names.iterator();
		while(i.hasNext()) {
		System.out.println(i.next());
		}
	
	}
}
