package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVo;

@Mapper
public interface DeptMapper {

		/**
		 * @Since : 2022. 12. 1.
		 * @Author : mr.Choi
		 * @Return : List<DeptVO>
		 * @Comment : dept 테이블 전체 조회
		 */
		List<DeptVO> selectDept();
		
		/**
		 * @Since : 2022. 12. 1.
		 * @Author : mr.Choi
		 * @Return : List<EmpVo>
		 * @Comment : 부서 신설
		 */
		List<EmpVo> selectEmp();

		int insertEMP(DeptVO vo);
		
		
		/**
		 * @Since : 2022. 12. 1.
		 * @Author : mr.Choi
		 * @Return : int
		 * @Comment : 부서 폐지
		 */
		int deleteEmp(int deptno);
		
}
