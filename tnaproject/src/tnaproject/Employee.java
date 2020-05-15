package tnaproject;

import java.util.*;
import java.text.*;
import javax.swing.*;

/**
 * A class representing an Employee object.
 */
public class Employee {

	private String employeeName;
    private String employeeID;
    private String checkInTime;
    private String checkOutTime;
    private String timeWorked;
    private String attendance;

    /**
     * Constructor of Employee class.
     * @param employeeName name of the employee.
     * @param employeeID ID of the employee.
     */
    public Employee(String employeeName, String employeeID)
    {
     this.employeeName = employeeName;
     this.employeeID = employeeID;
    }

    /**
     * Get the employee name
     * @return String employeeName
     */
    public String getEmployeeName() 
    {
     return employeeName;
    }

    /**
     * Get the ID of the employee
     * @return String employeeID
     */
    public String getEmployeeID() 
    {
     return employeeID;
    }

    /**
     * Get the check in time of the employee
     * @return String checkInTime
     */
    public String getCheckInTime() 
    {
     return checkInTime;
    }
    
    /**
     * Set the check in time of the employee
     */   
    public void setCheckInTime()
    {
     String checkInHour = null;
     String checkInMinute = null;
     int i1 = 0;
     int i2 = 0;
     while (true)
           {
            try 
                {
                  checkInHour = JOptionPane.showInputDialog(null, "Check in hour : ");
                  i1 = Integer.parseInt(checkInHour);
                  while (i1 < 0 || i1 > 23)
                  { JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                                  "", JOptionPane.INFORMATION_MESSAGE);
                    checkInHour = JOptionPane.showInputDialog(null, "Check in hour : ");
                    i1 = Integer.parseInt(checkInHour);
                  }
                  break;
                }
             catch (NumberFormatException e) 
             { JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                             "", JOptionPane.INFORMATION_MESSAGE); } 
           }

    while (true)
          {
           try 
              {
                checkInMinute = JOptionPane.showInputDialog(null, "Check in minute : ");
                i2 = Integer.parseInt(checkInMinute);
                while (i2 < 0 || i2 > 59)
                {  JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                                 "", JOptionPane.INFORMATION_MESSAGE);
                   checkInMinute = JOptionPane.showInputDialog(null, "Check in minute : ");
                   i2 = Integer.parseInt(checkInMinute);
                }
                break;
              }
           catch (NumberFormatException e) 
           {  JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                            "", JOptionPane.INFORMATION_MESSAGE); } 
          }

     this.checkInTime = checkInHour + ":" + checkInMinute;
    }
    
    /**
     * Get the check out time of the employee
     * @return String checkOutTime
     */
    public String getCheckOutTime() 
    {
     return checkOutTime;
    }
    
    /**
     * Set the check out time of the employee
     */
    public void setCheckOutTime()
    {
     String checkOutHour = null;
     String checkOutMinute = null;
     int i1 = 0;
     int i2 = 0;
     while (true)
           {
            try 
                {
                  checkOutHour = JOptionPane.showInputDialog(null, "Check out hour : ");
                  i1 = Integer.parseInt(checkOutHour);
                  while (i1 < 0 || i1 > 23)
                  { JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                                  "", JOptionPane.INFORMATION_MESSAGE);
                    checkOutHour = JOptionPane.showInputDialog(null, "Check out hour : ");
                    i1 = Integer.parseInt(checkOutHour);
                  }
                  break;
                }
             catch (NumberFormatException e) 
             { JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                             "", JOptionPane.INFORMATION_MESSAGE); } 
           }

    while (true)
          {
           try 
              {
                checkOutMinute = JOptionPane.showInputDialog(null, "Check out minute : ");
                i2 = Integer.parseInt(checkOutMinute);
                while (i2 < 0 || i2 > 59)
                {  JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                                 "", JOptionPane.INFORMATION_MESSAGE);
                   checkOutMinute = JOptionPane.showInputDialog(null, "Check out minute : ");
                   i2 = Integer.parseInt(checkOutMinute);
                }
                break;
              }
           catch (NumberFormatException e) 
           {  JOptionPane.showMessageDialog(null, "Not a valid input, please try again", 
                                            "", JOptionPane.INFORMATION_MESSAGE); } 
          }
     this.checkOutTime = checkOutHour + ":" + checkOutMinute;;
    }
    
    /**
     * Get how many hours the employee has worked
     * @return String timeWorked
     * @exception ParseException when you fail to parse a String that is ought to have a special format
     */
    public String getTimeWorked() throws Exception
    {
     SimpleDateFormat format = new SimpleDateFormat("HH:mm");
     Date date1 = format.parse(checkInTime);
     Date date2 = format.parse(checkOutTime);
     long difference = date2.getTime() - date1.getTime();
     if (date1.compareTo(date2) > 0)
        { difference = (format.parse("25:00")).getTime() + difference; }
     long diffMinutes = difference / (60 * 1000) % 60;
     long diffHours = difference / (60 * 60 * 1000) % 24;
     this.timeWorked = diffHours + ":" + diffMinutes;
     return timeWorked;
    }
    
    /**
     * Get if the employee has attended or not
     * @return String attendance
     * @exception ParseException when you fail to parse a String that is ought to have a special format
     */
    public String getAttendance() throws Exception
    {
     SimpleDateFormat format = new SimpleDateFormat("HH:mm");
     Date date1 = format.parse(timeWorked);
     String timeNeededToWork = 8 + ":" + 00;
     Date date2 = format.parse(timeNeededToWork);
     if (date1.compareTo(date2) == 0 || date1.compareTo(date2) > 0)
        {this.attendance = "EMPLOYEE ATTENDED AND WORKED FOR " + timeWorked + " HOURS";}
     else if (date1.compareTo(date2) < 0 && date1.compareTo(format.parse("00:00")) > 0)
        {this.attendance = "EMPLOYEE ATTENDED, BUT WORKED ONLY FOR " + timeWorked + " HOURS";}
     else
        {this.attendance = "EMPLOYEE DID NOT ATTEND";}
     return attendance;
    }
}
