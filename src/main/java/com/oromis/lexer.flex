package com.oromis;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;
import visitors.lexical.*;

%%

%class Lexer
%implements sym
%public
%unicode
%line
%column
%cup
%function next_token
%{

    private java.util.HashMap<String,EntryLexem> stringsTable=new java.util.HashMap<>();
    public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
		this(new InputStreamReader(is));
        symbolFactory = sf;
    }

    StringBuffer string = new StringBuffer();
    private ComplexSymbolFactory symbolFactory;

	public Symbol symbol(String name, int code){
		return symbolFactory.newSymbol(name, code,
						new Location(yyline+1,yycolumn+1 - yylength()),
						new Location(yyline+1,yycolumn+1)
				);

    }

    public Symbol symbol(String name, int code, Object value){
        Symbol s=symbolFactory.newSymbol(name, code,
                            new Location(yyline+1, yycolumn+1),
                            new Location(yyline+1, yycolumn+yylength()), value);

        if (stringsTable.containsKey(s.value.toString())) {
            stringsTable.get(s.value.toString()).addLocation(s);
        } else {
            stringsTable.put(s.value.toString(),new EntryLexem(s) );
        }

        return s;
	}
	public java.util.HashMap<String,EntryLexem> getStringsTable(){
	    return stringsTable;
	}
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }

    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" +
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }
%}

/*Regular definition for my language*/

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n] /*All except carriage return*/
WhiteSpace = {LineTerminator} | [ \t\f] /*White space can be a line terminator and must be ignored*/
DecLiteral = 0 | [1-9][0-9]* /*Decimal number is 0 or start with a number that not is zero followed by 0 or plus digits*/
DoubleLiteral = (0 | [1-9][0-9]*)\.[0-9]+
/*String literal*/
StringLiteral = [^\r\n\"\\]

/*Handle comments*/
Comment = {InlineComment} | {MultilineComment}
InlineComment = "#" {InputCharacter}* {LineTerminator}?
MultilineComment = "'''" {GoodStuffForComment}* {LineTerminator}? "'''"
GoodStuffForComment={InputCharacter}|{LineTerminator}

Identifier = [:jletter:] [:jletterdigit:]* /*identifier must start with a letter*/


%state STRING


%eofval{
    return symbolFactory.newSymbol("EOF",EOF);
%eofval}

/*%state CODESEG*/

%%

<YYINITIAL> {
	{Comment} { /*Ignore Comments*/}
  	{WhiteSpace} { /*Ignore Whitespaces*/ }
	"head" { return symbol("HEAD", sym.HEAD); }
	"start" { return symbol("START", sym.START); }
	"int" { return symbol("INT", sym.INT); }
	"bool" { return symbol("BOOL", sym.BOOL); }
	"double" { return symbol("DOUBLE", sym.DOUBLE); }
	"string" { return symbol("STRING", sym.STRING); }
	"def" { return symbol("DEF", sym.DEF); }
	"<-" { return symbol("READ", sym.READ); }
	"->" { return symbol("WRITE", sym.WRITE); }
	"true" { return symbol("TRUE", sym.TRUE); }
	"false" { return symbol("FALSE", sym.FALSE); }
	"=" { return symbol("ASSIGN", sym.ASSIGN); }
	"if" { return symbol("IF", sym.IF); }
	"then" { return symbol("THEN", sym.THEN); }
	"while" { return symbol("WHILE", sym.WHILE); }
	"do" { return symbol("DO", sym.DO); }
	"else" { return symbol("ELSE", sym.ELSE); }
	"(" { return symbol("LPAR", sym.LPAR); }
	")" { return symbol("RPAR", sym.RPAR); }
	":" { return symbol("COLON", sym.COLON); }
	"{" { return symbol("LGPAR", sym.LGPAR); }
	"}" { return symbol("RGPAR", sym.RGPAR); }
	"," { return symbol("COMMA", sym.COMMA); }
	";" { return symbol("SEMI", sym.SEMI); }
	"+" { return symbol("PLUS", sym.PLUS); }
	"-" { return symbol("MINUS", sym.MINUS); }
	"*" { return symbol("TIMES", sym.TIMES); }
	"/" { return symbol("DIV", sym.DIV); }
	">" { return symbol("GT", sym.GT); }
	">=" { return symbol("GE", sym.GE); }
	"<=" { return symbol("LE", sym.LE); }
	"<" { return symbol("LT", sym.LT); }
	"==" { return symbol("EQ", sym.EQ); }
	"not" { return symbol("NOT", sym.NOT); }
	"&&" { return symbol("PLUS", sym.PLUS); }
	"||" { return symbol("PLUS", sym.PLUS); }
	{Identifier} { return symbol("NAME",sym.NAME, yytext()); }
	{DecLiteral} { return symbol("INT_CONST", sym.INT_CONST, Integer.parseInt(yytext())); }
    {DoubleLiteral} { return symbol("DOUBLE_CONST",sym.DOUBLE_CONST, Double.parseDouble(yytext())); }

    /*When found " start state string*/
    \"   { yybegin(STRING);string.setLength(0);  }

}
/*Handle String state*/
 <STRING> {
      \"                             { yybegin(YYINITIAL);
                                       return symbol("STRING_CONST",sym.STRING_CONST,
                                       string.toString()); }
      [^\n\r\"\\]+                   { string.append( yytext() ); }
      \\t                            { string.append('\t'); }
      \\n                            { string.append('\n'); }

      \\r                            { string.append('\r'); }
      \\\"                           { string.append('\"'); }
      \\                             { string.append('\\'); }
    }


// error fallback
[^]|\n          { emit_warning("Unrecognized character '" +yytext()+"' -- ignored"); }
