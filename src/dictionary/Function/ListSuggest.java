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
import javax.swing.DefaultListModel;

/**
 *
 * @author chinh
 */
public class ListSuggest {
    public DefaultListModel listSuggest(String spelling){
        DefaultListModel dlm = new DefaultListModel();
        try{
            Connection connection = ConnectionUtils.getMyConnection();
            Statement statement = connection.createStatement();
            EditStr es = new EditStr();
            spelling = es.editStr3(spelling);
            String sql = "SELECT word.spelling FROM word WHERE spelling like '"+spelling+"%' order by word.spelling asc limit 20";
            System.out.println(spelling);
            ResultSet rs = statement.executeQuery(sql);               
            while(rs.next()){
                String wordSpelling = rs.getString("spelling");
                dlm.addElement(wordSpelling);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dlm;
    }
}