package Assignment4;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import htmlparser.HTMLtoText;

public class Task4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f1 = new File("src/W3C Web Pages/Text"); // fetching web pages
		File[] f1_list = f1.listFiles(); //list of files
		String phone = "(\\()?(\\d){3}(\\))?[- ](\\d){3}-(\\d){4}"; //pattern of phone number
		String email_id="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";//pattern for emailid
	
		
		System.out.print("list of Phone Numbers :\n");
		for(int i=0; i<f1_list.length; i++) 
			if(f1_list[i].isFile())
			{
				FileReader filerdr=new FileReader("src/W3C Web Pages/Text/"+f1_list[i].getName());// Reads the file
				 HTMLtoText txt = new HTMLtoText(); //convert HTMl to Text
			     txt.parse(filerdr);//parsing text
			     filerdr.close();//closing file
			     String txt1 = txt.getText(); 
			     Pattern p1 = Pattern.compile(phone);
				 Matcher m1 = p1.matcher(txt1); 
				 while (m1.find( )) // check whether if the match is found for phone number
				 {
			          System.out.println( m1.group(0) +" Phone number is found at " + m1.start(0));
				 }
			}
		
		System.out.print("\nlist of Email id :\n");
		for(int i=0; i<f1_list.length; i++)//iterator the loop until the length of file
		{
			 if(f1_list[i].isFile())
			 {
				 FileReader filerdr=new FileReader("src/W3C Web Pages/Text/"+f1_list[i].getName()); //Reads the file
				 HTMLtoText p1 = new HTMLtoText(); //convert HTML to Text
			     p1.parse(filerdr);//parsing the file
			     filerdr.close();//closing the file
			     String txt2 = p1.getText();//storing the text
			     Pattern p =Pattern.compile(email_id);
			     Matcher m1=p.matcher(txt2);// matching the pattern
			     while (m1.find( ))// check whether if the match found for email
			     {
			          System.out.println( m1.group(0)+ " Email id is found at " + m1.start(0));
			     }
			 }
		}
	}

}
