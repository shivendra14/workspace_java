package javaGraphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class image
{	
	JLabel l1=null;
	ImageIcon image1=null;
	image()
	{
		Frame f=new Frame("image frame");
		image1=new ImageIcon("trucks.jpg");
		l1=new JLabel(image1);
		f.add(l1);
		f.setLayout(new GridLayout(3,1));
		f.setSize(200,200);
		f.setVisible(true);
	}
	public static void main(String a[])
	{
		new image();
	}
}