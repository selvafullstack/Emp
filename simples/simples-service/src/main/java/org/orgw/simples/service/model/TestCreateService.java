package org.orgw.simples.service.model;




import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.apache.log4j.Logger;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.core.exception.SimplesConstant;
import org.orgw.simples.core.exception.ValidationException;
import org.orgw.simples.core.util.UtilHelper;
import org.orgw.simples.data.CreateTestRequest;
import org.orgw.simples.data.TestResponse;
import org.orgw.simples.repository.ITestRepository;
import org.orgw.simples.repository.model.Users;
import org.orgw.simples.service.ITestCreateService;


@Service
@Transactional
public class TestCreateService implements ITestCreateService {
	private final Logger log = Logger.getLogger(getClass());
	
	@Autowired
	ITestRepository testRepository;
	
	@Override
	public TestResponse addTest(CreateTestRequest request) throws BaseException {
		// TODO Auto-generated method stub
		try {
			
			
			Users userdetails = testRepository.getbyEmpname(request.getEmployeid());	
			
			if(userdetails!=null) {
			
				Users datas = new Users();
				datas.setIp(request.getIp());
				datas.setPassword(request.getPassword());
				datas.setDateTime(UtilHelper.getSystemDate());
				datas.setEmployeId(request.getEmployeid());
				datas.setStatus("1");
				testRepository.save(datas);
				testRepository.refresh(datas);
				
			
				return getedata(request);
				
				
			}else {
				
				throw new ValidationException(SimplesConstant.CODE_0,SimplesConstant.USERAVAILBLE);
				
				
			}
					
				
				
				}catch(Exception e) {
					
					log.debug("addTest handleException Exception"+e);
					
					throw new ValidationException(SimplesConstant.CODE_0,SimplesConstant.WRONG);
					
				}
		
		
	}

	private TestResponse getedata(CreateTestRequest request) throws BaseException {
		
		Users datas = testRepository.getbyEmpname(request.getEmployeid());
		TestResponse entity = new TestResponse();
		entity.setId(datas.getId());
		entity.setPassword(datas.getPassword());
		entity.setDateTime(datas.getDateTime());
		entity.setStatus(datas.getStatus());
		entity.setEmployeid(datas.getEmployeId());
		entity.setIp(datas.getIp());
		return entity;
	}

	@Override
	public TestResponse loginUser(CreateTestRequest request) throws BaseException {
		
		try {
			Users userdetails = testRepository.getbyEmpname(request.getEmployeid());	
	        
			if((userdetails.getEmployeId().equals(request.getEmployeid())) && (userdetails.getPassword().equals(request.getPassword()))) {
				TestResponse entity = new TestResponse();
				entity.setId(userdetails.getId());
				entity.setPassword(userdetails.getPassword());
				entity.setDateTime(userdetails.getDateTime());
				entity.setStatus(userdetails.getStatus());
				entity.setEmployeid(userdetails.getEmployeId());
				entity.setIp(userdetails.getIp());
				return entity;  
				
			}else {
				
				throw new ValidationException(SimplesConstant.CODE_0,SimplesConstant.FAIL);
				
			}
			
		}catch(Exception e) {
			
			
			throw new ValidationException(SimplesConstant.CODE_0,SimplesConstant.WRONG);
		}
		
	}

	@Override
	public TestResponse addUser(CreateTestRequest request) throws BaseException {

		Users entity = new Users();
		entity.setIp(request.getIp());
		entity.setPassword(request.getPassword());
		entity.setEmployeId(request.getEmployeid());
		entity.setStatus("1");
		testRepository.save(entity);
		testRepository.refresh(entity);
		
		
		
		return null;
	}
	
	
	

}
