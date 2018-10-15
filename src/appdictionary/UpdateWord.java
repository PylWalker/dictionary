/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdictionary;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class UpdateWord {
    public int updateWord(String spelling,String explain){
        int tmp = 0;
        try {
            Connection connection = ConnectionUtils.getMyConnection();
            Statement statement = connection.createStatement();
            String sql = "UPDATE tbl_edict SET spelling = '"+spelling+"',`explain` = '"+explain+"' WHERE spelling = '"+spelling+"'";
            System.out.println(sql);
            tmp = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
}
