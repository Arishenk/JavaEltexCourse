package com.arishenk;

public class TypeException extends Exception {

    private String someString;

    public TypeException(String string) {
        this.someString = string;
        System.out.println("Exception TypeException");
    }

    public void typeExceptionMsg() {
        System.err.println("This is exception message for string: " + someString);
    }

}
