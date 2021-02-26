package com.marvel.model;

public class Creator {

	private int id;
	private String name;
	private String role;
	private String comic;
	private int id_mainCharacter;
	
	
	public Creator(String name, String role, String comic, int id_mainCharacter) {
		this.name = name;
		this.role = role;
		this.comic = comic;
		this.id_mainCharacter = id_mainCharacter;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getComic() {
		return comic;
	}


	public void setComic(String comic) {
		this.comic = comic;
	}


	public int getId_mainCharacter() {
		return id_mainCharacter;
	}


	public void setId_mainCharacter(int id_mainCharacter) {
		this.id_mainCharacter = id_mainCharacter;
	}
	
	
	
			
	
	
	
}
