package checkout;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {
	
	ArrayList<ArrayList<String>> dataObjects = new ArrayList<>();
	ArrayList<String> data = new ArrayList<>();

	public ArrayList<ArrayList<String>> readCsv() throws IOException {
		String path = System.getProperty("user.dir");
		BufferedReader csvReader = new BufferedReader(new FileReader(path + "\\excell\\data3.csv"));
		String row;
		while ((row = csvReader.readLine()) != null) {

			if (row.contains("//")) {
				dataObjects.add(data);
				data = new ArrayList<>();
			} else {
				data.add(row);
			}
			// String[] data = row.split(",");
			// do something with the data
		}
		dataObjects.add(data);
		csvReader.close();
		return dataObjects;
	}

}
