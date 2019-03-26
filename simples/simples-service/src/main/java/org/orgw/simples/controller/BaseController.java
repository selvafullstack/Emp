package org.orgw.simples.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.orgw.simples.core.exception.BaseException;
import org.orgw.simples.core.exception.SimplesConstant;
import org.orgw.simples.core.util.UtilHelper;
import org.orgw.simples.data.Response;


@Component
public abstract class BaseController{
    
	private final Logger log = Logger.getLogger(getClass());
	
	
	
	private Object request;
	
	private Object getRequest() {
		return avoidNull(request) ;
	}

	public void setRequest(Object request) {
		this.request = request;
	}

	protected abstract String getServiceCode();	

	
	@ExceptionHandler(BaseException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Response handleException(BaseException e) {
		log.debug("BaseController handleException BaseException : "+e.getLocalizedMessage(),e);
		Response failure = failure(e.getErrorCode(),e.getErrorMessage());
		return failure;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Response handleException(Exception e) {
		log.debug("BaseController handleException Exception"+e.getLocalizedMessage(),e);
		Response failure = failure(SimplesConstant.CODE_0.getCode(),SimplesConstant.TECH_ERROR.getCode());
		return failure;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleException(MethodArgumentNotValidException exception) {
		FieldError fieldError = exception.getBindingResult().getFieldError();
		Response failure = failure(SimplesConstant.CODE_0.getCode(),fieldError.getDefaultMessage());
		return failure;
    }

	protected Response response() {
		return new Response();
	}
	
	protected Response response(String message) {
		Response response = new Response();
		response.setMessage(message);
		
		return response;
	}
	
	protected Response response(String message,Object result) {
		Response response = new Response();
		response.setMessage(message);
		response.setResult(Arrays.asList(result));
		
		return response;
	}
	protected Response response(Object result) {
		Response response = new Response();
		response.setResult(Arrays.asList(result));
		return response;
	}
	
	protected Response response(String message,List result) {
		Response response = new Response();
		response.setMessage(message);
		response.setResult(result);
		return response;
	}
	
	protected Response response(List result) {
		Response response = new Response();
		
		response.setResult(result);
		return response;
	}

	protected Response failure(String code, String message) {
		Response response = new Response();
		response.setStatus(org.orgw.simples.data.ResponseStatus.FAILURE);
		response.setResult(new ArrayList());
		response.setResponsecode(code != null ? code : SimplesConstant.CODE_0.getCode());
		response.setMessage(message != null ? message: SimplesConstant.TECH_ERROR.getCode());
		return response;
	}	
	
	private  Object avoidNull(Object value) {
		return value==null ? "" : value;
	}

}
