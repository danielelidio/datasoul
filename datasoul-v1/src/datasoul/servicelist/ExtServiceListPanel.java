/*
 * ExtServiceListPanel.java
 *
 * Created on May 23, 2008, 6:56 PM
 */

package datasoul.servicelist;

import datasoul.datashow.ServiceItem;
import datasoul.datashow.ServiceListColorRender;
import datasoul.datashow.ServiceListTable;
import datasoul.datashow.TextServiceItem;
import datasoul.datashow.TextServiceItemEditorForm;
import datasoul.song.Song;
import datasoul.song.SongEditorForm;
import datasoul.templates.TemplateComboBox;
import datasoul.util.ObjectManager;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author  samuel
 */
public class ExtServiceListPanel extends javax.swing.JPanel {
    
    /** Creates new form ExtServiceListPanel */
    public ExtServiceListPanel() {
        initComponents();
        ServiceListTable.registerExtendedInstance(this);
        
        tableServiceList.setDraggable(false);
        
        TemplateComboBox comboBox = new TemplateComboBox(); 
        comboBox.setFilterType(TemplateComboBox.FILTER_GENERAL);
        this.tableServiceList.getColumnModel().getColumn(ServiceListTable.ExtendedServiceListTable.COLUMN_TEMPLATE).setCellEditor(new DefaultCellEditor(comboBox));          

        
        ServiceListColorRender cr = new ServiceListColorRender();
        for (int i=0; i<ServiceListTable.ExtendedServiceListTable.COLUMN_COUNT; i++){
            this.tableServiceList.getColumnModel().getColumn(i).setCellRenderer(cr);
        } 
          
        songsSearchPanel1.setSourceView(ObjectManager.VIEW_SERVICE);
        ObjectManager.getInstance().setExtServicePanel(this);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableServiceList = new datasoul.util.DnDTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        toolBar = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JSeparator();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        txtHours = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMinutes = new javax.swing.JTextField();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textSong = new javax.swing.JTextPane();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSongName = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        songsSearchPanel1 = new datasoul.song.SongsSearchPanel();

        jSplitPane1.setDividerLocation(600);

        jLabel2.setText("Start Time:");

        jLabel1.setText("Service Title:");

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        txtTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTitleFocusLost(evt);
            }
        });

        tableServiceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableServiceList);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/fileopen.png"))); // NOI18N
        btnOpen.setText("Open");
        btnOpen.setBorderPainted(false);
        btnOpen.setFocusPainted(false);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOpen);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filesave.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorderPainted(false);
        btnSave.setFocusPainted(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);

        btnSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filesaveas.png"))); // NOI18N
        btnSaveAs.setText("Save As");
        btnSaveAs.setBorderPainted(false);
        btnSaveAs.setFocusPainted(false);
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSaveAs);

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/compfile.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.setBorderPainted(false);
        btnExport.setFocusPainted(false);
        jToolBar1.add(btnExport);

        toolBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        toolBar.setFloatable(false);
        toolBar.setMinimumSize(new java.awt.Dimension(30, 25));
        toolBar.setOpaque(false);

        jSeparator1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        toolBar.add(jSeparator1);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/editdelete.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        btnRemove.setText(bundle.getString("Delete")); // NOI18N
        btnRemove.setToolTipText(bundle.getString("Delete_item")); // NOI18N
        btnRemove.setAlignmentY(0.0F);
        btnRemove.setBorderPainted(false);
        btnRemove.setFocusPainted(false);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        toolBar.add(btnRemove);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/edit.png"))); // NOI18N
        btnEdit.setText("Edit Item");
        btnEdit.setToolTipText(bundle.getString("Edit_selected_item_...")); // NOI18N
        btnEdit.setAlignmentY(0.0F);
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        toolBar.add(btnEdit);

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/up.png"))); // NOI18N
        btnUp.setText("Move Up");
        btnUp.setToolTipText(bundle.getString("Change_item_order_to_upper_position")); // NOI18N
        btnUp.setAlignmentY(0.0F);
        btnUp.setBorderPainted(false);
        btnUp.setFocusPainted(false);
        btnUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpMouseClicked(evt);
            }
        });
        toolBar.add(btnUp);

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/down.png"))); // NOI18N
        btnDown.setText("Move Down");
        btnDown.setToolTipText(bundle.getString("Change_item_order_to_lower_position")); // NOI18N
        btnDown.setAlignmentY(0.0F);
        btnDown.setBorderPainted(false);
        btnDown.setFocusPainted(false);
        btnDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDownMouseClicked(evt);
            }
        });
        toolBar.add(btnDown);

        jLabel4.setText("Service Notes:");

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        txtNotes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNotesFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtNotes);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        txtHours.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHours.setText("10");
        txtHours.setMinimumSize(new java.awt.Dimension(30, 27));
        txtHours.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoursFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoursFocusLost(evt);
            }
        });
        txtHours.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoursKeyPressed(evt);
            }
        });
        jPanel1.add(txtHours);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(":");
        jPanel1.add(jLabel3);

        txtMinutes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinutes.setText("30");
        txtMinutes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMinutesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMinutesFocusLost(evt);
            }
        });
        jPanel1.add(txtMinutes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(495, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jSplitPane2.setDividerLocation(350);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane3.setViewportView(textSong);

        jToolBar2.setFloatable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/kappfinder.png"))); // NOI18N
        jLabel5.setText(bundle.getString("Preview")); // NOI18N
        jToolBar2.add(jLabel5);

        jLabel6.setText(bundle.getString("Author:")); // NOI18N

        jLabel7.setText(bundle.getString("Song:")); // NOI18N

        lblSongName.setText("     ");

        lblAuthor.setText("     ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSongName)
                    .addComponent(lblAuthor))
                .addContainerGap(271, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSongName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblAuthor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel4);
        jSplitPane2.setLeftComponent(songsSearchPanel1);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoursFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoursFocusLost
        try{
            int x = Integer.parseInt(txtHours.getText());
            if (x < 0 || x > 24){
                throw new Exception();
            }
            ServiceListTable.getActiveInstance().setStartHour(x);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Invalid value");
            txtHours.setText(Integer.toString(ServiceListTable.getActiveInstance().getStartHour()));
        }
        revalidate();
    }//GEN-LAST:event_txtHoursFocusLost

    private void txtMinutesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinutesFocusLost
        try{
            int x = Integer.parseInt(txtMinutes.getText());
            if (x < 0 || x > 60){
                throw new Exception();
            }
            ServiceListTable.getActiveInstance().setStartMinute(x);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Invalid value");
            txtMinutes.setText(Integer.toString(ServiceListTable.getActiveInstance().getStartMinute()));
        }
    }//GEN-LAST:event_txtMinutesFocusLost

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void txtTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTitleFocusLost
        ServiceListTable.getActiveInstance().setTitle(txtTitle.getText());
    }//GEN-LAST:event_txtTitleFocusLost

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        ServiceListTable.getActiveInstance().openServiceList();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ServiceListTable.getActiveInstance().saveServiceList();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        ServiceListTable.getActiveInstance().saveServiceListAs();
    }//GEN-LAST:event_btnSaveAsActionPerformed

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        tableServiceList.removeItem();
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tableServiceList.getSelectedRow() == -1){
            return;
        }
        
        ServiceItem item = (ServiceItem)ServiceListTable.getActiveInstance().getServiceItem( tableServiceList.getSelectedRow() );
        if(item instanceof Song){
            SongEditorForm sef = new SongEditorForm((Song)item);
            sef.setVisible(true);
        }else if(item instanceof TextServiceItem){
            TextServiceItemEditorForm tsief = new TextServiceItemEditorForm((TextServiceItem)item);
            tsief.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpMouseClicked
        tableServiceList.upItem();
    }//GEN-LAST:event_btnUpMouseClicked

    private void btnDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDownMouseClicked
        tableServiceList.downItem();
    }//GEN-LAST:event_btnDownMouseClicked

    private void txtNotesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNotesFocusLost
        ServiceListTable.getActiveInstance().setNotes(txtNotes.getText());
}//GEN-LAST:event_txtNotesFocusLost

    private void txtHoursKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoursKeyPressed
    }//GEN-LAST:event_txtHoursKeyPressed

    private void txtHoursFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoursFocusGained
        txtHours.selectAll();
    }//GEN-LAST:event_txtHoursFocusGained

    private void txtMinutesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMinutesFocusGained
        txtMinutes.selectAll();
    }//GEN-LAST:event_txtMinutesFocusGained
    
    public JTable getTableServiceList(){
        return tableServiceList;
    }
    
    public void setStartHourMinute(String hour, String minute){
        txtHours.setText(hour);
        txtMinutes.setText(minute);
    }
    
    public void setTitle(String title){
        txtTitle.setText(title);
    }
    
    public void setNotes(String notes){
        txtNotes.setText(notes);
    }

    public void viewSong(Song song) {
        lblSongName.setText(song.getTitle());
        lblAuthor.setText(song.getSongAuthor());
        textSong.setText(song.getText().replace(Song.CHORUS_MARK, "").replace(Song.SLIDE_BREAK, ""));
        textSong.setCaretPosition(0);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblSongName;
    private datasoul.song.SongsSearchPanel songsSearchPanel1;
    private datasoul.util.DnDTable tableServiceList;
    private javax.swing.JTextPane textSong;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextField txtHours;
    private javax.swing.JTextField txtMinutes;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
    
}
