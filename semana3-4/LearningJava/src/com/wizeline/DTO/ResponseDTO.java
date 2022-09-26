package com.wizeline.DTO;

public class ResponseDTO {
	
	private String status;
	private String code;
	
	private ErrorDTO errors = new ErrorDTO();
	
	
	private ResponseDTO(ResponseDTOBuilder builder){
		this.status = builder.status;
		this.code = builder.code;
		this.errors = builder.errors;
		
	}

    public String getStatus() {
        return status;
    }

   /// public void setStatus(String status) {
     //   this.status = status;
    //}

    public String getCode() {
        return code;
    }

  //  public void setCode(String code) {
    //    this.code = code;
   // }

    public ErrorDTO getErrors() {
        return errors;
    }

   // public void setErrors(ErrorDTO errors) {
    //    this.errors = errors;
   // }
    
    
    
    
    
    
    
    
    public static final class ResponseDTOBuilder {
    	
    	private String status;
    	private String code;
    	
    	private ErrorDTO errors = new ErrorDTO();
    	
    	
    public ResponseDTOBuilder() {}
    
    
    public ResponseDTOBuilder status(String status) {
    	this.status= status;
    	return this;
    }
    public ResponseDTOBuilder code(String code) {
    	this.code= code;
    	return this;
    }
    
    
    public ResponseDTOBuilder errors(ErrorDTO errorDTO) {
    	this.errors= errorDTO;
    	return this;
    }
    
    
    //devuelve el objeto ya contruido
    public ResponseDTO build() {
    	ResponseDTO responseDTO =  new ResponseDTO(this);
        validateUserObject(responseDTO);
        return responseDTO;
    }
    private void validateUserObject(ResponseDTO responseDTO) {
        //aplicar validaciones...
       
    }
    
    
    
    	
    	
    }
}


