package com.riveiro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.User_model;

public class DBManager {
	
	static final String DBDriver = "com.mysql.jdbc.Driver";
	static final String DBUrl = "jdbc:mysql://localhost:3306/test?useLegacyDatetimeCode=false&serverTimezone=UTC";
	static final String DBUser= "root";
	static final String DBPass= "admin";
	
	
	static 
	{
		try 
		{
			Class.forName(DBDriver);
			
		}
		catch(ClassNotFoundException e)
		{
			
			System.exit(0);
			
		}
	}
	
	public static int NuevoUsuario(String nombre, String apellido, String email, String password) {
		
		int i=0;
		try {
			
			Connection conn = DriverManager.getConnection(DBUrl, DBUser, DBPass);
			
			String sql= "insert into user (nombre,apellido,email,password) values (?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, email);
			ps.setString(4, password);
			i = ps.executeUpdate();
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return i;
	}
	
	public static ArrayList<User_model> ObtenerUsuarios()
	{
		ArrayList<User_model> listUsuarios= new ArrayList<User_model>();
		int i=0;
		try 
		{
			
			Connection conn = DriverManager.getConnection(DBUrl, DBUser, DBPass);
			String sql= "select * from user";
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User_model usuario = new User_model();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setEmail(rs.getString(4));
				listUsuarios.add(usuario);
			}
			
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return listUsuarios;
		
	}
	
public static int ModificarUsuario(int id, String nombre, String apellido, String email, String password ) {
		
		int i=0;
		try {
			
			Connection conn = DriverManager.getConnection(DBUrl, DBUser, DBPass);
			
			String sql= "update user set nombre=?, apellido=?, email=?, password=? where id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(5,id);
			i = ps.executeUpdate();
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return i;
	}
public static int EliminarUsuario(int id ) {
	
	int i=0;
	try {
		
		Connection conn = DriverManager.getConnection(DBUrl, DBUser, DBPass);
		System.out.println("ENTROEliminar");
		String sql= "delete from user where id=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, id);
		i = ps.executeUpdate();
		
	}
	catch(SQLException e) {
		
		e.printStackTrace();
		
	}
	
	return i;
}

}
