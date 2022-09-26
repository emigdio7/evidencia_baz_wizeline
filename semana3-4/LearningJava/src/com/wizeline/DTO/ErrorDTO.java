package com.wizeline.DTO;

public class ErrorDTO {

	String errorCode;
	String mensaje;
	
	
	public ErrorDTO() {
		super();
	}
	
	public ErrorDTO(String errorCode, String mensaje) {
		super();
		this.errorCode = errorCode;
		this.mensaje = mensaje;
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
}
