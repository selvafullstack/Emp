package org.orgw.simples.service;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.AttendanceRequest;
import org.orgw.simples.data.AttendanceResponse;

public interface IAttendanceService {

	AttendanceResponse addAttendance(AttendanceRequest attendanceRequest) throws BaseException;
	AttendanceResponse checkin(AttendanceRequest paramAttendanceRequest) throws BaseException;
	AttendanceResponse checkout(AttendanceRequest paramAttendanceRequest) throws BaseException;
	AttendanceResponse getattendance(AttendanceRequest paramAttendanceRequest) throws BaseException;

}
