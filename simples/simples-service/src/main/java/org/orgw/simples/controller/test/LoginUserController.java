package org.orgw.simples.controller.test;

import java.net.InetAddress;

import org.apache.log4j.Logger;
import org.orgw.simples.controller.BaseController;
import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.CreateTestRequest;
import org.orgw.simples.data.Response;
import org.orgw.simples.repository.model.Users;
import org.orgw.simples.service.ITestCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUserController extends BaseController {

	private final Logger log = Logger.getLogger(getClass());
	
	@Autowired
	ITestCreateService createService;
	
	@PostMapping(value="/user/login", produces = "application/json; charset=UTF-8")
	public Response loginUser(@RequestBody CreateTestRequest request)throws BaseException {
		 
		//try {
		//InetAddress inetAddress = InetAddress.getLocalHost();
		
		//System.out.println("IP Address:- " + inetAddress.getHostAddress());
	    //   System.out.println("Host Name:- " + inetAddress.getHostName());
		// validate(request);
			
		
	//	log.debug("IP Address:- "+inetAddress.getHostAddress());
		
		//}catch(Exception e) {
			
			
		//}
		
		
		
		return response(createService.loginUser(request));
		//return null;
		
	}
	
	
	private void validate(CreateTestRequest request) {
		
		
		
		
	}


	@Override
	protected String getServiceCode() {
		
		return "Login";
	}

}
