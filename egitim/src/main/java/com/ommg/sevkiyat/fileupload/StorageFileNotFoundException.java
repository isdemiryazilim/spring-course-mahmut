package com.ommg.sevkiyat.fileupload;

public class StorageFileNotFoundException extends StorageException {

	private static final long serialVersionUID = -4984546678202006081L;

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}