package javaGraphics;
import java.awt.*;
import java.awt.event.*;

class mouse extends MouseAdapter
{	
	Button b;
	Frame f;
	
	mouse()
	{
		 f=new Frame("abc");
 		 f.setSize(400,400);
		 b=new Button("ok");
		 b.addMouseListener(this);
		 f.add(b);
		 f.setVisible(true);
	
	}
	public static void main(String a[])
	{
		new mouse();
	 }
	public void mousePressed(MouseEvent m)
	{
	 System.out.println("mouse pressed");
	}
}