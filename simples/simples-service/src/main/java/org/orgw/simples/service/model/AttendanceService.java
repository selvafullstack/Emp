package org.orgw.simples.service.model;

import javax.transaction.Transactional;

import org.orgw.simples.data.AttendanceRequest;
import org.orgw.simples.data.AttendanceResponse;
import org.orgw.simples.repository.IAttendanceRepository;
import org.orgw.simples.repository.model.Attendance;
import org.orgw.simples.service.IAttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AttendanceService implements IAttendanceService{
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IAttendanceRepository attendanceRepository;
	
	
	public AttendanceResponse addAttendance(AttendanceRequest attendanceRequest) {
		
		//try {

		
		Attendance attendance=new Attendance();
		attendance.setEmpid(attendanceRequest.getEmpid());
		attendance.setCheckin(attendanceRequest.getCheckin());
		attendance.setCheckout(attendanceRequest.getCheckout());
		attendance.setTotaltime(attendanceRequest.getTotaltime());
		attendance.setDate(attendanceRequest.getDate());
		attendanceRepository.save(attendance);
		attendanceRepository.refresh(attendance);
		
		 String id = attendance.getId();
		 return attendancedetails(attendanceRequest,id);
		
		//}catch(Exception e) {
			//LOG.debug("AttendanceService "+ e);
		//}
	//	return null;
	}


	private AttendanceResponse attendancedetails(AttendanceRequest attendanceRequest, String id) {
		
		
		Attendance attendancedetails=attendanceRepository.getattendancedetails(id);
		
		AttendanceResponse attendance=new AttendanceResponse();
		
		attendance.setEmpid(attendancedetails.getEmpid());
		attendance.setCheckin(attendancedetails.getCheckin());
	    attendance.setCheckout(attendancedetails.getCheckout());
	    attendance.setTotaltime(attendancedetails.getTotaltime());
	    attendance.setDate(attendancedetails.getDate());
		// TODO Auto-generated method stub
		return attendance;
	}
	

}
