package com.test.web.dao;

import java.util.List;

import com.test.web.entity.MemberInfo;

public interface MemberInfoDAO {
	List<MemberInfo> selectMemberInfoList(MemberInfo memberInfo);
	MemberInfo selectMemberInfo(MemberInfo memberInfo);
	int saveMemberInfo(MemberInfo memberInfo);
	int updateMemberInfo(MemberInfo memberInfo);
	int deleteMemberInfo(MemberInfo memberInfo);
}
