package com.oromis;

import java.util.Stack;

/**
 * @author Domenico Antonio Tropeano on 23/01/2018 at 17:02
 * @project yaspl
 */
public class TestShit {
    public static void main( String[] args ){
        Stack<String> stack=new Stack();
        stack.push("ciao");
        stack.push("bellla");
        System.out.println(stack.firstElement());
    }
}
