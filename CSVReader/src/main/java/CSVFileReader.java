import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVFileReader implements FileFunctionsInterface{  
  //Method to display entire data in the csv file
  public List<String> csvRead(String csvFileName) 
  {   
	  List<String> lines = new ArrayList<String>();	   
	  if(csvFileName.substring((csvFileName.length()-4)).equals(".csv"))
	  {
	  try
	  {
		  BufferedReader reader = new BufferedReader(new FileReader(csvFileName));		 
	      String line = null;
	  while ((line = reader.readLine()) != null) 
	    {
	      lines.add(line);
	    }
      	
      reader.close();    
	  }
	  catch(FileNotFoundException f)	
	  {  
		  System.out.println("File Not Found");
		  throw new RuntimeException();
	  }
	  catch(IOException io)
	  {
		  System.out.println("Invalid Input");
		  throw new RuntimeException();
	  }
	  }
	  else
		  System.out.println("Enter a valid .csv file");
	 return lines;
	  
  } 
  //Method to fetch a particular row in a .csv file
  public String csvFetchRow(String csvFileName,int n)
  
  { 
	  String result=new String();
	  if(csvFileName.substring((csvFileName.length()-4)).equals(".csv"))
    {  
	  try
  	 {
	  BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
	  List<String> lines = new ArrayList<String>();
	  String line = null;
	  while ((line = reader.readLine()) != null)
	  	{
	      lines.add(line);
	  	}     
	  	  result=(lines.get(n-1));
	  reader.close();
	  
  	 }
     catch(ArrayIndexOutOfBoundsException a)
     {
    	 System.out.println("Row number out of range");
    	 throw new RuntimeException();
     }
	  catch(FileNotFoundException f)
	     {
	    	 System.out.println("File Not Found");
	    	 throw new RuntimeException();
	     }
	  catch(IOException i)
	  {
		  System.out.println("Invalid Input");
		  throw new RuntimeException();
	  }
    }
  else
	  result="Enter a valid .csv file";
  return result;
  }
  
  //Method to search whether a value is in the .csv file
  public List<String> csvSearchElement(String csvFileName, String element)
  {
	  List<String> result=new ArrayList<String>();
	  if(csvFileName.substring((csvFileName.length()-4)).equals(".csv"))
	  {
		  try
		  {
	  int flag=0;
	  BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
	  List<String> lines = new ArrayList<String>();
	  String line = null;
	  while ((line = reader.readLine()) != null)
	  	{
	      lines.add(line);
	  	} 
	  for(int i=0;i<lines.size();i++)
	  {
		  if(lines.get(i).toLowerCase().contains(element.toLowerCase())) {
			  int index=lines.indexOf(lines.get(i))+1;
			  result.add("Element Found at line:"+index+"\n"+lines.get(i));			  
                 flag=1;     
		  }
	  }
	  if(flag==0)
		  result.add("Element not found");
	  
	  reader.close();
		  }
		  catch(FileNotFoundException f)
		  {
			  System.out.println("File Not Found");
			  throw new RuntimeException();
		  }
		  catch(IOException i)
		  {
			  System.out.println("Invalid Input");
			  throw new RuntimeException();
		  }
	  }
	  else
		  result.add("Enter a valid .csv file");
     return result; 
  }  
	 
}
