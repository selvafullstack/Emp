package org.orgw.simples.service;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.LeaveRequest;
import org.orgw.simples.data.LeaveResponse;

public interface ILeaveService {

	LeaveResponse leaverequest(LeaveRequest request) throws BaseException;
		

}
