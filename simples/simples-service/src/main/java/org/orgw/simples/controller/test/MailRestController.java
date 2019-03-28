package org.orgw.simples.controller.test;





import org.apache.log4j.Logger;
import org.orgw.simples.controller.BaseController;
import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.LeaveRequest;
import org.orgw.simples.data.Response;
import org.orgw.simples.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailRestController  extends BaseController {

	private final Logger log = Logger.getLogger(getClass());
	

	@Autowired
	ILeaveService leaveservice;
	

	 @RequestMapping(path="/user/leaverequest",method= {RequestMethod.GET,RequestMethod.POST})
	 public Response leaveRequest(@RequestBody LeaveRequest request) throws BaseException {
		 return response("users",leaveservice.leaverequest(request));
	 }
	 
	@Override
	protected String getServiceCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
