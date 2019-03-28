package org.orgw.simples.repository;

import java.util.List;

import org.orgw.simples.repository.model.EmailDetails;
import org.springframework.jdbc.core.RowMapper;

public interface ILeaveRequestRepository extends DataRepository<EmailDetails> {

	EmailDetails getleaverequestdetails(String empid);

	List<EmailDetails> query(String sql, RowMapper<EmailDetails> rm);
	
	

}
