/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.Function;

import dictionary.Apps.DictionaryApp;
import dictionary.ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import dictionary.Function.EditStr;
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
            EditStr es = new EditStr();
            spelling = es.editStr3(spelling);
            String sql = "SELECT word.explain FROM word WHERE word.spelling = '"+spelling+"'";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                tmp = es.editStr(rs.getString("explain"),spelling);
            } else{
                tmp = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
}
