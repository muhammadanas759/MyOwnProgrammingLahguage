/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

/**
 *
 * @author Muhammad anas
 */
class SyntaxAnalyzer {
int index=0;
    validator keywords=new validator();
    public SyntaxAnalyzer() {
    }
    public String dataType(String VP){
        
        for (int j = 0; j < 3; j++) {
           if(keywords.key[0][j].equals(VP))
               return LexicalAnalyzer.tokens.get(index).CP;
        }
        if( "str".equals(LexicalAnalyzer.tokens.get(index).CP))
            return LexicalAnalyzer.tokens.get(index).CP;
        
    return "";
    }
    public String AccessModifier(String AM){
        for (int j = 0; j < 3; j++) {
           if(keywords.key[14][j].equals(AM))
               return LexicalAnalyzer.tokens.get(index).CP;
        }
    return "";
    }
    
    public boolean repeat(){
        keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
            //FIRST(<repeat>) = {repeat}
            if (keywords.key[2][0].equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                //<repeat>  repeat(<F1>, <F2>, <F3>)\\r<Body>
                if (keywords.key[2][0].equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                    if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                        if (F1())
                        {
                                   
                                if (F2())
                                {
                                    if ("?".equals(LexicalAnalyzer.tokens.get(index).CP))
                                    {
                                        index++;
                                        if (F3())
                                        {
                                            if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
                                            {
                                                index++;
                                               if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)){
                                                index++;
                                                
                                                   if (Body())
                                                {
                                                    return true;
                                                }
                                            }
                                        }
                                        }
                                    }
                                
                                
                            }
                        }
                    }
                }
            }
        return false;}
  
    private  boolean linebreaking(){
    if(("\\r".equals(LexicalAnalyzer.tokens.get(index).VP) && "end".equals(LexicalAnalyzer.tokens.get(index+1).VP)))
    {   index++;
    index++;
        return true;
    }
    else if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)){
    
    return true;
    }
    
    return false;
    }
        private boolean Body()
        {
           
            
            //FIRST(<Body>) = {\\r  , jabtak , DT , Barbar , agar , return ,  inc_dec , ID , break , continue , this }
            if ("unless".equals(LexicalAnalyzer.tokens.get(index).CP) ||
              LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
               "repeat".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "check".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "ret".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP)||
                    "break".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "cont".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "this".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                ",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                 "\\r".equals(LexicalAnalyzer.tokens.get(index).VP)||
                    "end".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Body>  end\\r | <S_ST>end \\r| {<M_ST>}
                
                
                    if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                             if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)){
                    
                                 index++;

                                 return true;
                                 }
                    
                }
            else if (M_ST())
                    {
                        if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
                        {
                            index++;
                             
                             if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)){
                                 index++;

                                 return true;
                                 }
                          }
                
            }
                    else if (S_ST())
                {
                         if("end".equals(LexicalAnalyzer.tokens.get(index).VP)){
                             
                             index++;
                             
                             if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)){
                                 index++;

                                 return true;
                                 }
                          }
                }
            
            }
         return false;
        }
        
        private boolean M_ST()
        {
            //FIRST(<M_ST>) = { jabtak , DT , Barbar , agar , return ,  inc_dec , ID , break , continue, this , Null}
            if ("unless".equals(LexicalAnalyzer.tokens.get(index).CP) ||
              LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
               "repeat".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "check".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "ret".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP)||
                    "break".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "cont".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "this".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                 if (S_ST())
               
                {
                    if (M_ST())
                    {
                        return true;
                    }
                }
            }
            ////FOLLOW(<M_ST>) = { end }
            else if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
               return true;
            }
            return false;
        }

        
        private boolean S_ST()
    
        {
           
            //FIRST(S_ST) = {jabtak , DT , Barbar , agar , return ,  inc_dec , ID , break , continue , this}
            if ("unless".equals(LexicalAnalyzer.tokens.get(index).CP) ||
              LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
               "repeat".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "check".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "ret".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP)||
                    "break".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "cont".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "this".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<S_ST><Unless> | DT <S_St_DT> | <Bar_Bar> | <check> | <Return> | inc_dec  ID<inc_dec_list>\\r|ID <S_St_ID>| <break> | <continue> |<this>
                if (Unless())
                {
                    return true;
                }
                else if (LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) )
                {
                    index++;
                    if (S_St_DT())
                    {
                       return true;
                    }
                }
                else if (repeat())
                {
                     return true;
                }
                else if (check())
                {
                    return true;
                }
               else if (Return())
                {
                   return true;
                }
                else if ( keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                    if ( keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                    {   
                        index++;
                        if (inc_dec_list())
                       
                        {
                            if (  "\\r".equals(LexicalAnalyzer.tokens.get(index).VP) )
                            {
                                index++;
                                return true;
                            }
                        }
                    }
                }
                else if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (S_St_ID())
                   {
                        return true;
                    }
                }
                else if (BREAK())
                {
                     return true;
                }
                else if (CONTINUE())
                {
                   return true;
                }
            }
           return false;
        }
          private boolean Unless()//while
        {
            if (  "unless".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                if ( "unless".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if ( "(".equals(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                        if (Exp())
                        {
                    if ( ")".equals(LexicalAnalyzer.tokens.get(index).VP))
                            {
                                index++;        
                            if ( "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                            { 
                                index++;
                              
                            if (Body())
                                {
                                     return true;
                                }
                            }
                        }
                    }
                    }
                }
            }
            
           return false;
        }

         private boolean Return()
        {
            
            //FIRST(<Return>) = {return}
            if ("ret".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                if ("ret".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (return2())
                    {
                         return true;
                    }
                }
            }
           return false;
        }

        private boolean return2()
        {
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).CP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).CP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                    "\\r".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                     return true;
                }
                else if(Exp())
                {
                    if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                    {
                        index++;
                        return true;
                    }
                }
            }
          return false;
        }

        private boolean BREAK()
        {
            
            if ("break".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                if ("break".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                    {   
                       return true;
                    }
                }
            }
            return false;
        }

        private boolean CONTINUE()
        {
           
            if ("cont".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                if ("cont".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                    {
                         return true;
                    }
                }
            }
           return false;
        }

        private boolean check()//if-else
        {
            if ("check".equals(LexicalAnalyzer.tokens.get(index).VP) )
            {
                //<check>  check(<Exp>)\\r <M_ST>\\r end <O_Else>
                if ("check".equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    
                    index++;
                    if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                        if (Exp())
                        {
                            
                            if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
                            {
                                
                                index++;
                                if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)){
                                 index++;
                                    if (M_ST())
                                    {
                                            if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
                                        {
                                                                                    index++;

                                     if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)){


                                            index++;
                                            
                                            if (O_Else())
                                            {
                                               return true;
                                            }
                                        }
                                        }
                                    }
                                }
                                }
                            }
                        }
                    }
                }
            
            return false;
        }
        
        private boolean O_Else()
        {
           
            
            //FIRST(<O_Else>) = {warna , Null}
            if ("otherwise".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<O_Else>  warna <M_ST>end | Null
                if ("otherwise".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)) {
                        index++;
                      
                    if (M_ST())
                        {
                            
                        
                        if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
                            {
                                index++;
                      if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP)) {
                        index++;
                  
                                return true;
                            }
                        }
                        }
                    }  
                    }
                }
            
            //FOLLOW(<O_Else>) = { jabtak , DT , Barbar , agar , return ,  inc_dec , ID , break , continue,end}
            else if ("unless".equals(LexicalAnalyzer.tokens.get(index).CP) ||
              LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
               "repeat".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "check".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "ret".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP)||
                    "break".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "cont".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "this".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                    "end".equals(LexicalAnalyzer.tokens.get(index).CP)){
                
                
              return true;
            }
           return false;
        }

 private boolean S_St_DT()
        
        {
           
            //FIRST(<S_St_DT>) = {ID , void , DT , [}
            if (LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
                  "void".equals(LexicalAnalyzer.tokens.get(index).CP) ||
keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP)||
              "[".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<S_St_DT>  ID <S_St_DT2> | <Method_DEC> | <Array_DEC>
                if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                   
                    index++;
                    if (S_St_DT2())
  {
                       return true;
                    }
                }
                else if (Array_DEC())
                {
                    return true;
                }
            }
             return false;
        }

        private boolean S_St_DT2()
        {
            
           keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
            ////FIRST(<S_St_DT2>) = { AOP , , , \\r }
            if ("Assignment Operator".equals(validator. checking_operator)||
                ",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP)
                    )
            {
                if (Variable_Link2())
                {
                    return true;
                }
            }
            return false;
        }

          private boolean S_St_ID()
      {
           keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
            
          //FIRST(<S_St_ID>) = {inc_dec , = , ID ,  .  , (  }
            ////FIRST(<S_St_ID>) = {inc_dec , AOP , ID , [ ,  .  , (  ,}
            if (keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP)||
                "Assignment Operator".equals(validator. checking_operator)||
                    keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                ".".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                 "(".equals(LexicalAnalyzer.tokens.get(index).CP)||
                    "[".equals(LexicalAnalyzer.tokens.get(index).CP) )
            {
                //<S_St_ID>  inc_dec | <Assign_Op> | <Object_link> | <Object_Call> | <Method_Call_1>7
                //inc_dec; | <Assign_Op>| <Object_link> | <Object_Call>; | <Method_Call_1>; | [<Exp>] <Assign_Op>	

                //<S_St_ID>inc_dec; | <Assign_Op>| <Object_Call>; | <Method_Call_1>; | [ <2> | ID <Object_Creation_Exp>
                if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                   
                   
                    index++;
                    if ( "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                    {
                        index++;
                         return true;
                    }
                }
                else if (Assign_Op())
                
               {
                    return true;
                }
                else if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                   
                    index++;
                }
                else if (  "[".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                   
                    index++;
                }
                else if (Object_Call())
                
                {
                    
                    if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                    {
                        index++;
                      return true;
                    }
                }
                 else if (Method_Call_1())
  
                 {
                    if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                    {
                        index++;
                        return true;
                    }
                }
                
            }
            return false;
        }
           private boolean Object_Call()
        {
           
            //FIRST(<Object_Call>) = {. , [}
            if (".".equals(LexicalAnalyzer.tokens.get(index).CP)||
                "[".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Object_Call>  . ID <Object_Call>| <Method_Call_1> 
                //<Object_Call> . <Exp> | [<Exp>].<Exp>
                if (".".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;

                   
                 
                    
                    if (Exp())
                    {
                        return true;
                    }
                }
                else if ("[".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                   index++;
                    
                    if (Exp())
                    {
                        if ("]".equals(LexicalAnalyzer.tokens.get(index).CP))
                        {
                            index++;
                            if (".".equals(LexicalAnalyzer.tokens.get(index).CP))
                            {
                                index++;
                                if (Exp())
                                {
                                   
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
          return false;
        }

        private boolean Param()
        {
          if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP)
                   )
            {
                //<Param> <Exp> <Param1> | Null
                if (Exp())
                {
                    if (Param1())
                    {
                        return true;
                    }
                }
                else if(keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ){
                index++;
                  if (Param1())
                    {
                        return true;
                    }
                
                }
            }

            else if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                return true;
            }
            return false;
        }

        private boolean Param1()
        {

            //FIRST(<Param1>) = {, , Null}
            if (",".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Param1>  ,  ID <Param1> | Null
                index++;

                if (Exp())
                {
                    if (Param1())
                    {
                        return true;
                    }
                }
                else if(keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ){
                index++;
                    if (Param1())
                    {
                        return true;
                    }
                }
            }
            else if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                return true;
            }
            return false;
        }

             private boolean Method_Call_1()
        {
           
            
            if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Method_Call_1>  (<Param>) 
                if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (Param())
                    {
                        if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
                        {
                            index++;
                  if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP) || ".".equals(LexicalAnalyzer.tokens.get(index).VP) )
                        {
                            return true;
                        }
                        }    
                    }
                }
            }
           return false;
        }

          private boolean Assign_Op()
        {
           
           keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
           
            //FIRST(<Assign_Op>) = { : }
            if ("Assignment Operator".equals(validator. checking_operator))
            {
                if ("Assignment Operator".equals(validator. checking_operator))
                {
                    
                    index++;
                    if (Assign_Op2())
                    {
                        return true;
                    }
                }
            }
           return false;
        }

        private boolean Assign_Op2()
        {
            //FIRST(<Assign_Op2>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).CP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).CP ) 
          )
            {
                //<Assign_Op2>  <Exp>\\r
                if (Exp())
                {
                    if (("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))|| "?".equals(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                         return true;
                    }
                }
            }
          return false;
        }


        private boolean F3()
        {
           
            //FIRST(<F3>) = {inc_dec , ID , Null}
            if ( keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP)
                    )
            {
                //<F3>  inc_dec ID | ID inc_dec| Null
                if (keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                    if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                        return true;
                    }
                }
                else if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP))
                    {index++;
                       return true;
                    }
                }
            }
            ////FOLLOW(<F3>) = { ) }
            
            else if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                
                
                return true;
            }
            return false;
        }
