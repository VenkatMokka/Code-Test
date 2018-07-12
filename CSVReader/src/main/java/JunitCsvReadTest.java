import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JunitCsvReadTest {

	String file="C:/Users/user/Desktop/Sample.csv";
	String notFoundFile="C:\\Users\\venkatachalams\\Desktop\\NoFile.csv";
	String notCsvFile="C:\\Users\\venkatachalams\\Desktop\\NoFile.txt";
	List<String> expected=new ArrayList<String>();
	List<String> output=new ArrayList<String>();
	String expectedInvalid="Enter a valid .csv file";
	String value="Venkat";
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	//Test case for file not found exception
	@Test
	public void fileNotFoundException() {
		CSVFileReader csvRow=new CSVFileReader();
		exception.expect(RuntimeException.class);
		csvRow.csvFetchRow(notFoundFile,1);			
	}
	
	@Test
	public void noCsv()
	{
		expected.add(expectedInvalid);
		CSVFileReader csvSearch=new CSVFileReader();
		output.addAll(csvSearch.csvSearchElement(notCsvFile, value));
		assertEquals(expected.get(0),output.get(0));		
	}
	
	public void csvResult() throws IOException 
	{
		  BufferedReader reader = new BufferedReader(new FileReader(file));		 
	      String line = null;
	  while ((line = reader.readLine()) != null) 
	    {
	      expected.add(line);
	    }
         System.out.println(expected);  
	}
	
}
