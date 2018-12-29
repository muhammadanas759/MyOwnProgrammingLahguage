/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Muhammad anas
 */
public class validator extends classPart{
//private String[] DT_ = {"number", "dub", "ch"};
//private final String string_ = "str";
//private final String for_ = "repeat";
//private final String while_ = "unless";
//private final String do_ = "perform";
//private final String return_ = "ret";
//private final String ifelse_ = "checkotherwise";
//private final String switch_ = "switch";
//private final String case_ = "case";
//private final String main_ = "master";
//private final String end_ = "end";
//private final String default_ = "default";
//private final String print_ = "pt";
//public classPart[] keyword;
// for(int a=0;a<15;a++){
//
//}   
     static int checking;
  static String checking_operator="";
 static String[][] key={{"number","dub","ch"}
               ,{"str"}
       ,{"repeat"}
       ,{"unless"}
       ,{"perform"}
       ,{"ret"}
       ,{"check"}
       ,{"otherwise"}
       ,{"class"}
       ,{"void"}
       ,{"end"}
       ,{"def"}
       ,{"pt"}
       ,{"array"}
        ,{"public","private","protected"}  
       };
         
  public validator() {
     
  }
  
    Matcher matcher;
    
    public boolean Validate_IsKeyword(String word){
        System.out.println("c:");
        for(int row = 0; row < key.length; row++) {
            for (int j = 0; j <key[row].length ; j++) {
               if(word.equals(key[row][j])){
               
                   checking=row;
                  // System.out.println("key::::"+checking);
               return true;
               }
               
            }
        }
        return false;
 
    }
    public boolean Validate_Punctuator(String temp){
           
       
            switch (temp.charAt(0)) {
                case '(':
                    //temp = "(";
                    return true;
                   
                case ')':
                    //temp = ")";
                    return true;
                case '[':
                    //temp = "[";
                     return true;
                case ']':
                   // temp = "]";
                     return true;
               
                case ',':
                //temp=",";
                 return true;
                case '?':
                        return true;
                        
                default:
                     return false;
            }
            
        }
        
    public boolean Validate_Operator(String str){
    		
		if (str.equals(":")||str.equals("+:") ) {
                     checking_operator = "Assignment Operator";
                     return true;
		} else if (str.equals("+") || str.equals("-") || str.equals("*")
				|| str.equals("/")) {
		checking_operator = "Arithematic Operator";
		return true;
                } else if (str.equals("::") || str.equals(">") || str.equals("<")
				|| str.equals(">:") || str.equals("<:") || str.equals("<<")
                        || str.equals(">>")|| str.equals("!:") ) {
			checking_operator = "Relational Operator";
		return true;
                } else if (str.equals("|")||str.equals("&")||str.equals("&&") || str.equals("||") || str.equals("NOT")) {
			checking_operator = "Logical Operator";
		return true;
                } else if (str.equals("++") || str.equals("--") || str.equals("!")) {
			checking_operator = "Unary Operator";
		return true;
                }
                else if (str.equals(">>") || str.equals("<<") ) {
			checking_operator = "shift Operator";
		return true;
                }
                
                else 
                    checking_operator = "";
                        return false;
		
    }
    public boolean Validate_MultiDivideMode(String a){
    if(a.equals("*")||a.equals("/") ||a.equals("%")){
    return true;
    }
     return false;
            
        }
    
    public boolean Validate_bool(String a){
    if(a.equals("false")||a.equals("true")){
    return true;
    }
     return false;
            
        }
    
    public boolean Validata_IncDec(String a){
    if(a.equals("++")||a.equals("++"))
    return true;
    
     return false;
            
        }
    
public boolean Validate_not(String word){
    if("!".equals(word))
        return true;
    
    return false;
    } 
    
    public boolean Validate_Identifire_SA(String word){
        if(IsKeyword(word)){
     return false;}
     else{
        matcher=Identifier.matcher(word);
        System.out.println("identifire");
        return matcher.matches();
     }
    }
    public boolean Validate_Identifire(String word){
     
        matcher=Identifier.matcher(word);
        System.out.println("identifire");
        return matcher.matches();
     
    }
 public boolean Validate_Float(String word){
matcher=Floating.matcher(word);
     System.out.println("float");
      
return matcher.matches();
 }

 
 public boolean Validate_SimpleFloat(String word){
matcher=simpleFloat.matcher(word);
     System.out.println("simple float");
      
return matcher.matches();
 }
 public boolean Validate_Int(String word){              
 matcher=Unsigned.matcher(word);
        return matcher.matches();
   }
 public boolean Validate_Char(String word){
  matcher=Character.matcher(word);
        return matcher.matches();   
  }
 public boolean Validate_String(String word){
   matcher=String.matcher(word);
  
         
        return matcher.matches();
   }
//----- ---------------RE for character -------------------// 
           Pattern Character = Pattern.compile("(\'(\\\\(\\\\|\"|\'|r|b|t|n|o))\')|(\'.\')");
//----- ---------------RE for single unsigned integer -------------------// 
           Pattern Unsigned = Pattern.compile("\\d+");
//----- ---------------RE for single signed integer -------------------// 
           Pattern Signed = Pattern.compile("[+-]\\d+");
//----- ---------------RE for String -------------------// 
           Pattern String = Pattern.compile("(\"(\\\\(\\\\|\"|\'|r|b|t|n|o))*\")|(\".*\")");
//----- ---------------RE of floating point number -------------------// 
           Pattern Floating= Pattern.compile("[+-]?\\d*\\.\\d*([Ee]([+-]?\\d+))?");
//--------------RE for simple float 
           Pattern simpleFloat=Pattern.compile("[-+]?[0-9]*\\.?[0-9]*");
//---- ---------------RE of email-------------------// 
           Pattern Email = Pattern.compile("[A-Za-z0-9_]+(\\@\\w+\\.\\w+)");
//--------------------RE for identifier------------------//
         Pattern Identifier = Pattern.compile("[_a-zA-Z][_a-zA-Z0-9]{0,30}");

    private boolean IsKeyword(String word) {
        for (int i = 0; i <key.length ; i++) {
            System.out.println(""+key[i].length);
            for (int j = 0; j < key[i].length; j++) {
                if(word.equals(key[i][j])){
                return true;
                }
            }
        }
        
    return false;
    }
          
           
   
    
}
