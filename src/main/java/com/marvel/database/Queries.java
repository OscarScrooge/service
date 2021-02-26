package com.marvel.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.marvel.model.Character;
import com.marvel.model.Creator;
import com.marvel.model.MainCharacter;

public class Queries {

	static DBConnection conn = new DBConnection();
	static Connection c = null;

	
	/*
	 * Método para insertar al personaje principal en la BD
	 * Recibe como parámetro un objeto  MainCharacter
	 * */
	public static MainCharacter insertMainCharacter(MainCharacter character) {

		conn.setConnection();
		c = conn.getConnection();

		PreparedStatement ps;
		try {

			/*
			 * Se usa un store procedure para guardars los datos.
			 * Este procedimiento indicará si el personaje exite en la DB o no	
			 * y actualizará		 
			 * */
			ps = c.prepareStatement("{call insert_main_character(?,?)}");
			ps.setInt(1, character.getId_api());
			ps.setString(2, character.getName());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				character = new MainCharacter(Integer.parseInt(rs.getString("id")),
						Integer.parseInt(rs.getString("id_api")), rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return character;
	}

	
	/*
	 * Método para insertar una lista de colaboradores en la DB
	 * */
	public static void insertCreator(List<Creator> creators) {

		conn = new DBConnection();
		conn.setConnection();
		c = conn.getConnection();

		PreparedStatement ps;
		try {
			
			/*
			 * Se usa un store procedure para guardars los datos.
			 * Este procedimiento indicará si el colaborador exite en la DB o no
			 * y actualizará			 
			 * */
			ps = c.prepareStatement("{call insert_creator(?,?,?,?)}");
			
			for (Creator creator : creators) {

				ps.setString(1, creator.getName());
				ps.setString(2, creator.getRole());
				ps.setString(3, creator.getComic());
				ps.setInt(4, creator.getId_mainCharacter());
				ps.executeUpdate();

			}
			System.out.println("Success insertign creators");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		

	}
	
	/*
	 * Método para insertar una lista de otros personajes en la DB
	 * */
	public static void insertOtherCharacter(List<Character> characters) {

		conn = new DBConnection();
		conn.setConnection();

		c = conn.getConnection();

		PreparedStatement ps;
		try {
			
			/*
			 * Se usa un store procedure para guardars los datos.
			 * Este procedimiento indicará si el personaje exite en la DB o no			 
			 * */
			ps = c.prepareStatement("{call insert_other_character(?,?,?)}");

			for (Character character : characters) {
				ps.setString(1, character.getName());
				ps.setString(2, character.getComic());
				ps.setInt(3, character.getIdMainCharacter());
				ps.executeUpdate();
			}
			System.out.println("Success insertign other characters");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
