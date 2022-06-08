package com.min.proj.service;

import java.util.Map;

public interface ITopCategoryService {

	/**
	 * TopCategory(대분류) 작성하는 메소드 
	 * @param map projName 프로젝트 이름, topCode 코드번호, topContent  내용 3개의 키값으로 구성
	 * @return 1 성공
	 */
	public int newTopCategory(Map<String, String>map);
	
	/**
	 * 대분류를 수정하는 메소드
	 * @param map topCode 대분류 코드명,topName 대분류 이름,topId 대분류 고유번호
	 * @return 1 성공
	 */
	public int fixTopCategory(Map<String, String>map);
	
}
