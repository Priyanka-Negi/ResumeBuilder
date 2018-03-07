/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resume;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import javafx.scene.layout.Border;
import org.apache.poi.xwpf.usermodel.*;
/**
 *
 * @author shish
 */
public class Objective {
    String obj;
    boolean expr;
    Resume r;
    Objective(Resume r)
    {
        expr=false;
        this.r=r;
        createOBGUI();
    }
    
    private void createOBGUI()
    {
        JFrame f=new JFrame("Objective");
         r.setFrame(f);
         JLabel ol=new JLabel("Your Carrer Objective");
         JTextArea o=new JTextArea();
         JLabel rl=new JLabel("Check if Experienced or not");
         JRadioButton fre=new JRadioButton("Fresher");
         JRadioButton exp=new JRadioButton("Experienced");
         ButtonGroup bg=new ButtonGroup();
         bg.add(exp);
         bg.add(fre);
         JButton nx=new JButton("Next");
         int x=50,y=100,H=30,W=200,m=15;
       
         ol.setBounds(x, y, W, H);
        o.setBounds(x+W+m,y,W+100,H*5);
        o.setLineWrap(true);
      o.setRows(5);
        y=y+H*5+m;
        rl.setBounds(x, y, W+100, H);
        y=y+H+m;
        fre.setBounds(x, y, W, H);
         exp.setBounds(x+W+m, y, W, H);
         y=y+H+m;
         nx.setBounds(x+W/2, y, W, H);
         fre.setBackground(Color.ORANGE);
         exp.setBackground(Color.ORANGE);
         f.add(ol);
         
         f.add(o);
         f.add(rl);
         f.add(fre);
         f.add(exp);
         f.add(nx);
         r.setFontcolor(f);
         f.setVisible(true);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         nx.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae)
         {
             obj=o.getText();
             expr=exp.isSelected();
             if(obj==null||obj.equals(""))
             {
                  JOptionPane.showMessageDialog(null,"Please enter all fields");
           
             }
             else
             {
                 writeOB();
                 f.setVisible(false);
                 f.dispose();
             }
             
             if(expr)
             {
                 WorkExp en=new WorkExp(r);
             }
             else
             {
                 EducationalInfo en=new EducationalInfo(r);
                 
             }
             
             
             
             
         }
         
         });
         
         
         
         
    }
    
    public void writeOB()
    {
        XWPFParagraph p=r.d.createParagraph();
        r.setHeading(p.createRun(),"Objective" );
        XWPFParagraph p2=r.d.createParagraph();
        XWPFRun rr=p2.createRun();
        r.setDefaultFont(rr, obj);
        rr.addBreak();
        p2.setBorderBottom(Borders.THICK);
        /*try{
        r.d.write(r.file);
        r.file.close();
        }
        catch(IOException easa)
        {
        System.out.println(easa.getLocalizedMessage());
        }
        */
    }
    
    
    public static void main(String[] args)
    {
        Resume r=new Resume();
        Objective o=new Objective(r);
    }
    
}
