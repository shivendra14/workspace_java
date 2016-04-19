import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AnagramFinder
{    
Button b1;
JTextField tf1=new JTextField(12);
JTextArea ta=new JTextArea(13,12);
    AnagramFinder()
    {
        JFrame f=new JFrame("Anagrams");
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
                
                JLabel l3=new JLabel("Anagram");
                f1.add(l3,BorderLayout.NORTH);
                JTextArea ta1=new JTextArea();
                ta1.setText("\nAnagram is a meaningful permutation of a word.\n\nThis Anagram Solver gives all the Anagrams possible of a word with any possible length.\n\n\n Contact:\n shivendra.agarwal.eee10@itbhu.ac.in\n");
                ta1.setEditable(false);
                ta1.setLineWrap(true);
                ta1.setWrapStyleWord(true);
                f1.add(ta1,BorderLayout.CENTER);
                f1.setVisible(true);
            }});
        JLabel l1=new JLabel("__________Enter the word to find its Anagrams__________");
        f.add(l1);
        tf1.addActionListener(Action());
        f.add(tf1);
        b1=new Button("Search!");
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
                input=input.toLowerCase();
                ta.setText("");
                if(input.length()<=0)
                return;
                else
                {
                    Anagram obj=new Anagram();
                    NodeString perm=obj.main(input);
                    if(perm==null)
                    ta.append("No anagram exists for this word in Dictionary.\n");
                    else
                    {
                     int i=0;
                     while(perm!=null)
                     {
                      ta.append((++i)+". "+perm.a+"\n");
                      perm=perm.next;
                     }
                    }
                }
            }};
    }
          
    
    public static void main(String a[])throws Exception
    {
            SwingUtilities.invokeLater(new Runnable() {
                public void run()
                {
                    new AnagramFinder();
                }
            });
        }
}
