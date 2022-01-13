package database;

import domain.usertabel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class user_data {

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_user(String user, String pass, String dap) {
        try (Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into user values(?,?,?)");) {

            p.setString(1, user);
            p.setString(2, pass);
            p.setString(3, dap);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public static ArrayList<usertabel> get_user() {
        ArrayList<usertabel> list = new ArrayList<>();
        try (Connection con = connect();
                PreparedStatement p = con.prepareStatement("select * from user");) {

            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new usertabel(r.getString("user_name"), r.getString("password"), r.getString("dapmerment")));
            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
        return list;
    }

    public static int check_user(String user, String pass) {
        ArrayList<usertabel> arr = get_user();
        int x = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getUser_name().equals(user)) {
                if (arr.get(i).getPass().equalsIgnoreCase(pass)) {
                    x = 1;
                    break;
                } else {
                    x = 2;
                    break;
                }
            } else {
                x = 0;
            }

        }
        return x;
    }

    public static String getDap(String user) {

        try (Connection con = connect();
                PreparedStatement ps = con.prepareStatement("select dapmerment from user where user_name=?");) {

            ps.setString(1, user);
            ResultSet r = ps.executeQuery();
            return r.getString("dapmerment");
        } catch (SQLException ex) {

        }
        return null;

    }
}