//
//        private boolean F4()
//        {   keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
//          
//            //FIRST(<F4>) = {inc_dec , AOP}
//            if ( keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
//               "Assignment Operator".equals(validator. checking_operator)) 
//            {
//                //<F4>  inc_dec | AOP <Exp>
//                if (keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP))
//                {
//                   
//                    index++;
//                }
//                else if ("Assignment Operator".equals(validator. checking_operator))
//                {
//                    index++;
//                    if (Exp())
//                    {
//                       return true;
//                    }
//                }
//            }
//           return false;
//        }
        
        private boolean Exp()
        {
           
            //FIRST(<Exp>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST , ! , ( , inc_dec  }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP)
                )
            {
                //<Exp>  <OR_Exp>
                if (OR_Exp())
                {
                    
                   return true;
                }
            }
          return false;
        }

        private boolean OR_Exp()
        {
            
            //FIRST(<OR_Exp>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST  }
            //FIRST(<OR_Exp>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST , ! , ( , inc_dec }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP)
                      )
            {
                //<OR_Exp>  <AND_Exp> <OR_Exp2>
                if (AND_Exp())
                {
                    if (OR_Exp2())
                    {
                         return true;
                    }
                }
            }
           return false;
        }

        private boolean OR_Exp2()
        {
           
            //FIRST(<OR_Exp2>) = {|| , Null}
            if ("||".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                //<OR_Exp2>  || <AND_Exp> <OR_Exp2> | Null
                if ("||".equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                    if (AND_Exp())
                    {
                       
                        if (OR_Exp2())
                        {
                            
                             return true;
                        }
                    }
                }
            }

            //FOLLOW(<OR_Exp2>) = { ,  , ) , } , ] , \\r}
            else if (",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                ")".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "}".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).CP)||
                "?".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                
               return true;
            }
            return false;
        }

        private boolean AND_Exp()
        {
           
            //FIRST(<AND_Exp>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST  }
     if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP)
                 
                )
            {
                //<AND_Exp>  <ROP> <AND_Exp2>
                if (ROP())
                {
                    if (AND_Exp2())
                    {
                        
                       return true;
                    }
                }
            }
             return false;
        }

        private boolean AND_Exp2()
        {
            
            //FIRST(<AND_Exp2>) = {&& , Null}
            if ("&&".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                //<AND_Exp2>  && <ROP> <AND_Exp2> | Null
                if ("&&".equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                    if (ROP())
                    {
                        
                        if (AND_Exp2())
                        {
                            
                             return true;
                        }
                    }
                }
            }
            ///FOLLOW(<AND_Exp2>) = {||, ,  , ) , } , ] , \\r}
            
            else if ("||".equals(LexicalAnalyzer.tokens.get(index).VP) ||
            ",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                ")".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "}".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).CP)||
                "?".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
            
            {
               return true;
            }
            return false;
        }

        private boolean ROP()
        {
            //FIRST(<ROP>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST  }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP ))
            {
                //<ROP>  <E> <ROP2>
              
                if (E())
                {
                    if (ROP2())
                    {
                        
                        return true;
                    }
                }
            }
          return false;
        }

        private boolean ROP2()
        {
         keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
            //FIRST(<ROP2>) = {ROP , Null}
            if ("Relational Operator".equals(validator.checking_operator)) //can be '=' TEMP
            {
                //<ROP2>  ROP <E> <ROP2> | Null
                if ("Relational Operator".equals(validator.checking_operator))
                {
                    index++;
                    if (E())
                    {
                      
                        if (ROP2())
                        {
                            
                            return true;
                        }
                    }
                }
            }

            ////FOLLOW(<ROP2>) = {&& ,||, ,  , ) , } , ] , \\r}
            else if ("&&".equals(LexicalAnalyzer.tokens.get(index).VP)||
                    "||".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                    ",".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                ")".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "}".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "?".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                    {
               return true;
            }
            return false;
        }

       
        private boolean E()
        {
            //FIRST(<E>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST  }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP )
                )
            {
                //<E>  <T> <E2>
                
                if (this.T())
                {
                    if (E2())
                    {
                        
                      return true;
                    }
                }
            } return false;
        }

        private boolean E2()
        {
                  keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
   
            //FIRST(<E2 >) = {Plus_Minus , Null}
            if ("+".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "-".equals(LexicalAnalyzer.tokens.get(index).VP)
                )
            {
                //<E2>  Plus_Minus <T > <E2> | Null
                if ("+".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "-".equals(LexicalAnalyzer.tokens.get(index).VP)
                )
                {
                    index++;
                    if (this.T())
                    {
                        if (E2())
                        {
                            
                           return true; 
                        }
                    }
                }
            }
            
            //FOLLOW(<E2>) = {ROP , && ,||, ,  , ) , } , ] , \\r}}
            else if ( "Relational Operator".equals(validator.checking_operator)||
                    "&&".equals(LexicalAnalyzer.tokens.get(index).VP)||
                    "||".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                    ",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                ")".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "}".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).CP)||
                "?".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                return true;
            }return false;
        }
        
        private boolean T()
        {
            //FIRST(<T>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST  }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP 
                ))
            {
                //<T>  <F> <T2>
                if (F())
                {
                    if (this.T2())
                    {
                        
                        return true;
                    }
                }
            }return false;
        }

        private boolean T2()
        {
                    keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
   
            //FIRST(<T2>) = { M_D_M , Null}
            if (keywords.Validate_MultiDivideMode(LexicalAnalyzer.tokens.get(index).VP))
            {
                //<T2>  M_D_M <F> <T2> | Nulll
                if (keywords.Validate_MultiDivideMode(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                    if (F())
                    {
                       
                        if (this.T2())
                        {
                            
                            return true;
                        }
                    }
                }
            }
            //FOLLOW(<T2>) = { Plus_Minus , ROP , && ,||, ,  , ) , } , ] , \\r}

            else if ("+".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "-".equals(LexicalAnalyzer.tokens.get(index).VP) ||
          "Relational Operator".equals(validator.checking_operator)||
                    "&&".equals(LexicalAnalyzer.tokens.get(index).VP)||
                    "||".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                    ",".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                ")".equals(LexicalAnalyzer.tokens.get(index).VP) ||
//                "}".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "?".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
          
            {
                
                
              return true;
            }
             return false;
        }
        
        private boolean F()
        {
            //FIRST(<F>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST  }
            //FIRST(<F>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST , ! , ( , inc_dec }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) ||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP ) )
            {
                //<F>  ID | <CONST>
                //<F> ID <id_op>  |<Const> |!<F> | (<Exp>) | Inc_Dec  ID<inc_dec_list>
                if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) )
                {
                   
                    index++;
                    if (id_op())
                    {
                       return true;
                    }
                }
                else if (CONST())
                {
                    return true;
                }
                else if (  keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                    if (F())
                    {
                        return true;
                    }
                }
                else if (    "(".equals(LexicalAnalyzer.tokens.get(index).CP ))
                {
                    index++; 
                    if (Exp())
                    {
                        if (    ")".equals(LexicalAnalyzer.tokens.get(index).CP ))
                        {
                            index++;
                           return true;
                        }
                    }
                }
                else if (   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) )
                {
                    index++;
                    if (   keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) )
                    {
                        index++;
                        if (inc_dec_list())
                        {
                           return true;
                        }
                    }
                }
            }
           return false;
        }
