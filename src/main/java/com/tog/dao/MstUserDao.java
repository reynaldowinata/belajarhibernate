package com.tog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tog.entity.MstUser;

public interface MstUserDao extends JpaRepository<MstUser, Integer> {
	
	@Query(value="SELECT p FROM MstUser p WHERE p.username = :username "
			+ "and p.password = :password")
	public List<MstUser> findByUsernameAndPassword(
			@Param("username") String username,
			@Param("password") String password);

}
