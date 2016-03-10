
/** Minimum Edit Distance Program **
 * Author: Janshar Teja  **
** Date: 11/03/2015 **/
package minEditDistance;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout; 
public class guiScreen extends JPanel
{
	static int h;
	static int w;
	static String s;
	static String b ;
	static int table[][];
    public guiScreen()                       
    {
        super();
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)  
    {
    	Font  f = new Font("Times New Roman", Font.PLAIN, 16);
          g.setFont(f);
          g.setColor(Color.black);
        int width = getWidth();            
        int height = getHeight();           

        super.paintComponent(g);            
        for(int i=0; i<=w; i++){
        	 for(int j=0; j<=h; j++){
             	g.drawRect((i*100)+100,(j*100)+50,100,100);
             	g.drawString(String.valueOf(table[i][j]), (i*100)+150,(j*100)+100);	

             }
        }
        for(int i=0; i<w; i++){
        	g.drawString(b.substring(i,i+1), (i*100)+250, 30);
        	for(int j=0; j<h; j++){
            	g.drawString(s.substring(j,j+1), 70, (j*100)+200);

        	}
        }
        g.setColor(Color.RED);
        g.drawString(String.valueOf(table[w][h]),(w*100)+150,(h*100)+100);
    	g.setColor(Color.black);

       f = new Font("Times New Roman", Font.BOLD, 20);
        g.setFont(f);
        g.drawString("Minimum Edit Distance = "+table[w][h],(w*100)+250,(h*50)+100);

        
        
      

    }

    public static void main(String[] args)
    {
         b = JOptionPane.showInputDialog("Enter String:");
         s = JOptionPane.showInputDialog("Enter String to compare to:");
        getDistance dist = new getDistance();
       dist.getInput(s, b);
       dist.populateTable();
       w = b.length();
       h = s.length();
       table= dist.table;
     

        guiScreen panel = new guiScreen();                           
        JFrame application = new JFrame();                            
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                           
        application.add(panel);           


        application.setSize((w*100)+500, (w*100)+400);         
        application.setVisible(true);          
    
       
    }

}