//            private boolean id_op(ref string RT, string N, string T, ref string NT)
            private boolean id_op()
        {
 keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
            
          
            //FIRST(<id_op>) = { Null , ( , [ , . , inc_dec}
            if ("(".equals(LexicalAnalyzer.tokens.get(index).CP ) ||
                "[".equals(LexicalAnalyzer.tokens.get(index).CP ) ||
                ".".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP))
            {
                //<id_op>  Null | <Method_Call_1> | [ <Exp> ] |<Member_exp> |  Inc_Dec 

//                if (Method_Call_1(ref RT, N))
                if (Method_Call_1())
                {
//                    NT = N;
                    return true;
                }
                else if ("[".equals(LexicalAnalyzer.tokens.get(index).CP ) 
                )
                {
                    
                    index++;
                    if (Exp())
                    {
                        if ("]".equals(LexicalAnalyzer.tokens.get(index).CP ) )
                        {
                          
                            index++;
                            return true;
                        }
                    }
                }
                else if (Member_exp())
                {
                   return true;
                }
                else if (keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP))
                {
                    
                    index++;
                   return true;
                }
            }
////FOLLOW(<id_op>) = {M_D_M , Plus_Minus , ROP , && ,||, ,  , ) , } , ] , ;}
            else if (
                    keywords.Validate_MultiDivideMode(LexicalAnalyzer.tokens.get(index).VP)||
            "+".equals( LexicalAnalyzer.tokens.get(index).VP) ||
            "-".equals( LexicalAnalyzer.tokens.get(index).VP) ||
                    
                 "Relational Operator".equals( validator.checking_operator) ||
            "&&".equals(LexicalAnalyzer.tokens.get(index).VP )||
                                "||".equals(LexicalAnalyzer.tokens.get(index).VP )||        
                    ")".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "}".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                ",".equals(LexicalAnalyzer.tokens.get(index).VP ))
            {
               
                return true;
            }
           return false;
        }

        private boolean Member_exp()
        {
            //FIRST(<Member_exp>) = { . }
            if (".".equals(LexicalAnalyzer.tokens.get(index).VP ) )
            {
                //<Member_exp> -> .ID < Member_exp_2>
                if (".".equals(LexicalAnalyzer.tokens.get(index).VP ) )
                {
                   
                    index++;
                    if (        keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP)){
                        index++;
                        if (ME_3())
                        {
                            if(Member_exp()){
                            
                            return true;
                            }
                        }
                    }
                }
                }
            
            else if("\\r".equals(LexicalAnalyzer.tokens.get(index).VP )){
            return true; 
            }
            return false;
           
        }

        private boolean ME_3(){
        if("(".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "[".equals(LexicalAnalyzer.tokens.get(index).VP )||
                ".".equals(LexicalAnalyzer.tokens.get(index).VP )
                ){
        if(Member_exp()){
        return true;
        }
        else if(Member_exp_2()){
        return true;
        }
        }
        
        
        //follow
        else if(   keywords.Validate_MultiDivideMode(LexicalAnalyzer.tokens.get(index).VP)||
            "+".equals(LexicalAnalyzer.tokens.get(index).VP) ||
            "-".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                    
                 "Relational Operator".equals( validator.checking_operator) ||
            "&&".equals(LexicalAnalyzer.tokens.get(index).VP )||
                                "||".equals(LexicalAnalyzer.tokens.get(index).VP )||        
                    ")".equals(LexicalAnalyzer.tokens.get(index).CP ) ||
                "}".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                ",".equals(LexicalAnalyzer.tokens.get(index).VP )||
                ".".equals(LexicalAnalyzer.tokens.get(index).VP )){
        return true;
        }
        return false;
        }
        
        private boolean Member_exp_2()
        {  
            //FIRST(< Member_exp_2>) = {Null , ( , [}
            if ("(".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "[".equals(LexicalAnalyzer.tokens.get(index).VP ) )
            {
                //< Member_exp_2> -> Null | <Method_Call_1> | [<Exp>]
//                if (Method_Call_1(ref RT, N))
                if (Method_Call_1())
                {
                  return true;
                }
                else if ("[".equals(LexicalAnalyzer.tokens.get(index).CP ) )
                {
                   
                    index++;
                    if (Exp())
                    {
                        if ("]".equals(LexicalAnalyzer.tokens.get(index).CP ) )
                        {
                          
                           
                            index++;
                            return true;
                        }
                    }
                }
            }
            else if (     keywords.Validate_MultiDivideMode(LexicalAnalyzer.tokens.get(index).VP)||
            "+".equals( LexicalAnalyzer.tokens.get(index).VP) ||
            "-".equals( LexicalAnalyzer.tokens.get(index).VP) ||
                    
                 "Relational Operator".equals( validator.checking_operator) ||
            "&&".equals(LexicalAnalyzer.tokens.get(index).VP )||
                                "||".equals(LexicalAnalyzer.tokens.get(index).VP )||        
                    ")".equals(LexicalAnalyzer.tokens.get(index).CP ) ||
                "}".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP ) ||
                ",".equals(LexicalAnalyzer.tokens.get(index).VP )
                   || ".".equals(LexicalAnalyzer.tokens.get(index).VP )
                 )
            {
                
           
              return true;
            }
           return false;
        }

    

        private boolean inc_dec_list()
        {
            
                    keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
   
            //FIRST(<inc_dec_list>) = { [ , . , Null}
            if ( "[".equals(LexicalAnalyzer.tokens.get(index).CP )||
                 ".".equals(LexicalAnalyzer.tokens.get(index).VP ))
            {
                //<inc_dec_list>  [<Exp>] | .ID[<Exp>] |Null 
                if( "[".equals(LexicalAnalyzer.tokens.get(index).CP )){

                    index++;
                    if(Exp())
                    {
                        if( "]".equals(LexicalAnalyzer.tokens.get(index).CP ))
                        {
                           
                            index++;
                           return true;
                        }
                    }
                }else if( ".".equals(LexicalAnalyzer.tokens.get(index).VP ))
                {
                   
                    index++;
                    if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                        if ( "[".equals(LexicalAnalyzer.tokens.get(index).VP ))
                        {
                           
                            index++;
                            if(Exp())
                            {
                                if( "]".equals(LexicalAnalyzer.tokens.get(index).CP ))
                                {
                                    index++;
                                
                                if( "\\r".equals(LexicalAnalyzer.tokens.get(index).VP ))
                                {
                                    
                                   return true;
                                }
                            }
                            }
                        }
                        }
                    }
                }
                
            
            //FOLLOW(<inc_dec_list>) = {M_D_M , Plus_Minus , ROP , && ,||, ,  , ) , } , ] , \\r}
            else if(keywords.Validate_MultiDivideMode(LexicalAnalyzer.tokens.get(index).CP) ||
                   "+".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "-".equals(LexicalAnalyzer.tokens.get(index).VP) ||
          "Relational Operator".equals(validator.checking_operator)||
                    "&&".equals(LexicalAnalyzer.tokens.get(index).VP)||
                    "||".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                    ",".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                ")".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                //"}".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "]".equals(LexicalAnalyzer.tokens.get(index).VP)||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                
               return true;
            }
             return false;
        }

        
        private boolean CONST()
        {
            //FIRST(<CONST>) = { INT_CONST, FLOAT_CONST , STRING_CONST , CHAR_CONST ,BOOL_CONST }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ) )
            {
                //<CONST>   INT_CONST| FLOAT_CONST | STRING_CONST | CHAR_CONST | BOOL_CONST
                if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP ))
                {
                    if ( keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP))
                    {
                    }
                    else if ( keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP))
                    {
                    }
                    else if ( keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP))
                    {
                    }
                    else if ( keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP))
                    {
                    }
                    else if ( keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP))
                    {
                        
                    }
                    index++;
               
                    return true;
                }
            }
            return false;
        }


 public boolean F2(){
     //FIRST(<F2>) = { ID, INT_CONST , FLOAT_CONST , STRING_CONST , CHAR_CONST , BOOL_CONST , Null }
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP)
       )
            {
                //<F2>  <Exp> <X> | Null
                if (Exp())
                {
                   if(X())
                    {
                        return true;
                    }
                }
            }
                ////FOLLOW(<F2>) = { ?}
             
            else if ("?".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                return true;
            }
            return false;
        }
 
 public  boolean X()
        {
           
            //FIRST(<X>) = { , , Null}
            if (",".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<X>  , <Exp> <X> | Null
                index++;
                if (Exp())
                {
                   
                    if (X())
                    {
                        return true;
                    }
                }
            }

            ////FOLLOW(<X>) = { ? }
            
            else if ("?".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                return true;
            }
            return false;
        }

        
    
 
    
    public boolean Condition_for(){
                keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
        
        if(ID_const()){
        if("Relational Operator".equals(validator.checking_operator)){
        if(ID_const()){
        return true;
        }
        }
        }
        
        return false;}

    public boolean ID_const(){
    if(keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).CP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).CP))
    {
        return true;
    }
    
    return false;}
    
     private boolean F1()
        {
            //FIRST(<F1>) = {DT , ID , Null}
            if ( keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP ) ||
           LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)))
            {
                //<F1>  <DEC> |ID <Assign_Op> | Null
                if (DEC())
                {
                    return true;
                }
                else if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP ))
                {
                   index++;
                    if (Assign_Op())
                    {
                         return true;
                    }
                }
            }
            //FOLLOW(<F1>) = { ?}
            else if ("?".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                index++;
              return true;
            }
             return false;
        }
     public boolean assignment_(){
                keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
           
           
            //FIRST(<Assign_Op>) = { : }
            if ("Assignment Operator".equals(validator. checking_operator))
            {
                //<Assign_Op> AOP <Assign_Op2>	
                if ("Assignment Operator".equals(validator. checking_operator))
                {  index++;
                    if (Id_Const())
                    {
                        return true;
                    }
                }
            }
           return false;
        }
