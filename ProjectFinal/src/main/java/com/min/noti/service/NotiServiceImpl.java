package com.min.noti.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.noti.mapper.INotiDao;
import com.min.noti.vo.NotiVo;
import com.min.noti.vo.MemListVo;



@Service
public class NotiServiceImpl implements INotiService {
	@Autowired
	private INotiDao dao;
	
	@Override
	public int notification_insert_privacy() {
		return dao.notification_insert_privacy();
	}

	@Override
	public int notification_insert_team() {
		return dao.notification_insert_team();
	}

	@Override
	public int notification_update(Map<String, Object> map) {
		return dao.notification_update(map);
	}

	@Override
	public List<NotiVo> notification_my_noti(Map<String, Object> map) {
		return dao.notification_my_noti(map);
	}

	@Override
	public List<NotiVo> notification_noti_confirm() {
		return dao.notification_noti_confirm();
	}

	@Override
	public int notification_delete(Map<String, Object> map) {
		return dao.notification_delete(map);
	}

	@Override
	public int notification_count(Map<String, Object> map) {
		return dao.notification_count(map);
	}

	@Override
	public MemListVo chatting_groupName(Map<String, Object> map) {
		return dao.chatting_groupName(map);
	}

	@Override
	public int notification_delete_All() {
		return dao.notification_delete_All();
	}
}
