package net.chitta.cinema.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.SpringLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class FrmBookingSystem2 {

	 JFrame frame;
	 JTextField textField;
	 JTextField textField_1;
	private final Action action = new SwingAction();
	private JButton btnNewButton;
	private final Action action_1 = new SwingAction_1();
	private static net.chitta.cinema.BookingSystem sys;


	/**
	 * Launch the application.
	 */
    
   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		   
			public void run() {
				try {
					FrmBookingSystem2 window = new FrmBookingSystem2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmBookingSystem2() {
		sys = (net.chitta.cinema.BookingSystem) net.chitta.cinema.Utilities.initialise();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse Clicked");
			}
		});
		frame.setBounds(100, 100, 499, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("User Name");
		
		JLabel lblPassword = new JLabel("Password");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setAction(action);
		
		btnNewButton = new JButton("Exit");
		btnNewButton.setAction(action_1);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 4, SpringLayout.SOUTH, lblPassword);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnSubmit);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 49, SpringLayout.EAST, btnSubmit);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -98, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSubmit, 141, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSubmit, -98, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 56, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 141, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 83, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 272, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 101, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 141, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 272, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 110, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 71, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 62, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 71, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		
		Box horizontalBox = Box.createHorizontalBox();
		springLayout.putConstraint(SpringLayout.NORTH, horizontalBox, 254, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, horizontalBox, 64, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, horizontalBox, 255, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, horizontalBox, 65, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(horizontalBox);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblPassword);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnSubmit);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(textField);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
	        String name, pw;        
	        net.chitta.cinema.Person person;
	        name= textField.getText();
	        pw=textField_1.getText();
            person = sys.isUserExist(new net.chitta.cinema.Person(name,pw));
			System.out.println("Please enter correct username and password");    
			if (person != null) {sys.uiEntryPoint(person);}
		}
	}
	

	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Logout");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		    frame.setVisible(false);
		    frame.dispose();
	
		}
	}
}
