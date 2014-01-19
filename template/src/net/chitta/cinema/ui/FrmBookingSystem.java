package net.chitta.cinema.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import net.chitta.cinema.BookingSystem;
import net.chitta.cinema.Person;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class FrmBookingSystem extends JFrame {
	
//	BookingSystem bookingSystem = new BookingSystem();
	private static BookingSystem sys;
	static FrmBookingSystem frame;
	private JPanel contentPane;
	private JTextField txtUserID;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FrmBookingSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmBookingSystem() {
		sys = (BookingSystem) net.chitta.cinema.Utilities.initialise();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(10, 11, 46, 14);
		contentPane.add(lblUserId);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(66, 7, 168, 20);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		JButton btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtUserID.getText();
				
				String pw = new String(txtPassword.getPassword());
//				Person person = bookingSystem.isUserExist(new Person(name,pw));
//				bookingSystem.
				Person person = sys.isUserExist(new Person(name,pw));
				System.out.println("Please enter correct username and password");    
				if (person != null) {
				    frame.setVisible(false);
				    frame.dispose();
					sys.uiEntryPoint(person);
					}
				
			}
		});
		btnSubmit.setBounds(343, 232, 89, 23);
		contentPane.add(btnSubmit);
		txtPassword = new JPasswordField();
		txtPassword.setBounds(66, 38, 168, 20);
		contentPane.add(txtPassword);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(0, 41, 46, 14);
		contentPane.add(lblPassword);
	}
}
