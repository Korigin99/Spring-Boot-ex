package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;

/*
 * RestControoler 와 Controller 차이점
 * 
 * Controller는 페이지(html) 이동
 * RestControoler는 데이터 (JSON) 전송
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.ApiService;
import com.example.demo.vo.DeptVO;
import com.example.demo.vo.EmpVo;
import com.example.demo.vo.Login;
import com.example.demo.vo.Login2;
import com.example.demo.vo.Movie;
import com.example.demo.vo.UsersVO;

/*
 * RestController와 Controller 차이점
 * 
 * Controller는 페이지(html)이동
 * RestController는 데이터(JSON) 전송
 * 
 * Controller는 사용자 요청(URL 요청)을 처리하는 Class
 * 
 */

// Rest : 자원 (== 데이터)
@RestController
public class ApiController {
	
	final String ROOT_URL  = "/api/v1";

	// ApiService apiService = new ApiService(); // 클래스를 전역변수로
	// @Autowired : Spring에서 객체를 관리함 (IoC : Inversion of Control 제어 역전)
	@Autowired
	ApiService apiService; // 자동으로 관리해줌.

	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	/*
	 * 클래스 이름 : 앞에 대문자로 시작 ex) Apple (o) apple (x) 변수 명 : 상수를 제외한 변수 이름은 소문자 :
	 * String name (o) String Name (x) 상수 : final double PI = 3.14 (o) fainal double
	 * pi = 3.14 (x) 함수이름 : 명사 (x) 동사 (o) ex) function makeData(o) function data(x)
	 */

	@GetMapping("/api/v1/sample")
	public List<String> callData() {
		List<String> list = new ArrayList<String>();
		list.add("삼겹살");
		list.add("오리고기;");
		list.add("목살");

		return list;
	}

	// Get : 조회
	// Mapping : URL 연결
	// v1 : 버전을 의미함 (version 1)
	@GetMapping("/api/v1/movie")
	public Movie callMovie() {

		Movie movie = new Movie();
		movie.setTitle("Just Freinds");
		movie.setYear("2005");
		movie.setRuntime("96 min");
		movie.setGenre("Comedy, Romance");
		// movie라는 객체를 전달함
		return movie;
	}

	// URL이름은 중복될 수 없다.
	@GetMapping("/api/v1/movies")
	public List<Movie> callMovies() {

		return apiService.makeMovies();
	}

	// ? -> 쿼리스트링
	// & -> 엔드연산자
	// URL을 이용해서 데이터를 받는 방법.
	// Path 길(주소 or 경로)로 데이터 받기!
	// Path(경로) + Variable (값)
	// 데이터가 1개 혹은 2개이면 Path로 함.
	@GetMapping("/api/v1/sports/qatar2022/article/{articleNumber}")
	public int callArticle(@PathVariable int articleNumber) {
		return articleNumber;
	}
	// /webtoon/list?titleId=758037&weekday=mon

	// ? 쿼리스트링으로 데이터 받기
	// /api/v1/webtoon/list?titleId=758037&weekday=mon
	// Request(요청) + Param (파라미터)
	// 데이터 보낼게 많으면 쿼리스트링
	@GetMapping("/api/v1/webtoon/list")
	public Map<String, Object> callwebtoon(@RequestParam int titleId, @RequestParam String weekday) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titleId", titleId);
		map.put("weekday", weekday);

