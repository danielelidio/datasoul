/*
 * ChordShapePanel.java
 *
 * Created on 21 de Janeiro de 2006, 19:10
 */

package datasoul.song;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.imageio.plugins.png.PNGImageWriter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author  Administrador
 */
public class ChordShapePanel extends javax.swing.JPanel {

    private String shape;
    private int startFret;
    private boolean editable;

    /**
     * Creates new form ChordShapePanel
     */
    public ChordShapePanel() {
        initComponents();

        startFret = 1;
        editable = true;
        
        this.setShape("X X X X X X");
        
        startFret = 1;
    }

    public boolean isEmpty(){
        if(this.shape.equals("X X X X X X")){
            return true;
        }
        return false;
    }
    
    public ChordShapePanel(String shape) {
        initComponents();

        startFret = 1;
        editable = true;
        
        this.setShape(shape);
    }
    
    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
        
        //sets the start fret
        int minFret = 33;
        String[] notes = shape.split(" ");
        for(int i=0;i<notes.length;i++){
            if(!notes[i].equals("X")){
                int num = Integer.parseInt(notes[i]);
                if(num<minFret)
                    minFret = num;
            }
        }
        if(minFret==0)
            startFret = 1;
        else
            startFret = minFret;
    }

    @Override
    public void paint(java.awt.Graphics g) {

        this.setBackground(Color.WHITE);
        
        super.paint(g);
        
        drawShape(g);
        
    }

    public void drawShape(Graphics g){
        Graphics2D g2 = (Graphics2D) g;        

        //draw white background
        g2.setPaint(Color.white);
        g2.fill(new Rectangle2D.Double(0,0,80,130));        

        g2.setPaint(Color.black);        
        g2.drawString(String.valueOf(this.startFret), 2, 23);
        if(this.startFret<10){
            g2.draw(new java.awt.geom.Ellipse2D.Double(8,14,3,3));                                
            g2.draw(new Rectangle2D.Double(8,19,3,0));        
        }else{
            g2.draw(new java.awt.geom.Ellipse2D.Double(13,14,3,3));
            g2.draw(new Rectangle2D.Double(13,19,3,0));                
        }
        
        g2.draw(new Rectangle2D.Double(20,11,50,100));        
        //draw horizontal lines
        g2.draw(new Rectangle2D.Double(20,10,10,100));
        g2.draw(new Rectangle2D.Double(30,10,10,100));
        g2.draw(new Rectangle2D.Double(40,10,10,100));        
        g2.draw(new Rectangle2D.Double(50,10,10,100));

        //draw vertical lines
        g2.draw(new Rectangle2D.Double(20,10,50,20));        
        g2.draw(new Rectangle2D.Double(20,10,50,40));                
        g2.draw(new Rectangle2D.Double(20,10,50,60));        
        g2.draw(new Rectangle2D.Double(20,10,50,80));        
        g2.draw(new Rectangle2D.Double(20,10,50,100));        

        String[] notes = shape.split(" ");
        int numX = 0;
        int min = 33;
        for(int i=0;i<notes.length;i++){
            if(notes[i].equals("X")){
                numX ++;
            }else{
                int num = Integer.parseInt(notes[i]);
                if(num<min)
                    min = num;
            }
        }
        //print pestana
        if(min>0){
            g2.setPaint(Color.decode("0xff8888"));
            if(numX==0){
                int fret = (min-startFret+1);
                g2.fill(new RoundRectangle2D.Double(15,-4+20*fret,60,8,8,8));
            }else if(numX==1){
                if(notes[0].equals("X")){
                    int fret = (min-startFret+1);
                    g2.fill(new RoundRectangle2D.Double(25,-4+20*fret,50,8,8,8));
                }
                if(notes[5].equals("X")){
                    int fret = (min-startFret+1);
                    g2.fill(new RoundRectangle2D.Double(15,-4+20*fret,50,8,8,8));
                }
            }
        }

        
        //print the notes
        boolean bassNote = true;
        if(notes.length==6){
            for(int i=0;i<notes.length;i++){
                if(notes[i].equals("X")){
                    //string without note
                    g2.setPaint(Color.black);        
                    g2.drawString("X", 17+10*i, 122);
                }else{
                    g2.setPaint(Color.red);        
                    if(Integer.parseInt(notes[i])>0){
                        //finger note
                        int fret = (Integer.parseInt(notes[i])-startFret+1);
                        g2.fill(new Ellipse2D.Double(16+10*i,-4+20*fret,8,8));
                    }else{
                        //free note
                        g2.setPaint(Color.blue);        
                        g2.fill(new Ellipse2D.Double(16+10*i,7,8,8));
                    }
                    g2.setPaint(Color.black);        
                    //if is the first note print a filled circle
                    if(bassNote){
                        g2.fill(new Ellipse2D.Double(17+10*i,115,6,6));                    
                        bassNote = false;
                    }else{
                        g2.draw(new Ellipse2D.Double(17+10*i,115,6,6));                    
                    }
                }
            }
        }
    }
    
    public void createImage(File file) throws FileNotFoundException, IOException{
        java.awt.image.BufferedImage image = 
        new java.awt.image.BufferedImage(80,130,java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        
        drawShape(g);
        
        FileOutputStream out = new FileOutputStream(file);
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image);
    }
    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChordShapePanel.this.mouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 141, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 168, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClicked
        //just change if is editable
        if(editable){
            int x = evt.getX();
            int y = evt.getY();

            //it's a blank area
            if(x<15&&y>25)
                return;

            //change the start fret
            if(x<15&&y<25){
                String str = JOptionPane.showInputDialog(this,"Digit the start fret desired.","Start fret",JOptionPane.QUESTION_MESSAGE);
                try{
                    startFret = Integer.parseInt(str);
                }catch (Exception e){

                }
                this.repaint();

                return;
            }

            int chordSelected = (int)Math.ceil((x-15)/10);
            String[] notes = shape.split(" ");
            String strAux = "";
            for(int i=0;i<notes.length;i++){
                if(i==chordSelected)    
                    if(y<110)
                        strAux = strAux + ((int)Math.ceil((y+10)/20)+startFret-1)+" ";
                    else
                        strAux = strAux + "X ";
                else
                    if(!notes[i].equals("X"))
                        strAux = strAux + (Integer.parseInt(notes[i]))+" ";
                    else
                        strAux = strAux + notes[i]+" ";                    
            }
            shape = strAux;
            this.repaint();
        }
    }//GEN-LAST:event_mouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
