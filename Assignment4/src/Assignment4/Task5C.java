package Assignment4;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import htmlparser.HTMLtoText;

public class Task5C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("Links that contain references in a Web page and may contain folders:\n");
		File f1 = new File("src/W3C Web Pages");//Fetching the html pages from W3C Web Pages folder
		File[] f1_list = f1.listFiles(); // list of files
		String pat = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";//format of string to be matched with Links that contain references in a Web page and may contain folders 
		
		
		
		for(int i=0; i<f1_list.length; i++)
		{
			if(f1_list[i].isFile())
			{
				FileReader fr=new FileReader("src/W3C Web Pages/"+f1_list[i].getName()); // Reads the file
				 HTMLtoText parse = new HTMLtoText(); //converting HTML to Text
			     parse.parse(fr);//parsing the file
			     fr.close();//closing the file
			     String txt = parse.getText();
			     Pattern pat1 = Pattern.compile(pat);
				 Matcher m1 = pat1.matcher(txt); 
				 while (m1.find( )) {
					 if(m1.group().contains("www.w3.org/2005/xpath-functions/collation/"))// check whether if the same pattern is found
			          System.out.println("Link found at : " + m1.group(0) + " at " + m1.start(0));//prints the location of link 
				}
			}
		}
	}

}
