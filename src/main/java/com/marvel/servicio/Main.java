package com.marvel.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		
		
		// TODO Auto-generated method stub
		 //Objeto de conexión a base de datos tipo Connection
		  Connection conn = null;
		  
		  //Objeto de propiedades donde vamos a cargar las propiedades del archivo
		  Properties props = new Properties();
		  
		  
		  //Resultset donde vamos a buscar el resultado que genera el query
		  ResultSet rs = null;
		  
		  //Input Stream donde leemos el recurso donde está el archivo de propiedades
		  InputStream is = Main.class.getClassLoader().getResourceAsStream("app.properties");
		  
		  //Objeto que utilizaremos para lanzar un query a la base de datos
		  PreparedStatement ps = null;
		  
		  //Cargamos las propiedades que vienene del archivo
		  props.load(is);
		  
		  //Cerramos el recurso
		  is.close();
		  
		  //Abrimos try para controlar cualquier excepción de SQL que ocurra
		  try {
		   
		   //Abrimos conexión a base de datos
		   conn = DriverManager.getConnection(props.getProperty("url"), props);
		   
		   //Armamos el prepared statement con el query a realizar
		   //ps = conn.prepareStatement("select * from student");
		   ps = conn.prepareStatement( "INSERT INTO marvel.character (id_api,name) VALUES (?,?) ON DUPLICATE KEY UPDATE id_api=?" );
		   ps.setInt(1,1009368);		   
		   ps.setString(2,"Iron Man");
		   ps.setInt(3,1009368);
		   
		 //Ejecutamos el query
		  ps.executeUpdate();
		   //Ejecutamos el query
		  // rs = ps.executeQuery();
		   * 
		   * 
		   * 
		   */
		     
		   //Obtenemos el resultado
		   /*if (rs.next()){
		    System.out.println(rs.getString("full_name").toString());
		   }*/
		
		
		/*
		   
		   //Si continuamos entonces estamos conectados de forma satisfactoria
		   System.out.println("Conectado a la Base de Datos");
		  
		  //Catch para atrapar alguna excepción de SQL
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  
		  //Bloque finally para cerrar la conexión
		  }finally{
		   if (conn!=null){
		   try {
		    conn.close();
		   } catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		   }
		  }*/
		
		System.out.println("starting service");

	}

}
