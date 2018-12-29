
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Muhammad anas
 */
public class LexicalAnalyzer extends tokenSet {

    /**
     * @param args the command line arguments
     */
    static int d = 0;

    static ArrayList<tokenSet> tokens = new ArrayList<>();
//static String keywordName;
    static int lineNum = 0;
static boolean multiline=true;
    public static void main(String[] args) throws FileNotFoundException, IOException {
  //      // TODO code application logic here
//        //  validator val=new validator();

// Open the file
FileInputStream fstream = new FileInputStream("C:\\Users\\Muhammad anas\\Documents\\NetBeansProjects\\lexicalAnalyzer\\src\\lexicalanalyzer\\compiler.txt");
BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        
String strLine;

//Read File Line By Line
while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
 System.out.println (strLine.length());
validator v = new validator();
String temp="";            

            while((strLine.length()-1)!=d){
                System.out.println("length of strLine"+strLine.length());
                temp = splitwords(strLine);
System.out.println("temp="+temp);
                
if(temp.isEmpty()){
    System.out.println("empty");
}
else if(temp.contains("$*")){
    String comment=String.valueOf(strLine.charAt(d));
    d++;
    while (!((strLine.charAt(d)=='*')&&(strLine.charAt(d+1)=='$'))) {        
        if(d==(strLine.length()-1)){
               strLine = br.readLine();
       lineNum++;
       d=0;
           
        }else{
        comment+=String.valueOf(strLine.charAt(d));
        d++;
    }
    }
   d=strLine.length()-1;
    System.out.println("comment:"+comment);
}
//else if(v.Validate_Float(temp) || v.Validate_SimpleFloat(temp)){
else if(v.Validate_Float(temp)){
                tokenSet id = new tokenSet("float const", temp, lineNum);
                tokens.add(id);
                }

else if (Character.isAlphabetic(temp.charAt(0))) {
                if (v.Validate_Identifire(String.valueOf(temp))) {
                    if (v.Validate_IsKeyword(temp)) {

                        tokenSet key = new tokenSet(keywords(v.checking), temp, lineNum);
                        tokens.add(key);
                    } else {
                        tokenSet id = new tokenSet("identifier", temp, lineNum);
                        tokens.add(id);
                    }
                }

            }
        
            else{
                if(v.Validate_Int(temp)){
                    tokenSet id = new tokenSet("number const", temp, lineNum);
                        tokens.add(id);
                }
                
                else{
                tokenSet id = new tokenSet("invalid token", temp, lineNum);
                        tokens.add(id);
                }
                }
            }
               if(!strLine.isEmpty()){
                   if(temp.equals("$*")){
                   
 }
                   else{
               tokenSet id = new tokenSet("line Change char", "\\r", lineNum);
                tokens.add(id);
                   }
               }
            lineNum++;
        d = 0;
          
//    String a="checkotherwise";
//        if (val.Validate_IsKeyword(a)) {
////            if(val.checking==0)
////            System.out.println("k"+val.checking);
//System.out.println("val:"+val.checking);
//
//        }
//        else if(val.Validate_Operator(a))
//            System.out.println("O");
//        else if(val.Validate_Punctuator(a)){
//            System.out.println("P");
//        }
//        else{
//            System.out.println("nothing");
//        }
//     
//        tokenSet token=new tokenSet();
//        token=lexicalAnalyzer();
//   
//        
        }
tokenSet endOfCode = new tokenSet("$", "$", lineNum);
                tokens.add(endOfCode);
SyntaxAnalyzer CFG=new SyntaxAnalyzer();
if(CFG.validateCFG()){
    System.out.println("true");
    System.out.println("**********BUILD SUCCESSFULL************");
}
else{
    
    System.out.println("********** ERROR OCCURED************");
    System.out.println("false");

}


 File fout = new File("C:\\Users\\Muhammad anas\\Documents\\NetBeansProjects\\lexicalAnalyzer\\src\\lexicalanalyzer\\output.txt");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 
	for (int i = 0; i < tokens.size(); i++) {
		bw.write("(" + tokens.get(i).CP + "," + tokens.get(i).VP + "," + (tokens.get(i).line+1) + ")");
		bw.newLine();
	}
 	bw.close();

//        System.out.println("=========  TOKENS  =========");
//        for (int i = 0; i < tokens.size(); i++) {
//            System.out.println("(" + tokens.get(i).CP + "," + tokens.get(i).VP + "," + (tokens.get(i).line+1) + ")");
//        }
        
    }

