/*
 * ChordEditorFrame.java
 *
 * Created on 23 de Janeiro de 2006, 20:34
 */

package datasoul.song;

import com.sun.jndi.url.dns.dnsURLContext;
import java.util.ArrayList;

/**
 *
 * @author  Administrador
 */
public class ChordEditorFrame extends javax.swing.JFrame {

    private Chord chord;
    /** Creates new form ChordEditorFrame */
    public ChordEditorFrame(Chord chord) {
        initComponents();
        
        this.chord = chord;
        
        ArrayList<String> shapes = chord.getShapes();
        if(shapes.size()>0)
            this.chordShapePanel1.setShape(shapes.get(0));
        if(shapes.size()>1)
            this.chordShapePanel2.setShape(shapes.get(1));
        if(shapes.size()>2)
            this.chordShapePanel3.setShape(shapes.get(2));
        if(shapes.size()>3)
            this.chordShapePanel4.setShape(shapes.get(3));
        if(shapes.size()>4)
            this.chordShapePanel5.setShape(shapes.get(4));
        if(shapes.size()>5)
            this.chordShapePanel6.setShape(shapes.get(5));
        
        this.fieldName.setText(chord.getName());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        chordShapePanel1 = new datasoul.song.ChordShapePanel();
        chordShapePanel2 = new datasoul.song.ChordShapePanel();
        chordShapePanel3 = new datasoul.song.ChordShapePanel();
        chordShapePanel4 = new datasoul.song.ChordShapePanel();
        chordShapePanel5 = new datasoul.song.ChordShapePanel();
        chordShapePanel6 = new datasoul.song.ChordShapePanel();
        fieldName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnApply = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.layout.GroupLayout chordShapePanel1Layout = new org.jdesktop.layout.GroupLayout(chordShapePanel1);
        chordShapePanel1.setLayout(chordShapePanel1Layout);
        chordShapePanel1Layout.setHorizontalGroup(
            chordShapePanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 80, Short.MAX_VALUE)
        );
        chordShapePanel1Layout.setVerticalGroup(
            chordShapePanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 130, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout chordShapePanel2Layout = new org.jdesktop.layout.GroupLayout(chordShapePanel2);
        chordShapePanel2.setLayout(chordShapePanel2Layout);
        chordShapePanel2Layout.setHorizontalGroup(
            chordShapePanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 80, Short.MAX_VALUE)
        );
        chordShapePanel2Layout.setVerticalGroup(
            chordShapePanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 130, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout chordShapePanel3Layout = new org.jdesktop.layout.GroupLayout(chordShapePanel3);
        chordShapePanel3.setLayout(chordShapePanel3Layout);
        chordShapePanel3Layout.setHorizontalGroup(
            chordShapePanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 80, Short.MAX_VALUE)
        );
        chordShapePanel3Layout.setVerticalGroup(
            chordShapePanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 130, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout chordShapePanel4Layout = new org.jdesktop.layout.GroupLayout(chordShapePanel4);
        chordShapePanel4.setLayout(chordShapePanel4Layout);
        chordShapePanel4Layout.setHorizontalGroup(
            chordShapePanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 80, Short.MAX_VALUE)
        );
        chordShapePanel4Layout.setVerticalGroup(
            chordShapePanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 130, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout chordShapePanel5Layout = new org.jdesktop.layout.GroupLayout(chordShapePanel5);
        chordShapePanel5.setLayout(chordShapePanel5Layout);
        chordShapePanel5Layout.setHorizontalGroup(
            chordShapePanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 80, Short.MAX_VALUE)
        );
        chordShapePanel5Layout.setVerticalGroup(
            chordShapePanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 130, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout chordShapePanel6Layout = new org.jdesktop.layout.GroupLayout(chordShapePanel6);
        chordShapePanel6.setLayout(chordShapePanel6Layout);
        chordShapePanel6Layout.setHorizontalGroup(
            chordShapePanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 80, Short.MAX_VALUE)
        );
        chordShapePanel6Layout.setVerticalGroup(
            chordShapePanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 130, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel1.setText("Chord:");

        btnApply.setText("Apply");
        btnApply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApplyMouseClicked(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(chordShapePanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(chordShapePanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(chordShapePanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(chordShapePanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(btnApply, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, chordShapePanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(btnCancel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, chordShapePanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(fieldName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chordShapePanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chordShapePanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chordShapePanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(chordShapePanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chordShapePanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(chordShapePanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancel)
                    .add(btnApply))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnApplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplyMouseClicked
        chord.removeAllShapes();
        
        if(!this.chordShapePanel1.isEmpty())
            chord.addShape(this.chordShapePanel1.getShape());
        if(!this.chordShapePanel2.isEmpty())
                chord.addShape(this.chordShapePanel2.getShape());
        if(!this.chordShapePanel3.isEmpty())
                chord.addShape(this.chordShapePanel3.getShape());
        if(!this.chordShapePanel4.isEmpty())
                chord.addShape(this.chordShapePanel4.getShape());
        if(!this.chordShapePanel5.isEmpty())
                chord.addShape(this.chordShapePanel5.getShape());
        if(!this.chordShapePanel6.isEmpty())
                chord.addShape(this.chordShapePanel6.getShape());

        chord.setName(this.fieldName.getText());
        this.dispose();
    }//GEN-LAST:event_btnApplyMouseClicked
    
    /**
     * @param args the command line arguments
     */
/*    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChordEditorFrame().setVisible(true);
            }
        });
    }
*/    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCancel;
    private datasoul.song.ChordShapePanel chordShapePanel1;
    private datasoul.song.ChordShapePanel chordShapePanel2;
    private datasoul.song.ChordShapePanel chordShapePanel3;
    private datasoul.song.ChordShapePanel chordShapePanel4;
    private datasoul.song.ChordShapePanel chordShapePanel5;
    private datasoul.song.ChordShapePanel chordShapePanel6;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
