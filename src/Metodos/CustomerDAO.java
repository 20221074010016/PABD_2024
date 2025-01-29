package Metodos;

import java.sql.*;

public class CustomerDAO {

    private Connection con;

    public CustomerDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
        System.out.println("Connection OK");
    }

    public void insertCustomer(Customer c) throws SQLException {
        String sql = "insert into customer"
                + "(store_id, first_name, last_name, email, address_id, active)"
                + "values"
                + "(?,? ,? ,? ,? ,?) ";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());

        pst.execute();
        pst.close();

        System.out.println("Insert OK");
    }

    public void deleteCustomer(int id) throws SQLException {

        String delet = "delete from customer "
                + "where customer_id = ? ;";

        PreparedStatement smt = con.prepareStatement(delet);

        smt.setInt(1, id);

        smt.execute();
        smt.close();

    }

    public void updateCustomer(int customerId, String column, Object value) throws SQLException {

        if (column == null || column.isEmpty()) {
            throw new IllegalArgumentException("O nome da coluna não pode ser vazio");
        }

        String up = "UPDATE customer SET " + column + " = ? WHERE customer_id = ?";

        PreparedStatement smt = con.prepareStatement(up);

        smt.setObject(1, value);
        smt.setInt(2, customerId);

        smt.executeUpdate();
        smt.close();
    }

    public void showCustomer() throws SQLException {
        Statement st = con.createStatement();

        String query = "select * from customer order by customer_id desc  limit 10 ";

        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData md = rs.getMetaData();

        int col = md.getColumnCount();

        System.out.println("Table, " + md.getTableName(1));

        for (int i = 1; i <= col; i++) {

            System.out.print(md.getColumnName(i) + "\t");
        }

        System.out.println();

        while (rs.next()) {

            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");

            }

            System.out.println();
        }

        st.close();

    }
}
