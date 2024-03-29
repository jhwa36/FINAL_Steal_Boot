package com.steal.bs.model;

import java.util.List;

import com.steal.bs.dto.EmpDto;
import com.steal.bs.dto.MainDto;

public interface MainBiz {
	
	List<MainDto> selectList();
	MainDto selectOne(String id);
	int insert(MainDto dto);
	int update(MainDto dto);
	int delete(int seq);
	String loginidchk(String id);
	String signupempchk(String emp);
	String updatepwchk(String seq);
	String idsearch(MainDto dto);
	String pwsearch(MainDto dto);
	int empUpdate(MainDto dto);
	List<EmpDto> empList();
	int empInsert(EmpDto dto);
	int empDelete(int emp_no);
	int empNameUpdate(String name, String emp_no);
	
}
