package com.example.demo.vo;

//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
public class Movie {
	
	private String Title;
	private String Year;
	private String Runtime;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	private String Genre;
	
}