public boolean Id_Const()
{if(keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).CP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).CP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).CP)
           ){
    index++;
    if(";".equals(LexicalAnalyzer.tokens.get(index).CP))
    index++;
        return true;
   
   
   }
return false;
}
     
     
private boolean DEC()
        {
           
            
            //FIRST(<DEC>) = { DT}
            if (LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)))
            {
                //<DEC>  DT <Variable_Link>
                if (LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)))
                {
                    index++;
                    if (Variable_Link())
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean Variable_Link()
        {
          
            
            //FIRST(<Variable_Link>) = {ID} 
            if ( keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Variable_Link>  ID <Varaiable_Link2>
                if ( keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (Variable_Link2())
                    {
                        
                         return true;
                    }
                }
            }
           return false;
        }

            private boolean Variable_Value()
        {
            if (keywords.Validate_Char(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_Float(LexicalAnalyzer.tokens.get(index).VP) ||
        keywords.Validate_String(LexicalAnalyzer.tokens.get(index).VP)  ||
        keywords.Validate_Int(LexicalAnalyzer.tokens.get(index).VP)   ||
           keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).VP) ||
           keywords.Validate_bool(LexicalAnalyzer.tokens.get(index).VP)||
                   keywords.Validata_IncDec(LexicalAnalyzer.tokens.get(index).VP) ||
                keywords.Validate_not(LexicalAnalyzer.tokens.get(index).VP)||
                "(".equals(LexicalAnalyzer.tokens.get(index).VP )
        )
            {
                //<Variable_Value>   <Exp><LIST>  	
                if (Exp())
                {
                  
                    if (LIST())
                    {
                        return true;
                         }
                }
            }
           return false;
           }
   

    private boolean LIST()
        {
            //FIRST(<LIST >) = {, , \\r}
            if (",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                    "?".equals(LexicalAnalyzer.tokens.get(index).VP) ||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP) )
            {
                //<LIST >  , ID <Variable_Link2> | \\r | ?
                if (",".equals(LexicalAnalyzer.tokens.get(index).CP)) {
                    
                    //semanticAnalyzer.insertVariables(N, T, semanticAnalyzer.currentScope());
                    index++;

                    if ( keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP ))
                    {
                        index++;
                        if (Variable_Link2())
                        {
                             return true;
                        }
                    }
                }
                else if ( "\\r".equals(LexicalAnalyzer.tokens.get(index).VP) )
                {
                    index++;
                    return true;
                }
                
                else if ( "?".equals(LexicalAnalyzer.tokens.get(index).VP) )
                {
                    index++;
                    return true;
                }
            }
           return false;
        }
     private boolean Variable_Link2()
        {
                           keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
      
                           if (",".equals(LexicalAnalyzer.tokens.get(index).CP)||
                    "\\r".equals(LexicalAnalyzer.tokens.get(index).VP)||
                    "Assignment Operator".equals(validator. checking_operator));
                    {
                //<Variable_Link2>  :<Variable_Value>| <LIST>
                //<Variable_Link2>  :<Value_Method>| <LIST>
               
                        if ("Assignment Operator".equals(validator. checking_operator))
                {
                    index++;
                    if (Variable_Value())
                    {
                        return true;
                    }
                }
                else if (LIST())
                {
                    return true;
                }
            }
            return false;
        }

    
    public boolean class_(){
        int a=1;
        if(LexicalAnalyzer.tokens.get(a).CP.equals("a")){
            
       
        
        }
return true;        
        }
    
        private boolean Class_Base()
        {
           
            if ("extends".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                index++;
                if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                   return true;
                }
            }

            else if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                 return true;
            }

            return false;
        }

        private boolean Class_Link()
        {
            
            if ("class".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Class_Link>  class ID <Class_Base><Class_Body>end
                index++;
                if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {

                    index++;
                    if (Class_Base())
                    {
                            if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                            {
                                index++;
                                if (Class_Body())
                                {
                                    
                                  if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
                                { index++;
                              if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                            {
                                index++;
                            }  
 
                                         return true;
                                    }               
//                                    
                                }
                            }
                        }
                    }
                }
            
            

            // 
            return false;
        }

        private boolean Class_Body()
        {
            
            //FIRST(<Class_Body>) = { access_modifier , static , DT ,void ,ID , class  , Null
            if (
                    
                    LexicalAnalyzer.tokens.get(index).CP.equals("Access Modifier") ||
              LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
                 "void".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP)||  
               "class".equals(LexicalAnalyzer.tokens.get(index).CP)
                    ) {
                //<Class_Body>  <Class_Member> <Class_Body> | Null
                if (Class_Member())
                {
                    if (Class_Body())
                    {
                        return true;
                    }
                }
            }

            //FOLLOW(<Class_Body>) = { end }
            else if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
              return true;
            }
            System.out.println(index);
