package org.orgw.simples.repository;

import java.util.List;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.repository.model.Users;


public interface ITestRepository extends DataRepository<Users> {

	Users getbyEmpname(String employeId) throws BaseException;
	
	
}
