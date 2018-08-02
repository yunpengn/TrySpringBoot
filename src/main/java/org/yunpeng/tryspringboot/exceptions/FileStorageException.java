package org.yunpeng.tryspringboot.exceptions;

public class FileStorageException extends RuntimeException {
    public FileStorageException(String message, Exception e) {
        super(message, e);
    }
}
