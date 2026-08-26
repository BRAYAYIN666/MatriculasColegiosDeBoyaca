package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.FileReader;

import co.edu.uptc.model.Campus;
import co.edu.uptc.model.Department;
import co.edu.uptc.model.Institution;
import co.edu.uptc.model.Municipality;
import co.edu.uptc.structures.SimpleList;

public class Persistence {
	
	private final String FILE_PATH = "resources/Matrícula_Instituciones_Educativas_oficiales_y_no_oficiales_-_DEPARTAMENTO_DE_BOYACÁ_20260822.csv";
	private final String FILTER_YEAR = "2.022";

	public void loadFromFile(Department department) {
		try {
			FileReader reader = new FileReader(FILE_PATH);
			BufferedReader buffer = new BufferedReader(reader);
			buffer.readLine();

			String currentLine;
			while ((currentLine = buffer.readLine()) != null) {
				processLine(currentLine, department);
			}

			reader.close();
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processLine(String currentLine, Department department) {
		String split = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
		String[] data = currentLine.split(split);

		int fieldIndex = 0;
		while (fieldIndex < data.length) {
			data[fieldIndex] = data[fieldIndex].trim().replace("\"", "");
			fieldIndex++;
		}

		if (FILTER_YEAR.equals(data[0])) {
			createHierarchy(data, department);
		}
	}

	private SimpleList<String> extractGrades(String[] data) {
		SimpleList<String> grades = new SimpleList<String>();
		int column = 8;
		while (column <= 19) {
			if (column < data.length && data[column] != null && !data[column].isEmpty()) {
				grades.add(data[column]);
			} else {
				grades.add("0");
			}
			column++;
		}
		return grades;
	}

	private void createHierarchy(String[] data, Department department) {
		String munName = data[1].trim();
		String instName = data[3].trim();
		String campusName = data[5].trim();

		Municipality currentMunicipality = department.searchMunicipality(munName);
		if (currentMunicipality == null) {
			currentMunicipality = new Municipality(munName);
			department.addMunicipality(currentMunicipality);
		}

		Institution currentInstitution = currentMunicipality.searchInstitution(instName);
		if (currentInstitution == null) {
			currentInstitution = new Institution(instName);
			currentMunicipality.addInstitution(currentInstitution);
		}

		SimpleList<String> grades = extractGrades(data);
		Campus newCampus = new Campus(campusName, grades);
		currentInstitution.addCampus(newCampus);
	}
}
