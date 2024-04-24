public class CsvFileReader {

	private static final int NUMCOL = 8;   

	public static String[] lineReader(String string) {
		int start = 0;
		int end = string.indexOf(',');
		String[] data = new String[NUMCOL];
		int index = 0; 
		while (start < end && start < string.length()) {
			if (string.charAt(start)== '"') {
				start = start + 1;
				end = string.indexOf('"', start);
			}				
			String Value = string.substring(start, end) .trim();
			data[index++] = Value;		

			if (string.charAt(end) == '"') {
				start = end + 2;
			}			
			else {
				start = end + 1;
			}

			end = string.indexOf(',',start);
		}
		data[index] = string.substring(start).trim();	
		return data;
	}	
}
