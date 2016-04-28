import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GUI
{    
Button b1;
JTextField tf1=new JTextField(12);
JTextArea ta=new JTextArea(13,12);
    GUI()
    {
        JFrame f=new JFrame("WCI2 Convertor");
        f.setSize(365,340);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation (dim.width/2 - f.getSize().width/2, dim.height/2 - f.getSize().height/2);
        
        MenuBar mbar=new MenuBar();
        Menu help=new Menu("Help");
        final MenuItem item1;
        help.add(item1 = new MenuItem("About"));
        f.setMenuBar(mbar);
        mbar.add(help);
        item1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae)
            {
                JFrame f1=new JFrame("About");
                f1.setSize(300,200);
                f1.setResizable(false);
                f1.setLayout(new BorderLayout());
                
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                f1.setLocation (dim.width/2 - f1.getSize().width/2, dim.height/2 - f1.getSize().height/2);
                
                JLabel l3=new JLabel("Parser");
                f1.add(l3,BorderLayout.NORTH);
                JTextArea ta1=new JTextArea();
                ta1.setText(" WCI2RawByte_to_Type2Converter \n\n Sample Input: \n 0x7e 0x1 \n Sample Output: \n <byte>0xe2</byte> \n <byte>0x7a</byte> \n <byte>0x12</byte> \n <byte>0x0a</byte>\n ");
                ta1.setEditable(false);
                ta1.setLineWrap(true);
                ta1.setWrapStyleWord(true);
                f1.add(ta1,BorderLayout.CENTER);
                f1.setVisible(true);
            }});
        JLabel l1=new JLabel("Input:");
        f.add(l1);
        tf1.addActionListener(Action());
        f.add(tf1);
        b1=new Button("Convert");
        b1.addActionListener(Action());
        f.add(b1);
        
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        f.add(new JScrollPane(ta));
        f.setVisible(true);
    }
    
    public ActionListener Action()
    {
        return new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                String input=tf1.getText();
                ta.setText("");
                if(input.length()<=0)
                return;
                else
                {
                	SaurabhXML tempObj= new SaurabhXML();
                	String outArr[]=tempObj.findAns(input);
                    
                    if(outArr==null)
                    ta.append("No ans.\n");
                    else
                    {
                    	for (String x: outArr)
        	            	if (x!=null)
        	            		ta.append(x+"\n");
                    }
                }
            }};
    }
          
    
    public static void main(String a[])throws Exception
    {
            SwingUtilities.invokeLater(new Runnable() {
                public void run()
                {
                    new GUI();
                }
            });
        }
}
