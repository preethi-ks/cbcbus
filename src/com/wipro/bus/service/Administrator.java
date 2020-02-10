package com.wipro.bus.service;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.dao.ScheduleDAO;
import com.wipro.bus.util.InvalidInputException;
public class Administrator  {
	ScheduleDAO scheduleDAO=new ScheduleDAO();
	public String addSchedule(ScheduleBean scheduleBean){
		try{
			if(scheduleBean!=null && scheduleBean.getSource().length()>2
				&& scheduleBean.getDestination().length()>2 && scheduleBean.getArrivalTime().length()>0
				&& scheduleBean.getStartTime().length()>0){
				if(scheduleBean.getSource().equals(scheduleBean.getDestination())){
					return "Source and Destination same";
				}else{
					scheduleBean.setScheduleId_ID(scheduleDAO.generateID(scheduleBean.getSource(),scheduleBean.getDestination()));
				return scheduleDAO.createSchedule(scheduleBean);
				}
			}else{
				try{
					throw new InvalidInputException();
				}catch(InvalidInputException e){
					return e.toString();
				}
			}
		}
			catch(NullPointerException e){
				return "INVALID INPUT";
			}
			
		}
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination){
		return scheduleDAO.viewSchedule(source, destination);
	}

	}
