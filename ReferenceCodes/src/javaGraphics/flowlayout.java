package javaGraphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class flowlayout
{
	JLabel l1=null,l2=null,l3=null;
	JTextField tf1=null,tf2=null,tf3=null;
	Button b;
	flowlayout()
	{
		JFrame f=new JFrame("credit");
		
		
		f.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		l1=new JLabel("Account number");
		f.add(l1);
		
		tf1=new JTextField("	");
		f.add(tf1);
		
		f.setSize(300,300);
		f.setVisible(true);
		f.pack();
		
	}
	
	public static void main(String a[])
	{
		new flowlayout();
	}

}