package org.orgw.simples.repository;

import org.orgw.simples.repository.model.EmailDetails;

public interface ILeaveRequestRepository extends DataRepository<EmailDetails> {

	EmailDetails getleaverequestdetails(String empid);
	
	

}
