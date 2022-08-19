/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import datesos.DateEtOEt;
import java.util.ArrayList;
import java.util.Date;
import model.Employee;

/**
 *
 * @author NamDoan
 */
public class TimeInput {
    public static void main(String[] args)
    {
        EmployeeDBContext db = new EmployeeDBContext();
        Date beginDate = new Date();
        Date end = DateEtOEt.addDays(beginDate, 30);
        ArrayList<Employee> employees = db.getEmployees(beginDate, end);
    }
}
