package pro102;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class update_student extends JPanel implements ActionListener {

    JLabel fname, lname, adde, dap, id;
    JTextField fristname, lastname, addr, dapr, ide;
    JButton send;

    public update_student() {
        this.setLayout(null);
        Color c = new Color(255, 182, 193);
        this.setBackground(c);
        //label set//
        id = new JLabel("id student:");
        fname = new JLabel("frsti name");
        lname = new JLabel("last name");
        adde = new JLabel("adders");
        dap = new JLabel("dapmermnt");
        id.setBounds(50, 20, 80, 25);
        fname.setBounds(50, 50, 80, 25);
        lname.setBounds(50, 80, 80, 25);
        adde.setBounds(50, 110, 80, 25);
        dap.setBounds(50, 140, 80, 25);
        this.add(fname);
        this.add(lname);
        this.add(adde);
        this.add(dap);
        this.add(id);
        //label finsh set//

        // field set  // 
        ide = new JTextField();
        fristname = new JTextField();
        lastname = new JTextField();
        addr = new JTextField();
        dapr = new JTextField();
        ide.setBounds(150, 20, 120, 20);
        fristname.setBounds(150, 50, 120, 20);
        lastname.setBounds(150, 80, 120, 20);
        addr.setBounds(150, 110, 120, 20);
        dapr.setBounds(150, 140, 120, 20);
        this.add(fristname);
        this.add(lastname);
        this.add(addr);
        this.add(dapr);
        this.add(ide);
         // field  finsh set  //  

        //button set// 
        send = new JButton("update");
        send.setBounds(120, 200, 120, 20);
        this.add(send);
        send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == send) {
            try {

                database.student_data.update_student(Integer.parseInt(ide.getText()), fristname.getText(), lastname.getText(), addr.getText(), dapr.getText());
                System.out.println("insert done");
                ide.setText(null);
                fristname.setText(null);
                lastname.setText(null);
                addr.setText(null);
                dapr.setText(null);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