		return map;
	}

	@GetMapping("/api/v1/webtoon/list/titleId/{titleId}/weekday/{weekday}")
	public Map<String, Object> callwebtoon2(@PathVariable int titleId, @PathVariable String weekday) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titleId", titleId);
		map.put("weekday", weekday);

		return map;
	}

	// Post: 데이터를 받아서 CREATE 할 때 많이씀.
	@PostMapping("/api/v1/join")
	public boolean callJoin(@RequestBody Login login) {
		System.out.println("HTML에서 서버로 받아온 데이터입니다.");
		System.out.println("아이디 : " + login.getId());
		System.out.println("이메일 : " + login.getEmail());
		System.out.println("비밀번호 : " + login.getPw());

		return true;
	}

	/*
	 * C(Create) R(Read) U(Update) D(Delete) Get : 데이터 조회 == select Post : 데이터 생성
	 * (전송) == insert Patch : 데이터 업데이트 == update Delete : 데이터 삭제 == delete
	 * - 수정, 삭제, 조회, 생성
	 * C(Create)R(Read)U(Update)D(Delete)
	 * 
	 */
	@PostMapping("/api/v1/join2")
	public boolean callJoin(@RequestBody Login2 login2, HttpServletRequest request) {

		String ip = request.getRemoteAddr();
		System.out.println("요청받은 IP : " + ip);

		System.out.println("HTML에서 서버로 받아온 데이터입니다.");
		System.out.println("회사 이름 : " + login2.getCompanyName());
		System.out.println("사용자 이름 : " + login2.getUserName());
		System.out.println("연락처 : " + login2.getPhone());

		return true;
	}

	@GetMapping("/api/v1/emp")
	public List<EmpVo> callEmp() {
		return empMapper.selectEmp();
	}

	@GetMapping("/api/v1/dept")
	public List<DeptVO> callDept() {
		return empMapper.selectDept();
	}

	@PostMapping("/api/v1/dept/newdept")
	public int calldeptjoin(@RequestBody DeptVO dept) {
		
		return empMapper.insertDEPT(dept);
	}
	
	@DeleteMapping("/api/v1/dept/{deptno}")
	public int calldeptDelete(@PathVariable int deptno) {
		return empMapper.deleteDept(deptno);
	}
	
	@PostMapping("/api/v1/emp/join")
	public int callEmpjoin(@RequestBody EmpVo emp) {
		
		return empMapper.insertEMP(emp);
	}
	
	@DeleteMapping("/api/v1/emp/{empno}")
	public int callEmpDelete(@PathVariable int empno) {
		return empMapper.deleteEmp(empno);
	}
	
	@PatchMapping("/api/v1/emp")
	public int callEmpUpdate(@RequestBody EmpVo emp) {
		return empMapper.updateEmp(emp);
	}
	//회원 가입
	@PostMapping("/api/v1/login3/join")
	public int callUsersjoin(@RequestBody UsersVO users) {
		String password = users.getPw();
		password = passwordEncoder.encode(password);
		
		users.setPw(password);
				
		return empMapper.insertUsers(users);
	}
	//로그인
	//세션 : 서버(자바 서블릿 컨테이너)에 임시적으로 데이터를 저장함
	@PostMapping("/api/v1/login")
	public UsersVO callUserLogin(@RequestBody UsersVO vo, HttpServletRequest req) {
		
		String password = vo.getPw();//HTML에 저장된 내 비밀번호 가져옴
		
		vo = empMapper.selectUsersPassword(vo);
		//아이디 틀리면 vo에 null 들어감.
		if(vo == null) {
			vo = new UsersVO();
			vo.setUser(false);
		}
		
		String DBpassword = vo.getPw();//데이터베이스에 저장된 내 비밀번호 가져옴
		
		boolean isUser = passwordEncoder.matches(password, DBpassword);
		
		if(!isUser) {
			vo.setUser(false);
			return vo;
		}
		// 고객정보 세션에 넣기
		HttpSession session = req.getSession(); //세션불러오기
		// 세션은 key와 value로 구성 (HashMap과 동일)
		// 세션은 서버가 종료될 때 까지 데이터가 유지됨(디폴트로 가지고 있는 시간은 30분)
		session.setAttribute("name", vo.getName()); //세션 사용자 이름 저장
		
		vo.setUser(true);
		return vo;
	}
	//관리자 페이지 (사용자 조회)
	@GetMapping("/api/v1/users")
	public List<UsersVO> callUsers() {
		return empMapper.selectUsers();
	}
	// 사용자 정보 삭제
	@DeleteMapping("/api/v1/users/{id}")
	public int callusersDelete(@PathVariable String id) {
		return empMapper.deleteUsers(id);
	}
	
	@GetMapping("/api/v1/users/{id}")
	public boolean callUser(@PathVariable String id) {
		
		return apiService.checkUser(id);
	}
}













