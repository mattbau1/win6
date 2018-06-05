package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MyGUI {

	protected Shell shell;
	private Text vorname;
	private Label lblNachname;
	private Text nachnahme;
	private Label lblAdresse;
	private Text adresse;
	private Text plz;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyGUI window = new MyGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		vorname = new Text(shell, SWT.BORDER);
		vorname.setBounds(113, 10, 76, 21);

		Label lblVorname = new Label(shell, SWT.NONE);
		lblVorname.setBounds(25, 16, 55, 15);
		lblVorname.setText("Vorname");

		Button btnHallo = new Button(shell, SWT.NONE);
		btnHallo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// System.out.println("bUTTON GEDRÜCKT");

				try {
					System.out.println(getVorname().getText());
					System.out.println(getNachnahme().getText());
					System.out.println(getAdresse().getText());
					System.out.println(Integer.parseInt(getPlz().getText()));

					Person p = new Person();
					p.setVorname(getVorname().getText());
					p.setNachname(getNachnahme().getText());
					p.setAdresse(getAdresse().getText());
					p.setPlz(Integer.parseInt(getPlz().getText()));

					Person.getPersonenliste().add(p);

					clearMask();
					//
					try {
						Writer writer = new FileWriter("C:\\temp\\output.json");
						Gson gson = new GsonBuilder().serializeNulls().create();
						//
						gson.toJson(Person.getPersonenliste(), writer);
						//
						writer.flush();
						writer.close();
					} catch (IOException ioe) {

					}

					//
				} catch (NumberFormatException a) {
					System.out.println("falsch plz");
					MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					mb.setText("Fehler");
					mb.setMessage("PLZ im falschen Format");
					mb.open();
				}
			}

		});
		btnHallo.setBounds(25, 159, 241, 25);
		btnHallo.setText("Hallo");

		lblNachname = new Label(shell, SWT.NONE);
		lblNachname.setBounds(25, 49, 65, 15);
		lblNachname.setText("Nachname");

		nachnahme = new Text(shell, SWT.BORDER);
		nachnahme.setBounds(113, 49, 76, 21);

		lblAdresse = new Label(shell, SWT.NONE);
		lblAdresse.setBounds(25, 80, 55, 15);
		lblAdresse.setText("Adresse");

		adresse = new Text(shell, SWT.BORDER);
		adresse.setBounds(113, 85, 76, 21);

		Label lblPlz = new Label(shell, SWT.NONE);
		lblPlz.setBounds(25, 121, 55, 15);
		lblPlz.setText("Plz");

		plz = new Text(shell, SWT.BORDER);
		plz.setBounds(113, 112, 76, 21);

	}

	protected void clearMask() {
		vorname.setText("");
		nachnahme.setText("");
		adresse.setText("");
		plz.setText("");
	}

	protected Text getVorname() {
		return vorname;
	}

	protected Text getNachnahme() {
		return nachnahme;
	}

	protected Text getAdresse() {
		return adresse;
	}

	public Text getPlz() {
		return plz;
	}
}
