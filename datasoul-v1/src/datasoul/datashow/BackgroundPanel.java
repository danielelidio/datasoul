/*
 * BackgroundPanel.java
 *
 * Created on 13 July 2006, 00:00
 */

package datasoul.datashow;

import datasoul.config.BackgroundConfig;
import datasoul.config.ConfigObj;
import datasoul.render.ContentManager;
import datasoul.templates.DisplayTemplate;
import datasoul.templates.ImageTemplateItem;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author  samuelm
 */
public class BackgroundPanel extends javax.swing.JPanel {
    
    /** Creates new form BackgroundPanel */
    public BackgroundPanel() {
        
        initComponents();

        BufferedImage img1 = BackgroundConfig.getInstance().getMainBackgroundImg();
        BufferedImage img2 = BackgroundConfig.getInstance().getMonitorBackgroundImg();
        
        imageDisplayMain.getImageTemplateItem().setStretchIdx(ImageTemplateItem.STRETCH_NO);
        imageDisplayMain.getImageTemplateItem().setAlignmentIdx(ImageTemplateItem.ALIGN_CENTER);
        imageDisplayMain.getImageTemplateItem().setVerticalAlignmentIdx(ImageTemplateItem.VALIGN_MIDDLE);
        imageDisplayMain.updateSize();
        
        imageDisplayMonitor.getImageTemplateItem().setStretchIdx(ImageTemplateItem.STRETCH_NO);
        imageDisplayMonitor.getImageTemplateItem().setAlignmentIdx(ImageTemplateItem.ALIGN_CENTER);
        imageDisplayMonitor.getImageTemplateItem().setVerticalAlignmentIdx(ImageTemplateItem.VALIGN_MIDDLE);
        imageDisplayMonitor.updateSize();
        
        imageDisplayMain.getImageTemplateItem().setImage(img1);
        imageDisplayMonitor.getImageTemplateItem().setImage(img2);

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        cbMainBackgroundMode = new javax.swing.JComboBox();
        btnChangeMain = new javax.swing.JButton();
        imageDisplayMain = new datasoul.util.ImageDisplay();
        btnColorMain = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbMonitorBackgroundMode = new javax.swing.JComboBox();
        btnChangeMonitor = new javax.swing.JButton();
        imageDisplayMonitor = new datasoul.util.ImageDisplay();
        btnMonitorColor = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Main Output"));
        cbMainBackgroundMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Static", "Live" }));
        cbMainBackgroundMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMainBackgroundModeItemStateChanged(evt);
            }
        });
        cbMainBackgroundMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMainBackgroundModeActionPerformed(evt);
            }
        });

        btnChangeMain.setText("Image");
        btnChangeMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeMainActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout imageDisplayMainLayout = new org.jdesktop.layout.GroupLayout(imageDisplayMain);
        imageDisplayMain.setLayout(imageDisplayMainLayout);
        imageDisplayMainLayout.setHorizontalGroup(
            imageDisplayMainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 278, Short.MAX_VALUE)
        );
        imageDisplayMainLayout.setVerticalGroup(
            imageDisplayMainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 110, Short.MAX_VALUE)
        );

        btnColorMain.setText("Color");
        btnColorMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorMainActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, imageDisplayMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(cbMainBackgroundMode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnChangeMain)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnColorMain)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbMainBackgroundMode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChangeMain)
                    .add(btnColorMain))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(imageDisplayMain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Monitor Output"));
        cbMonitorBackgroundMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Static", "Live" }));
        cbMonitorBackgroundMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonitorBackgroundModeItemStateChanged(evt);
            }
        });
        cbMonitorBackgroundMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonitorBackgroundModeActionPerformed(evt);
            }
        });

        btnChangeMonitor.setText("Image");
        btnChangeMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeMonitorActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout imageDisplayMonitorLayout = new org.jdesktop.layout.GroupLayout(imageDisplayMonitor);
        imageDisplayMonitor.setLayout(imageDisplayMonitorLayout);
        imageDisplayMonitorLayout.setHorizontalGroup(
            imageDisplayMonitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 278, Short.MAX_VALUE)
        );
        imageDisplayMonitorLayout.setVerticalGroup(
            imageDisplayMonitorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 111, Short.MAX_VALUE)
        );

        btnMonitorColor.setText("Color");
        btnMonitorColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorColorActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, imageDisplayMonitor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3Layout.createSequentialGroup()
                        .add(cbMonitorBackgroundMode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnChangeMonitor)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnMonitorColor)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbMonitorBackgroundMode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChangeMonitor)
                    .add(btnMonitorColor))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(imageDisplayMonitor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMonitorColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorColorActionPerformed

        JColorChooser cc = new JColorChooser();
        Color color =  cc.showDialog(this, "Choose color", Color.BLACK);
        if (color != null){ // color is null if the user choose cancel.
            BufferedImage img = new BufferedImage(DisplayTemplate.TEMPLATE_WIDTH, DisplayTemplate.TEMPLATE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g = img.createGraphics();
            g.setColor(color);
            g.fillRect(0, 0, DisplayTemplate.TEMPLATE_WIDTH, DisplayTemplate.TEMPLATE_HEIGHT);
            imageDisplayMonitor.getImageTemplateItem().setImage(img);
            BackgroundConfig.getInstance().setMonitorBackgroundImg(img);
        }
        
    }//GEN-LAST:event_btnMonitorColorActionPerformed

    private void btnColorMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorMainActionPerformed

        JColorChooser cc = new JColorChooser();
        Color color =  cc.showDialog(this, "Choose color", Color.BLACK);
        if (color != null){ // color is null if the user choose cancel.
            BufferedImage img = new BufferedImage(DisplayTemplate.TEMPLATE_WIDTH, DisplayTemplate.TEMPLATE_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics2D g = img.createGraphics();
            g.setColor(color);
            g.fillRect(0, 0, DisplayTemplate.TEMPLATE_WIDTH, DisplayTemplate.TEMPLATE_HEIGHT);
            imageDisplayMain.getImageTemplateItem().setImage(img);
            BackgroundConfig.getInstance().setMainBackgroundImg(img);
        }
        
    }//GEN-LAST:event_btnColorMainActionPerformed

    private void btnChangeMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeMonitorActionPerformed

        JFileChooser fc = new JFileChooser();
        File dir = new File (System.getProperty("user.dir"));
        fc.setCurrentDirectory(dir);
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setControlButtonsAreShown(true);
        fc.setDialogTitle("Select Image");
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION && fc.getSelectedFile().exists() ){
            String filename = fc.getSelectedFile().getAbsolutePath();
            imageDisplayMonitor.getImageTemplateItem().loadImage(filename);
            BackgroundConfig.getInstance().setMonitorBackgroundImg( imageDisplayMonitor.getImageTemplateItem().getImage() );
            imageDisplayMonitor.updateSize();
            imageDisplayMonitor.repaint();
        }        
        
    }//GEN-LAST:event_btnChangeMonitorActionPerformed

    private void btnChangeMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeMainActionPerformed

        JFileChooser fc = new JFileChooser();
        File dir = new File (System.getProperty("user.dir"));
        fc.setCurrentDirectory(dir);
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setControlButtonsAreShown(true);
        fc.setDialogTitle("Select Image");
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION && fc.getSelectedFile().exists() ){
            String filename = fc.getSelectedFile().getAbsolutePath();
            imageDisplayMain.getImageTemplateItem().loadImage(filename);
            BackgroundConfig.getInstance().setMainBackgroundImg( imageDisplayMain.getImageTemplateItem().getImage() );
            imageDisplayMain.updateSize();
            imageDisplayMain.repaint();
        }        
        
    }//GEN-LAST:event_btnChangeMainActionPerformed

    private void cbMonitorBackgroundModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonitorBackgroundModeActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_cbMonitorBackgroundModeActionPerformed

    private void cbMonitorBackgroundModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonitorBackgroundModeItemStateChanged

        if ( cbMonitorBackgroundMode.getSelectedIndex() == 0 ){
            btnChangeMonitor.setEnabled(true);
        }else{
            btnChangeMonitor.setEnabled(false);
        }
        
        if ( ConfigObj.getInstance().getMonitorOutput() ){
            ContentManager.getMonitorDisplay().setBackgroundMode( cbMonitorBackgroundMode.getSelectedIndex() );
        }

    }//GEN-LAST:event_cbMonitorBackgroundModeItemStateChanged

    private void cbMainBackgroundModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMainBackgroundModeActionPerformed
        
    }//GEN-LAST:event_cbMainBackgroundModeActionPerformed

    private void cbMainBackgroundModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMainBackgroundModeItemStateChanged

        if ( cbMainBackgroundMode.getSelectedIndex() == 0 ){
            btnChangeMain.setEnabled(true);
        }else{
            btnChangeMain.setEnabled(false);
        }
        
        if ( ConfigObj.getInstance().getMainOutput() ){
            ContentManager.getMainDisplay().setBackgroundMode( cbMainBackgroundMode.getSelectedIndex() );
        }
    }//GEN-LAST:event_cbMainBackgroundModeItemStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeMain;
    private javax.swing.JButton btnChangeMonitor;
    private javax.swing.JButton btnColorMain;
    private javax.swing.JButton btnMonitorColor;
    private javax.swing.JComboBox cbMainBackgroundMode;
    private javax.swing.JComboBox cbMonitorBackgroundMode;
    private datasoul.util.ImageDisplay imageDisplayMain;
    private datasoul.util.ImageDisplay imageDisplayMonitor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
    
}
