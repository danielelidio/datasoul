/*
 * SongsListPanel.java
 *
 * Created on 22 de Dezembro de 2005, 21:32
 */

package datasoul.song;

import datasoul.*;
import datasoul.util.*;
import datasoul.datashow.*;
import datasoul.song.*;
import java.io.File;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.basic.BasicDirectoryModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author  Administrador
 */
public class SongsListPanel extends javax.swing.JPanel implements javax.swing.event.TableModelListener{

    private Object objectManager;    

    /**
     * Creates new form SongsListPanel
     */
    public SongsListPanel() {
        initComponents();
  
        tableSongList.setDroppable(false);
        
        loadMusics();
    }
    
    public void loadMusics(){

        SongListTable songTable = new SongListTable();
        
        String path = System.getProperty("user.dir") + System.getProperty("file.separator") + "songs";
        
        File file = new File(path);
        String[] files = file.list();
        
        // there is at least one file in the directroy?
        if (files!=null){
            int size = files.length;
            
            for(int i=0; i<size;i++){
                if(files[i].contains(".song")){
                    File songFile = new File(path + System.getProperty("file.separator") + files[i]);
                    
                    Document dom=null;
                    Node node = null;
                    Song song;
                    try {
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                        
                        //Using factory get an instance of document builder
                        DocumentBuilder db = dbf.newDocumentBuilder();
                        
                        //parse using builder to get DOM representation of the XML file
                        dom = db.parse(songFile);
                        
                        //node = dom.getDocumentElement().getChildNodes().item(0);
                        node = dom.getElementsByTagName("Song").item(0);
                        
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(this,"Error, the file is not well formed\nErro:"+e.getMessage(),"DataSoul Error",0);
                    }
                    
                    song = new Song();
                    try {
                        song.readObject(node);
                        song.setFileName(songFile.getName());
                        song.setFilePath(songFile.getPath());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,"Error, the file is not well formed\nErro:"+e.getMessage(),"DataSoul Error",0);
                    }
                    
                    
                    songTable.addItem(song);
                }
            }
            
        }//if there is any file
        songTable.setView("FileName");
        songTable.addTableModelListener(this);
        
        tableSongList.setModel(songTable);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        toolBar = new javax.swing.JToolBar();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddToList = new javax.swing.JButton();
        scroolSongList = new javax.swing.JScrollPane();
        tableSongList = new datasoul.util.DnDTable();

        toolBar.setBorder(null);
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/new.gif")));
        btnNew.setAlignmentY(0.0F);
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
        });

        toolBar.add(btnNew);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/edit.gif")));
        btnEdit.setAlignmentY(0.0F);
        btnEdit.setName("btnEdit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        toolBar.add(btnEdit);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/delete.gif")));
        btnDelete.setAlignmentY(0.0F);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });

        toolBar.add(btnDelete);

        btnAddToList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/addToList.gif")));
        btnAddToList.setAlignmentY(0.0F);
        btnAddToList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddToListMouseClicked(evt);
            }
        });

        toolBar.add(btnAddToList);

        tableSongList.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSongList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableSongListKeyPressed(evt);
            }
        });
        tableSongList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSongListMouseClicked(evt);
            }
        });

        scroolSongList.setViewportView(tableSongList);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(118, 118, 118))
            .add(scroolSongList, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(scroolSongList, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddToListMouseClicked
        if(objectManager instanceof DatashowPanel){
            DatashowPanel om = (DatashowPanel)objectManager;
            om.getServiceListPanel().addItem(tableSongList.getModel().getValueAt(tableSongList.getSelectedRow(),0));
        }else{
            SongsPanel om = (SongsPanel)objectManager;            
            om.getPraiseListPanel().addItem(tableSongList.getModel().getValueAt(tableSongList.getSelectedRow(),0));
        }
    }//GEN-LAST:event_btnAddToListMouseClicked

    private void tableSongListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSongListMouseClicked
        showItem();
    }//GEN-LAST:event_tableSongListMouseClicked

    private void tableSongListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableSongListKeyPressed
        showItem();
    }//GEN-LAST:event_tableSongListKeyPressed

    private void showItem(){
        if(objectManager instanceof DatashowPanel){
            DatashowPanel om = (DatashowPanel)objectManager;
            om.getPreviewPanel().previewItem();
        }else{
            SongsPanel om = (SongsPanel)objectManager;            
            om.getSongViewerPanel().viewSong((Song)tableSongList.getModel().getValueAt(tableSongList.getSelectedRow(),0));
        }
    }
    
    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        Song song = (Song)tableSongList.getModel().getValueAt(tableSongList.getSelectedRow(),0);
        String filePath = song.getFilePath();
        
        File file = new File(filePath);
        if(JOptionPane.showConfirmDialog(this,"Are you shure that you want to delete the file "+filePath+" ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            if(file.delete()){
                tableSongList.removeItem();                
            }
        }
        this.repaint();
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
///        File file = new File("D:/Meus Documentos/Datasoul/songs/"+listSongs.getModel().getElementAt(listSongs.getSelectedIndex())+".song");
///        SongEditorFrame songEditor = new SongEditorFrame(file);

        SongEditorFrame songEditor = new SongEditorFrame((Song)tableSongList.getModel().getValueAt(tableSongList.getSelectedRow(),0));        
        songEditor.setVisible(true);
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        File file = new File("");
        SongEditorFrame songEditor = new SongEditorFrame();

        songEditor.setVisible(true);
    }//GEN-LAST:event_btnNewMouseClicked

    public void tableChanged(TableModelEvent e) {
        this.repaint();
    }

    public Object getObjectManager() {
        return objectManager;
    }

    public void setObjectManager(Object objectManager) {
        this.objectManager = objectManager;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToList;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JScrollPane scroolSongList;
    private datasoul.util.DnDTable tableSongList;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    
}
