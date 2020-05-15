package tnaproject;

import javax.swing.*;
import java.util.*;

/**
 * The class that makes the connection between Employee and EmployeeView.
 */
public class EmployeeController {

	   private ArrayList <Employee> model;
	   private EmployeeView view;

	   public EmployeeController(ArrayList <Employee> model, EmployeeView view) {
	      this.model = model;
	      this.view = view;
	   }
	   
	   public void initController() 
	   {
	      view.getSubmit().addActionListener(e -> submitInfo());
	      view.getGet().addActionListener(e -> { try {getInfo();} 
	                                             catch (Exception i) 
	                                             {
	                                              JOptionPane.showMessageDialog(null, "Input was given incorrectly or wasn't given at all", 
	                                              "", JOptionPane.INFORMATION_MESSAGE);
	                                             }
	                                           }
	                                      );
	   }
	   
	   public void submitInfo() 
	   {
	      String userName = view.getUserNameText().getText();
	      String id = view.getIDText().getText();
	      for (Employee i : model)
	      {
	      if ((i.getEmployeeName()).equals(userName) && (i.getEmployeeID()).equals(id))
	         {
	           i.setCheckInTime();
	           i.getCheckInTime();
	           i.setCheckOutTime();
	           i.getCheckOutTime();
	         }
	      }
	   }

	   public void getInfo() throws Exception
	   {
	      String userName = view.getUserNameText().getText();
	      String id = view.getIDText().getText();
	      for (Employee i : model)
	      {
	      if ((i.getEmployeeName()).equals(userName) && (i.getEmployeeID()).equals(id))
	         {
	              i.getTimeWorked();
	              String attendance = i.getAttendance();
	              JOptionPane.showMessageDialog(null, attendance, 
	              "Has this employee been to work today?", JOptionPane.INFORMATION_MESSAGE);
	         }
	      }
	   }
}
