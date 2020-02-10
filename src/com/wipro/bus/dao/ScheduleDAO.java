package com.wipro.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.util.DBUtil;

public class ScheduleDAO {
Connection con;
PreparedStatement ps;
ResultSet rs;
public String createSchedule(ScheduleBean scheduleBean){
	con=(Connection) DBUtil.getDBConnection();
	try{
		ps=con.prepareStatement("insert into SCHEDULE_TBL values(?,?,?,?,?)");
		ps.setString(1,scheduleBean.getScheduleId_ID() );
		ps.setString(2, scheduleBean.getSource());
		ps.setString(3, scheduleBean.getDestination());
		ps.setString(4,scheduleBean.getStartTime());
		ps.setString(5,scheduleBean.getArrivalTime());
		if(ps.executeUpdate()>0){
			return "Success";
		}
	}catch(SQLException e){
		System.out.println(e);
	}
	return null;
}
public String generateID(String source,String destination){
	con=(Connection) DBUtil.getDBConnection();
	int id=0;
	try{
		ps=con.prepareStatement("select SCHEDULE_SEQ.nextval from dual");
		rs=ps.executeQuery();
		rs.next();
		id=rs.getInt(1);
	}catch(SQLException e){
		System.out.println(e);
	}
	return source.substring(0, 2).toUpperCase()+destination.substring(0,2).toUpperCase()+id;
}
public ArrayList<ScheduleBean> viewSchedule(String source,String destination){
	ArrayList<ScheduleBean> list=new ArrayList<ScheduleBean>();
	con=(Connection) DBUtil.getDBConnection();
	try{
		ps=con.prepareStatement("select * from SCHEDULE_TBL where source='"+source+"' and destination='"+destination+"'");
		rs=ps.executeQuery();
		while(rs.next()){
			ScheduleBean bean=new ScheduleBean();
			bean.setScheduleId_ID(rs.getString(1));
			bean.setSource(rs.getString(2));
			bean.setDestination(rs.getString(3));
			bean.setStartTime(rs.getString(4));
			bean.setArrivalTime(rs.getString(5));
			list.add(bean);
		}
	}catch(SQLException e){
		System.out.println(e);
	}
	return list;
	
}
}
