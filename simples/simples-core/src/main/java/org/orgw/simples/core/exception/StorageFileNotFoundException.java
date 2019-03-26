package org.orgw.simples.core.exception;

public class StorageFileNotFoundException extends BaseException {
	public StorageFileNotFoundException() {
		super();
	}
	public StorageFileNotFoundException(final String errorCode,final String errorMessage ) {
		super(errorCode,errorMessage);
	}
	public StorageFileNotFoundException(final String errorCode,final String errorMessage,Throwable throwable ) {
		super(errorCode,errorMessage,throwable);
	}
	public StorageFileNotFoundException(Throwable throwable ) {
		super(throwable);
	}
	public StorageFileNotFoundException(final String errorMessage,Throwable throwable ) {
		super(errorMessage,throwable);
	}
}
