package pro102;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class udpate_degree extends JPanel implements ActionListener {

    Color r = new Color(64, 224, 208);
    JLabel m1, m2, m3, m4, m5, m6, ide;
    JTextField t1, t2, t3, t4, t5, t6, id;
    JButton serch_id, update_deg;
    ArrayList<domain.dig> arr;

    public udpate_degree() {
        this.setBackground(r);
        this.setLayout(null);
        ide = new JLabel("enatr id:");
        m1 = new JLabel("AI205:");
        m2 = new JLabel("IT102:");
        m3 = new JLabel("IS101:");
        m4 = new JLabel("IM180:");
        m5 = new JLabel("ML105:");
        m6 = new JLabel("CS205:");
        ide.setBounds(60, 20, 100, 25);
        m1.setBounds(60, 50, 50, 25);
        m2.setBounds(60, 80, 50, 25);
        m3.setBounds(60, 110, 50, 25);
        m4.setBounds(60, 140, 50, 25);
        m5.setBounds(60, 175, 50, 25);
        m6.setBounds(60, 210, 50, 25);
        add(m1);
        add(m2);
        add(m3);
        add(m4);
        add(m5);
        add(m6);
        add(ide);
        //text set
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        id = new JTextField();
        id.setBounds(115, 20, 50, 25);
        t1.setBounds(115, 50, 50, 25);
        t2.setBounds(115, 80, 50, 25);
        t3.setBounds(115, 110, 50, 25);
        t4.setBounds(115, 140, 50, 25);
        t5.setBounds(115, 175, 50, 25);
        t6.setBounds(115, 210, 50, 25);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(id);
        //end text set
        serch_id = new JButton("serch");
        serch_id.setBounds(180, 20, 80, 20);
        serch_id.addActionListener(this);
        add(serch_id);
        update_deg = new JButton("upgreed digree");
        update_deg.setBounds(100, 245, 120, 20);
        update_deg.addActionListener(this);
        add(update_deg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == serch_id) {
           
            arr=database.degree_data.get_student(Integer.parseInt(id.getText()));
            int r=Integer.parseInt(id.getText());
            try{
t1.setText(""+arr.get(0).getM1());
t2.setText(""+arr.get(0).getM2());
t3.setText(""+arr.get(0).getM3());
t4.setText(""+arr.get(0).getM4());
t5.setText(""+arr.get(0).getM5());
t6.setText(""+arr.get(0).getM6());
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "id not found","erroe",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource()==update_deg)
        {
            try 
            {
            database.degree_data.update_student(Integer.parseInt(id.getText()),Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
             JOptionPane.showMessageDialog(null,"done","ok",JOptionPane.INFORMATION_MESSAGE);
             t1.setText(null);
              t2.setText(null);
               t3.setText(null);
                t4.setText(null);
                 t5.setText(null);
                  t6.setText(null);
                   id.setText(null);
            
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,  ex.getMessage(),"erroe",JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}
