/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app_pdbd;

import java.sql.*;

/**
 *
 * @author 20221074010016
 */
public class App_pdbd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Customer c = new Customer(2, "Pedro", "Rocha", "Pedro.rocha@gmail.com", 12, 1);
        
        CustomerDAO dao = new CustomerDAO();
       
        dao.insertCustomer(c);
        
        dao.deleteCustomer(619);
        
        dao.updateCustomer(620, "first_name", "joao");
        
        dao.showCustomer();

    }
}
