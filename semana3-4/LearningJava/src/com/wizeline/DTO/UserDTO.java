package com.wizeline.DTO;

import java.util.Map;

public class UserDTO {

	
	private String usuario;
	private String password;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserDTO getParameters(Map<String, String> parameters) {
		
		UserDTO usr = new UserDTO();
		
		usr.setUsuario(parameters.get("user"));
		usr.setPassword(parameters.get("password"));
		
		return usr;
		
	}
	
	
}
