/* The following code was generated by JFlex 1.6.1 */

package com.oromis;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>D:/Workspaces/GitRepo/YASPL.2/src/main/java/com/oromis/lexer.flex</tt>
 */
public class Lexer implements sym, java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\13\1\3\1\2\1\0\1\3\1\1\16\13\4\0\1\3\1\0"+
    "\1\54\1\10\1\12\1\0\1\52\1\11\1\40\1\41\1\50\1\47"+
    "\1\45\1\34\1\6\1\51\1\4\11\5\1\42\1\46\1\33\1\36"+
    "\1\35\2\0\32\12\1\0\1\7\2\0\1\12\1\0\1\16\1\25"+
    "\1\12\1\17\1\15\1\32\1\31\1\14\1\23\2\12\1\27\1\12"+
    "\1\24\1\26\2\12\1\22\1\20\1\21\1\30\1\12\1\37\3\12"+
    "\1\43\1\53\1\44\1\0\41\13\2\0\4\12\4\0\1\12\2\0"+
    "\1\13\7\0\1\12\4\0\1\12\5\0\27\12\1\0\37\12\1\0"+
    "\u01ca\12\4\0\14\12\16\0\5\12\7\0\1\12\1\0\1\12\21\0"+
    "\160\13\5\12\1\0\2\12\2\0\4\12\1\0\1\12\6\0\1\12"+
    "\1\0\3\12\1\0\1\12\1\0\24\12\1\0\123\12\1\0\213\12"+
    "\1\0\5\13\2\0\246\12\1\0\46\12\2\0\1\12\7\0\47\12"+
    "\7\0\1\12\1\0\55\13\1\0\1\13\1\0\2\13\1\0\2\13"+
    "\1\0\1\13\10\0\33\12\5\0\3\12\15\0\6\13\5\0\1\12"+
    "\4\0\13\13\1\0\1\13\3\0\53\12\37\13\4\0\2\12\1\13"+
    "\143\12\1\0\1\12\10\13\1\0\6\13\2\12\2\13\1\0\4\13"+
    "\2\12\12\13\3\12\2\0\1\12\17\0\1\13\1\12\1\13\36\12"+
    "\33\13\2\0\131\12\13\13\1\12\16\0\12\13\41\12\11\13\2\12"+
    "\4\0\1\12\5\0\26\12\4\13\1\12\11\13\1\12\3\13\1\12"+
    "\5\13\22\0\31\12\3\13\104\0\25\12\56\0\41\13\66\12\3\13"+
    "\1\12\22\13\1\12\7\13\12\12\2\13\2\0\12\13\1\0\20\12"+
    "\3\13\1\0\10\12\2\0\2\12\2\0\26\12\1\0\7\12\1\0"+
    "\1\12\3\0\4\12\2\0\1\13\1\12\7\13\2\0\2\13\2\0"+
    "\3\13\1\12\10\0\1\13\4\0\2\12\1\0\3\12\2\13\2\0"+
    "\12\13\4\12\7\0\1\12\5\0\3\13\1\0\6\12\4\0\2\12"+
    "\2\0\26\12\1\0\7\12\1\0\2\12\1\0\2\12\1\0\2\12"+
    "\2\0\1\13\1\0\5\13\4\0\2\13\2\0\3\13\3\0\1\13"+
    "\7\0\4\12\1\0\1\12\7\0\14\13\3\12\1\13\13\0\3\13"+
    "\1\0\11\12\1\0\3\12\1\0\26\12\1\0\7\12\1\0\2\12"+
    "\1\0\5\12\2\0\1\13\1\12\10\13\1\0\3\13\1\0\3\13"+
    "\2\0\1\12\17\0\2\12\2\13\2\0\12\13\1\0\1\12\7\0"+
    "\1\12\7\0\3\13\1\0\10\12\2\0\2\12\2\0\26\12\1\0"+
    "\7\12\1\0\2\12\1\0\5\12\2\0\1\13\1\12\7\13\2\0"+
    "\2\13\2\0\3\13\10\0\2\13\4\0\2\12\1\0\3\12\2\13"+
    "\2\0\12\13\1\0\1\12\20\0\1\13\1\12\1\0\6\12\3\0"+
    "\3\12\1\0\4\12\3\0\2\12\1\0\1\12\1\0\2\12\3\0"+
    "\2\12\3\0\3\12\3\0\14\12\4\0\5\13\3\0\3\13\1\0"+
    "\4\13\2\0\1\12\6\0\1\13\16\0\12\13\11\0\1\12\6\0"+
    "\4\13\1\0\10\12\1\0\3\12\1\0\27\12\1\0\20\12\3\0"+
    "\1\12\7\13\1\0\3\13\1\0\4\13\7\0\2\13\1\0\3\12"+
    "\5\0\2\12\2\13\2\0\12\13\21\0\3\13\1\0\10\12\1\0"+
    "\3\12\1\0\27\12\1\0\12\12\1\0\5\12\2\0\1\13\1\12"+
    "\7\13\1\0\3\13\1\0\4\13\7\0\2\13\7\0\1\12\1\0"+
    "\2\12\2\13\2\0\12\13\1\0\2\12\16\0\3\13\1\0\10\12"+
    "\1\0\3\12\1\0\51\12\2\0\1\12\7\13\1\0\3\13\1\0"+
    "\4\13\1\12\10\0\1\13\7\0\3\12\2\13\2\0\12\13\12\0"+
    "\6\12\2\0\2\13\1\0\22\12\3\0\30\12\1\0\11\12\1\0"+
    "\1\12\2\0\7\12\3\0\1\13\4\0\6\13\1\0\1\13\1\0"+
    "\10\13\6\0\12\13\2\0\2\13\15\0\60\12\1\13\2\12\7\13"+
    "\4\0\10\12\10\13\1\0\12\13\47\0\2\12\1\0\1\12\2\0"+
    "\2\12\1\0\1\12\2\0\1\12\6\0\4\12\1\0\7\12\1\0"+
    "\3\12\1\0\1\12\1\0\1\12\2\0\2\12\1\0\4\12\1\13"+
    "\2\12\6\13\1\0\2\13\1\12\2\0\5\12\1\0\1\12\1\0"+
    "\6\13\2\0\12\13\2\0\4\12\40\0\1\12\27\0\2\13\6\0"+
    "\12\13\13\0\1\13\1\0\1\13\1\0\1\13\4\0\2\13\10\12"+
    "\1\0\44\12\4\0\24\13\1\0\2\13\5\12\13\13\1\0\44\13"+
    "\11\0\1\13\71\0\53\12\24\13\1\12\12\13\6\0\6\12\4\13"+
    "\4\12\3\13\1\12\3\13\2\12\7\13\3\12\4\13\15\12\14\13"+
    "\1\12\17\13\2\0\46\12\1\0\1\12\5\0\1\12\2\0\53\12"+
    "\1\0\u014d\12\1\0\4\12\2\0\7\12\1\0\1\12\1\0\4\12"+
    "\2\0\51\12\1\0\4\12\2\0\41\12\1\0\4\12\2\0\7\12"+
    "\1\0\1\12\1\0\4\12\2\0\17\12\1\0\71\12\1\0\4\12"+
    "\2\0\103\12\2\0\3\13\40\0\20\12\20\0\126\12\2\0\6\12"+
    "\3\0\u026c\12\2\0\21\12\1\0\32\12\5\0\113\12\3\0\13\12"+
    "\7\0\15\12\1\0\4\12\3\13\13\0\22\12\3\13\13\0\22\12"+
    "\2\13\14\0\15\12\1\0\3\12\1\0\2\13\14\0\64\12\40\13"+
    "\3\0\1\12\3\0\2\12\1\13\2\0\12\13\41\0\4\13\1\0"+
    "\12\13\6\0\130\12\10\0\51\12\1\13\1\12\5\0\106\12\12\0"+
    "\37\12\1\0\14\13\4\0\14\13\12\0\12\13\36\12\2\0\5\12"+
    "\13\0\54\12\4\0\32\12\6\0\12\13\46\0\27\12\5\13\4\0"+
    "\65\12\12\13\1\0\35\13\2\0\13\13\6\0\12\13\15\0\1\12"+
    "\10\0\16\13\102\0\5\13\57\12\21\13\7\12\4\0\12\13\21\0"+
    "\11\13\14\0\3\13\36\12\15\13\2\12\12\13\54\12\16\13\14\0"+
    "\44\12\24\13\10\0\12\13\3\0\3\12\12\13\44\12\122\0\3\13"+
    "\1\0\25\13\4\12\1\13\4\12\3\13\2\12\1\0\2\13\6\0"+
    "\300\12\66\13\6\0\4\13\u0116\12\2\0\6\12\2\0\46\12\2\0"+
    "\6\12\2\0\10\12\1\0\1\12\1\0\1\12\1\0\1\12\1\0"+
    "\37\12\2\0\65\12\1\0\7\12\1\0\1\12\3\0\3\12\1\0"+
    "\7\12\3\0\4\12\2\0\6\12\4\0\15\12\5\0\3\12\1\0"+
    "\7\12\16\0\5\13\32\0\5\13\20\0\2\12\23\0\1\12\13\0"+
    "\5\13\1\0\12\13\1\0\1\12\15\0\1\12\20\0\15\12\3\0"+
    "\37\12\21\0\15\13\4\0\1\13\3\0\14\13\21\0\1\12\4\0"+
    "\1\12\2\0\12\12\1\0\1\12\3\0\5\12\6\0\1\12\1\0"+
    "\1\12\1\0\1\12\1\0\4\12\1\0\13\12\2\0\4\12\5\0"+
    "\5\12\4\0\1\12\21\0\51\12\u0a77\0\57\12\1\0\57\12\1\0"+
    "\205\12\6\0\4\12\3\13\2\12\14\0\46\12\1\0\1\12\5\0"+
    "\1\12\2\0\70\12\7\0\1\12\17\0\1\13\27\12\11\0\7\12"+
    "\1\0\7\12\1\0\7\12\1\0\7\12\1\0\7\12\1\0\7\12"+
    "\1\0\7\12\1\0\7\12\1\0\40\13\57\0\1\12\u01d5\0\3\12"+
    "\31\0\11\12\6\13\1\0\5\12\2\0\5\12\4\0\126\12\2\0"+
    "\2\13\2\0\3\12\1\0\132\12\1\0\4\12\5\0\51\12\3\0"+
    "\136\12\21\0\33\12\65\0\20\12\u0200\0\u19b6\12\112\0\u51d6\12\52\0"+
    "\u048d\12\103\0\56\12\2\0\u010d\12\3\0\20\12\12\13\2\12\24\0"+
    "\57\12\1\13\4\0\12\13\1\0\37\12\2\13\120\12\2\13\45\0"+
    "\11\12\2\0\147\12\2\0\43\12\2\0\10\12\77\0\13\12\1\13"+
    "\3\12\1\13\4\12\1\13\27\12\5\13\20\0\1\12\7\0\64\12"+
    "\14\0\2\13\62\12\21\13\13\0\12\13\6\0\22\13\6\12\3\0"+
    "\1\12\1\0\1\12\2\0\12\13\34\12\10\13\2\0\27\12\15\13"+
    "\14\0\35\12\3\0\4\13\57\12\16\13\16\0\1\12\12\13\6\0"+
    "\5\12\1\13\12\12\12\13\5\12\1\0\51\12\16\13\11\0\3\12"+
    "\1\13\10\12\2\13\2\0\12\13\6\0\27\12\3\0\1\12\3\13"+
    "\62\12\1\13\1\12\3\13\2\12\2\13\5\12\2\13\1\12\1\13"+
    "\1\12\30\0\3\12\2\0\13\12\5\13\2\0\3\12\2\13\12\0"+
    "\6\12\2\0\6\12\2\0\6\12\11\0\7\12\1\0\7\12\1\0"+
    "\53\12\1\0\12\12\12\0\163\12\10\13\1\0\2\13\2\0\12\13"+
    "\6\0\u2ba4\12\14\0\27\12\4\0\61\12\u2104\0\u016e\12\2\0\152\12"+
    "\46\0\7\12\14\0\5\12\5\0\1\12\1\13\12\12\1\0\15\12"+
    "\1\0\5\12\1\0\1\12\1\0\2\12\1\0\2\12\1\0\154\12"+
    "\41\0\u016b\12\22\0\100\12\2\0\66\12\50\0\15\12\3\0\20\13"+
    "\20\0\20\13\3\0\2\12\30\0\3\12\31\0\1\12\6\0\5\12"+
    "\1\0\207\12\2\0\1\13\4\0\1\12\13\0\12\13\7\0\32\12"+
    "\4\0\1\12\1\0\32\12\13\0\131\12\3\0\6\12\2\0\6\12"+
    "\2\0\6\12\2\0\3\12\3\0\2\12\3\0\2\12\22\0\3\13"+
    "\4\0\14\12\1\0\32\12\1\0\23\12\1\0\2\12\1\0\17\12"+
    "\2\0\16\12\42\0\173\12\105\0\65\12\210\0\1\13\202\0\35\12"+
    "\3\0\61\12\17\0\1\13\37\0\40\12\20\0\33\12\5\0\46\12"+
    "\5\13\5\0\36\12\2\0\44\12\4\0\10\12\1\0\5\12\52\0"+
    "\236\12\2\0\12\13\126\0\50\12\10\0\64\12\234\0\u0137\12\11\0"+
    "\26\12\12\0\10\12\230\0\6\12\2\0\1\12\1\0\54\12\1\0"+
    "\2\12\3\0\1\12\2\0\27\12\12\0\27\12\11\0\37\12\101\0"+
    "\23\12\1\0\2\12\12\0\26\12\12\0\32\12\106\0\70\12\6\0"+
    "\2\12\100\0\1\12\3\13\1\0\2\13\5\0\4\13\4\12\1\0"+
    "\3\12\1\0\33\12\4\0\3\13\4\0\1\13\40\0\35\12\3\0"+
    "\35\12\43\0\10\12\1\0\34\12\2\13\31\0\66\12\12\0\26\12"+
    "\12\0\23\12\15\0\22\12\156\0\111\12\67\0\63\12\15\0\63\12"+
    "\u030d\0\3\13\65\12\17\13\37\0\12\13\17\0\4\13\55\12\13\13"+
    "\2\0\1\13\22\0\31\12\7\0\12\13\6\0\3\13\44\12\16\13"+
    "\1\0\12\13\20\0\43\12\1\13\2\0\1\12\11\0\3\13\60\12"+
    "\16\13\4\12\5\0\3\13\3\0\12\13\1\12\1\0\1\12\43\0"+
    "\22\12\1\0\31\12\14\13\110\0\7\12\1\0\1\12\1\0\4\12"+
    "\1\0\17\12\1\0\12\12\7\0\57\12\14\13\5\0\12\13\6\0"+
    "\4\13\1\0\10\12\2\0\2\12\2\0\26\12\1\0\7\12\1\0"+
    "\2\12\1\0\5\12\2\0\1\13\1\12\7\13\2\0\2\13\2\0"+
    "\3\13\2\0\1\12\6\0\1\13\5\0\5\12\2\13\2\0\7\13"+
    "\3\0\5\13\u010b\0\60\12\24\13\2\12\1\0\1\12\10\0\12\13"+
    "\246\0\57\12\7\13\2\0\11\13\27\0\4\12\2\13\42\0\60\12"+
    "\21\13\3\0\1\12\13\0\12\13\46\0\53\12\15\13\10\0\12\13"+
    "\66\0\32\12\3\0\17\13\4\0\12\13\u0166\0\100\12\12\13\25\0"+
    "\1\12\u01c0\0\71\12\u0507\0\u039a\12\146\0\157\12\21\0\304\12\u0abc\0"+
    "\u042f\12\u0fd1\0\u0247\12\u21b9\0\u0239\12\7\0\37\12\1\0\12\13\146\0"+
    "\36\12\2\0\5\13\13\0\60\12\7\13\11\0\4\12\14\0\12\13"+
    "\11\0\25\12\5\0\23\12\u0370\0\105\12\13\0\1\12\56\13\20\0"+
    "\4\13\15\12\u4060\0\2\12\u0bfe\0\153\12\5\0\15\12\3\0\11\12"+
    "\7\0\12\12\3\0\2\13\1\0\4\13\u14c1\0\5\13\3\0\26\13"+
    "\2\0\7\13\36\0\4\13\224\0\3\13\u01bb\0\125\12\1\0\107\12"+
    "\1\0\2\12\2\0\1\12\2\0\2\12\2\0\4\12\1\0\14\12"+
    "\1\0\1\12\1\0\7\12\1\0\101\12\1\0\4\12\2\0\10\12"+
    "\1\0\7\12\1\0\34\12\1\0\4\12\1\0\5\12\1\0\1\12"+
    "\3\0\7\12\1\0\u0154\12\2\0\31\12\1\0\31\12\1\0\37\12"+
    "\1\0\31\12\1\0\37\12\1\0\31\12\1\0\37\12\1\0\31\12"+
    "\1\0\37\12\1\0\31\12\1\0\10\12\2\0\62\13\u0200\0\67\13"+
    "\4\0\62\13\10\0\1\13\16\0\1\13\26\0\5\13\1\0\17\13"+
    "\u0d50\0\305\12\13\0\7\13\u0529\0\4\12\1\0\33\12\1\0\2\12"+
    "\1\0\1\12\2\0\1\12\1\0\12\12\1\0\4\12\1\0\1\12"+
    "\1\0\1\12\6\0\1\12\4\0\1\12\1\0\1\12\1\0\1\12"+
    "\1\0\3\12\1\0\2\12\1\0\1\12\2\0\1\12\1\0\1\12"+
    "\1\0\1\12\1\0\1\12\1\0\1\12\1\0\2\12\1\0\1\12"+
    "\2\0\4\12\1\0\7\12\1\0\4\12\1\0\4\12\1\0\1\12"+
    "\1\0\12\12\1\0\21\12\5\0\3\12\1\0\5\12\1\0\21\12"+
    "\u1144\0\ua6d7\12\51\0\u1035\12\13\0\336\12\2\0\u1682\12\u295e\0\u021e\12"+
    "\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05ee\0"+
    "\1\13\36\0\140\13\200\0\360\13\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\2\3\1\4\1\1\12\5\1\6"+
    "\1\7\1\10\1\11\1\5\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\2\1\1\24"+
    "\1\25\1\26\1\27\1\0\2\4\1\0\3\5\1\30"+
    "\4\5\1\31\3\5\1\32\1\33\1\34\1\35\1\36"+
    "\1\5\1\37\1\40\1\41\1\42\1\43\1\0\2\5"+
    "\1\44\5\5\1\45\1\46\3\5\1\0\1\47\1\50"+
    "\3\5\1\51\1\52\1\53\2\5\1\0\1\5\1\54"+
    "\1\5\1\55\1\56\1\4\1\57\1\60";

  private static int [] zzUnpackAction() {
    int [] result = new int[101];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\55\0\132\0\207\0\132\0\264\0\341\0\u010e"+
    "\0\u013b\0\u0168\0\u0195\0\u01c2\0\u01ef\0\u021c\0\u0249\0\u0276"+
    "\0\u02a3\0\u02d0\0\u02fd\0\u032a\0\u0357\0\u0384\0\u03b1\0\u03de"+
    "\0\132\0\132\0\132\0\132\0\132\0\132\0\132\0\132"+
    "\0\132\0\132\0\u040b\0\u0438\0\132\0\u0465\0\u0492\0\132"+
    "\0\u04bf\0\u04ec\0\132\0\u0519\0\u0546\0\u0573\0\u05a0\0\u05cd"+
    "\0\u05fa\0\u0627\0\u0654\0\u0681\0\u0168\0\u06ae\0\u06db\0\u0708"+
    "\0\132\0\132\0\132\0\132\0\132\0\u0735\0\132\0\132"+
    "\0\132\0\132\0\u04bf\0\u0762\0\u078f\0\u07bc\0\u0168\0\u07e9"+
    "\0\u0816\0\u0843\0\u0870\0\u089d\0\u0168\0\u0168\0\u08ca\0\u08f7"+
    "\0\u0924\0\u0951\0\u0168\0\u0168\0\u097e\0\u09ab\0\u09d8\0\u0168"+
    "\0\u0168\0\u0168\0\u0a05\0\u0a32\0\u0a5f\0\u0a8c\0\u0168\0\u0ab9"+
    "\0\u0168\0\u0168\0\u0a5f\0\u0168\0\u0168";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[101];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\2\5\1\6\1\7\2\3\1\10\1\11"+
    "\1\12\1\3\1\13\1\14\1\12\1\15\1\16\1\17"+
    "\1\12\1\20\1\21\1\22\4\12\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\46\2\3\4\46\1\47\44\46\1\50\57\0\1\5"+
    "\60\0\1\51\52\0\2\7\1\51\46\0\1\10\1\52"+
    "\1\53\52\10\11\0\1\54\47\0\2\12\4\0\21\12"+
    "\4\0\1\12\21\0\2\12\4\0\3\12\1\55\15\12"+
    "\4\0\1\12\21\0\2\12\4\0\15\12\1\56\3\12"+
    "\4\0\1\12\21\0\2\12\4\0\3\12\1\57\10\12"+
    "\1\60\4\12\4\0\1\12\21\0\2\12\4\0\7\12"+
    "\1\61\11\12\4\0\1\12\21\0\2\12\4\0\2\12"+
    "\1\62\5\12\1\63\10\12\4\0\1\12\21\0\2\12"+
    "\4\0\12\12\1\64\5\12\1\65\4\0\1\12\21\0"+
    "\2\12\4\0\14\12\1\66\4\12\4\0\1\12\21\0"+
    "\2\12\4\0\14\12\1\67\4\12\4\0\1\12\21\0"+
    "\2\12\4\0\4\12\1\70\14\12\4\0\1\12\51\0"+
    "\1\71\1\0\1\72\53\0\1\73\55\0\1\74\54\0"+
    "\1\75\22\0\2\12\4\0\2\12\1\76\16\12\4\0"+
    "\1\12\67\0\1\40\55\0\1\40\1\0\1\46\2\0"+
    "\4\46\1\0\44\46\22\0\1\77\1\100\1\0\1\101"+
    "\27\0\1\102\4\0\2\103\51\0\1\53\63\0\1\104"+
    "\47\0\2\12\4\0\4\12\1\105\14\12\4\0\1\12"+
    "\21\0\2\12\4\0\6\12\1\106\12\12\4\0\1\12"+
    "\21\0\2\12\4\0\20\12\1\107\4\0\1\12\21\0"+
    "\2\12\4\0\16\12\1\110\2\12\4\0\1\12\21\0"+
    "\2\12\4\0\4\12\1\111\3\12\1\112\10\12\4\0"+
    "\1\12\21\0\2\12\4\0\3\12\1\113\15\12\4\0"+
    "\1\12\21\0\2\12\4\0\16\12\1\114\2\12\4\0"+
    "\1\12\21\0\2\12\4\0\7\12\1\115\11\12\4\0"+
    "\1\12\21\0\2\12\4\0\7\12\1\116\11\12\4\0"+
    "\1\12\21\0\2\12\4\0\14\12\1\117\4\12\4\0"+
    "\1\12\21\0\2\12\4\0\15\12\1\120\3\12\4\0"+
    "\1\12\21\0\2\12\4\0\11\12\1\121\7\12\4\0"+
    "\1\12\15\0\11\104\1\122\43\104\4\0\2\12\4\0"+
    "\5\12\1\123\13\12\4\0\1\12\21\0\2\12\4\0"+
    "\3\12\1\124\15\12\4\0\1\12\21\0\2\12\4\0"+
    "\13\12\1\125\5\12\4\0\1\12\21\0\2\12\4\0"+
    "\10\12\1\126\10\12\4\0\1\12\21\0\2\12\4\0"+
    "\11\12\1\127\7\12\4\0\1\12\21\0\2\12\4\0"+
    "\12\12\1\130\6\12\4\0\1\12\21\0\2\12\4\0"+
    "\3\12\1\131\15\12\4\0\1\12\21\0\2\12\4\0"+
    "\15\12\1\132\3\12\4\0\1\12\21\0\2\12\4\0"+
    "\6\12\1\133\12\12\4\0\1\12\21\0\2\12\4\0"+
    "\15\12\1\134\3\12\4\0\1\12\15\0\11\104\1\135"+
    "\43\104\4\0\2\12\4\0\15\12\1\136\3\12\4\0"+
    "\1\12\21\0\2\12\4\0\7\12\1\137\11\12\4\0"+
    "\1\12\21\0\2\12\4\0\12\12\1\140\6\12\4\0"+
    "\1\12\21\0\2\12\4\0\3\12\1\141\15\12\4\0"+
    "\1\12\21\0\2\12\4\0\3\12\1\142\15\12\4\0"+
    "\1\12\15\0\11\104\1\143\43\104\4\0\2\12\4\0"+
    "\3\12\1\144\15\12\4\0\1\12\21\0\2\12\4\0"+
    "\17\12\1\145\1\12\4\0\1\12\15\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2790];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\1\1\1\11\23\1\12\11\2\1\1\11"+
    "\2\1\1\11\1\0\1\1\1\11\1\0\14\1\5\11"+
    "\1\1\4\11\1\1\1\0\15\1\1\0\12\1\1\0"+
    "\10\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[101];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */


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
    return symbolFactory.newSymbol(name, code,
    					new Location(yyline+1, yycolumn+1),
    					new Location(yyline+1, yycolumn+yylength()), value);
    }
    protected void emit_warning(String message){
    	System.out.println("scanner warning: " + message + " at : 2 "+
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }

    protected void emit_error(String message){
    	System.out.println("scanner error: " + message + " at : 2" +
    			(yyline+1) + " " + (yycolumn+1) + " " + yychar);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 3240) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {     return symbolFactory.newSymbol("EOF",EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { emit_warning("Unrecognized character '" +yytext()+"' -- ignored");
            }
          case 49: break;
          case 2: 
            { /*Ignore Whitespaces*/
            }
          case 50: break;
          case 3: 
            { return symbol("INT_CONST", sym.INT_CONST, Integer.parseInt(yytext()));
            }
          case 51: break;
          case 4: 
            { /*Ignore Comments*/
            }
          case 52: break;
          case 5: 
            { return symbol("NAME",sym.NAME, yytext());
            }
          case 53: break;
          case 6: 
            { return symbol("LT", sym.LT);
            }
          case 54: break;
          case 7: 
            { return symbol("MINUS", sym.MINUS);
            }
          case 55: break;
          case 8: 
            { return symbol("GT", sym.GT);
            }
          case 56: break;
          case 9: 
            { return symbol("ASSIGN", sym.ASSIGN);
            }
          case 57: break;
          case 10: 
            { return symbol("LPAR", sym.LPAR);
            }
          case 58: break;
          case 11: 
            { return symbol("RPAR", sym.RPAR);
            }
          case 59: break;
          case 12: 
            { return symbol("COLON", sym.COLON);
            }
          case 60: break;
          case 13: 
            { return symbol("LGPAR", sym.LGPAR);
            }
          case 61: break;
          case 14: 
            { return symbol("RGPAR", sym.RGPAR);
            }
          case 62: break;
          case 15: 
            { return symbol("COMMA", sym.COMMA);
            }
          case 63: break;
          case 16: 
            { return symbol("SEMI", sym.SEMI);
            }
          case 64: break;
          case 17: 
            { return symbol("PLUS", sym.PLUS);
            }
          case 65: break;
          case 18: 
            { return symbol("TIMES", sym.TIMES);
            }
          case 66: break;
          case 19: 
            { return symbol("DIV", sym.DIV);
            }
          case 67: break;
          case 20: 
            { yybegin(STRING);string.setLength(0);
            }
          case 68: break;
          case 21: 
            { string.append( yytext() );
            }
          case 69: break;
          case 22: 
            { string.append('\\');
            }
          case 70: break;
          case 23: 
            { yybegin(YYINITIAL);
                                       return symbol("STRING_CONST",sym.STRING_CONST,
                                       string.toString());
            }
          case 71: break;
          case 24: 
            { return symbol("DO", sym.DO);
            }
          case 72: break;
          case 25: 
            { return symbol("IF", sym.IF);
            }
          case 73: break;
          case 26: 
            { return symbol("READ", sym.READ);
            }
          case 74: break;
          case 27: 
            { return symbol("LE", sym.LE);
            }
          case 75: break;
          case 28: 
            { return symbol("WRITE", sym.WRITE);
            }
          case 76: break;
          case 29: 
            { return symbol("GE", sym.GE);
            }
          case 77: break;
          case 30: 
            { return symbol("EQ", sym.EQ);
            }
          case 78: break;
          case 31: 
            { string.append('\t');
            }
          case 79: break;
          case 32: 
            { string.append('\r');
            }
          case 80: break;
          case 33: 
            { string.append('\n');
            }
          case 81: break;
          case 34: 
            { string.append('\"');
            }
          case 82: break;
          case 35: 
            { return symbol("DOUBLE_CONST",sym.DOUBLE_CONST, Double.parseDouble(yytext()));
            }
          case 83: break;
          case 36: 
            { return symbol("DEF", sym.DEF);
            }
          case 84: break;
          case 37: 
            { return symbol("INT", sym.INT);
            }
          case 85: break;
          case 38: 
            { return symbol("NOT", sym.NOT);
            }
          case 86: break;
          case 39: 
            { return symbol("HEAD", sym.HEAD);
            }
          case 87: break;
          case 40: 
            { return symbol("ELSE", sym.ELSE);
            }
          case 88: break;
          case 41: 
            { return symbol("THEN", sym.THEN);
            }
          case 89: break;
          case 42: 
            { return symbol("TRUE", sym.TRUE);
            }
          case 90: break;
          case 43: 
            { return symbol("BOOL", sym.BOOL);
            }
          case 91: break;
          case 44: 
            { return symbol("START", sym.START);
            }
          case 92: break;
          case 45: 
            { return symbol("FALSE", sym.FALSE);
            }
          case 93: break;
          case 46: 
            { return symbol("WHILE", sym.WHILE);
            }
          case 94: break;
          case 47: 
            { return symbol("DOUBLE", sym.DOUBLE);
            }
          case 95: break;
          case 48: 
            { return symbol("STRING", sym.STRING);
            }
          case 96: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
