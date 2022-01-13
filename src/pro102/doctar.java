package pro102;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

public class doctar extends JFrame {

    static String dap;
    JTabbedPane tab;
    update_student s1;
    udpate_degree d2;
    add a1;
    degree d1;
    print_degree degr;

    public doctar(String dap) {

        this.dap = dap;

    }
    /*public doctar() 
     {
          
     }*/

    public void show_doctorS() {
Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aboud Mahmoud\\Desktop\\work place\\photos\\tr.png");
        a1 = new add();
        this.setIconImage(icon);
        d1 = new degree(this.dap);
        tab = new JTabbedPane();
        degr = new print_degree();
        s1 = new update_student();
        d2 = new udpate_degree();
        this.setTitle("Doctor control");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        tab.addTab("student", a1);
        tab.addTab("dagree", d1);
        tab.addTab("show_dagree", degr);
        tab.addTab("edit student", s1);
        tab.addTab("edit degree", d2);
        Color c = new Color(186, 85, 211);
        tab.setBackground(c);
        this.add(tab);
        this.setVisible(true);
    }

}
