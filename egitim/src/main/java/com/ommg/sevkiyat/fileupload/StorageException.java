package com.ommg.sevkiyat.fileupload;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = 658728069366500647L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
