package com.costuary.server.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.costuary.common.util.IpUtil;
import com.costuary.server.dto.DellVostro220sDto;
import com.costuary.server.service.impl.DellVostro220sHealthInfoServiceImpl;

@Controller
@RequestMapping("/")
public class ServerHealthInfoController {

	@Autowired
	private DellVostro220sHealthInfoServiceImpl dellVostroService;

	/**
	 * Add Server Health Info for Dell vostro-220s
	 * @param parameters
	 * @return
	 */
	@RequestMapping("/ServerHealthInfo")
    @ResponseBody
    public String addServerHealthInfo(@RequestParam HashMap<String, Object> parameters, HttpServletRequest request) {
		String response = "";
		int result = 0;
		String ipv4 = IpUtil.getIpAddr(request) != null ? IpUtil.getIpAddr(request) : "";
		String cpu1 = parameters.get("cpu1") != null ?  parameters.get("cpu1").toString() : "";
		String cpu2 = parameters.get("cpu2") != null ?  parameters.get("cpu2").toString() : "";
		String cpu3 = parameters.get("cpu3") != null ?  parameters.get("cpu3").toString() : "";
		String cpu4 = parameters.get("cpu4") != null ?  parameters.get("cpu4").toString() : "";
		String fan1 = parameters.get("fan1") != null ?  parameters.get("fan1").toString() : "";
		String fan2 = parameters.get("fan2") != null ?  parameters.get("fan2").toString() : "";
		//check params
		if(StringUtils.isEmpty(cpu1)
				|| StringUtils.isEmpty(cpu2)
				|| StringUtils.isEmpty(cpu3)
				|| StringUtils.isEmpty(cpu4)
				|| StringUtils.isEmpty(fan1)
				|| StringUtils.isEmpty(fan2)
				|| StringUtils.isEmpty(ipv4) ) {
			response = "error:params must not null or empty!";
		}else {
			DellVostro220sDto dto = DellVostro220sDto.builder()
					.cpu1(cpu1)
					.cpu2(cpu2)
					.cpu3(cpu3)
					.cpu4(cpu4)
					.fan1(fan1)
					.fan2(fan2)
					.ipv4(ipv4)
					.build();
			result = dellVostroService.addServerHealthInfo(dto);
			if(result > 0) {
				response = "success!";
			}else {
				response = "failure!";
			}
		}
        return response;
    }

}
