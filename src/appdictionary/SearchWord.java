/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdictionary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class SearchWord {
    public String searchWord(String spelling){
        String tmp = null;
        try {
            Connection connection = ConnectionUtils.getMyConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT tbl_edict.explain FROM tbl_edict WHERE tbl_edict.spelling = '"+spelling+"'";
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                EditStr es = new EditStr();
                tmp = es.editStr(rs.getString("explain"),spelling);
            } else{
                if(spelling == ""){
                    //jLbSpelling.setText("");
                    //jLbExplain.setText("");
                } else{
                    //jLbSpelling.setText("My dictionary doesn't have this word");
                    //jLbExplain.setText("");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
}
