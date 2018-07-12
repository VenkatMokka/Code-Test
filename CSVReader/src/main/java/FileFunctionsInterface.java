import java.util.List;

public interface FileFunctionsInterface {
	public List<String> csvRead(String csvFileName);
	public String csvFetchRow(String csvFileName,int rowNum);
	public List<String> csvSearchElement(String csvFileName, String element);	
}
