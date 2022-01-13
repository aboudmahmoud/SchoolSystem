package pro102;

//import database.user_data;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class FScreen extends JFrame implements ActionListener, KeyListener {

    img ima = new img();
    JLabel user, bass;
    JTextField usr;
    JPasswordField pss;
    JButton log_in, sign_in;

    public FScreen() {
        Show_fscren();
       

    }

    public void Show_fscren() {
        setTitle("centar of student");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 760);
        setResizable(true);
        // label satup
        user = new JLabel("usre name:");
        bass = new JLabel("bassword:");
        user.setBounds(100, 70, 80, 25);
        bass.setBounds(100, 100, 80, 25);
        user.setForeground(Color.red);
        bass.setForeground(Color.red);
        ima.add(user);
        ima.add(bass);
         // end label satup 
        // field area setup
        usr = new JTextField();
        pss = new JPasswordField();
        usr.setBounds(190, 70, 180, 20);
        pss.setBounds(190, 100, 180, 20);
        ima.add(usr);
        ima.add(pss);
         //endl area setup        
        //sing  setup 

        log_in = new JButton("log in ");
        sign_in = new JButton("sign in");
        log_in.setBounds(120, 140, 80, 20);
        sign_in.setBounds(210, 140, 80, 20);
        sign_in.addActionListener(this);
        log_in.addActionListener(this);
        ima.add(log_in);
        ima.add(sign_in);
        addKeyListener(this);//importn of key 1
        setFocusable(true);//importn of key 2
        setFocusTraversalKeysEnabled(true);//importn of key 3
        //end sing  setup 
        add(ima);
        setVisible(true);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sign_in) {
            this.dispose();
            new ScenodScreend();
        }
        if (e.getSource() == log_in) {
            checklog();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_ENTER) {

            checklog();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void checklog() {
        int i = database.user_data.check_user(usr.getText(), pss.getText());
        if (i == 1) {
            JOptionPane.showMessageDialog(this, " hello " + usr.getText());
            this.dispose();

          
            
            new doctar(database.user_data.getDap(usr.getText())).show_doctorS();

        } else if (i == 2) {
            JOptionPane.showMessageDialog(this, "password is worng");
        } else if (i == 0) {
            JOptionPane.showMessageDialog(this, "usrname is not exsit");
        }
    }
}
