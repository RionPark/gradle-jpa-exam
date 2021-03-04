package com.test.web.service;

import java.util.List;

import com.test.web.entity.HiberInfo;

public interface HiberInfoService {

	List<HiberInfo> getHiberInfoList();
	HiberInfo getHiberInfo(int hiNum);
	int saveHiberInfo(HiberInfo hiberInfo);
	int updateHiberInfo(HiberInfo hiberInfo);
	int deleteHiberInfo(int hiNum);
}
