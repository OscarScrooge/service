package com.marvel.database;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
	
	
	//Objeto de conexión a base de datos tipo Connection	
	Connection connection =null;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection() {
		  		
		  Properties props = new Properties();		 
		  
		  //Input Stream donde leemos el recurso donde está el archivo de propiedades
		  InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("app.properties");
		  
		  try {
			 props.load(is);			
			  is.close();
			  
			  Class.forName(props.getProperty("driver")); 
	      connection = DriverManager.getConnection(props.getProperty("url"), props);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		  
	}
	
	
	

}
