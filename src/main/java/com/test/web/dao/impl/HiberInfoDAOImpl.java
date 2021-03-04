package com.test.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.test.web.dao.HiberInfoDAO;
import com.test.web.entity.HiberInfo;
import com.test.web.util.SessionUtil;

public class HiberInfoDAOImpl implements HiberInfoDAO {

	@Override
	public List<HiberInfo> getHiberInfoList() {
		Session ss = SessionUtil.getSession();
		Query<HiberInfo> q = ss.createNativeQuery("select hi_num, hi_id, hi_name from hiber_info", HiberInfo.class);
		List<HiberInfo> hiberInfoList = q.list();
		ss.close();
		return hiberInfoList;
	}

	@Override
	public HiberInfo getHiberInfo(int hiNum) {
		Session ss = SessionUtil.getSession();
		HiberInfo hiberInfo = ss.get(HiberInfo.class, hiNum);
		ss.close();
		return hiberInfo;
	}

	@Override
	public int saveHiberInfo(HiberInfo hiberInfo) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		int cnt = (int)ss.save(hiberInfo);
		ss.getTransaction().commit();
		ss.close();
		return cnt;
	}

	@Override
	public int updateHiberInfo(HiberInfo hiberInfo) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		HiberInfo org = ss.get(HiberInfo.class, hiberInfo.getHiNum());
		if(org==null) {
			ss.close();
			return 0;
		}
		ss.clear();
		ss.update(hiberInfo);
		ss.getTransaction().commit(); 
		ss.close();
		return 1;
	}

	@Override
	public int deleteHiberInfo(int hiNum) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		HiberInfo org = ss.get(HiberInfo.class, hiNum);
		if(org==null) {
			ss.close();
			return 0;
		}
		ss.clear();
		ss.delete(org);
		ss.getTransaction().commit();
		ss.close();
		return 1;
	}

}
