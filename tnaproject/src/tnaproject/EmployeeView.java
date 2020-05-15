package tnaproject;

import java.awt.*;
import javax.swing.*;

/**
 * A class representing the view.
 */
public class EmployeeView extends JFrame
{

	 JPanel panel;
	 JLabel user_label, id_label;
	 JTextField userName_text, id_text;
	 JButton submit, get, cancel;
	 EmployeeView() 
	 {
	      // Create Username Label and Text Field
	      user_label = new JLabel();
	      user_label.setText("                 Employee Name :");
	      userName_text = new JTextField();
	      
	      // Create ID Label and Text Field
	      id_label = new JLabel();
	      id_label.setText("                        Employee ID :");
	      id_text = new JTextField();
	      
	      // Create the Submit and Get buttons
	      submit = new JButton("ENTER");
	      get = new JButton("GET ATTENDANCE");
	      panel = new JPanel(new GridLayout(3, 1));
	      
	      // Add everything to the panel
	      panel.add(user_label);
	      panel.add(userName_text);
	      panel.add(id_label);
	      panel.add(id_text);
	      panel.add(submit);
	      panel.add(get);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      add(panel, BorderLayout.CENTER);
	      setTitle("Employee Time and Attendance");
	      setSize(450,300);
	      setVisible(true);
	 }
	 
	  /**
	    * Create getters to some of the visual components. 
	    * They will be useful to add action listeners later in the Controller.
	    */
	  
	 public JTextField getUserNameText() {
     return userName_text;
     }
		 
	 public JTextField getIDText() {
	 return id_text;
	 }
		 
	 public JButton getSubmit() {
	 return submit;
	 }
		 
	 public JButton getGet() {
	 return get;
	 }
}
