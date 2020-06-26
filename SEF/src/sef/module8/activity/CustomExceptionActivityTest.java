package sef.module8.activity;
//Needs to be completed
//This program accepts a user name and checks user's validity
//The user name is checked against an array of names.

import sef.module8.sample.CustomException;

public class CustomExceptionActivityTest {

	//1 - Type main method and call validateUser() from it.
	//Call this method with different names to test it 
	
	public static void main(String[] args) {
		String name = new String();
		name = "Zenta";		
		try {validateUser(name);
		
		
		} catch (CustomExceptionActivity e) {
			//System.out.println("Check your name input!");
			System.out.println(e.getMessage()); 
		} 
		
	}


public static void validateUser(String name) throws CustomExceptionActivity
{
	//array of names
String []validUsers={"John","Mike","Shanti","Stacie"};
//flag stores 1 if a match is found else it should remain 0 
int flag=0;
for(int i=0;i<4;i++)
{
	if(validUsers[i] == name) {
		flag=1;
		//System.out.println("Greaaaat!");
	   }
//2 - Write code to check if parameter name contains a value which is found in validUsers array and change flag's value accordingly 
	
	
}
//3 - check if flag is zero, throw CustomExceptionActivity Exception.
//You may also have to declare this exception in the method call using throws.

if(flag == 0) {
	
//System.out.println("Whoa!!");
throw new CustomExceptionActivity();
}

//4 - else if flag is one, print a message "Welcome to Payroll program". 

if(flag == 1) {
	
System.out.println("Welcome to Payroll program");

}

}
}
