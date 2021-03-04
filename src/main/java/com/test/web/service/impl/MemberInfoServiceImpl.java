package com.test.web.service.impl;

import java.util.List;

import com.test.web.dao.MemberInfoDAO;
import com.test.web.dao.impl.MemberInfoDAOImpl;
import com.test.web.entity.MemberInfo;
import com.test.web.service.MemberInfoService;

public class MemberInfoServiceImpl implements MemberInfoService {
	private MemberInfoDAO memberInfoDAO = new MemberInfoDAOImpl();
	@Override
	public List<MemberInfo> selectMemberInfoList(MemberInfo memberInfo) {
		return memberInfoDAO.selectMemberInfoList(memberInfo);
	}

	@Override
	public MemberInfo selectMemberInfo(MemberInfo memberInfo) {
		return memberInfoDAO.selectMemberInfo(memberInfo);
	}

	@Override
	public int saveMemberInfo(MemberInfo memberInfo) {
		return memberInfoDAO.saveMemberInfo(memberInfo);
	}

	@Override
	public int updateMemberInfo(MemberInfo memberInfo) {
		return memberInfoDAO.updateMemberInfo(memberInfo);
	}

	@Override
	public int deleteMemberInfo(MemberInfo memberInfo) {
		return memberInfoDAO.deleteMemberInfo(memberInfo);
	}

}
