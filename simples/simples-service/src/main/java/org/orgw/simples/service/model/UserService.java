package org.orgw.simples.service.model;

import javax.transaction.Transactional;

import org.orgw.simples.core.util.UtilHelper;
import org.orgw.simples.data.CreateTestRequest;
import org.orgw.simples.data.UserResponse;
import org.orgw.simples.repository.ITestRepository;
import org.orgw.simples.repository.IUserRepository;
import org.orgw.simples.repository.model.Users;
import org.orgw.simples.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService  implements IUserService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserResponse addUser(CreateTestRequest request) {
		
		
		Users newuser = new Users();
		newuser.setEmployeId(request.getEmployeid());
		newuser.setIp(request.getIp());
		newuser.setPassword(request.getPassword());
		newuser.setDateTime(UtilHelper.getSystemDate());
		newuser.setStatus("1");
		userRepository.save(newuser);
		userRepository.refresh(newuser);
		
		
		return getdetails(request);
	}

	private UserResponse getdetails(CreateTestRequest request) {
		
		
		Users userdetails = userRepository.getuserdetails(request.getEmployeid());
		
		UserResponse user=  new UserResponse();
		user.setEmployeid(userdetails.getEmployeId());
		user.setPassword(userdetails.getPassword());
		user.setIp(userdetails.getIp());
		
		return user;
	}

	
}
