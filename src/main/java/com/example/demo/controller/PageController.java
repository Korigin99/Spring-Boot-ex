package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

//Controller는 페이지 주소를 작성할 때 사용하는 어노테이션
@Controller
public class PageController {

	@GetMapping("/")
	public String callIndexPage() {
		// return에 html파일 이름을 작성
		return "index";
	}

	// 사용자(클라이언트)가 /home 주소를 입력하면
	// home이름을 가진 html을 return 한다는 걸 의미.
	@GetMapping("/home")
	public String callHomePage(HttpServletRequest request) {

		String ip = request.getRemoteAddr();
		System.out.println("요청받은 IP : " + ip);

		return "home";
	}

	@GetMapping("/96choi")
	public String callHomePage1() {
		return "choi";
	}

	@GetMapping("/movie")
	public String callMoviePage(HttpServletRequest request) {

		String ip = request.getRemoteAddr();
		System.out.println("요청받은 IP : " + ip);

		return "movie";
	}

	@GetMapping("/login")
	public String callLoginPage() {
		return "login";
	}

	@GetMapping("/login2")
	public String callLogin2Page() {
		return "login2";
	}
	
	@GetMapping("/login3")
	public String callLoginPage3() {
		return "login3";
	}

	@GetMapping("/emp")
	public String callempPage(HttpServletRequest request) {

		String ip = request.getRemoteAddr();
		System.out.println("요청받은 IP : " + ip);

		return "emp";
	}

	@GetMapping("/dept")
	public String calldeptPage(HttpServletRequest request) {

		String ip = request.getRemoteAddr();
		System.out.println("요청받은 IP : " + ip);

		return "dept";
	}
	
	@GetMapping("/users")
	public String callUsersPage(HttpServletRequest req, ModelMap map) {
		//ModelMap : HTML에 데이터를 전달함! (HTML에 데이터를 전달하는 방법은 크게 2가지)
		//1. AJAX를 이용한 데이터 처리
		//2. ModelMap을 활용한 데이터 처리
		//실무에서는 1번과 2번을 번갈아 가면서 쓰지만, 우리는 1번에 초점을 두고 공부해야 함.
		//2번은 쓰는 곳도 있고 안쓰는 곳도 있기 때문에
		HttpSession session = req.getSession(); // 세션 호출
		String name = (String) session.getAttribute("name");//세션에 저장한 데이터 호출 
		System.out.println("name ====> " + name);
		map.addAttribute("name", name);//사용자 이름 Map에 추가
		return "users";
	}
	
	
}
