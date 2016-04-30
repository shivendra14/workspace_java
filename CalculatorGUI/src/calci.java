import java.awt.*;
import java.awt.event.*;
import java.io.*;
class calci implements ActionListener
{
 	Button b1,b2,b3,b4,b5,b6,b7,b8,b9; 
 	TextField tf=null;
 	int a=0,b=0,c=0,i=0;
 	String s1,s="";	
   	calci()
 	{
   		Frame f=new Frame("calculator");
   		f.setSize(400,400);
   		f.setLayout(new GridLayout(4,3));
   		tf=new TextField("result");
   		b1=new Button("1");
    		b2=new Button("2");
   		b3=new Button("3");
   		b4=new Button("+");
   		b5=new Button("=");
		b6=new Button("-");
		b7=new Button("*");
		b8=new Button("/");
   		b9=new Button("CLEAR");
		b1.addActionListener(this);
   		b2.addActionListener(this);
   		b3.addActionListener(this);
   		b4.addActionListener(this);
   		b5.addActionListener(this);
   		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		f.add(tf);
   		f.add(b1);
   		f.add(b2);
   		f.add(b3);
   		f.add(b4);
   		f.add(b5);
   		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.setVisible(true);
   	
  	}
   	public static void main(String a[])throws IOException
   	{
    		new calci();
   	}
  	public void actionPerformed(ActionEvent ae)
   	{ 
	
		if(ae.getSource()==b1)
		{
	     		String s1=b1.getLabel();
	     		s=s+s1;
	    		tf.setText(s);
               	}
        	if(ae.getSource()==b2)
		{
	     		String s1=b2.getLabel();
 	     		s=s+s1;
			tf.setText(s);    
             
		}
        	if(ae.getSource()==b3)
		{
	     		String s1=b3.getLabel();
	     		s=s+s1;
			tf.setText(s);    
 	    
		}
        	if(ae.getSource()==b4)
		{
	  
	   	 	a=Integer.parseInt(tf.getText());
            		s="";
            		s1="";	
	  		c=c+a;         
             		i=1;
		}       
		if(ae.getSource()==b6)
		{
	  
	   	 	a=Integer.parseInt(tf.getText());
            		s="";
            		s1="";	
	  		c=c+a;         
             		i=2;
		}       
		if(ae.getSource()==b7)
		{
	  
	   	 	a=Integer.parseInt(tf.getText());
            		s="";
            		s1="";	
	  		c=c+a;         
             		i=3;
		}       
		if(ae.getSource()==b8)
		{
	  
	   	 	a=Integer.parseInt(tf.getText());
            		s="";
            		s1="";	
	  		c=c+a;         
             		i=4;
		}       
		if(ae.getSource()==b9)
		{
	  
	   	 	
            		s="";
            		s1="";	
	  		tf.setText("");
		}       
		if(ae.getSource()==b5)
		{
			if(i==1)
			{b=Integer.parseInt(tf.getText());
	     		c=c+b;
             		}

			if(i==2)
			{b=Integer.parseInt(tf.getText());
	     		c=c-b;
             		}

			if(i==3)
			{b=Integer.parseInt(tf.getText());
	     		c=c*b;
             		}

			if(i==4)
			{b=Integer.parseInt(tf.getText());
	     		c=c/b;
             		}
	     		String s3=Integer.toString(c);
			tf.setText(s3);
             		c=0;
            		s="";
            		s1="";
		}
       
       
	 }		
}