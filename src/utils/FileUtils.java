package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
	
	/**
	 * Load any CSV content into a List<String[]>
	 * @param path
	 * @return
	 */
	public static List<List<String>> loadCSV(String path) {
		BufferedReader csvReader = null;
		List<List<String>> content = new ArrayList<>();
		try {
			
			// If file don't exist it creates
			File yourFile = new File(path);
			yourFile.createNewFile(); // if file already exists will do nothing
			
			// Read the file lines into list
			csvReader = new BufferedReader(new FileReader(path));
			String row = "";
			while ((row = csvReader.readLine()) != null) {
			    List<String> data = Arrays.asList(row.split(","));
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
	public static void saveCSV(String path, List<List<String>> content) {
		FileWriter csvWriter = null;
		try {
			csvWriter = new FileWriter(path);
			for (List<String> rowData : content) {
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
