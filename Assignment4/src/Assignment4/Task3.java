package Assignment4;


import java.io.*;

import htmlparser.HTMLtoText;

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String path = "src/W3C Web Pages";
			// fetching web pages from W3 Web Pages
			File f1 = new File(path); 
			File[] f1_list = f1.listFiles();
			
			for(int i=0; i<f1_list.length; i++)
			{
				
				if(f1_list[i].isFile()) 
				{
				
			     FileReader fr=new FileReader(path+"\\"+f1_list[i].getName());//reads the file
			   //HTML to text parser
				 HTMLtoText p = new HTMLtoText();
			     p.parse(fr);//parsing the file 
			     fr.close();//closing the  file
			     String txt = p.getText();// converting HTML to text
			     
			     BufferedWriter bw = new BufferedWriter(new FileWriter("htmltotext"+f1_list[i].getName()+".txt")); 
			     bw.write(txt);//write text into file
			     bw.close(); //closing file
				}
			}
			}
			catch (Exception e) {
				e.printStackTrace(); 
			}
	}

}