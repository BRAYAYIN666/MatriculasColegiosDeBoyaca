package co.edu.uptc.presenter;

import co.edu.uptc.model.Department;
import co.edu.uptc.model.Municipality;
import co.edu.uptc.structures.SimpleList;
import co.edu.uptc.view.View;

public class Presenter {

	private View view;
	private Department department;

	public Presenter() {
		department = new Department();
		view = new View(this);
	}
	
	public void loadCombos() {
		SimpleList<String> municipalities = new SimpleList<String>();
		SimpleList<String> institutions = new SimpleList<String>();
		SimpleList<String> campuses = new SimpleList<String>();
		
		for (Municipality mun : department.getMunicipalities()) {
			municipalities.add(mun.getName());
		}
		
		for (Institutions ins : ) {
			municipalities.add(mun.getName());
		}
		
		for (Municipality mun : department.getMunicipalities()) {
			municipalities.add(mun.getName());
		}
		view.loadCombos(municipalities);
	}

	public static void main(String[] args) {
		new Presenter();
	}

}
