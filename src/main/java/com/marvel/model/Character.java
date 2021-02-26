package com.marvel.model;

public class Character {
	
	private int id;
	private String name;
	private String comic;
	private int idMainCharacter;
				
	public Character(String name, String comic, int idMainCharacter) {
		this.name = name;
		this.comic = comic;
		this.idMainCharacter = idMainCharacter;
	}
		
	public int getIdMainCharacter() {
		return idMainCharacter;
	}

	public void setIdMainCharacter(int idMainCharacter) {
		this.idMainCharacter = idMainCharacter;
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
	public String getComic() {
		return comic;
	}
	public void setComic(String comic) {
		this.comic = comic;
	}
	
	
	
	

}
