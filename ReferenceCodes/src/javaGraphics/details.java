package javaGraphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class details extends MouseAdapter implements ItemListener,ActionListener 
{
	CheckboxGroup cbg;
 	TextField tf1,tf2,tf3;
 	Choice a;
	String s1="",s2="",s3=""; 
	ImageIcon im1=null,im2=null;
	JLabel l5=null,l6=null,l7=null;
	details()
	{
		JFrame f=new JFrame("my frame");
   		f.setLayout(new GridLayout(6,3));
   		
		im1=new ImageIcon("05.jpg");
		im2=new ImageIcon("12.jpg");
		l7=new JLabel("");
		l5=new JLabel(im1);
		l6=new JLabel(im2);
		l5.addMouseListener(this);
		l6.addMouseListener(this);
	
		JLabel l=new JLabel("SEX");
		JLabel l1=new JLabel("NAME");
		JLabel l2=new JLabel("PASSWORD");
		JLabel l3=new JLabel("CONFIRM PASSWORD");
  		JLabel l4=new JLabel("SELECT CITY");
		JButton b=new JButton("LOG IN"); 
  		tf1=new TextField();
  		tf2=new TextField();
   		tf3=new TextField();
   		a=new Choice();
   		cbg=new CheckboxGroup();
   		Checkbox male=new Checkbox("male",true,cbg);
        	JLabel n1=new JLabel(" ");
		JLabel n2=new JLabel(" ");   
   		Checkbox female=new Checkbox("female",false,cbg);
  		male.addItemListener(this);
  		female.addItemListener(this);
   		b.addActionListener(this);
   			a.add("jaipur");
   			a.add("delhi");
   			a.add("mumbai");
   			a.add("kolkata");
			a.add("pune");
   			a.add("gurgaon");
   			a.add("bangalore");
   			a.addItemListener(this);
      		f.add(l);
   		f.add(male);
   		f.add(female);
		f.add(l1);
		f.add(tf1);
		f.add(n1);
		f.add(l2);
		f.add(tf2);
		f.add(n2);
		f.add(l3);
		f.add(tf3);
		f.add(b);
		f.add(l4);
		f.add(a);
	 	f.add(l7);
		f.add(l5);
	f.add(l6);
      tf2.setEchoChar('*');
      tf3.setEchoChar('*');
 	f.setSize(400,400);
   	
	f.setVisible(true);
	}
 public static void main(String a[])
  {
	new details();
  }
public void itemStateChanged(ItemEvent ie)
	{
 	
	String s=cbg.getSelectedCheckbox().getLabel();
 	System.out.println(s);
 	
	
	String s4=a.getSelectedItem();
 	System.out.println(s4);
 
	}
	public void actionPerformed(ActionEvent ae)
	{	 s1=tf1.getText().trim();
       		 s2=tf2.getText().trim();

 		 s3=tf3.getText().trim();


		if(s3.equals(s2))
		{
			System.out.println("ok");
		}
		else
		 {
			System.out.println("re-enter password");
		}
		
		System.out.println("re-enter password");
	}
	public void mouseClicked(MouseEvent me)
	{
	if(me.getSource()==l5)
		{
		JFrame f1=new JFrame("image 1");
		f1.setSize(300,300);
		JLabel lb=new JLabel("congratulations");
		f1.add(lb);
		f1.add(l5); 
		f1.setVisible(true);
		}
	if(me.getSource()==l6)
		{
		JFrame f2=new JFrame("image 1");
		f2.setSize(300,300);
		JLabel lb1=new JLabel("congratulations");
		f2.add(lb1);
		f2.add(l6); 
		f2.setVisible(true);
		}
	
	}
}