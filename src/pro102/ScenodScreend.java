
package pro102;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;


public class ScenodScreend extends JFrame implements ActionListener {
        img ima=new img();
        JLabel usr,dapmernt,pass,note;
        JTextField user = new JTextField(); 
         JTextField dap = new JTextField(""); 
         JPasswordField pss= new JPasswordField();
         JButton send =new JButton("Regster");
         JButton back =new JButton("back");
         Color r = new Color(152,251,152);
        public ScenodScreend()
        {
            SC_scern();
        }
        public void SC_scern()
        {
              setTitle("sing up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760,760);
        setResizable(true);
        //label part ---//
        usr= new JLabel("username:");
       dapmernt= new JLabel("dapmernt:");
        pass= new JLabel("password:");
        note=new JLabel("only CS , IS , IT");
        usr.setForeground(Color.red);
        usr.setBounds(100,100,80,20);
        pass.setForeground(Color.red);
        pass.setBounds(100, 130, 80, 20);
        dapmernt.setForeground(Color.red);
        dapmernt.setBounds(100, 170, 80, 20);
          note.setForeground(Color.red);
        note.setBounds(340, 170,150,20);
               note.setFont(new Font("bold",Font.BOLD,20));
        ima.add(usr); ima.add(pass); ima.add(dapmernt);  ima.add(note);
           //end label part ---//
        // field part//
        user.setBounds(190, 100, 140, 20);
        pss.setBounds(190, 130, 140, 20);
        dap.setBounds(190, 170, 140, 20);
        ima.add(pss); ima.add(dap);
        ima.add(user);
         // end field part//
        // button part//
        send.setBounds(140, 210, 80, 20);
        send.addActionListener(this);
              back.setBounds(0, 0, 80, 20);
              back.setBackground(r);
              back.addActionListener(this);
        ima.add(send); ima.add(back); 
        // end button part//
        add(ima);
        setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
  if (e.getSource()==back)     
  {
      this.dispose();
      new FScreen();
  }
  if (e.getSource()==send)
  {

      String t1=dap.getText(); 
      if (t1.equalsIgnoreCase("cs")|| t1.equalsIgnoreCase("is")|| t1.equalsIgnoreCase("it"))
      {
      database.user_data.insert_user(user.getText(), pss.getText(), dap.getText());
      user.setText("");
      pss.setText("");
      dap.setText("");
       JOptionPane.showMessageDialog(null, "insert done","note ",JOptionPane.INFORMATION_MESSAGE);
this.dispose();
      new FScreen();
  }
      else 
      {
          JOptionPane.showMessageDialog(null, "dapmernt not exsist","erorr dapmarment",JOptionPane.WARNING_MESSAGE);
      }
      }
   
  
    }

}
