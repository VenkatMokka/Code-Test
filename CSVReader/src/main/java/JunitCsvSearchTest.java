import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JunitCsvSearchTest {
	String file="C:/Users/user/Desktop/Sample.csv";
	
	String notFoundFile="C:\\Users\\venkatachalams\\Desktop\\NoFile.csv";
	String notCsvFile="C:\\Users\\venkatachalams\\Desktop\\NoFile.txt";
	String value="Venkat";
	String noValue="Durga";
	List<String> expected=new ArrayList<String>();
	List<String> output=new ArrayList<String>();
	String expectedInvalid="Enter a valid .csv file";
	
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
	public void invalidInputException() {
		CSVFileReader csvRow=new CSVFileReader();
		exception.expect(RuntimeException.class);
		csvRow.csvFetchRow(file,'h');			
	}

	@Test
	public void searchElementTest()
	{
		expected.add("Element Found at line:1\n"
				+ "Venkat,8041388");
		CSVFileReader csvSearch=new CSVFileReader();
		output.addAll(csvSearch.csvSearchElement(file,value));
	    assertEquals(expected.get(0),output.get(0));
	}
	@Test
	public void noCsv()
	{
		expected.add(expectedInvalid);
		CSVFileReader csvSearch=new CSVFileReader();
		output.addAll(csvSearch.csvSearchElement(notCsvFile, value));
		assertEquals(expected.get(0),output.get(0));		
	}		
	
	@Test
	public void elementNotFoundTest()
	{
		expected.add("Element not found");
		CSVFileReader csvSearch=new CSVFileReader();
		output.addAll(csvSearch.csvSearchElement(file,noValue));
	    assertEquals(expected.get(0),output.get(0));
	}

}
