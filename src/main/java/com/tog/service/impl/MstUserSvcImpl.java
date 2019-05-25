package com.tog.service.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tog.dao.MstUserDao;
import com.tog.entity.MstUser;
import com.tog.service.MstUserSvc;

@Service
@Transactional
public class MstUserSvcImpl implements MstUserSvc {
	
	@Autowired
	private MstUserDao mstUserDao;

	@Override
	public List<MstUser> findAll() {
		try {
			return mstUserDao.findAll();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new HibernateException(exception);
		}
	}

	@Override
	public List<MstUser> findByUsernameAndPassword(String username,
			String password) {
		try {
			return mstUserDao.findByUsernameAndPassword(username, password);
		} catch (Exception e) {
			throw new HibernateException(e);
		}
	}

	@Override
	public void save(MstUser mstUser) {
		try {
			mstUserDao.save(mstUser);
		} catch (Exception e) {
			throw new HibernateException(e);
		}
	}
	
	

}
