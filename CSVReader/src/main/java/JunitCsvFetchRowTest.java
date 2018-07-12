import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


//Test Cases for fetching a row functionality
public class JunitCsvFetchRowTest {

		String file="C:/Users/"+System.getProperty("user.name")+"/Desktop/Sample.csv";
		String notFoundFile="C:\\Users\\venkatachalams\\Desktop\\NoFile.csv";
		String notCsvFile="C:\\Users\\venkatachalams\\Desktop\\NoFile.txt";
		String value="Venkat";
		int validRowNumber=5;
		int invalidRowNumber=8;
		String expectedRow="Kiran,8041388";
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
		public void arrayIndexOutOfBounds()
		{
			CSVFileReader csvRow=new CSVFileReader();
			exception.expect(RuntimeException.class);
			csvRow.csvFetchRow(file,invalidRowNumber);
		}
	
		
		//Test case for fetching a row
		@Test
		public void testRow() {
			CSVFileReader csvRow=new CSVFileReader();
			String rowTest=csvRow.csvFetchRow(file,validRowNumber);
			assertEquals(expectedRow,rowTest);		
			
		}
		
		//Test case for a validity of .csv file
		@Test
		public void noCsv()
		{
			CSVFileReader noCsv=new CSVFileReader();
			String notCsv=noCsv.csvFetchRow(notCsvFile,1);			
			assertEquals(expectedInvalid,notCsv);
		}		
		
		
		
}



