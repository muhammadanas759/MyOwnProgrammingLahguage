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
public class classPart {
String className;
String classValue;

    public classPart(String className, String classValue) {
        this.className = className;
        this.classValue = classValue;
    }

    public classPart() {
    }
    public void setNameValue(String className,String classValue){
    this.className = className;
        this.classValue = classValue;
    
    } 
            

    public String getClassName() {
        return className;
    }

  
    public String getClassValue() {
        return classValue;
    }

  
}
