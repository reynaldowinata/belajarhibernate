package com.tog.service;

import java.util.List;

import com.tog.entity.MstUser;

public interface MstUserSvc {
	
	public List<MstUser> findAll();
	public List<MstUser> findByUsernameAndPassword(
			String username,
			String password);
	public void save(MstUser mstUser);

}