System.out.println(""+LexicalAnalyzer.tokens.get(index).CP);
            
           return false;
        }

        private boolean Class_Member()
        {
                     
            //FIRST(<Class_ Member >) = { access_modifier , static , DT ,void ,ID , class }
            if (    LexicalAnalyzer.tokens.get(index).CP.equals("Access Modifier") ||
              LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
                 "void".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP)||  
               "class".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "null".equals(LexicalAnalyzer.tokens.get(index).CP))            {
                if (Access_Modifier())
                {
                    if (Member_Link())
                    {
                        return true;
                    }
                }
            }
             return false;
        }
        
        public boolean validateCFG(){
            if(Start()){
            if(LexicalAnalyzer.tokens.get(index).CP.equals("$")){
            return true;
            }
            
            }
            
            
            return false;
        
        }
        public boolean Start()
        {
            
            //FIRST(<Class_Dec>) = { access_modifier, class}
            if (LexicalAnalyzer.tokens.get(index).CP.equals("Access Modifier") ||
               "class".equals(LexicalAnalyzer.tokens.get(index).CP)  )
            {

                //<Class_Dec>   <Access_Modifier><Class_Link><secondclass>
                if (Access_Modifier())
                {
                    if (Class_Link())
                    {
                        if(secondclass()){
                         return true;
                        }
                    }
                }
            }
            // 
          return false;
        }
        private boolean secondclass(){
    if(LexicalAnalyzer.tokens.get(index).CP.equals("Access Modifier") ||
               "class".equals(LexicalAnalyzer.tokens.get(index).CP) ){
        if(Start()){
            return true;}
    
    }
    else if(LexicalAnalyzer.tokens.get(index).CP.equals("$")
            ){
        
        return true;}
 
    return false;  
}

        private boolean Access_Modifier()
        {
            
            //FIRST(<Access_Modifier>) = { access_modifier, Null}
            if (LexicalAnalyzer.tokens.get(index).CP.equals("Access Modifier") )
            {
                //<Access_Modifier>  access_modifier | Null
                if (LexicalAnalyzer.tokens.get(index).CP.equals("Access Modifier") )
                {
                    index++;
                    return true;
                }
            }

            //FOLLOW(<Access_Modifier>) = { class , DT ,void ,ID  }
            else if ( LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
                 "void".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP)||  
               "class".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
              return true;
            }

         return false;
        }


        private boolean Member_Link()
        {
           
            if (  "static".equals(LexicalAnalyzer.tokens.get(index).CP) ||
              LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
                 "void".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP)||  
               "class".equals(LexicalAnalyzer.tokens.get(index).CP) )
            {
                    if (SS_A())
                    {
                        return true;
                    
                }

                else if ("void".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                        if (Method_Link3())
                        {
                            return true;
                        }
                    }
                }

                else if (LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)))
                {
                    index++;
                    if (DT_2())
                    {
                        return true;
                    }
                }

                else if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                   

                    index++;
                    if (Object_Constructor_Dec())
                    {
                         return true;
                    }
                }
            }
            return false;
        }
        

        private boolean Object_Constructor_Dec()
        {
           
            ////FIRST(<Object_Constructor_DEC>) = { ID, [ , (}
            if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                "[".equals(LexicalAnalyzer.tokens.get(index).CP)||
                    "(".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Object_Constructor_DEC>   <Constructor_DEC>
               if(Constructor_DEC())
                {
                  return true;
                }
            }
          return false;
        }

        private boolean DT_2()
        {
            //FIRST(<DT_2>) = {ID , [}
            if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP)||
               "[".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<DT_2> ID <ID_1>|< Array_DEC>
                if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {

                    index++;
                    if (ID_1())
                    {
                       return true;
                    }
                }

                else if (Array_DEC())
                {
                     return true;
                }
            }
            return false;
        }

        private boolean ID_1()
        {
           
              keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
          
            //FIRST(<ID_1>) = {( , AOP , , , \\r }
            if( "(".equals(LexicalAnalyzer.tokens.get(index).CP) ||
             "Assignment Operator".equals(validator. checking_operator) ||
                ",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                ";".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<ID_1><Varaiable_Link2> | <Method_Link 3>
                if (Variable_Link2())
                {
                    return true;
                }
                else if (Method_Link3())
                {
                   return true;
                }
            }
           return false;
        }

        public boolean SS_A()
        {
            System.out.println("token index:"+LexicalAnalyzer.tokens.get(index).CP);
            if (   LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) ||
                 "void".equals(LexicalAnalyzer.tokens.get(index).CP) ||
               keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))         {
                //<SS_A>   DT <DT_1> |ID <Id_OArray> |void ID<Method_Link3> 
                if (LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)))
                {
                    index++;
                    if (DT_1())
                    {
                         return true;
                    }
                }
                else if ("void".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                    {
                        index++;
                        if (Method_Link3())
                        {
                           return true;
                        }
                    }
                }
