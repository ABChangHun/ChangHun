package com.min.sche.mapper;

import java.util.List;
import java.util.Map;

import com.min.sche.vo.WbsViewVo;


public interface IScheduleDao {

	public List<WbsViewVo> getTeamSchedule(List<String> userList);
	
	public int pScheduleInsert(Map<String, Object> map);
	public int pScheduleUpdate(Map<String, Object> map);
	public int pScheduleDelete(Map<String, Object> map);
	
}
