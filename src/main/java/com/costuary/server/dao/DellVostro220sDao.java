package com.costuary.server.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.costuary.server.dto.DellVostro220sDto;

/**
 *
 * @author Tim.Zhang
 *
 */
@Mapper
public interface DellVostro220sDao {

    /**
     * Add Server Health Info.
     * @param dellVostro220sDto
     * @return
     */
	@Insert("insert into Costuary.dell_vostro220s_info(CPU_CORE_1,CPU_CORE_2,CPU_CORE_3,CPU_CORE_4,CPU_FAN_RPM,MTB_FAN_RPM,IP4_ADDR) values(#{cpu1},#{cpu2},#{cpu3},#{cpu4},#{fan1},#{fan2},#{ipv4})")
    int addServerHealthInfo(DellVostro220sDto dellVostro220sDto);
}
