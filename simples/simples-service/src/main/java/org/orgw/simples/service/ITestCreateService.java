package org.orgw.simples.service;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.CreateTestRequest;
import org.orgw.simples.data.TestResponse;

public interface ITestCreateService {

	TestResponse addTest(CreateTestRequest request) throws BaseException;

	TestResponse loginUser(CreateTestRequest request)throws BaseException;

	TestResponse addUser(CreateTestRequest request) throws BaseException;

	
}
