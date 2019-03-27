package org.orgw.simples.repository.jpa;

import javax.persistence.NoResultException;

import org.orgw.simples.repository.IAttendanceRepository;
import org.orgw.simples.repository.model.Attendance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceRepository extends AbstractBaseRepository<Attendance> implements IAttendanceRepository {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Override
	public Attendance getattendancedetails(String id) {
		 try{
		        return this.getEntityManager().createQuery("select sc from Attendance sc where sc.id=:id ", Attendance.class)
		        		.setParameter("id", id)
		        		//.setParameter("status", "1")
		        		.getSingleResult();
				}catch(NoResultException  e){
					LOG.debug("AttendanceRepository :: by getattendanceetails :: NoResultException");
				}
				return null;
	}
	@Override
	public Attendance getEmployeeDetailByDate(String empid, String date) {
		try{
	        return this.getEntityManager().createQuery("select sc from Attendance sc where sc.empid=:empid and sc.date=:date  ", Attendance.class)
	        		.setParameter("empid", empid)
	        		.setParameter("date", date)
	        		.getSingleResult();
			}catch(NoResultException  e){
				LOG.debug("AttendanceRepository :: by getEmployeeDetailByDate :: NoResultException");
			}
		return null;
	}

}
