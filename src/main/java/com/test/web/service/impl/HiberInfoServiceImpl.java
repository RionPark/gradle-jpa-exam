package com.test.web.service.impl;

import java.util.List;

import com.test.web.dao.HiberInfoDAO;
import com.test.web.dao.impl.HiberInfoDAOImpl;
import com.test.web.entity.HiberInfo;
import com.test.web.service.HiberInfoService;

public class HiberInfoServiceImpl implements HiberInfoService {
	private HiberInfoDAO hiberInfoDAO = new HiberInfoDAOImpl();
	@Override
	public List<HiberInfo> getHiberInfoList() {
		return hiberInfoDAO.getHiberInfoList();
	}

	@Override
	public HiberInfo getHiberInfo(int hiNum) {
		return hiberInfoDAO.getHiberInfo(hiNum);
	}

	@Override
	public int saveHiberInfo(HiberInfo hiberInfo) {
		return hiberInfoDAO.saveHiberInfo(hiberInfo);
	}

	@Override
	public int updateHiberInfo(HiberInfo hiberInfo) {
		return hiberInfoDAO.updateHiberInfo(hiberInfo);
	}

	@Override
	public int deleteHiberInfo(int hiNum) {
		return hiberInfoDAO.deleteHiberInfo(hiNum);
	}

}
