package com.tabletale.rpgwiki.services.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg) {
        super(msg);
    }

}
