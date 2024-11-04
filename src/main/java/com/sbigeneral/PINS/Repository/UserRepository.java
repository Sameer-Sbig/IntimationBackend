package com.sbigeneral.PINS.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sbigeneral.PINS.Entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<User>  findByUsername(String username);

	/*
	 * @Query("select u from User u where u.username = :username") Optional<User>
	 * findByagrementcode(String agrementcode);
	 */
	@Query("select u from User u where u.username = :username")
	public User findByUsername1(String username);
	
	
	@Modifying
    @Transactional
    @Query("UPDATE User e SET e.EncodePassword = :EncodePassword, e.flag = :flag, e.password = :password WHERE e.username = :username")
    int updateColumnsById(@Param("username") String username,
                          @Param("EncodePassword") String EncodePassword,
                          @Param("flag") String flag,
                          @Param("password") String password);

}
