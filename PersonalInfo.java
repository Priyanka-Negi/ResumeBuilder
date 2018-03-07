/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resume;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author shish
 */
public class PersonalInfo{
    String name;
    String email;
    String addr;
    String phno;
    String dob;
    Resume r;
    PersonalInfo(Resume r)
    {
        this.r=r;
        createPIGUI();
    }

      private void createPIGUI()
    {
       JFrame f=new JFrame("Personal Info");
       r.setFrame(f);
       JLabel nl=new JLabel("Name");
        JTextField n=new JTextField();
        JLabel el=new JLabel(" Email");
        JTextField e=new JTextField();
        JLabel al=new JLabel("address");
        JTextArea a=new JTextArea();
       // a.setColumns(10);
        a.setLineWrap(true);
        JLabel pl=new JLabel(" Phone NO");
        JTextField p=new JTextField();
        JLabel dl=new JLabel(" DOB (DD/MM/YYYY)");
        JTextField d=new JTextField();
  JButton b=new JButton("Next");
        int x=50,y=100,H=30,W=200,m=15;
        
        nl.setBounds(x, y, W, H);
        n.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        el.setBounds(x, y, W, H);
        e.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        al.setBounds(x, y, W, H);
   
        a.setBounds(x+W+m, y, W, H*4);
        y=y+H*4+m;
        pl.setBounds(x, y, W, H);
        p.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        dl.setBounds(x,y,W,H);
        d.setBounds(x+W+m,y,W,H);
        b.setBounds(x+W/2,y+H+20,W,H);
        f.add(nl);
        f.add(n);
        f.add(el);
        f.add(e);
        f.add(al);
        f.add(a);
        f.add(pl);
        f.add(p);
        f.add(dl);
        f.add(d);
        f.add(b);
        r.setFontcolor(f); 
      
        b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            name=n.getText();
            email=e.getText();
            addr=a.getText();
            phno=p.getText();
            dob=d.getText();
            boolean err=false;
            if(name==null||email==null||addr==null||phno==null||dob==null||dob.equals("")||email.equals("")||name.equals("")||addr.equals("")||phno.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter all fields");
            }
            else
            {
                Pattern pemail=Pattern.compile("^[a-zA-Z1-9]+@[a-zA-Z1-9]+\\.com$");
            Pattern pph=Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d");
            Pattern pd=Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d");            
            Matcher m=pemail.matcher(email);
            Matcher m2=pph.matcher(phno);
            Matcher m1=pd.matcher(dob);
            if(!m.find())
            {
                JOptionPane.showMessageDialog(null,"Enter a valid email");
                err=true;
            }
            else if(phno.length()!=10||!m2.find())
            {
                JOptionPane.showMessageDialog(null,"Enter a valid phoneno");
                err=true;
                
            }else if(!m1.find())
            {
                JOptionPane.showMessageDialog(null,"Enter date in a valid format as mentioned");
                err=true;
                
            }
            
                
            }
            
            
            if(!err)
            {
                f.setVisible(false);
                f.dispose();
                writePI();               
                Objective o=new Objective(r);
            }
            
        }
        });
        
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setResizable(true);
       f.setVisible(true);
        
    }

    public void writePI()
    {
        XWPFParagraph p=r.d.createParagraph();
        XWPFRun nm=p.createRun();
        nm.setBold(true);
        nm.setFontSize(24);
        nm.setFontFamily("Times New Roman");
    //    System.out.println("Writing to doc "+name+email+phno);
        nm.setText(name);
        nm.addBreak();
        p.setBorderBottom(Borders.THICK);
        
        
        XWPFParagraph p3=r.d.createParagraph();
        XWPFRun nm1=p3.createRun();
       // nm1.addBreak();
        //nm1.setText("Personal Information ");
        r.setHeading(nm1, "Personal Information");
        
        
        XWPFParagraph p1=r.d.createParagraph();
        XWPFRun e=p1.createRun();
        r.setDefaultFont(e,"Email          :      "+email);
        e.addBreak();
        r.setDefaultFont(e,"Phone No     :      "+phno);
        e.addBreak();
        r.setDefaultFont(e,"Address        :      "+addr);
        e.addBreak();
        r.setDefaultFont(e,"DOB            :      "+dob);
        e.addBreak();
       p1.setBorderBottom(Borders.THICK);        
     
      
      
      }
   
    
    
  
   
}
