/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resume;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.*;
import javax.swing.JFrame;
import java.math.BigInteger;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
 
//import org.apache.poi.hwpf.HWPFDocument;
/**
 *
 * @author shish
 */
public class Resume{
 public  XWPFDocument d;
  public FileOutputStream file;
    Resume()
    {
    
        d=new XWPFDocument();
        try{
    file=new FileOutputStream("C:\\Users\\shish\\Desktop\\JavaGeneratedResume.doc");
     // pi.write(d);
    
    //createPIGUI();
   // d.write(f);
   // f.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
            
    
        
    }
    
    
    public static void main(String[] args) throws IOException {
    Resume r=new Resume();
     PersonalInfo p=new PersonalInfo(r);
    
    
   
    }
    
    
   public void setFontcolor(Component component)
   {
       int fontSize=20;
        Font f = component.getFont();
   component.setFont(new Font(Font.SERIF,Font.BOLD,20)); 
   if (component instanceof Container) {
        for (Component child : ((Container) component).getComponents()) {
            setFontcolor(child);
        }
    }
       
   }
   
   public void setFrame(JFrame f)
   {
                 f.setSize(600, 600);
      f.setLayout(null);
     f.getContentPane().setBackground(Color.ORANGE);
 
   }
   
   
    public void setHeading(XWPFRun nm1,String s)
    {
        nm1.setBold(true);
        nm1.setFontSize(22);
        nm1.setUnderline(UnderlinePatterns.SINGLE);
        nm1.setFontFamily("Times New Roman");
        nm1.setText(s);
        
    }
    
    
     public void setDefaultFont(XWPFRun r,String s)
     {
         r.setFontSize(16);
        r.setFontFamily("Times New Roman");
        r.setText(s);
     }
    
    public BigInteger addListStyle() {
        try {
 
            XWPFNumbering numbering = d.createNumbering();
            // generate numbering style from XML
            InputStream in = new FileInputStream("C:\\Users\\shish\\OneDrive\\Documents\\NetBeansProjects\\resume\\src\\resume\\numbering.xml");
            CTAbstractNum abstractNum = CTAbstractNum.Factory.parse(in);
            XWPFAbstractNum abs = new XWPFAbstractNum(abstractNum, numbering);
            // find available id in document
            BigInteger id = BigInteger.valueOf(1);
            boolean found = false;
            while (!found) {
                Object o = numbering.getAbstractNum(id);
                found = (o == null);
                if (!found)
                    id = id.add(BigInteger.ONE);
            }
            // assign id
            abs.getAbstractNum().setAbstractNumId(id);
            // add to numbering, should get back same id
            id = numbering.addAbstractNum(abs);
            // add to num list, result is numid
            return d.getNumbering().addNum(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 


    
}
