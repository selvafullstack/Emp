package org.orgw.simples.repository.jpa;

import javax.persistence.NoResultException;

import org.orgw.simples.repository.IUserRepository;
import org.orgw.simples.repository.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends AbstractBaseRepository<Users> implements IUserRepository  {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Override
	public Users getuserdetails(String employeid) {

		 try{
	        return this.getEntityManager().createQuery("select sc from Users sc where sc.employeId=:employeId and sc.status=:status", Users.class)
	        		.setParameter("employeId", employeid)
	        		.setParameter("status", "1")
	        		.getSingleResult();
			}catch(NoResultException  e){
				LOG.debug("UserRepository :: by getuserdetails :: NoResultException");
			}
			return null;
		
	}

	
	
	
	
}
