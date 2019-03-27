package org.orgw.simples.service.model;

import javax.transaction.Transactional;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.data.AttendanceRequest;
import org.orgw.simples.data.AttendanceResponse;
import org.orgw.simples.repository.IAttendanceRepository;
import org.orgw.simples.repository.model.Attendance;
import org.orgw.simples.service.IAttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AttendanceService implements IAttendanceService
{
private final Logger LOG = LoggerFactory.getLogger(getClass());
@Autowired
IAttendanceRepository attendanceRepository;

public AttendanceResponse addAttendance(AttendanceRequest attendanceRequest) {
  this.LOG.debug("Attendance" + attendanceRequest.getEmpid());
  
  this.LOG.debug("Attendance" + attendanceRequest.getDate());
  Attendance employee = this.attendanceRepository.getEmployeeDetailByDate(attendanceRequest.getEmpid(), attendanceRequest.getDate());
  String id;
  if (employee == null)
  {
    Attendance attendance = new Attendance();
    attendance.setEmpid(attendanceRequest.getEmpid());
    attendance.setCheckin(attendanceRequest.getCheckin());
    attendance.setCheckout(attendanceRequest.getCheckout());
    attendance.setTotaltime(attendanceRequest.getTotaltime());
    attendance.setDate(attendanceRequest.getDate());
    this.attendanceRepository.save(attendance);
    this.attendanceRepository.refresh(attendance);
    
    id = attendance.getEmpid();
  }
  else
  {
    employee.setDate(attendanceRequest.getDate());
    this.attendanceRepository.update(employee);
    id = employee.getEmpid();
  }
  return attendancedetails(attendanceRequest, id);
  
  
}

private AttendanceResponse attendancedetails(AttendanceRequest attendanceRequest, String id) {
  Attendance attendancedetails = this.attendanceRepository.getEmployeeDetailByDate(attendanceRequest.getEmpid(), attendanceRequest.getDate());
  
  AttendanceResponse attendance = new AttendanceResponse();
  
  attendance.setId(attendancedetails.getId());
  attendance.setEmpid(attendancedetails.getEmpid());
  attendance.setCheckin(attendancedetails.getCheckin());
  attendance.setCheckout(attendancedetails.getCheckout());
  attendance.setTotaltime(attendancedetails.getTotaltime());
  attendance.setDate(attendancedetails.getDate());
  
  return attendance;
}

public AttendanceResponse checkin(AttendanceRequest attendanceRequest)throws BaseException {
  Attendance employee = this.attendanceRepository.getEmployeeDetailByDate(attendanceRequest.getEmpid(), attendanceRequest.getDate());
  if (employee.getCheckin() == null)
  {
    employee.setCheckin(attendanceRequest.getCheckin());
    this.attendanceRepository.update(employee);
  }
  return attendancedetails(attendanceRequest, employee.getId());
}

public AttendanceResponse checkout(AttendanceRequest attendanceRequest) throws BaseException {
  Attendance employecheckout = this.attendanceRepository.getEmployeeDetailByDate(attendanceRequest.getEmpid(), attendanceRequest.getDate());
  
  employecheckout.setCheckout(attendanceRequest.getCheckout());
  employecheckout.setTotaltime(attendanceRequest.getTotaltime());
  this.attendanceRepository.update(employecheckout);
  
  return attendancedetails(attendanceRequest, employecheckout.getId());
}

public AttendanceResponse getattendance(AttendanceRequest attendanceRequest) throws BaseException {
  Attendance attendancedetails = this.attendanceRepository.getattendancedetails(attendanceRequest.getAttendid());
  
  AttendanceResponse attendance = new AttendanceResponse();
  
  attendance.setId(attendancedetails.getId());
  attendance.setEmpid(attendancedetails.getEmpid());
  attendance.setCheckin(attendancedetails.getCheckin());
  attendance.setCheckout(attendancedetails.getCheckout());
  attendance.setTotaltime(attendancedetails.getTotaltime());
  attendance.setDate(attendancedetails.getDate());
  
  return attendance;
}
}