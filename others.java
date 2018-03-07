/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resume;
import javax.swing.*;
import java.awt.event.ActionEvent;
import org.apache.poi.xwpf.usermodel.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author shish
 */
public class others {
String soft;
String lang;
String tech1;
Resume r;

others(Resume r)
{
    this.r=r;
    soft="";
    lang="";
   
    tech1="";
    createGUI();
}

public static void main(String[] args)
{
    Resume r=new Resume();
    others o=new others(r);
}


private void createGUI()
{
    
       JFrame f=new JFrame("Info");
       r.setFrame(f);
       JLabel skl=new JLabel("Soft Skills");
        JTextField sk=new JTextField();
        JLabel ll=new JLabel(" Languages Known");
        JTextField l=new JTextField();
        JLabel tel=new JLabel("Technical Skills");
        JTextField te=new JTextField();
        JButton b=new JButton("Generate Resume");
        int x=50,y=100,H=30,W=200,m=15;
        
        skl.setBounds(x, y, W, H);
        sk.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        ll.setBounds(x, y, W, H);
        l.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        tel.setBounds(x, y, W, H);
        te.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        b.setBounds(x+W/2, y, W, H);
        
        f.add(skl);
        f.add(sk);
        f.add(ll);
        f.add(l);
        f.add(tel);
        f.add(te);
        f.add(b);
        r.setFontcolor(f);
        b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
        
            tech1=te.getText();
            soft=sk.getText();
            lang=l.getText();
            
            
            try {
                XWPFParagraph p=r.d.createParagraph();
                XWPFRun run1=p.createRun();
                run1.setBold(true);
                r.setDefaultFont(run1,"Technical Skills :-      ");
                XWPFRun ru=p.createRun();
                r.setDefaultFont(ru,tech1);
                ru.addBreak();
                
                XWPFRun run=p.createRun();
                run.setBold(true);
                
                r.setDefaultFont(run,"Soft Skills :-            ");
                XWPFRun ru2=p.createRun();
                r.setDefaultFont(ru2,soft);
                ru2.addBreak();
                
                XWPFRun run2=p.createRun();
                run2.setBold(true);
                r.setDefaultFont(run2,"Languages Known :-       ");
                r.setDefaultFont(p.createRun(),lang);
                JOptionPane.showMessageDialog(null,"Resume Build and saved at Desktop ");
                r.d.write(r.file);
                r.file.close();
                f.dispose();
            } catch (IOException ex) {
                Logger.getLogger(others.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        });
   
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
         f.setResizable(true);
      
        


}


    
}
