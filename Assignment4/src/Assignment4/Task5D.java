package Assignment4;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import htmlparser.HTMLtoText;
public class Task5D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("d. Links with domain .net, .com, .org :\n");
		File f1 = new File("src/W3C Web Pages"); //Fetching the html pages from W3C Web Pages folder
		File[] f1_list = f1.listFiles(); // list of files
		String pat = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";//format of string to be matched with links with domain .net .com .org etc
		
		
		for(int i=0; i<f1_list.length; i++)
		{
			if(f1_list[i].isFile())
			{
				FileReader fr=new FileReader("src/W3C Web Pages/"+f1_list[i].getName()); //Reads the file
				 HTMLtoText parse = new HTMLtoText(); //  converting HTML to Text
			     parse.parse(fr);//parsing the files
			     fr.close();//closing file
			     String txt = parse.getText();
			     Pattern pat1 = Pattern.compile(pat); 
				 Matcher m1 = pat1.matcher(txt); 
				
				 while(m1.find())
				 {
					 if(m1.group().contains(".net")||m1.group().contains(".com")||m1.group().contains(".org"))//check whether if matches with the domain having .net, .com, and .org
				          System.out.println("links found at : " + m1.group(0) + " at " + m1.start(0));//print the location links
				 }
			}
		}
	}

}