//                else if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
//                {
//                
//                    if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
//                    {
//                        index++;
//                        if (Method_Link3())
//                        {
//                           return true;
//                        }
//                    }
//                }
            }

          return false;
        }

        private boolean DT_1()
       {
           
            //FIRST(<DT_1>) = {ID , [}
            if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP) ||
                "[".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<DT_1>  ID <ID_2>| <Array_DEC>
                if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (ID_2())
                    {
                        return true;
                    }
                }
                else if (Array_DEC())
                {
                    System.out.println("in Array Dec"+index);
                   return true;
                }
            }
            return false;
        }

        private boolean ID_2()
        {
           keywords.Validate_Operator(LexicalAnalyzer.tokens.get(index).VP);
            System.out.println(validator. checking_operator);
      //FIRST(<ID_2>) = {( , AOP , , , \\r }
            if ("(".equals(LexicalAnalyzer.tokens.get(index).CP)||  
                    "Assignment Operator".equals(validator. checking_operator) ||
",".equals(LexicalAnalyzer.tokens.get(index).CP) ||
                "\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                //<ID_2>  <Method_Link3> | <Variable_Link2>
                if (Method_Link3())
                {
                    return true;
                }
                else if (Variable_Link2())
                {
                  return true;
                }
            }
           return false;
        }
