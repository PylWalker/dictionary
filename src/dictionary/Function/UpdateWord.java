/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.Function;

import dictionary.Apps.DictionaryApp;
import dictionary.ConnectDB.ConnectionUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import dictionary.Function.EditStr;

/**
 *
 * @author chinh
 */
public class UpdateWord {
    public int updateWord(String spellingOld,String spellingNew,String explainNew){
        int tmp = 0;
        try {
            Connection connection = ConnectionUtils.getMyConnection();
            Statement statement = connection.createStatement();
            EditStr es = new EditStr();
            explainNew = es.editStr2(explainNew);
            String sql = "UPDATE word SET spelling = '"+spellingNew+"',`explain` = '"+explainNew+"' WHERE spelling = '"+spellingOld+"'";
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
