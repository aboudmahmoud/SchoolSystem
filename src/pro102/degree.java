
package pro102;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class degree extends JPanel implements ActionListener{
 JTable table ; 
 static String dap;
   Color c = new Color (224,255,255);
    JScrollPane sc;
    String data[][];
    String headr[]={"id","frist name","last name"};
    JLabel m1,m2,m3,m4,m5,m6;
    JTextField t1,t2,t3,t4,t5,t6;
    int ide;
   String nameid;
    JButton addeg;
    
 ArrayList<domain.student_table>arr;
    public degree (String dap) 
    {
      
        this.dap=dap;
        this.setLayout(null);
      arr=database.student_data.get_student(dap);
        this.setBackground(c);
        show_deg();
    }
    
    public void show_deg()
    {
           
          
     data=new String[arr.size()][3];
     for(int i=0 ; i<arr.size(); i++)
     {
         data[i][0]=""+arr.get(i).getId();
         data[i][1]=arr.get(i).getFname();
          data[i][2]=arr.get(i).getLname();
     }
     table =new JTable(data,headr);
     sc= new JScrollPane(table); 
      Color c = new Color (250,235,215);
     table.setBackground(c);
     sc.setBounds(0, 0, 250, 320);
     add(sc);
     // label set
     m1= new JLabel("AI205:");
     m2= new JLabel("IT102:");
     m3= new JLabel("IS101:");
     m4= new JLabel("IM180:");
     m5= new JLabel("ML105:");
     m6= new JLabel("CS205:");
     m1.setBounds(260,20, 50, 25);
     m2.setBounds(260,50, 50, 25);
     m3.setBounds(260,80, 50, 25);
     m4.setBounds(260,110, 50, 25);
     m5.setBounds(260,140, 50, 25);
     m6.setBounds(260,177, 50, 25);
     add(m1); add(m2); add(m3); add(m4); add(m5); add(m6);
     // label end set
     //text set
     t1=new JTextField();
     t2=new JTextField();
     t3=new JTextField();  
     t4=new JTextField();     
     t5=new JTextField();
     t6=new JTextField();
    t1.setBounds(315,20, 50, 25);
    t2.setBounds(315,50, 50, 25);
    t3.setBounds(315,80, 50, 25);
    t4.setBounds(315,110, 50, 25);
    t5.setBounds(315,140, 50, 25);
    t6.setBounds(315,177, 50, 25);
    add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);
      //end text set
    addeg= new JButton("add degree");
    addeg.setBounds(280, 220, 100, 20);
    Color color = new Color(205,92,92);
    addeg.setBackground(color);
    addeg.setForeground(Color.BLUE);
    addeg.addActionListener(this);
    add(addeg);
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
     table.addMouseListener(new java.awt.event.MouseAdapter() {
 @Override
 public void mouseClicked(java.awt.event.MouseEvent evt)
 {
     ttmouseClicked(evt);
 }
     });
    //end alignn table
    }
    
     private void   ttmouseClicked(java.awt.event.MouseEvent evt)// out of constructer
     {
        // ide=table.getSelectedRow()+1;
         ide=arr.get(table.getSelectedRow()).getId();
         //nameid=arr.get(table.getSelectedRow()).getFname();
        // System.out.println("ok u are in "+table.getSelectedRow());
         
     }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==addeg)
       {
           try{
     database.degree_data.insert_degree(ide, Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()),Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()));
     JOptionPane.showMessageDialog(this, "intsert done","done note",JOptionPane.INFORMATION_MESSAGE);
     t1.setText(null);    t2.setText(null);
         t3.setText(null);     t4.setText(null);
             t5.setText(null);     t6.setText(null);
            }
           catch(Exception ex)
           {
               System.out.println(ex.getMessage());
           }
       }
    }
}