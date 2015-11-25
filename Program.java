//package csm10j.lab13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Michelle
 */
public class Program extends JFrame implements MouseListener
{
    Integer numberofCircles = 0;
    Container pane;

    public static void main(String[] args)
    {   
      Program p = new Program();
      p.setup();
      p.setSize(400, 400);  
      p.mouseClicked(null); 
    }
    
    public void setup()
    {
        this.setTitle("Click me!");
        pane = getContentPane();
        pane.addMouseListener(this);
    }
    
    public void mouseClicked(MouseEvent event)
    {
        boolean flag = true;
        Integer numofCircles = 0;
        while(flag)
        {
            String input = JOptionPane.showInputDialog(null, "Enter number of ovals between 1-20", "Input Oval Number",
                JOptionPane.PLAIN_MESSAGE);
        
            try
            {
                numofCircles = Integer.parseInt(input);
                
                if (numofCircles > 20)
                    numofCircles = 20;

                flag = !(numofCircles >= 0 && numofCircles <= 20);
            }
            catch(Exception ex)
            {
                        
            }
        }
        
        numberofCircles = numofCircles;
        this.setVisible(false);
        pane.add(new DrawingPanel());
        this.setVisible(true);
    }
    
    @Override
    public void mousePressed(MouseEvent e) 
    {  
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
    }
    
    public class DrawingPanel extends JPanel
    {
        @Override
        public void paint(Graphics g)
        {   int x = 5;
            int y = 5;
            int height =80;
            int width = 140;
            g.setColor(Color.red);
            
            for (int i = 0; i < numberofCircles; i++)
                g.drawOval(x += 10, y += 10, height += 20, width += 30);
        }
    }
}