private boolean Method_Link3()
        {
            
            //FIRST(<Method_Link 3>) = { ( }
            if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Method_Link 3>   (<List_Param>)\\r <M_St>end\\r 
                if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    
                    index++;

                    if (List_Param())
                    {
                        if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
                        {
                            
                            index++;
                           
                            
                            if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                            {
                                index++;
                              if (M_ST())
                                {
                                  if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
                                    {
                                        index++;
                                        if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                                    {index++;
                                  
                                        return true;
                                    } 
                                    }
                                }
                              return true;
                            }                            
                        }
                    }
                }
            }
           return false;
        }
private boolean List_Param()
        {
        
            
            //FIRST(<List_Param>) = {DT , Null}
            if ( LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) )
            {
                //<List_Param>  DT ID <List_Param1> | Null
                if ( LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) )
                {
                    index++;
                    if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                    {index++;//during SA
                        if (List_Param1())
                        {
                            return true;
                        }
                    }
                }
            }
            //FOLLOW(<List_Param>) = { ) }
            else if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                return true;
            }
            return false;
        }

        private boolean List_Param1()
        {
          
            
            //FIRST(<List_Param>) = {DT , Null}
            if (",".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<List_Param> , DT ID <List_Param1> | Null
                if (",".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if ( LexicalAnalyzer.tokens.get(index).CP.equals(dataType(LexicalAnalyzer.tokens.get(index).VP)) )
                    {
                        index++;
                        if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                        {
                            index++;
                            if (List_Param1())
                            {
                               return true;
                            }
                        }
                    }
                }
            }
            //FOLLOW(<List_Param>) = { ) }//
            else if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
              return true;
            }
            return false;
        }


        private boolean Constructor_DEC()
        {
           
            //FIRST(<Constructor_DEC>) = {ID}
            //FIRST(<Constructor_DEC>) = { ( }
            if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Constructor_DEC>   ID (<List_Param>) <M-St>end
                //<Constructor_DEC> (<List_Param>) {<M-St>}
                if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (List_Param())
                    {
                        if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
                        {
                            index++;
                           
                       if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                            {
                                index++;
                                
                                //string MT = "";
                                if (M_ST())
                                {
                                    if ("end".equals(LexicalAnalyzer.tokens.get(index).CP))
                                    {
                                        index++;
                                    if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                                    {
                                        index++;
                                        return true;
                                    }
                                }
                            
                        }
                            }
                        }
                    }
                    
                }

            }
          return false;
        }
