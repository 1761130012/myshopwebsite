package com.example.exceptions;

/**
 * 字符 不是 字母 越界 异常
 */
public class CharacterNotLetterBoundsException extends Exception {

    public CharacterNotLetterBoundsException() {
        super("字符必须是字母");
    }

    public CharacterNotLetterBoundsException(String message) {
        super(message);
    }
}
