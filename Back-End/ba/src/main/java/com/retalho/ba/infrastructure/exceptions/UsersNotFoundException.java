package com.retalho.ba.infrastructure.exceptions;

import java.io.Serial;

public class UsersNotFoundException extends Exception{

    @Serial
    private static final long serialVersionUID = 1149241039409861914L;

    public UsersNotFoundException(String message){
        super(message);
    }

    public UsersNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
