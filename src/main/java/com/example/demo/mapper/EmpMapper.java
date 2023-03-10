package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVo;
import com.example.demo.vo.UsersVO;

/*
 * 추상클래스와 인터페이스 차이점.
 * 인터페이스 : 메소드 정의
 * 추상클래스 : 정의, 구현 가능 
 */


@Mapper
public interface EmpMapper {
	
	/**
	 * @Since : 2022. 11. 28.
	 * @Author : mr.Choi
	 * @Return : List<EmpVo>
	 * @Comment : EMP 테이블 전체 조회
	 */
	// art + shift + J
	List<EmpVo> selectEmp(); //메소드 정의
	
	/**
	 * @Since : 2022. 11. 29.
	 * @Author : mr.Choi
	 * @Return : List<DeptVO>
	 * @Comment : 사원 추가
	 */
	List<DeptVO> selectDept();

	int insertEMP(EmpVo vo);
	
	
	
	/**
	 * @Since : 2022. 12. 1.
	 * @Author : mr.Choi
	 * @Return : int
	 * @Comment : 사원 삭제
	 */
	int deleteEmp(int empno);
	

	int insertDEPT(DeptVO dept);
	
	/**
	 * @Since : 2022. 12. 1.
	 * @Author : mr.Choi
	 * @Return : int
	 * @Comment : 부서 폐지
	 */
	int deleteDept(int deptno);
	
	/**
	 * @Since : 2022. 12. 1.
	 * @Author : mr.Choi
	 * @Return : int
	 * @Comment : 사원 정보 수정
	 */
	int updateEmp(EmpVo vo);
	
	
	/**
	 * @Since : 2022. 12. 2.
	 * @Author : mr.Choi
	 * @Return : int
	 * @Comment : 회원 가입
	 */
	int insertUsers(UsersVO vo);
	
	/**
	 * @Since : 2022. 12. 2.
	 * @Author : mr.Choi
	 * @Return : List<UsersVO>
	 * @Comment : 유저 추가
	 */
	List<UsersVO> selectusers();

	int insertEMP(UsersVO vo);
	
	/**
	 * @Since : 2022. 12. 2.
	 * @Author : mr.Choi
	 * @Return : int
	 * @Comment : 회원인지 아닌지 체크
	 */
	int selectUsersFindById(UsersVO vo);
	
	/**
	 * @Since : 2022. 12. 2.
	 * @Author : mr.Choi
	 * @Return : List<UsersVO>
	 * @Comment : 사용자 전체 조회 페이지
	 */
	List<UsersVO> selectUsers();
	
	int deleteUsers(String id);
	
	/**
	 * @Since : 2022. 12. 6.
	 * @Author : mr.Choi
	 * @Return : UsersVO
	 * @Comment : 회원인지 아닌지 체크(암호화 추가된 체크방법)
	 */
	UsersVO selectUsersPassword(UsersVO vo);
	
	
	
}
