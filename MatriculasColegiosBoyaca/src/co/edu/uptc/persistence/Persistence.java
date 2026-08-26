package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.Department;

public class Persistence {

	private Department department;
	private BufferedReader bufferedReader;
	private static final String FILE_PATH = "resources/Matrícula_Instituciones_Educativas_oficiales_y_no_oficiales_-_DEPARTAMENTO_DE_BOYACÁ_20260822.csv";

	public Persistence(Department department) throws FileNotFoundException {
		this.department = department;
		bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
	}

	private boolean filterProperties(String[] property) {
		String municipality = property[1];
		String use = property[4];
		String area = property[5];
		return municipality.equals("15001") && (use.equals("D") || use.equals("A") || use.equals("J"))
				&& !area.equals("0");
	}

//	private void createProperty(String property[]) {
//		String cadastralNumber = property[2];
//		String addres = property[3];
//		int area = Integer.parseInt(property[5]);
//
//		Use use = null;
//		switch (property[4]) {
//		case "D", "A" -> use = Use.RESIDENTIAL;
//		case "J" -> use = Use.COMMERCIAL;
//		}
//
//		double price = area * 1000000.0;
//		double valuation = taxCalculator.calculateValuationFee(price);
//		byte stratum = (byte) (Math.random() * taxCalculator.getStratums().size() + 1);
//		Property aux = new Property(cadastralNumber, addres, area, stratum, use, valuation, price);
//		taxCalculator.addProperty(aux);
//	}
//	
	private void createCampus(String[] tuition) {
		String name = tuition[5];
		String[] grades = new String[12];
		for (int i = 0; i < 12; i++) {
			grades[i] = tuition[i + 8];
		}
	}

	private ArrayList<String[]> readAllProperties() throws IOException {
		ArrayList<String[]> allProperties = new ArrayList<String[]>();
		String property;
		bufferedReader.readLine();
		while ((property = bufferedReader.readLine()) != null) {
			allProperties.add(property.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
		}
		bufferedReader.close();
		return allProperties;
	}

//	private void createProperties() throws IOException {
//		readAllProperties().stream().filter(x -> filterProperties(x)).forEach(y -> createProperty(y));
//	}

}
