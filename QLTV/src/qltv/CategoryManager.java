/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ADMIN
 */
public class CategoryManager {
    private Connection conn;
    ArrayList<Category> list = new ArrayList<>();

    public CategoryManager(Connection conn) {
        this.conn = BConnection.getConnection();
        if(this.conn == null){
            System.out.println("Connection failed!");
        }else{
            System.out.println("Connection success!");
        }
    }
    
    public DefaultComboBoxModel getCategory(){
        list.clear();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        
        try{
            String sql = "Select * from Categories";
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category s = new Category(rs.getInt("id"), rs.getString("name"));
                list.add(s);
                dcbm.addElement(s);
            }
        }catch(SQLException e){
            Logger.getLogger(BConnection.class.getName()).log(Level.SEVERE,null,e);
        }
        return dcbm;
    }
    
    
}
