package Assignment4;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import htmlparser.HTMLtoText;

public class Task5B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("b).	Links that contain folders: e.g., www.w3.org/TR/owl-features/ :\n");
		File f1 = new File("src/W3C Web Pages"); //Fetching the html pages from W3C Web Pages folder
		File[] f1_list = f1.listFiles(); 
		String pat = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"; //format of string to find links
		
		
		for(int i=0; i<f1_list.length; i++)
		{
			if(f1_list[i].isFile())
			{
				FileReader fr=new FileReader("src/W3C Web Pages/"+f1_list[i].getName()); //Reads the file
				 HTMLtoText parse = new HTMLtoText(); //converting HTML to Text
			     parse.parse(fr);//parsing the file
			     fr.close();//closing the file
			     String txt = parse.getText();
			     Pattern pat1 = Pattern.compile(pat); 
				 Matcher m1 = pat1.matcher(txt); //Matching pattern
				 while(m1.find())
				 {
					 if(m1.group().contains("www.w3.org/TR/xhtml-modularization"))//check whether if the same format is found in the file
				          System.out.println("Folder: " + m1.group(0) + " found at " + m1.start(0));//prints the file reference and folder
				 }
			}
		}

	}

}