//    public boolean isAlphabet(char c){
//    if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
//            return true;
//        else
//        return false;
//        }
    
    
    public static String splitwords(String st) throws IOException {
        validator val = new validator();
        String temp = "";
        boolean fc = false;
        boolean invalidflt=false;

        ////while ( (st=br.readLine()) != null) {
//            //System.out.println("length of line:"+st.length());
////            if(val.Validate_Operator(String.valueOf(st.charAt(0)))){
////                System.out.println(""+val.checking_operator);
////            }
////            else{
////                System.out.println("not");}
        //       lineNum++;
////            if(st.length()==1 || st.isEmpty()){
////            return ""; }
////            
        for (int i = d; i <=st.length()-1; i++) {

            if(fc){
            if(st.charAt(i)=='.'){
            d=i;
                return temp;
            } 
            
            if(Character.isAlphabetic(st.charAt(i))){
                if(invalidflt){
                temp+=st.charAt(i);
               }else{
                d=i;
            return temp;
            }
            }
            else if(Character.isDigit(st.charAt(i))){
                invalidflt=true;
                temp+=st.charAt(i);
            }
            else{
                
             }
            
            }
            else if (Character.isAlphabetic(st.charAt(i))) {
                temp += st.charAt(i);
}
            else if(st.charAt(i)=='_'){
                temp += st.charAt(i);
            
            }
            //for space
            else if (st.charAt(i)==' ') {
               if(!temp.isEmpty()){
                d = i;
                   i++;
                return temp;
               }
               
            }
            //operator
            else if (val.Validate_Operator(String.valueOf(st.charAt(i)))) {
                if(!temp.isEmpty()) {
                    d = i;
                    return temp;
}
                
                    if (val.Validate_Operator(String.valueOf(st.charAt(i + 1)))) {
                    if(":+".equals(String.valueOf(st.charAt(i)).concat(String.valueOf(st.charAt(i+1)))) ||(":!".equals(String.valueOf(st.charAt(i)).concat(String.valueOf(st.charAt(i+1))))) ){//during SA
                    tokenSet op = new tokenSet("Assignment Operator",":", lineNum);
                    tokens.add(op);
                    }
                    if(val.Validate_Operator(String.valueOf(st.charAt(i)).concat(String.valueOf(st.charAt(i+1))))){
                    
                    tokenSet op = new tokenSet(val.checking_operator, String.valueOf(st.charAt(i)).concat(String.valueOf(st.charAt(i + 1))), lineNum);
                    tokens.add(op);
                    i = i + 1;
                    }
                    
                   
                } 
                else {
                    val.Validate_Operator(String.valueOf(st.charAt(i)));
                    tokenSet op = new tokenSet(val.checking_operator, String.valueOf(st.charAt(i)), lineNum);
                    tokens.add(op);
                    //i++;
                    
                }
            }
            //punctuator
            else if (val.Validate_Punctuator(String.valueOf(st.charAt(i)))) {
           if((")".equals(String.valueOf(st.charAt(i)))&&(!temp.isEmpty())) || ("]".equals(String.valueOf(st.charAt(i)))&&(!temp.isEmpty()))){//during SA
                  tokenSet id = new tokenSet("identifier", temp, lineNum);
                        tokens.add(id);
                        temp="";
                   
                  }
                if (!temp.isEmpty()) {
                    
                    if ((st.length()-1)==i) {
                   tokenSet pun = new tokenSet(String.valueOf(st.charAt(i)), String.valueOf(st.charAt(i)), lineNum);
                    tokens.add(pun);
                    }
                    d = i;
                    return temp;
                }
                if (st.charAt(i) == '.') {
                    temp += st.charAt(i);
                    while (val.Validate_Int(String.valueOf(st.charAt(i+1)))){
                        i++;
                        temp += st.charAt(i);
                    }
                } else {

                    tokenSet pun = new tokenSet(String.valueOf(st.charAt(i)), String.valueOf(st.charAt(i)), lineNum);
                    tokens.add(pun);
                    //i++;
                    //System.out.println("in Puctuators" + String.valueOf(st.charAt(i)));
                    //d = i;
                    //return temp;
                }
            }
            else if(st.charAt(i)=='$'){
                if (st.charAt(i+1)=='*') {
                    temp="$*";
                    i++;
                    d=i;
                    return temp;
                }
                i++;
                String comment=String.valueOf(st.charAt(i));
                while (!(i==(st.length()-1))) {                    
                    i++;
                  comment+=st.charAt(i);
       
                }
                System.out.println("Single Line Comments: "+comment);
            }        
//for float(45.87, 76.98n4, 4h6.867)
            else if (val.Validate_Int(String.valueOf(st.charAt(i)))) {
                temp += st.charAt(i);
                

                //System.out.println("printed in = "+temp);
//                if(i<(st.length()-1)){
//                while (i<(st.length()-1) && dig_matcher(st.charAt(i + 1)) ) {
//                    i++;
//                    temp += st.charAt(i);
//                }
//                if (st.charAt(i + 1) == '.') {
//                    i++;
//                    temp += st.charAt(i);
//                    
//                    if (dig_matcher(st.charAt(i + 1))) {
//
//                        while (dig_matcher(st.charAt(i))) {
//                            i++;
//                            temp += st.charAt(i);
//                        }
//                        d = i;
//                        return temp;
//
//                    } else {
//                        System.out.println("something wrong after \".\" ");
//                    }
//
//                }
//                }
//                else{
//                    d = i;
//                    return temp;
//                }
//
            }
            
             else if(st.charAt(i)=='.'){
             if((val.Validate_Int(temp))){
             fc=true;            
             //    if(val.Validate_Int(String.valueOf(st.charAt(i+1)))){
             temp += st.charAt(i);
               // }
             }
                else if(st.charAt(i+1)==('e'|'E')){
                    temp+=st.charAt(i);
                    temp+=st.charAt(i+1);
                    i++;
                    fc=true;
            }
            else if(val.Validate_Identifire(temp)){
                tokenSet id = new tokenSet("identifier", temp, lineNum);
                    tokens.add(id);
  if( i<st.length()-1)              
if(Character.isAlphabetic(st.charAt(i+1))){
                    tokenSet dot = new tokenSet("dot", ".", lineNum);
                    tokens.add(dot);
                    temp="";
}
else{
    temp=".";
}           
                    
           }
            else if(temp.isEmpty()){
            temp+=st.charAt(i);
            fc=true;
            }
            else{
                tokenSet invalid=new tokenSet("invalid", temp, lineNum);
                tokens.add(invalid);
            if( i<st.length()-1)
                if(Character.isAlphabetic(st.charAt(i+1))){
                    tokenSet dot = new tokenSet("dot", ".", lineNum);
                    tokens.add(dot);
                    temp="";
}
else{
    temp=".";
}           

            }
            }
                 else if (st.charAt(i) == '\'') {
                temp += st.charAt(i);
//                           i++;
//                           d=i;
                if (st.length() - 1 != i && st.charAt(i + 1) != ' ') {
                    if (st.charAt(i + 1) == '\\') {

                        temp += st.charAt(i + 1);
                        i++;
                        d = i;
                        //      if(!check_endofline(st.length())){break;}
                        if (check_reserved_char(st.charAt(i + 1))) {
                            temp += st.charAt(i + 1);
                            i++;
                            d = i;
                            if (st.charAt(i + 1) == '\'') {
                                temp += st.charAt(i + 1);
                                i++;
                                i++;
                                d = i;
                                //write token here 
                                //  return temp;
                                //tokens.add(new tokenSet("character_const", temp, lineNum));
                                //temp = "";
                                return temp;
                            } else {
                                temp += st.charAt(i + 1);
                                //tokens.add(new tokenSet("iv",temp,lineNum));
                                //temp="";
                                i++;
                                i++;
                                d = i;
                                return temp;
                            }
                        }
                    } else if (st.charAt(i + 1) != '\\') {
                        Pattern ch = Pattern.compile(".");
                        Matcher ch_m = ch.matcher(String.valueOf(st.charAt(i + 1)));
                        if (ch_m.matches()) {
                            temp += st.charAt(i + 1);
                            i++;
                            d = i;
                            if (st.charAt(i + 1) == '\'') {
                                temp += st.charAt(i + 1);
                                i++;
                                i++;
                                d = i;
                                //write token here
                                return temp;
                                //tokens.add(new tokenSet("character_const", temp, lineNum));
                                //temp = "";
                            } else {
                                temp += st.charAt(i + 1);
                                //tokens.add(new tokenSet("iv",temp,lineNum));
                                //temp="";
                                i++;
                                d = i;
                                //tokens.add(new tokenSet("iv", temp, lineNum));
                                return temp;
                            }
                        }

                    } else {
                        //default
                        if (i == st.length()) {
                            break;
                        }
                        temp += st.charAt(i);
                        i++;
                        d = i;

                    }
                }
//else {
//
//                    temp += st.charAt(i);
//                    //return temp;
//                    //tokens.add(new tokenSet("Invalid Token2", temp, lineNum));
//                }

            } 
            
            
            
            
            //for String checking "val"
            else if (st.charAt(i) == '"') {
              temp+=st.charAt(i);
                //i++; during SA
                   while(true){
                //System.out.println("printed in = "+temp);
                      if (st.charAt(i) == '\\') {
                          temp+=st.charAt(i+1);
                          i+=2;
                          
                      }
                      else{
                           i++;
                    temp += st.charAt(i);
                }
                while ((st.charAt(i) == '"')) {
                    
               tokenSet a=new tokenSet("string Constant", temp, lineNum);
               tokens.add(a);
               temp="";
               break;
                    //System.out.println("printed in == "+temp);
                }
                if(i==st.length()-1)
                    break;
                    
                  }
               }
            else if (st.charAt(i) == '\'') {
                if((i+3<=st.length()-1) ||(i+2<=st.length()-1)){
                i++;
                temp+=st.charAt(i);
                if(st.charAt(i) == '\\'){
                temp+=st.charAt(i);
                
                }
               
                } else{
                temp+=st.charAt(i);
            }
            }
//            else if (st.charAt(i) == '\'') {
//                //System.out.println(st.length()-1);
//                if (st.length()-1 != i&&st.charAt(i+1)!=' ') {
//                    if (st.charAt(i + 1) == '\\') {
//                        temp += st.charAt(i + 1);
//                        i++;
//                        d = i;
//                        if (check_reserved_char(st.charAt(i + 1))) {
//                            temp += st.charAt(i + 1);
//                            i++;
//                            d = i;
//                            if (st.charAt(i + 1) == '\'') {
//                                i++;
//                                d = i;
//                                //write token here 
//                                //  return temp;
//                                tokens.add(new tokenSet("character_const", temp, lineNum));
//                                temp = "";
//                            }
//                        }
//                    } else if (st.charAt(i + 1) != '\\') {
//                        Pattern ch = Pattern.compile(".");
//                        Matcher ch_m = ch.matcher(String.valueOf(st.charAt(i + 1)));
//                        if (ch_m.matches()) {
//                            temp += st.charAt(i + 1);
//                            i++;
//                            d = i;
//                            if (st.charAt(i + 1) == '\'') {
//                                i++;
//                                d = i;
//                                //write token here
//                                //return temp;
//                                tokens.add(new tokenSet("character_const", temp, lineNum));
//                                temp = "";
//                            }
//                        }
//
//                    } else {
//                        //default
//                        return temp;
//
//                    }
//                }else{
//                   
//                  temp+=st.charAt(i);
//                  //tokens.add(new tokenSet("Invalid Token2", temp, lineNum));
//                }
//
//            } 
            
            
            else if(st.charAt(i)=='\n'){
 //               System.out.println("line change character");
        return temp;
        }
            else {
                tokenSet id = new tokenSet("invalid", String.valueOf(st.charAt(i)), lineNum);
                tokens.add(id);

            }

        }
            
        d = st.length()-1;
       return temp;
    }

    //-----------------------------------
