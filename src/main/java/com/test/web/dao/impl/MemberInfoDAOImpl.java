package com.test.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.test.web.dao.MemberInfoDAO;
import com.test.web.entity.MemberInfo;
import com.test.web.util.SessionUtil;

public class MemberInfoDAOImpl implements MemberInfoDAO {

	
	@Override
	public int saveMemberInfo(MemberInfo memberInfo) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		int result = (int) ss.save(memberInfo);
		ss.getTransaction().commit();
		ss.close();
		return result;
	}

	@Override
	public List<MemberInfo> selectMemberInfoList(MemberInfo memberInfo) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		Query<MemberInfo> query = ss.createNativeQuery("select * from member_info",MemberInfo.class);
		List<MemberInfo> memberInfoList = query.list();
		ss.getTransaction().commit();
		ss.close();
		return memberInfoList;
	}

	@Override
	public MemberInfo selectMemberInfo(MemberInfo memberInfo) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		MemberInfo mi = ss.get(MemberInfo.class, memberInfo.getMiNum());
		ss.getTransaction().commit();
		ss.close();
		return mi;
	}

	@Override
	public int updateMemberInfo(MemberInfo memberInfo) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		MemberInfo mi = ss.get(MemberInfo.class, memberInfo.getMiNum());
		if(mi==null) {
			ss.close();
			return 0;
		}
		ss.clear();
		ss.update(memberInfo);
		ss.getTransaction().commit();
		ss.close();
		return 1;
	}

	@Override
	public int deleteMemberInfo(MemberInfo memberInfo) {
		Session ss = SessionUtil.getSession();
		ss.beginTransaction();
		MemberInfo mi = ss.get(MemberInfo.class, memberInfo.getMiNum());
		if(mi==null) {
			ss.close();
			return 0;
		}
		ss.clear();
		ss.delete(mi);
		ss.getTransaction().commit();
		ss.close();
		return 1;
	}

	
	public static void main(String[] args) {
		MemberInfoDAO memberInfoDAO = new MemberInfoDAOImpl();
		MemberInfo member = new MemberInfo();
		member.setMiNum(1);
		member.setMiAge(20);
		member.setMiId("test");
		member.setMiName("이름");
		member.setMiPwd("pass");
		System.out.println(memberInfoDAO.saveMemberInfo(member));
	}
}
