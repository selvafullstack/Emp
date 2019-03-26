package org.orgw.simples.repository;

import org.orgw.simples.repository.model.Users;

public interface IUserRepository extends DataRepository<Users> {

	Users getuserdetails(String employeid);

	
}
