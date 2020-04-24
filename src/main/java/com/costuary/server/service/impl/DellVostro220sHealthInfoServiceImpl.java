package com.costuary.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costuary.server.dao.DellVostro220sDao;
import com.costuary.server.dto.DellVostro220sDto;
import com.costuary.server.service.ServerHealthInfoService;

@Service
public class DellVostro220sHealthInfoServiceImpl implements ServerHealthInfoService {

	@Autowired
	private DellVostro220sDao dao;

	@Override
	public int addServerHealthInfo(Object obj) {
		int result = 0;
		if(obj instanceof DellVostro220sDto) {
			DellVostro220sDto dto = (DellVostro220sDto)obj;
			result = dao.addServerHealthInfo(dto);
		}
		return result;
	}

}
