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
  public class  tokenSet {
String CP;//class part
String VP;//value part
int line;

    public tokenSet() {
    }

    public tokenSet(String CP, String VP, int line) {
        this.CP = CP;
        this.VP = VP;
        this.line = line;
    }
    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getVP() {
        return VP;
    }

    public void setVP(String VP) {
        this.VP = VP;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
public static void addToken(String CP,String VP,int line){
//        this.CP = CP;
//        this.VP = VP;
//        this.line = line;


}
    

}
