package co.edu.uptc.view;

import javax.swing.JFrame;

import co.edu.uptc.presenter.Presenter;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private Presenter presenter;

	public View(Presenter presenter) {
		super("Matriculas Colegios Boyacá");
		this.presenter = presenter;
		initComponents();
		initListeners();
		initMetadata();
	}

	private void initMetadata() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents() {
		mainPanel = new MainPanel();
		add(mainPanel);
	}

	private void initListeners() {
		mainPanel.getMainDepartmentPanel().getByInstitutions().addActionListener(e -> {
			mainPanel.getMainDepartmentPanel().changePanel("showByInstitutions");
			mainPanel.getMainDepartmentPanel().getInsertPanel().clearNameField();
		});

		mainPanel.getMainDepartmentPanel().getInsert().addActionListener(e -> {
			mainPanel.getMainDepartmentPanel().changePanel("insert");
		});
	}
}
