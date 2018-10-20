/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.Function;

/**
 *
 * @author chinh
 */
public class EditStr {
    public String editStr(String str,String str2){
        str = str.replace("</Q></N></I></F></C>","");
        while(str.contains("<br />"))
            str = str.replace("<br />","\n");
        while(str.contains("="))
            str = str.replace("=","Eg: ");
        while(str.contains("+"))
            str = str.replace("+",":");
        while(str.contains("@"))
            str = str.replace("@","<->");
        while(str.contains("&lt"))
            str = str.replace("&lt;","<");
        while(str.contains("&gt;"))
            str = str.replace("&gt;",">");
        while(str.contains("<C><F><I>"))
            str = str.substring(18+str2.length());
        while(str.contains("daunhay"))
            str = str.replace("daunhay", "'");
        return str;
    }
    
    public String editStr2(String str){
        while(str.contains("'"))
            str = str.replace("'", "daunhay");
        return str;
    }
    
    public String editStr3(String str){
        if(str.contains("'"))
            str = str.replace("'", "\\\'");
        return str;
    }
}
