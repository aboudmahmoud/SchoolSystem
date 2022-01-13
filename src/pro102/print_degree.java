
package pro102;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class print_degree extends JPanel implements ActionListener {
JTable table; 
JScrollPane sc;
String hader[] = {"id","Frist name","Scenod name", "deparment","degree"}; 
String data[][]; 
JButton printe; 
    ArrayList<domain.student_table> arr;
    public print_degree()
    {
        Color cr = new Color(245,255,250);
        this.setLayout(null);
        show_deg();
        this.setBackground(cr);
    }
       public void show_deg()
    {
           
           arr=database.student_data.get_student_degree();
     data=new String[arr.size()][5];
     for(int i=0 ; i<arr.size(); i++)
     {
         data[i][0]=""+arr.get(i).getId();
         data[i][1]=arr.get(i).getFname();
          data[i][2]=arr.get(i).getLname();
          data[i][4]=arr.get(i).getDep();
          data[i][3]=arr.get(i).getAder();// here will not get adders but will get sum of dgree
     }
     table =new JTable(data,hader);
    
     sc= new JScrollPane(table); 
      Color c = new Color (221,160,221);
     table.setBackground(c);
     sc.setBounds(0, 0, 350, 320);
     add(sc);
    
    printe= new JButton("print degree");
    
    Color color = new Color(255,248,220);
   printe.setBackground(color);
   Color tr = new Color(188,143,143);
    printe.setForeground(tr);
    printe.setBounds(350, 80 ,120, 20);
    printe.addActionListener(this);
    add(printe);
     //align table
     ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
             .setHorizontalAlignment((int)JLabel.CENTER_ALIGNMENT);
     DefaultTableCellRenderer v = new DefaultTableCellRenderer();
     v.setHorizontalAlignment(JLabel.CENTER);
     table.getColumnModel().getColumn(0).setCellRenderer(v);
     for( int i=0 ; i<table.getColumnCount();i++)
     {
         table.getColumnModel().getColumn(i).setCellRenderer(v);
     }

    //end alignn table
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MessageFormat h= new MessageFormat("student data");
           MessageFormat f =new MessageFormat("page{1}");
           try {
               table.print(JTable.PrintMode.NORMAL,h,f); 
           }
           catch (Exception ee)
           {
               System.out.println("error man !");
           }
    }
    
}
