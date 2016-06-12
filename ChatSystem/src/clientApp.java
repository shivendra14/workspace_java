import java.net.*;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class clientApp
{    
	JFrame f1;
	static String serverIP="255.255.255.255";
	JTextField tfsip=new JTextField(serverIP);;
	JTextField tf1=new JTextField("Type here...");
	JTextArea ta=new JTextArea(13,12);
	String input="";
	static String clientname="Client";
	JTextField tfcnm=new JTextField(clientname);
	clientInner obj=new clientInner();
	//static saveBFile objfile=new saveBFile();

	clientApp()
	{		
		String arr[]=new String[2];
		//objfile.output(arr);
		tfsip=new JTextField(arr[1]);
		tfcnm=new JTextField(arr[0]);

		JFrame f=new JFrame("_Chat Box_");
		f.setSize(365,340);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

		MenuBar mbar=new MenuBar();
		f.setMenuBar(mbar);

		Menu help=new Menu("Help");
		MenuItem item1;
		help.add(item1 = new MenuItem("About"));
		mbar.add(help);
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{

				JFrame f1=new JFrame("About");
				f1.setSize(300,200);
				f1.setResizable(false);
				f1.setLayout(new BorderLayout());

				JLabel l3=new JLabel("Client");
				f1.add(l3,BorderLayout.NORTH);
				TextArea ta1;

				ta1=new TextArea("It is an easy Network Chat application.\nJust enter the IP address of system on which\nserver is running, and begin to group chat.\n\nSpecial thanks for the idea:\nHimanshu Gupta\n\nFor any query or suggestions contact:\nShivendra.Agarwal.eee10@iitbhu.ac.in");
				ta1.setEditable(false);
				f1.add(ta1,BorderLayout.CENTER);
				f1.setLocationRelativeTo(null);
				f1.setVisible(true);
			}});

		Menu setting=new Menu("Settings");
		MenuItem sitem1;
		setting.add(sitem1=new MenuItem("Server Settings"));
		sitem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				f1=new JFrame("");
				f1.setSize(150,125);
				f1.setResizable(false);
				f1.setLayout(new BorderLayout());
				JLabel l3=new JLabel("Enter Server IP Address");
				f1.add(l3,BorderLayout.NORTH);

				JButton b1;
				b1=new JButton("Submit");
				b1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae)
					{
						String temp=tfsip.getText();
						temp=temp.trim();
						if(temp.equals(serverIP))
						{f1.setVisible(false); return;}
						if(temp.length()>15)
							return;

						StringTokenizer abc=new StringTokenizer(temp,".");
						for(int i=1;i<=4;i++)
						{
							int addr=Integer.parseInt(abc.nextToken());
							if(addr>255 || addr<0)
								return;
						}
						boolean response=obj.setIP(temp);
						if(!response)
						{
							ta.append("Unable to Connect to the Server ...!!!\n" );
							return;
						}

						serverIP=temp;
						//              		objfile.input(clientname,serverIP);
						ta.setText("Connected to the Server.. :)\n" );		//		//Enter bye to exit\n
						from_server();
						f1.setVisible(false);
					}
				});
				f1.add(b1);
				f1.add(tfsip,BorderLayout.CENTER);
				f1.add(b1,BorderLayout.SOUTH);
				f1.setLocationRelativeTo(null);
				f1.setVisible(true);
			}});

		MenuItem sitem2;
		setting.add(sitem2=new MenuItem("Client Name"));
		mbar.add(setting);
		sitem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				f1=new JFrame("");
				f1.setSize(150,125);
				f1.setResizable(false);
				f1.setLayout(new BorderLayout());
				JLabel l3=new JLabel("Enter your nick name...");
				f1.add(l3,BorderLayout.NORTH);

				JButton b1;
				b1=new JButton("Submit");
				b1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae)
					{
						clientname=tfcnm.getText();
						obj.setName(clientname);
						//              		objfile.input(clientname,serverIP);
						f1.setVisible(false);
					}
				});
				f1.add(b1);
				f1.add(tfcnm,BorderLayout.CENTER);
				f1.add(b1,BorderLayout.SOUTH);
				f1.setLocationRelativeTo(null);
				f1.setVisible(true);
			}});


		JLabel l1=new JLabel("_________Enter the text and hit enter to multicast_________");
		f.add(l1,BorderLayout.NORTH);
		tf1.addActionListener(Action());


		DefaultCaret caret1 = (DefaultCaret)tf1.getCaret();
		caret1.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		f.add(tf1,BorderLayout.SOUTH);

		ta.setText("");
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		DefaultCaret caret = (DefaultCaret)ta.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		ta.setEditable(false);
		f.add(new JScrollPane(ta),BorderLayout.CENTER);
		f.setVisible(true);
		//f.setDefaultLookAndFeelDecorated(true);
		f.setLocationRelativeTo(null);
	}

	public void from_server()
	{
		Runnable from_serv = new Runnable() {
			public void run() {

				while(true)
				{
					String incomingserver=obj.from_serv();
					ta.append(incomingserver+"\n");
					if(incomingserver.equalsIgnoreCase("Server Shut Down !!!") || incomingserver.endsWith(" has exit the chat..."))
					{
						obj.close();
						break;

					}

				}

			}
		};	new Thread(from_serv,"from_serv").start();
	}

	public ActionListener Action()
	{
		return new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{    
				input=tf1.getText();
				tf1.setText("");
				if(input.length()<=0)
					return;
				else if(obj.esock.isConnected())
					obj.to_serv(input);                                                    
			}};
	}


	public static void main(String a[])throws IOException
	{
		//objfile.input(clientname, serverIP);


		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new clientApp();
			}
		});
	}

}





class clientInner
{
	Socket esock=new Socket();
	BufferedReader in=null;
	PrintWriter out=null;
	String cname="Client";

	public void setName(String name)
	{
		cname=name;
	}
	public boolean setIP(String serverIP)
	{	
		try
		{
			esock= new Socket(serverIP,4321);
			out=new PrintWriter(esock.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(esock.getInputStream()));
			out.println(cname);
			out.println(cname+ " has joined the chat...!!!" );
		}
		catch (IOException e)
		{	
			System.out.println("Error creating client socket");}

		return esock.isConnected();
	}

	public void to_serv(String input)
	{
		out.println(cname+": "+input);
		/*if(input.indexOf("bye")>-1)
			{
			out.println(cname+" has exit the chat...");
			}*/
	}

	public String from_serv()
	{
		String incomingserver="";
		try {
			incomingserver = in.readLine();
		} catch (IOException e) {

			e.printStackTrace();
			System.exit(0);
		}
		return incomingserver;

	}
	public void close()
	{
		out.close();
		try {
			in.close();
			esock.close();
			System.out.print("Socket close");} 
		catch (IOException e) {
			e.printStackTrace();}
	}
}