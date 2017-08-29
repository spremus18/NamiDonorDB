package namiDonorDB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class settingsForm extends JFrame {

	private JPanel contentPane;
	private JTextField user_tf;
	private JTextField passwd_tf;
	private JLabel lblPassword;
	private JLabel lblUrl;
	private JTextField url_tf;
	private JPanel panel;
	private JButton btnCancel;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settingsForm frame = new settingsForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void displayCurrent() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("settings.properties"));
		user_tf.setText(props.getProperty("user"));
		passwd_tf.setText(props.getProperty("password"));
		url_tf.setText(props.getProperty("url"));
	}
	
	private void saveSetting() throws Exception{
		//get and display properties info
				Properties props = new Properties();
				props.load(new FileInputStream("settings.properties"));
				OutputStream fileoutput = null;
				try {
					fileoutput = new FileOutputStream("settings.properties");
					
					//set the properties value
					props.setProperty("url",url_tf.getText());
					props.setProperty("user", user_tf.getText());
					props.setProperty("password", passwd_tf.getText());
					
					// save properties to project root folder
					props.store(fileoutput, null);
					
				} catch (IOException io){
					io.printStackTrace();
				} finally {
					if(fileoutput != null) {
						try {
							fileoutput.close();
						} catch (IOException e){
							e.printStackTrace();
						}
						
					}
				}
	}

	/**
	 * Create the frame.
	 */
	public settingsForm() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("User: ");
		contentPane.add(lblNewLabel, "2, 2, right, default");
		
		user_tf = new JTextField();
		contentPane.add(user_tf, "4, 2, fill, default");
		user_tf.setColumns(10);
		
		lblPassword = new JLabel("Password: ");
		contentPane.add(lblPassword, "2, 4, right, default");
		
		passwd_tf = new JTextField();
		contentPane.add(passwd_tf, "4, 4, fill, default");
		passwd_tf.setColumns(10);
		
		lblUrl = new JLabel("Url: ");
		contentPane.add(lblUrl, "2, 6, right, default");
		
		url_tf = new JTextField();
		contentPane.add(url_tf, "4, 6, fill, default");
		url_tf.setColumns(10);
		
		panel = new JPanel();
		contentPane.add(panel, "4, 18, fill, fill");
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCancel);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					saveSetting();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		panel.add(btnSave);
		
		//mySettings();
		displayCurrent();
		
	}

}