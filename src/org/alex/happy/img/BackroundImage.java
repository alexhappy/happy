package org.alex.happy.img;
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 

public class BackroundImage extends JFrame 
{ 
private static final long serialVersionUID = 1L; 
JScrollPane scrollPane; 
ImageIcon icon; 
Image image; 
Robot rb = null; 

public BackroundImage() 
{ 
icon = new ImageIcon("test1.png"); 

JPanel panel = new JPanel() 
{ 

private static final long serialVersionUID = 1L; 

protected void paintComponent(Graphics g) 
{ 
g.drawImage(icon.getImage(), 0, 0, null); 
super.paintComponent(g); 
} 
}; 
panel.setOpaque( false ); 
panel.setPreferredSize( new Dimension(800, 600) ); 
panel.addMouseListener(new MouseAdapter(){ 
public void mouseClicked(MouseEvent e) { 
int x = e.getX(); 
int y = e.getY(); 
//转化成#ffffff格式 
Color c = rb.getPixelColor(x, y); 
String r = Integer.toHexString(c.getRed()); 
String g = Integer.toHexString(c.getGreen()); 
String b = Integer.toHexString(c.getBlue()); 
if(r.length() == 1) r += "0"; 
if(g.length() == 1) g += "0"; 
if(b.length() == 1) b += "0"; 
//color就是获得点颜色的字符串表示 
String color = "#" + r + g +b; 
System.out.println(color); 
} 

}); 
scrollPane = new JScrollPane( panel ); 
getContentPane().add( scrollPane ); 
init(); 
} 
public void init() { 
try { 
rb = new Robot(); 
} catch (AWTException e) { 
e.printStackTrace(); 
} 
} 


public static void main(String [] args) 
{ 
BackroundImage frame = new BackroundImage(); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
frame.setSize(800, 600); 
frame.setLocationRelativeTo( null ); 
frame.setVisible(true); 
} 

}