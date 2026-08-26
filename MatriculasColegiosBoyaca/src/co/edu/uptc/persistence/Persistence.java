package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.FileReader;

import co.edu.uptc.model.Campus;
import co.edu.uptc.model.Department;
import co.edu.uptc.model.Institution;
import co.edu.uptc.model.Municipality;

public class Persistence {

	private final String FILE_PATH = "data/Matrícula_Instituciones_Educativas_oficiales_y_no_oficiales_-_DEPARTAMENTO_DE_BOYACÁ_20260822.csv";
	private final String FILTER_YEAR = "2.022";

	public void loadFromFile(Department department) {
		String currentLine = null;
		String split = ",(?=(?:[^\"]\"[^\"]\")[^\"]$)";

		try {
			FileReader reader = new FileReader(FILE_PATH);
			BufferedReader buffer = new BufferedReader(reader);
			buffer.readLine();
			while ((currentLine = buffer.readLine()) != null) {
				String[] data = currentLine.split(split);
				int fieldIndex = 0;

				while (fieldIndex < data.length) {
					data[fieldIndex] = data[fieldIndex].trim().replace("\"", "");
					fieldIndex++;
				}

				String munName = data[1].trim();
				String instName = data[3].trim();
				String campusCode = data[4].trim();
				String campusName = data[5].trim();

				int[] grades = new int[19 - 8 + 1];
				int column = 8;
				int gradeIndex = 0;
				while (column <= 19) {
					if (data[column] != null && !data[column].isEmpty()) {
						grades[gradeIndex] = Integer.parseInt(data[column]);
					} else {
						grades[gradeIndex] = 0;
					}
					column++;
					gradeIndex++;
				}
				if (FILTER_YEAR.equals(data[0])) {
//					Municipality currentMunicipality = department.searchMunicipality(munName);
//					if (currentMunicipality == null) {
//						currentMunicipality = new Municipality(munName);
//						department.addMunicipality(currentMunicipality);
//					}
//
//					Institution currentInstitution = currentMunicipality.searchInstitution(instName);
//					if (currentInstitution == null) {
//						currentInstitution = new Institution(instName);
//						currentMunicipality.insertInstitution(currentInstitution);
//					}
//
//					Campus newCampus = new Campus(campusCode, campusName, grades);
//					currentInstitution.addCampus(newCampus);
				}
			}
			reader.close();
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
