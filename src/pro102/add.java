
package pro102;

import database.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class add extends JPanel implements ActionListener{
    JLabel fname,lname,adde,dap;
    JTextField fristname,lastname,addr,dapr;
    JButton send;
    public add() 
    {
        this.setLayout(null);
        Color c=new Color(255,182,193);
        this.setBackground(c);
        //label set//
        fname= new JLabel("frsti name");
        lname= new JLabel("last name");
       adde= new JLabel("adders");
       dap= new JLabel("dapmermnt");
       fname.setBounds(50, 50, 80, 25);
       lname.setBounds(50, 80, 80, 25);
       adde.setBounds(50, 110, 80, 25);
       dap.setBounds(50, 140, 80, 25);
       this.add(fname);this.add(lname);this.add(adde);this.add(dap);
        //label finsh set//
       
       // field set  // 
       fristname= new JTextField(); 
       lastname= new JTextField(); 
       addr= new JTextField(); 
       dapr= new JTextField(); 
       fristname.setBounds(150, 50, 120, 20);
       lastname.setBounds(150, 80, 120, 20);
       addr.setBounds(150, 110, 120, 20);
       dapr.setBounds(150, 140, 120, 20);
       this.add(fristname);this.add(lastname);this.add(addr);this.add(dapr);
         // field  finsh set  //  
       
       //button set// 
       send = new JButton("send"); 
       send.setBounds(120, 200, 80, 20);
       this.add(send);
       send.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource()==send)
        {
            
          student_data.insert_student(fristname.getText(), lastname.getText(),addr.getText(),dapr.getText());
          fristname.setText("");addr.setText("");lastname.setText("");dapr.setText("");
          JOptionPane.showMessageDialog(this,"done","add messge",JOptionPane.INFORMATION_MESSAGE);
           
        }
    }
}
