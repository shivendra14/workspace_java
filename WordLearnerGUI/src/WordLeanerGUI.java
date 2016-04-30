import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class WordLearnerGUI
{    
Button b1,b2,b3;
JTextArea ta=new JTextArea(13,12);
String name="";
Combo pack;
int count,countunaw,countaw;
    WordLearnerGUI()
    {
        JFrame f=new JFrame("WordLearner");
        f.setSize(370,250);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation (dim.width/2 - f.getSize().width/2, dim.height/2 - f.getSize().height/2);
        
        MenuBar mbar=new MenuBar();
        Menu help=new Menu("Help");
        MenuItem item1;
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
                JLabel l3=new JLabel("Word Learner");
                
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                f1.setLocation (dim.width/2 - f1.getSize().width/2, dim.height/2 - f1.getSize().height/2);
                
                f1.add(l3,BorderLayout.NORTH);
                TextArea ta1;
                
                ta1=new TextArea("Word Learner generates random words from a\nlist based on the probability of being known i.e. \n an acquainted word occurs less frequently than\nothers. \n\n Contact:\n shivendra.agarwal.eee10@itbhu.ac.in\n");
                ta1.setEditable(false);
                f1.add(ta1,BorderLayout.CENTER);
                f1.setVisible(true);
            }});
            
        JLabel l1=new JLabel("   ",0);  //***** !!!! #### WORD LEARNER #### !!!! *****
        f.add(l1,BorderLayout.NORTH);
  
        b1=new Button("Learned");
        b1.addActionListener(Action());
        f.add(b1,BorderLayout.SOUTH);
        b2=new Button("Unaware");
        b2.addActionListener(Action());
        f.add(b2,BorderLayout.WEST);
        b3=new Button("Meaning");        
        b3.addActionListener(Action());
        f.add(b3,BorderLayout.EAST);
//        ta.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        f.add(new JScrollPane(ta),BorderLayout.CENTER);
        f.setVisible(true);
        
        //To set the first word while running the application.
        WordLearner obj=new WordLearner();
        pack=obj.main();
        ta.setText("\t"+pack.word.toUpperCase());
    }
    
    public ActionListener Action()
    {
        return new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                if(ae.getSource()==b1)
                {
                    try
                    {
                    FileWriter fw=new FileWriter("data/WordList.txt",true);//remove true to over-write the file
                    BufferedWriter bw=new BufferedWriter(fw);
                    PrintWriter pr=new PrintWriter(bw);
                        pr.print(pack.line+",");
                    pr.close();
                   }
                   catch(IOException e)
                   {
                    System.err.println(e);
                   }
                }
                if(ae.getSource()==b2 || ae.getSource()==b1)
                {
                WordLearner obj=new WordLearner();
                pack=obj.main();
                ta.setText("\t"+pack.word.toUpperCase());
                }
                else if(ae.getSource()==b3 && ta.getText().indexOf("\n\n\n")==-1)
                {
                ta.append("\n\n\n"+pack.meaning);
                }                
            }};
    }
             
    
    public static void main(String args[])throws IOException
    {
            SwingUtilities.invokeLater(new Runnable() {
                public void run()
                {
                    new WordLearnerGUI();
                }
            });
        }

}