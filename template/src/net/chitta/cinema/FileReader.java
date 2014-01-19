package net.chitta.cinema;
import java.io.*;
public class FileReader
{
   public static void printFile(String filename)
	{
      try{
		// Open the file that is the first 
		// command line parameter
		//FileInputStream fstream = new FileInputStream("c:\textfile.txt");
		FileInputStream fstream = new FileInputStream(filename);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null) 	{
			// Print the content on the console
			System.out.println (strLine);
		}
		//Close the input stream
		in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
   
   
   //test
   //public static void main(String[] args){
	   
	 //  FileReader.printFile("C:\\Documents and Settings\\mohafeh\\Desktop\\26Mar\\eclipse\\cinema\\README.TXT");
	   
	   
   }
   

