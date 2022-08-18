/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.EmployeeDBContext;
import datesos.DateEtOEt;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.Employee;

/**
 *
 * @author NamDoan
 */
public class TimeSheetReportController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Date today = new Date();
    today=DateEtOEt.removeTime(today);
    int dayOfMonth=DateEtOEt.getDayOfMonth(today);
    Date begin = DateEtOEt.addDays(today, -1*(dayOfMonth-1));
    Date end = DateEtOEt.addDays(DateEtOEt.addMonths(begin,1),-1);
    ArrayList<Date> dates= DateEtOEt.getDates(begin,end);
    EmployeeDBContext db = new EmployeeDBContext();
    ArrayList<Employee> employees = db.getEmployees(begin,end);
    request.setAttribute("dates", dates);
    request.setAttribute("dates", dates);
    request.setAttribute("employees", employees);
    request.getRequestDispatcher("view/chamcong.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    }
    
}
