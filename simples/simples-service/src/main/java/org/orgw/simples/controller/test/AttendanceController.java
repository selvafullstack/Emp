package org.orgw.simples.controller.test;

import org.apache.log4j.Logger;
import org.orgw.simples.controller.BaseController;
import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.AttendanceRequest;
import org.orgw.simples.data.CreateTestRequest;
import org.orgw.simples.data.Response;
import org.orgw.simples.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController extends BaseController {
	
	
private final Logger log = Logger.getLogger(getClass());

@Override
protected String getServiceCode() {
	// TODO Auto-generated method stub
	return null;
}
	
	@Autowired
	IAttendanceService attendanceService;
	
	@PostMapping(value="/user/attendance", produces = "application/json; charset=UTF-8")
	public Response attendance(@RequestBody AttendanceRequest attendanceRequest)throws BaseException {
		
		return response(attendanceService.addAttendance(attendanceRequest));
				
	}
	
	@PostMapping(value={"/user/getattendance"}, produces={"application/json; charset=UTF-8"})
	  public Response getattendance(@RequestBody AttendanceRequest attendanceRequest)
	    throws BaseException
	  {
	    return response(this.attendanceService.getattendance(attendanceRequest));
	  }
	  
	  @PostMapping(value={"/user/checkin"}, produces={"application/json; charset=UTF-8"})
	  public Response attendancecheckin(@RequestBody AttendanceRequest attendanceRequest)
	    throws BaseException
	  {
	    return response(this.attendanceService.checkin(attendanceRequest));
	  }
	  
	  @PostMapping(value={"/user/checkout"}, produces={"application/json; charset=UTF-8"})
	  public Response attendancecheckout(@RequestBody AttendanceRequest attendanceRequest)
	    throws BaseException
	  {
	    return response(this.attendanceService.checkout(attendanceRequest));
	  }
   
}
