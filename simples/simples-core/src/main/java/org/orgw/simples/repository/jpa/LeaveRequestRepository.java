package org.orgw.simples.repository.jpa;

import javax.persistence.NoResultException;

import org.orgw.simples.repository.ILeaveRequestRepository;
import org.orgw.simples.repository.model.EmailDetails;
import org.orgw.simples.repository.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class LeaveRequestRepository extends AbstractBaseRepository<EmailDetails> implements ILeaveRequestRepository{

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Override
	public EmailDetails getleaverequestdetails (String empid) {
		 try{
		        return this.getEntityManager().createQuery("select sc from EmailDetails sc where sc.id=:id", EmailDetails.class)
		        		.setParameter("id", empid)
		        		//.setParameter("status", "1")
		        		.getSingleResult();
				}catch(NoResultException  e){
					LOG.debug("LeaveRequestRepository :: by getleaverequestdetails :: NoResultException");
				}
				return null;
			
		}

	
	
	
}
