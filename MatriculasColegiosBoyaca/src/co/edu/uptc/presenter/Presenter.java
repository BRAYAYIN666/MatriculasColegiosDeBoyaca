package co.edu.uptc.presenter;

import co.edu.uptc.model.Department;
import co.edu.uptc.view.View;

public class Presenter {

	private View view;
	private Department department;

	public Presenter() {
		department = new Department();
		view = new View(this);
	}

	public static void main(String[] args) {
		new Presenter();

	}

}
