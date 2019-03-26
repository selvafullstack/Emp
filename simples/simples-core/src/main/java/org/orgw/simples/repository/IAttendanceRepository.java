package org.orgw.simples.repository;

import org.orgw.simples.repository.model.Attendance;
import org.orgw.simples.repository.model.Users;

public interface IAttendanceRepository extends DataRepository<Attendance>{

	Attendance getattendancedetails(String checkin);

}
