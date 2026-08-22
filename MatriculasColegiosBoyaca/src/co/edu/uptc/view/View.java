package co.edu.uptc.view;

import javax.swing.JFrame;

import co.edu.uptc.presenter.Presenter;

public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private Presenter presenter;
	
	public View(Presenter presenter) {
		super("Matriculas Colegios Boyacá");
		this.presenter = presenter;
		initMetadata();
		initComponents();
		initListeners();
	}

	private void initListeners() {
		// TODO Auto-generated method stub
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}

	private void initMetadata() {
		// TODO Auto-generated method stub
		
	}

}
