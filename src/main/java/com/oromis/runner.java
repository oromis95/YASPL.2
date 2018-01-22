package com.oromis;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Domenico Antonio Tropeano on 22/01/2018 at 14:46
 * @project yaspl
 */
public class runner {
    public static void main( String[] args ) throws Exception {
        /*ComplexSymbolFactory cf = new ComplexSymbolFactory();
        FileInputStream fis = new FileInputStream(new File(App.class.getResource("/prova.yasp").getPath()));
        Parser parser = new Parser(new Lexer(cf, fis), cf);
        parser.parse();*/
        ComplexSymbolFactory cf = new ComplexSymbolFactory();
        FileInputStream fis = new FileInputStream(new File(runner.class.getResource("/input.txt").getPath()));
        Lexer l = new Lexer(cf, fis);
        while(true){
            Symbol symbol = l.next_token();
            if(symbol.sym == sym.EOF)
                break;
        }
        l.getStringsTable().entrySet().forEach(e -> System.out.println(String.format("Chiave:%s/Valore:%s", e.getKey(), e.getValue())));
    }
}
