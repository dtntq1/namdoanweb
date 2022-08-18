/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import datesos.DateEtOEt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.TimeSheet;

/**
 *
 * @author NamDoan
 */
public class EmployeeDBContext extends DBContext {
    
    public ArrayList<Employee> getEmployees(Date begin, Date end) {
    ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "SELECT e.eid,e.ename,ISNULL(t.tid,-1) tid,t.checkin,t.checkout\n"
                    + "                    FROM Employee e\n"
                    + "                    	LEFT JOIN (SELECT * FROM Timesheet WHERE \n"
                    + "                    	checkin >= ?\n"
                    + "                    	AND\n"
                    + "                    	checkin <= ?) t \n"
                    + "                    	ON e.eid = t.eid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setTimestamp(1, DateEtOEt.getTimeStamp(DateEtOEt.removeTime(begin)));
            stm.setTimestamp(2, DateEtOEt.getTimeStamp(DateEtOEt.removeTime(end)));
            ResultSet rs = stm.executeQuery();
            Employee curEmp = new Employee();
            curEmp.setId(-1);
            while (rs.next()) {
                int eid = rs.getInt("eid");
                if (eid != curEmp.getId()) {
                    curEmp = new Employee();
                    curEmp.setId(eid);
                    curEmp.setName(rs.getString("ename"));
                    employees.add(curEmp);
                }
                int tid = rs.getInt("tid");
                if (tid != -1) {
                    TimeSheet t = new TimeSheet();
                    t.setEmployee(curEmp);
                    t.setId(tid);
                    t.setCheckin(DateEtOEt.getDateFrom(rs.getTimestamp("checkin")));
                    t.setCheckout(DateEtOEt.getDateFrom(rs.getTimestamp("checkout")));
                    curEmp.getTimesheets().add(t);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
}
