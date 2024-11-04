package com.sbigeneral.PINS.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbigeneral.PINS.Entity.UserDetails;





@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer > {
	
	
	@Query("SELECT u FROM UserDetails u where u.employeeId =:employeeIdInput")
	public UserDetails findByEmployeeId(@Param("employeeIdInput") String employeeIdInput);
	
	/*
	 * @Query("SELECT u FROM UserDetails u where u.employeeId =:userModel.employeeId AND u.password =:userModel.password"
	 * ) public UserDetails checkLogin(@Param("userModel") UserModel userEntered);
	 */

	@Query("SELECT u FROM UserDetails u WHERE u.employeeId = :employeeId  AND u.password = :password")
	public UserDetails checkLogin(@Param("employeeId") String employeeId, @Param("password") String password);
	
	   @Query("UPDATE UserDetails u SET u.isLoggedIn = false WHERE u.employeeId = :employeeId")
	    @Modifying
	    @Transactional
	    void logout(@Param("employeeId") String employeeId);
	   
	   
	   
	   
	   
	   // new code
//	 Optional<UserDetails> findByUsername(String employeeId);

	 
}