private boolean Array_DEC()
        {
          
            //FIRST(<Array_DEC>) = {[}
            if ("[".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Array_DEC>   [] ID <INIT_Array>
                if ("[".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
    System.out.println("in DEC:"+index);
                   
                    index++;
                    if ("]".equals(LexicalAnalyzer.tokens.get(index).CP))
                    {
                       
                        index++;
                        if (keywords.Validate_Identifire_SA(LexicalAnalyzer.tokens.get(index).CP))
                        {
                            index++;
                         
                            if (INIT_Array())
                            {
                                return true;
                            }
                        }
                    }
                }
            }
           return false;
        }
 private boolean INIT_Array()
        {
            //FIRST(<INIT_Array>) = {\\r , :}
            if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP) ||
               ":".equals(LexicalAnalyzer.tokens.get(index).VP))
            {
                //<INIT_Array>  \\r | :[<ID_Const>]<INIT_Array>
                if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                     return true;
                }
                else if (":".equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    System.out.println(""+index);
                    index++;
                            if ("[".equals(LexicalAnalyzer.tokens.get(index).CP))
                            {
                               
                                index++;
                                if (Array_const())
                                {
                                    if ("]".equals(LexicalAnalyzer.tokens.get(index).CP))
                                    {
                                       index++;
                                       if(INIT_Array())
                                           return true;
                                        }
                                    
                        }
                    }
                }
            }
           return false;
        }

    
        private boolean Array_const()
        {
            //FIRST(<Array_const>) = {{ , ;}
            if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Array_const>  <Array_C> | \\r
                if ("\\r".equals(LexicalAnalyzer.tokens.get(index).VP))
                {
                    index++;
                   return true;
                }
                else if (Array_C())
                {
                    return true;
                }
            }
              else if ("]".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                index++;
              return true;
            }
            return false;
        }

        private boolean Array_C()
        {
           
            // FIRST(<Array_C>) = { ( }
            if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Array_C>  { <Const> <Array_C2>
                //<Array_C>{ <Exp><Array_C2>
                if ("(".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (Exp())
                    {
                       
                        if (Array_C2())
                        {
                             return true;
                        }
                    }
                }
            }
            
              else if ("]".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
              return true;
            }
         return false;
        }

        private boolean Array_C2()
        {
            //FIRST(<Array_C2>) = {, , ) }
            if (")".equals(LexicalAnalyzer.tokens.get(index).CP)||
                ",".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
                //<Array_C2>  , <Const> | } ;
                //<Array_C2> , <Exp> | } \\r
                if (")".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    
                    index++;
                    return true;
                }
                else if (",".equals(LexicalAnalyzer.tokens.get(index).CP))
                {
                    index++;
                    if (Exp())
                    {
                        
                        if (Array_C2())
                        {
                             return true;
                        }
                    }
                }
            }
            
              else if ("]".equals(LexicalAnalyzer.tokens.get(index).CP))
            {
              return true;
            }
            return false;
        }

 
}
