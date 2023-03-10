package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.EmpMapper;
import com.example.demo.vo.Movie;
import com.example.demo.vo.UsersVO;

//Service : 서비스에서 로직(알고리즘)을 구현한다.
//비즈니스 구역(로직)  //for문쓰고 while문쓰고 하는 역할.
@Service
public class ApiService {

	@Autowired
	EmpMapper empMapper;
		
	public boolean checkUser(String id) {
		
		UsersVO vo = new UsersVO();
		vo.setId(id);
		
		int rows = empMapper.selectUsersFindById(vo);
		if(rows > 0) {
			return true;
		}
		
		return false;
	}
	
	
	
	

	/**
	 * @Since : 2022. 11. 23.
	 * @Author : mr.Choi
	 * @Return : List<Movie>
	 * @Comment : 영화 만들기
	 */
	public List<Movie> makeMovies() {
		
		List<Movie> list = new ArrayList<Movie>();
		
		Movie movie = new Movie();
		movie.setTitle("Just Freinds");
		movie.setYear("2005");
		movie.setRuntime("96 min");
		movie.setGenre("Comedy, Romance");

		Movie movie2 = new Movie();
		movie2.setTitle("Minions: The Rise of Gru");
		movie2.setYear("2022");
		movie2.setRuntime("87 min");
		movie2.setGenre("애니메이션");

		Movie movie3 = new Movie();
		movie3.setTitle("장화신은 고양이: 끝내주는 모험");
		movie3.setYear("2022");
		movie3.setRuntime("89 min");
		movie3.setGenre("애니메이션");
		
		Movie movie4 = new Movie();
		movie4.setTitle("Minions: The Rise of Gru");
		movie4.setYear("2022");
		movie4.setRuntime("87 min");
		movie4.setGenre("애니메이션");
		
		Movie movie5 = new Movie();
		movie5.setTitle("장화신은 고양이: 끝내주는 모험");
		movie5.setYear("2022");
		movie5.setRuntime("89 min");
		movie5.setGenre("애니메이션");
		
		list.add(movie);
		list.add(movie2);
		list.add(movie3);
		list.add(movie4);
		list.add(movie5);
		
		return list;
	}
	
}
