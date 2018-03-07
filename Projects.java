/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resume;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.*;
/**
 *
 * @author shish
 */
public class Projects {
    String name;
    String description;
    Resume r;
    Projects(Resume r)
    {
        this.r=r;
        name="";
        description="";
        createPGUI();
    }
    
    private void createPGUI()
    {
        JFrame f=new JFrame();
        r.setFrame(f);
        JLabel pl=new JLabel("Add Your Projects");
        JLabel pnl=new JLabel("Project Name");
        JTextField pn=new JTextField();        
        JLabel pdl=new JLabel("Description of Project");
        JTextArea pd=new JTextArea();
        
        JButton addp=new JButton("Add more Projects");
        JButton save=new JButton("Save");
        JButton next=new JButton("Next");
        pd.setLineWrap(true);
          int x=50,y=50,H=30,W=200,m=15;
        
        pl.setBounds(x+80, y, W, H);
        y=y+H+m;
        pnl.setBounds(x, y, W, H);
        pn.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        pdl.setBounds(x, y, W, H);
        pd.setBounds(x+W+m, y, W+100, H*5);
        y=y+H*5+m;
        addp.setBounds(x, y, W, H);
        save.setBounds(x+W+m,y,W-100,H);
        x=x+W+m;
        next.setBounds(x+W-88, y, W-100, H);
        
        f.add(pl);
        f.add(pnl);
        f.add(pn);
        f.add(pdl);
        f.add(pd);
        f.add(addp);
        f.add(save);
        f.add(next);
        r.setFontcolor(f);
      
        XWPFParagraph head=r.d.createParagraph();
        r.setHeading(head.createRun()  , "Projects");
        
        addp.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            pn.setText("");
            pd.setText("");
        }
        });
        
        
        
        save.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            name=pn.getText();
            description=pd.getText();
            
            if(name.equals("")||description.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Fill all details");
                
            }
            else
            {
              
                    XWPFParagraph p=r.d.createParagraph();
                    p.setNumID(BigInteger.valueOf(1));
                    XWPFRun run=p.createRun();
                    run.setBold(true);
                    r.setDefaultFont(run, name+" :-");
                   run.addBreak();
                    r.setDefaultFont(p.createRun(), description);
                    
                  JOptionPane.showMessageDialog(null,"Your information has been saved.You can Add more Projects");
            }
        
        
        
        
        }
        
        });
        
        
        next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
                XWPFParagraph p=r.d.createParagraph();
                p.createRun().setText("");
                p.setBorderBottom(Borders.THICK);
            
                f.dispose();
                others o=new others(r);
            
        }
        
        });
        
        
        
        
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
         f.setResizable(true);
      
        
        
        
        
    }
    
    /*
    public static void main(String[] args)
    {
    Resume r=new Resume();
    Projects p=new Projects(r);
    }
    */
    
}
