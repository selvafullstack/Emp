package org.orgw.simples.service;

import org.orgw.simples.data.CreateTestRequest;
import org.orgw.simples.data.UserResponse;

public interface IUserService {

	UserResponse addUser(CreateTestRequest request);

}
