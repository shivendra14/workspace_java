package javaGraphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class internalFrame implements ActionListener
{
	Button log,cancel;
	internalFrame()
	{
		JFrame f=new JFrame("Login");
		
		log=new Button("login");
		log.addActionListener(this);
		f.add(log);
	
		f.setSize(700,700);
		f.setVisible(true);
		f.pack();
		
	}
	public static void main(String a[])
	{
		new internalFrame();
	}
	public void actionPerformed(ActionEvent ae)
	{
		Button b=(Button)ae.getSource();
		if(b==log)
		{	System.out.print("");
			new MyInternalFrame();
		}
	}
}
	
 class MyInternalFrame extends JInternalFrame 
	{
		int xPosition = 30, yPosition = 30;
		MyInternalFrame() 
		{
			super("IFrame #",true,true, true,true);
			setSize(300, 300);
			setVisible(true);
			// Set the window's location.
		}
	}

			
		
		
		 