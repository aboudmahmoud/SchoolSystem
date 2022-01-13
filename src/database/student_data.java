
package database;

import domain.student_table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class student_data {

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:uni.db");
    }

    public static void insert_student(String fname, String lname, String adder, String dap) {
        try (Connection con = connect();
                PreparedStatement p = con.prepareStatement("insert into student (FName,LName,aders,daprment) values(?,?,?,?)");) {

            p.setString(1, fname);
            p.setString(2, lname);
            p.setString(3, adder);
            p.setString(4, dap);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public static ArrayList<student_table> get_student(String dep) {
        ArrayList<student_table> list = new ArrayList<>();
        try (Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from student where daprment=?");){
            

            p.setString(1, dep);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new student_table(r.getInt("id"), r.getString("FName"), r.getString("LName"), r.getString("aders"), r.getString("daprment")));

            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
        return list;
    }

    /* public static void insert_student(String text, String text0, String text1, String text2) {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }*/
     public static ArrayList<student_table> get_student_degree() {
        ArrayList<student_table> list = new ArrayList<>();
        try (Connection con = connect();
            PreparedStatement p = con.prepareStatement("select * from student,dapmernt where dapmernt.id=student.id");){
            

      
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new student_table(r.getInt("id"), r.getString("FName"), r.getString("LName"), ""+r.getString("sum"), r.getString("daprment")));

            }
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
        return list;
    }
public static void update_student(int id , String fname, String lname, String adder, String dap)
{
    try (Connection con = connect();
            PreparedStatement p = con.prepareStatement("update student set FName =? , LName=?,aders=?,daprment=? where id=?");
            )
    {
        p.setString(1, fname);
        p.setString(2, lname);
        p.setString(3,  adder);
        p.setString(4, dap);
        p.setInt(5, id);
           p.execute();
    }
    catch(SQLException ex )
    {
        JOptionPane.showMessageDialog(null, ex,"error",JOptionPane.WARNING_MESSAGE);
    }
    
}
}
