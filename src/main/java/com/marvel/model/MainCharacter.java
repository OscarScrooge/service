package com.marvel.model;

public class MainCharacter {

	private int id;
	private int id_api;
	private String name;
	
	
	public MainCharacter(int id, int id_api, String name) {
		this.id = id;
		this.id_api = id_api;
		this.name = name;
	}
	
	public MainCharacter(int id_api, String name) {		
		this.id_api = id_api;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_api() {
		return id_api;
	}
	public void setId_api(int id_api) {
		this.id_api = id_api;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
