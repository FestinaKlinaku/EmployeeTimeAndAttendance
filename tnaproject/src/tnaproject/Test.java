package tnaproject;

import java.util.*;
import javax.swing.*;

/**
 * The class that starts the program.
 */
public class Test
{
	public static void main(String[] args) throws Exception 
	   {     
	    ArrayList <Employee> model = getList();   
	    EmployeeView view = new EmployeeView();
	    EmployeeController controller = new EmployeeController(model, view); 
	    controller.initController();
	   }
	  
	   /**
         * Get the list of employees
         * @return ArrayList <Employee> model
         */
	   private static ArrayList <Employee> getList()
	   {
	    ArrayList <Employee> model = new ArrayList <Employee>();
	    while(true)
	    {
	    String[] options = {"YES", "NO"};
	    int pressedButton = JOptionPane.showOptionDialog(null, "Do you wanna add an employee?", "", 
	    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); 
	    if (pressedButton == 0)
	       {
	         String s1 = JOptionPane.showInputDialog(null, "Name : ");
	         String s2 = JOptionPane.showInputDialog(null, "ID : ");
	         Employee employee = new Employee(s1,s2);
	         model.add(employee);
	         for (int i = 0; i < model.size(); i++) 
	         {
	              for (int j = i + 1; j < model.size(); j++) 
	              {
	                   if ( ((model.get(i)).getEmployeeID()).equals((model.get(j)).getEmployeeID()) ) 
	                   {
	                      model.remove(j);
	                      JOptionPane.showMessageDialog(null, "An employee with this ID already exists", 
	                      "", JOptionPane.INFORMATION_MESSAGE);
	                      j--;
	                   }
	              }
	          }
	          continue;
	       }
	    else {break;}
	    }
	    return model;
	   }
}
