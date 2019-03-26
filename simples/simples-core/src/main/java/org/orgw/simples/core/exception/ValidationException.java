package org.orgw.simples.core.exception;


public class ValidationException extends BaseException {
	public ValidationException(final String errorCode,final String errorMessage) {
		super(errorCode,errorMessage);		
	}
	
	public ValidationException(final SimplesConstant errorCode,final SimplesConstant errorMessage) {
		super(errorCode.getCode(),errorMessage.getCode());		
	}
	
	public ValidationException(final SimplesConstant errorMessage) {
		super(SimplesConstant.CODE_0.getCode(),errorMessage.getCode());		
	}
	
	public ValidationException(final String errorMessage) {
		super(SimplesConstant.CODE_0.getCode(),errorMessage);		
	}
}
