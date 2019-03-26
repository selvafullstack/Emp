package org.orgw.simples.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.orgw.simples.repository.ITestRepository;
import org.orgw.simples.repository.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.core.exception.SimplesConstant;


@Repository
public class TestRepository  extends AbstractBaseRepository<Users> implements ITestRepository {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Override
	public Users getbyEmpname(String employeId) throws BaseException {
		try{
	        return this.getEntityManager().createQuery("select sc from Users sc where sc.employeId=:employeId and sc.status=:status", Users.class)
	        		.setParameter("employeId", employeId)
	        		.setParameter("status", "1")
	        		.getSingleResult();
			}catch(NoResultException  e){
				LOG.debug("TestRepository :: by getbyEmpname :: NoResultException");
			}
			return null;
	}
	
	
	
}
