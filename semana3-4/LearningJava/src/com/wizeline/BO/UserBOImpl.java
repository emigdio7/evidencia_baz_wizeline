package com.wizeline.BO;

import java.util.logging.Logger;

import com.wizeline.DAO.UserDAO;
import com.wizeline.DAO.UserDAOImpl;
import com.wizeline.DTO.ErrorDTO;
import com.wizeline.DTO.ResponseDTO;
import com.wizeline.utils.Utils;

public class UserBOImpl implements UserBO {

	
private static final Logger LOGGER = Logger.getLogger(UserBOImpl.class.getName());
	
	@Override
	public ResponseDTO createUser(String user, String password) {
		LOGGER.info("Inicia procesamiento en capa de negocio");
		ResponseDTO responseDTO;
		String result = "fail"; 
		if (Utils.validateNullValue(user) && Utils.validateNullValue(password)) {
			
			// UserDAO userDao = new UserDAOImpl();
			UserDAO userDao = UserDAOImpl.getInstance();//aplicando patron singleton
			
			
			result = userDao.createUser(user, password);
			
			//response.setCode("OK000");
			//response.setStatus(result);
			
			//aplicando patron builder
			 responseDTO = new ResponseDTO.ResponseDTOBuilder().code("OK000").status(result).build();	
		}else {
			//response.setCode("OK000");
			//response.setStatus(result);
			//response.setErrors(new ErrorDTO("ER001","Error al crear usuario"));
			
			//aplicando el patron builder
			 responseDTO = new ResponseDTO.ResponseDTOBuilder()
					.code("OK000")
					.errors(new ErrorDTO("ER001","Error al crear usuario"))
					.status(result)
					.build();	
			
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO login(String user, String password) {
		LOGGER.info("Inicia procesamiento en capa de negocio");
		
		String result = "";
		ResponseDTO responseDTO;
		if (Utils.validateNullValue(user) && Utils.validateNullValue(password)) {
			
			
	        // UserDAO userDao = new UserDAOImpl();
			UserDAO userDao = UserDAOImpl.getInstance();//aplicando patron singleton
				
			
			result = userDao.login(user, password);
		}
		if("success".equals(result)) {
			
			//response.setCode("OK000");
			//response.setStatus(result);
			
			//aplicando el patron builder
			 responseDTO = new ResponseDTO.ResponseDTOBuilder().code("OK000").status(result).build();			
		} else {
			
		//	response.setCode("ER001");
		//	response.setErrors(new ErrorDTO("ER001",result));
		//	response.setStatus("fail");
			
			//aplicando el patron builder
			 responseDTO = new ResponseDTO.ResponseDTOBuilder()
					.code("ER001")
					.errors(new ErrorDTO("ER001",result))
					.status("fail")
					.build();	
			
		}
		return responseDTO;
	}

	
}
