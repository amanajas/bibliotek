package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	/**
	 * Load any CSV content into a List<String[]>
	 * @param path
	 * @return
	 */
	public static List<String[]> loadCSV(String path) {
		BufferedReader csvReader = null;
		List<String[]> content = new ArrayList<>();
		try {
			csvReader = new BufferedReader(new FileReader(path));
			String row = "";
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    content.add(data);
			}
		} catch (IOException e) {
			System.out.println("Error when trying to load CSV: " + e.getMessage());
		} finally {
			if (csvReader != null) {
				try {
					csvReader.close();
				} catch (IOException e) {
					System.out.println("Error when trying to close CSV reader: " + e.getMessage());
				}
			}
		}
		return content;
	}
	
	/**
	 * Save List<String> to a CSV replacing the file content with the object's content
	 * @param path
	 * @param head
	 * @param content
	 */
	public static void saveCSV(String path, String[] head, List<String[]> content) {
		FileWriter csvWriter = null;
		try {
			csvWriter = new FileWriter(path);
			
			for (int i = 0; i < head.length; i ++) {
				String column = head[i];
				csvWriter.append(column);
				csvWriter.append(",");
			}
			csvWriter.append("\n");
			for (String[] rowData : content) {
			    csvWriter.append(String.join(",", rowData));
			    csvWriter.append("\n");
			}
		} catch (IOException e) {
			System.out.println("Error when trying to save CSV: " + e.getMessage());
		} finally {
			if (csvWriter != null) {
				try {
					csvWriter.flush();
					csvWriter.close();
				} catch (IOException e) {
					System.out.println("Error when trying to close CSV writer: " + e.getMessage());
				}
			}
		}
	}

}
