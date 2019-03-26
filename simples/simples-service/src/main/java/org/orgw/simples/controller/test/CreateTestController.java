package org.orgw.simples.controller.test;

import java.net.InetAddress;

import org.orgw.simples.controller.BaseController;
import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.CreateTestRequest;
import org.orgw.simples.data.Response;
import org.orgw.simples.service.ITestCreateService;
import org.orgw.simples.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTestController extends BaseController {

	
	@Autowired
	ITestCreateService createService;
	
	@Autowired
	IUserService userService;
	
	/*
	@PostMapping(value="/create/test", produces = "application/json; charset=UTF-8")
	public Response addComment(@RequestBody CreateTestRequest request)throws BaseException {
		 
		
		//datas.save("employee" new employee);
		//createService.update(employee);
		
		 
		// validate(request);
		 return response(createService.addTest(request));
	}
	
	
	@PostMapping(value="/create/newuser", produces = "application/json; charset=UTF-8")
	public Response addUser(@RequestBody CreateTestRequest request)throws BaseException {
		 
		
		//datas.save("employee" new employee);
		//createService.update(employee);
		
		 
		// validate(request);
		 return response(createService.addUser(request));
	}
	
	
	
	
	*/
	
	
	@PostMapping (value="user/create", produces = "application/json; charset-UTF-8")
	public Response userAdd(@RequestBody  CreateTestRequest  request  ) throws BaseException {
		
		
		
		
		return response (userService.addUser(request));
		
		
		
	}
	
	
	
	
	private void validate(CreateTestRequest request) throws BaseException {
		try {
		   //InetAddress inetAddress = InetAddress.getLocalHost();
	       //System.out.println("IP Address:- " + inetAddress.getHostAddress());
	      // System.out.println("Host Name:- " + inetAddress.getHostName());
	  
		}catch(Exception e) {
	
		}
	}


	@Override
	protected String getServiceCode() {
		// TODO Auto-generated method stub
		return "CreateTestAdd";
	}

	
}
