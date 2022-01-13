
package pro102;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class img extends JPanel{
    private ImageIcon i;
    public img ()
    {
        this.setLayout(null);
        
    }
@Override
  public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        // to go back do .. two ponts and "\\ " to name_file"\\"to name_img 
        i=new ImageIcon(getClass().getResource("..\\img\\ii.jpg"));
        i.paintIcon(this, g, 0, 0);
    }
    
}
