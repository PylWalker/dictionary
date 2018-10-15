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
public class DeleteWord {
    public int deleteWord(String spelling){
        int tmp = 0;
        try {
            Connection connection = ConnectionUtils.getMyConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM tbl_edict WHERE spelling = '"+spelling+"'";
            tmp = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DictionaryApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
}
