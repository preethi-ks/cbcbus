package com.wipro.bus.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.service.Administrator;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String operation=request.getParameter("operation");
		if(operation.equals("newSchedule")){
			String result=addSchedule(request);
			if(result.equals("SUCCESS")){
				response.sendRedirect("success.jsp");
			}else if(result.equals("FAIL")){
				response.sendRedirect("errorInserting.html");
			}
		}
		if(operation.equals("viewSchedule")){
			if(viewSchedule(request)==null){
				request.setAttribute("error",viewSchedule(request));
				System.out.println("No matching schedule exists!Please try again!");
				response.sendRedirect("displaySchedule.jsp");
			}else{
				request.setAttribute("bean",viewSchedule(request));
				RequestDispatcher dispatcher=request.getRequestDispatcher("displaySchedule");
				dispatcher.forward(request,response);
			}
		}
	}
	public String addSchedule(HttpServletRequest request){
		Administrator admin=new Administrator();
		ScheduleBean scheduleBean=new ScheduleBean();
		scheduleBean.setSource(request.getParameter("source"));
		scheduleBean.setDestination(request.getParameter("destination"));
		scheduleBean.setStartTime(request.getParameter("startTime"));
		scheduleBean.setArrivalTime(request.getParameter("arrivalTime"));
		admin.addSchedule(scheduleBean);
		return "SUCCESS";
		
		
	}
	public ArrayList<ScheduleBean> viewSchedule(HttpServletRequest request){
		Administrator admin=new Administrator();
		return admin.viewSchedule(request.getParameter("source"),request.getParameter("destination"));
		
	}



}