//    public static void generater(String temp){
//    return temp;
//    }
    static boolean check_reserved_char(char charAt) {
        switch (charAt) {
            case 'r':
                return true;
            case 'b':
                return true;
            case 't':
                return true;
            case 'n':
                return true;
            case '\'':
                return true;
            case '\\':
                return true;

            default:
                return false;
        }
    }
    public static String keywords(int ch) {

        switch (ch) {
            case 0:
                System.out.println("DT");
                return "DT";

            case 1:
                System.out.println("str");
                return "str";

            case 2:
                // keywordName="repeat";
                System.out.println("repeat");
                return "repeat";

            case 3:
                // keywordName="unless";
                System.out.println("unless");
                return "unless";

            case 4:
                System.out.println("perform");
                return "perform";
            case 5:
                System.out.println("ret");
                return "ret";
            case 6:
                //keywordName="checkotherwise";
                System.out.println("check");
                return "check";
            case 7:
                //keywordName="switch";
                System.out.println("otherwise");
                return "otherwise";
            case 8:
                //keywordName="case";
                System.out.println("class");
                return "class";
            case 9:
                //   keywordName="master";
                System.out.println("void");
                return "void";
            case 10:
                //keywordName="end";
                System.out.println("end");
                return "end";
            case 11:
                // keywordName="master";
                System.out.println("def");
                return "def";
            case 12:
                //keywordName="end";
                System.out.println("print");
                return "print";
            case 13:
                //keywordName="end";
                System.out.println("array");
                return "array";
            case 14:
                return "Access Modifier";


            default:
                System.out.println("nothing");
        }
        return null;
    }
    
}

