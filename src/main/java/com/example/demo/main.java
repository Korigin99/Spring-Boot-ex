package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class main {

	@GetMapping("/hello")
	public String callHomepage() {
		return "hello World~!";
	}
}

// @ -> Annatation이라고 함 (Spring에서 자주 나옴)
// 컴파일 : 개발자 -> 코딩(소스) .java -> 컴파일러 -> Class                --> JAVA(엔진 JVM) [런파일]
//		  이 과정을 컴파일 타임(환경) 이라고 한다. 읽을 수 있게 준비하는 과정