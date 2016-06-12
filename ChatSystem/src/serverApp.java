import java.net.*;
import java.io.*;
import java.util.*;
public class serverApp
{
	static ServerSocket serv1 = null;
	Socket scon = null;
	static int onClient=0;
	static ArrayList<serverApp> obj=new ArrayList<serverApp>();
	static serverApp objin=null;
	String clientName;

	public serverApp()throws IOException
	{
		// create  a socket for every new connection via new object.
		scon = serv1.accept();

	}
	public void setClientName(String name)
	{
		clientName=name;
	}

	public static void main(String args[])throws IOException
	{

		serv1 = new ServerSocket(4321);
		System.out.println("Server Open!!! :)    //Enter tata to shut down");
		for(int i=0;i<50;i++)
		{
			Runnable newUser=new Runnable(){ 
				public void run()
				{
					try{
						objin=new serverApp();
						onClient++;
						obj.add(objin);
						objin.setClientName(objin.inputFromSocket());
						System.out.println("No. of Clients online "+onClient);

						// Facility To Server to send message on all clients.
						Runnable to_client = new Runnable() {
							public void run() {
								while(true)
								{
									String data=send_from_server();
									if(data.endsWith("tata"))	//End server if it enters tata.
									{
										data="Server Shut Down !!!";
										for(int j=0;j<onClient;j++)
											obj.get(j).to_multi_client(data);
										try{serv1.close();} 
										catch(IOException e){System.out.println("IOException while closing server :(");}
										System.exit(0);
									}
									else
									{
										for(int j=0;j<onClient;j++)
											obj.get(j).to_multi_client(data);
									}
								}
							}};
							new Thread(to_client,"to_client").start();					


							// Method to display message from one client to all clients.
							Runnable from_client=new Runnable(){
								int p=onClient-1;
								serverApp objpres=obj.get(p);
								public void run() {
									int co=0; String data="";
									// Incoming Notice to all online
									//String data1=objpres.from_client();
									for(int j=0;j<onClient ;j++)
									{
										serverApp objprint=obj.get(j);
										if(objpres.equals(objprint)) continue;	
										try {
											objpres.outputToSocket(objprint.clientName+" is also online, at IP "+ objprint.scon.getInetAddress());
										} catch (IOException e) {							
											e.printStackTrace();}

										objprint.to_multi_client(data); 
									}



									while(true)
									{
										System.out.println(objpres.scon.isInputShutdown() );
										if(!objpres.scon.isConnected())
										{
											System.out.println("Client removed");
											obj.remove(p);
											onClient--;
											break; 
										}
										String data1=objpres.from_client();		// Now printing input given from client to server and spreading.
										if(data1.equals(data)) co++;
										if(co>=20) 
										{
											obj.remove(p);
											onClient--;
											break;
										}

										data=data1;
										for(int j=0;j<onClient ;j++)
										{
											serverApp objprint=obj.get(j);
											//if(objpres.equals(objprint)) continue;	 
											objprint.to_multi_client(data); 
										}
										if(data.endsWith(" has exit the chat..."))
										{
											obj.remove(p);
											onClient--;
											break;
										}
									}
								}};
								new Thread(from_client,"from_client").start();

					}
					catch(IOException e)
					{}
				}
			};
			new Thread(newUser,"User").start();
		}
	}

	// Method to display message from one client to all clients.
	public void to_multi_client( String data)
	{
		if(!data.equals(""))
		{
			try
			{
				outputToSocket(data);
			}
			catch (IOException e)
			{System.out.println("IOException while displaying to all clients.. :(");}
		}				
	}


	// Now printing input given from client to server.
	public String from_client()
	{
		String st="";
		try
		{
			st=inputFromSocket();
			System.out.println(st);					
		}
		catch (IOException e)
		{
			st="";
		}
		return st;	
	}

	// Facility To Server to send message on all clients.
	public static String send_from_server()
	{
		String io="";
		try
		{
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			io = new String(br.readLine());
		}
		catch(IOException e)
		{System.out.println("IOException while reading on server.. :(");}
		return "Server: "+io;
	}


	public void outputToSocket(String st) throws IOException
	{
		PrintWriter outgoing= new PrintWriter(scon.getOutputStream(), true);
		outgoing.println(st);
	}
	public String inputFromSocket() throws IOException
	{
		BufferedReader incoming = new BufferedReader(new InputStreamReader(scon.getInputStream()));
		String st = new String(incoming.readLine());
		return st;
	}
}
//how to give all other threads the data which i have got....
// defining common variable make problem of checking it in indefinite loop....
// thinking of calling other threads again on receiving data...  means repetition of 50 size loop
