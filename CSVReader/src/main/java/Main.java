import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main extends CSVFileReader {
	public static void main(String args[]) throws IOException 
	  {
	        int option;    
	        System.out.println("Enter Option\n1.Display Data\n2.Fetch a line\n3.Search Element");
	        try
		    {
		    Scanner optionScanner=new Scanner(System.in);
		    option=optionScanner.nextInt();		    
		    switch(option)
		    {
		    case 1 :  Scanner scanner = new Scanner(System.in);
			          System.out.println("Enter Absolute File Path\n");
			          String filePath= scanner.nextLine();
			          FileFunctionsInterface f=new CSVFileReader();
			          List<String> result=new ArrayList<String>();
		              result=f.csvRead(filePath);
		              for(int i=0;i<result.size();i++)
		              System.out.println(result.get(i).replace(',',' '));
		              scanner.close();
		              break;
		              
		    case 2 :  Scanner rowScanner = new Scanner(System.in);
		    		  System.out.println("Enter Absolute File Path\n");
		    		  String rowFilePath= rowScanner.nextLine();		    		
		    		  FileFunctionsInterface r=new CSVFileReader();
		    		  System.out.println("Enter Line Number");
		    		  Scanner lineNumber=new Scanner(System.in);
		    		  int n=lineNumber.nextInt();
		    		  System.out.println(r.csvFetchRow(rowFilePath,n).replace(',',' '));
		    		  rowScanner.close();
		    		  lineNumber.close();
		    		  break;
		    		  
		    case 3 :  Scanner elementScanner = new Scanner(System.in);
		    		  System.out.println("Enter Absolute File Path\n");
		    		  String elementFilePath= elementScanner.nextLine();
		    		  Scanner element = new Scanner(System.in);
		    		  System.out.println("Enter value to search\n");
		    		  String value= elementScanner.nextLine();		    		  
		    		  FileFunctionsInterface e=new CSVFileReader();
		    		  List<String> searchResult=new ArrayList<String>();
		              searchResult=e.csvSearchElement(elementFilePath,value);
		              for(int i=0;i<searchResult.size();i++)
			          System.out.println(searchResult.get(i).replace(',',' '));
		    		  break;
		    		  
		    default : System.out.println("Please enter a valid option");	
		    optionScanner.close();	 
		    }
		    }
		    catch(InputMismatchException i)
		    {
		    	System.out.println("Invalid Input");
		    	throw new RuntimeException();
		    }
		       
		   
		    } 
	  
}
