package tnaproject;

import javax.swing.*;
import java.util.*;

/**
 * The class that makes the connection between Employee and EmployeeView.
 */
public class EmployeeController 
{

	private ArrayList <Employee> model;
	private EmployeeView view;

	public EmployeeController(ArrayList <Employee> model, EmployeeView view) 
	{
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
	   Employee realEmployee = null;
	   String userName = view.getUserNameText().getText();
	   String id = view.getIDText().getText();
	   
	   for (Employee employee : model)
		   {
		            if (employee.getEmployeeName().equals(userName))
		            {
		                if (employee.getEmployeeID().equals(id))
		                {
		                    realEmployee = employee;
		                    employee.setCheckInTime();
		                    employee.getCheckInTime();
		                    employee.setCheckOutTime();
		                    employee.getCheckOutTime();
		                    break;
		                }
		            }
		   }
	   
	   if (realEmployee == null)
		   {
		            JOptionPane.showMessageDialog(null, "This employee doesn't exists", 
		            "", JOptionPane.INFORMATION_MESSAGE);;
		   }
	}

	public void getInfo() throws Exception
	{
	   Employee realEmployee = null;
	   String userName = view.getUserNameText().getText();
       String id = view.getIDText().getText();
       
	   for (Employee employee : model)
		   {
		            if (employee.getEmployeeName().equals(userName))
		            {
		                if (employee.getEmployeeID().equals(id))
		                {
		                    realEmployee = employee;
		                    employee.getTimeWorked();
		                    String attendance = employee.getAttendance();
		                    JOptionPane.showMessageDialog(null, attendance, "Has this employee been to work today?", JOptionPane.INFORMATION_MESSAGE);
		                    break;
		                }
		            }
		        }
		
	   if (realEmployee == null)
	   {
	            JOptionPane.showMessageDialog(null, "This employee doesn't exists", 
	            "", JOptionPane.INFORMATION_MESSAGE);;
	   }
	}
}
