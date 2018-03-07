/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resume;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.apache.poi.xwpf.usermodel.*;
/**
 *
 * @author shish
 */
public class EducationalInfo {
    int level;
    Resume r;
    clg clgc;
    EducationalInfo(Resume r)
    {
        clgc=new clg();
        this.r=r;
        createEIGUI();
    }
    
    private void createEIGUI()
    {
        JFrame f=new JFrame("Educational Information");
        r.setFrame(f);
        f.setSize(600,800);
        Object lev[]={"Post Graduate","Graduate","High School"};
        JLabel ll=new JLabel("Select Yout highest degree");
        JComboBox l=new JComboBox(lev);
      JButton b=new JButton("Next");
        int W=150,H=30;
        ll.setBounds(10,150,W+100,H);
       l.setBounds(300,150,W,H);
          b.setBounds(200,200,W,H);
        
          
       // JPanel PG=new JPanel();
       // clgc[0].addPanel(PG);
//       addPanel(PG,clgc[0]);
   // System.out.println("clg"+clgc[0].College);
     // System.out.println("deg"+clgc[0].Degree);
    //    System.out.println(clgc[0].Grade);
      //  System.out.println(clgc[0].Year);
        f.add(ll);
        f.add(l);
       f.add(b);
      //f.add(PG);
      
      b.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae)
      {   
          /*   ll.setVisible(false);
          l.setVisible(false);
          b.setVisible(false);
          */  
          f.dispose();
          int height=220,Y=0;
          int ind=l.getSelectedIndex();
          if(ind==-1)
          {
              JOptionPane.showMessageDialog(null,"Please Select Your Qualification");
          }
          else{
              
          JFrame f1=new JFrame();
          JButton b=new JButton("Next");
          r.setFrame(f1);
          b.setBounds(460, 300,100 , 30);
          
          f1.setSize(600, 800);
       ///   f1.setBackground(Color.ORANGE);
          f1.setLayout(null);
          f1.add(b);
          
          b.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae)
          {   
                         XWPFParagraph p=r.d.createParagraph();
                p.createRun().setText("");
                p.setBorderBottom(Borders.THICK);
     
              f1.dispose();
              Projects pro=new Projects(r);
          }
          });
          
          
          
          XWPFParagraph p=r.d.createParagraph();
          r.setHeading(p.createRun(), "Educational Qualification");
          XWPFTable table=r.d.createTable();
         
          
    table.setCellMargins(50, 450, 200, 750);

table.getCTTbl().getTblPr().unsetTblBorders();
//          table.setInsideHBorder(XWPFTable.XWPFBorderType.NONE, 0, 0,"#000000" );
  //        table.setInsideVBorder(XWPFTable.XWPFBorderType.NIL, 0, 0, "#000000");
          XWPFTableRow r1=table.getRow(0);
          XWPFRun run= r1.getCell(0).addParagraph().createRun();
          r.setDefaultFont(run,"Degree  " );
          run.setBold(true);
          XWPFRun run1=    r1.addNewTableCell().addParagraph().createRun();
          r.setDefaultFont(run1,"College  " );
          run1.setBold(true);
         
          XWPFRun run2=    r1.addNewTableCell().addParagraph().createRun();
          r.setDefaultFont(run2,"Grades  " );
           run2.setBold(true);
         
          XWPFRun run3=    r1.addNewTableCell().addParagraph().createRun();
          r.setDefaultFont(run3,"Year  " );
             run3.setBold(true);
         
              if(ind==0)
          {
              JPanel pg=new JPanel();
              clgc.addPanel(f1,pg, "Post Graduate Details", 0, Y,height,table,r);
            //f.add(pg);
          //    JOptionPane.showMessageDialog(null,"You selected"+ind);
              
          }
          if(ind==0||ind==1)
          {
              
              JPanel pg=new JPanel();
              Y=Y+height;
              clgc.addPanel(f1,pg, "Graduate Details", 0, Y,height,table,r);
             // f.add(pg);
              
            //  JOptionPane.showMessageDialog(null,"You selected"+ind);
              
          }
          
          
              JPanel pg=new JPanel();
              Y=Y+height;
              clgc.addPanel(f1,pg, "High School", 0, Y,height,table,r);
              //f.add(pg);
              
              //JOptionPane.showMessageDialog(null,"You selected"+ind);
          
          r.setFontcolor(f1);
         f1.setVisible(true);
         f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
          
          }
          
          
          
      }
      
      });
      
      
      
      
      
      f.setLayout(null);
      r.setFontcolor(f);
         f.setVisible(true);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        
    }
    
    
   
    
    public static void main(String[] args)
    {
    Resume r=new Resume();
    EducationalInfo e=new EducationalInfo(r);
    }  
    
}


class clg{
   public String College;
   public String Grade;
   public String Degree;
   public String Year;
clg()
{
    College="";
    Grade="";
    Degree="";
    Year="";
    
    
}

public void addPanel(JFrame f,JPanel PG,String title,int X,int Y,int hei,XWPFTable tab,Resume r)
    {
         int x=50,y=15,H=25,W=150,m=10;       
         PG.setBounds(X,Y,550,hei);
        PG.setBackground(Color.ORANGE);
        PG.setLayout(null);
   
        JLabel level=new JLabel(title);
         JLabel pgcl=new JLabel("College");
        JTextField pgc=new JTextField();
        JLabel pgdl=new JLabel("Degree");
        JTextField pgd=new JTextField();
        JLabel pggl=new JLabel("Grades");
        JTextField pgg=new JTextField();
        JLabel pgyl=new JLabel("Passing year");
        JTextField pgy=new JTextField();
        JButton next=new JButton("save");
       y=10;
       level.setBounds(x+50,y,W,H);
       y=y+H+m;
        pgcl.setBounds(x,y,W,H);
        pgc.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        pgdl.setBounds(x, y, W, H);
        pgd.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        pggl.setBounds(x, y, W, H);
        pgg.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        pgyl.setBounds(x, y, W, H);
        pgy.setBounds(x+W+m, y, W, H);
        y=y+H+m;
        next.setBounds(x+W/2, y, W, H);
        PG.add(level);
        PG.add(pgcl);
        PG.add(pgc);
        PG.add(pgdl);
        PG.add(pgd);
        PG.add(pggl);
        PG.add(pgg);
        PG.add(pgyl);
        PG.add(pgy);
       PG.add(next);
     PG.setVisible(true);
     
       f.add(PG);
     
         
        
       next.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent ae)
       {
        College=pgc.getText();
        Degree=pgd.getText();
        Grade=pgg.getText();
        Year=pgy.getText();
       if(College.equals("")||Degree.equals("")||Grade.equals("")||Year.equals(""))
       {
           JOptionPane.showMessageDialog(null,"Please Enter all fields");
       }
       else
       {
           XWPFTableRow r1=tab.createRow();
           r.setDefaultFont(r1.getCell(0).addParagraph().createRun(),Degree);
           
           r.setDefaultFont(r1.getCell(1).addParagraph().createRun(),College);
           r.setDefaultFont(r1.getCell(2).addParagraph().createRun(),Grade);
           r.setDefaultFont(r1.getCell(3).addParagraph().createRun(),Year);
           /*r1.getCell(1).setText(College);
           
           r1.getCell(2).setText(Grade);
           r1.getCell(3).setText(Year);
           */ 
           
       }
       
       
       
       
       
       }
       });
        
        
        
    }
    
    



}