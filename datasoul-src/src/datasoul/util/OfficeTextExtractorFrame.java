/*
 * Copyright 2005-2010 Samuel Mello
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 */

/*
 * OfficeTextExtractorFrame.java
 *
 * Created on 29/07/2010, 21:37:12
 */

package datasoul.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import datasoul.config.ConfigObj;
import datasoul.config.DisplayControlConfig;
import datasoul.serviceitems.song.AllSongsListTable;
import datasoul.serviceitems.song.Song;
import datasoul.serviceitems.text.TextServiceItem;

/**
 *
 * @author samuel
 */
public class OfficeTextExtractorFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5452527503567755096L;

	/** Creates new form OfficeTextExtractorFrame */
    public OfficeTextExtractorFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("CONVERTING OFFICE FILES")); // NOI18N
        setResizable(false);

        jLabel1.setText(bundle.getString("CONVERTING:")); // NOI18N

        lblName.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblName)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables

    public void findText(Node n, StringBuffer sb){
        if (n.getNodeName().equals("text:span")){
            sb.append(n.getTextContent());
            sb.append("\n");
        }else if (n.getNodeName().equals("text:p")){
            sb.append(n.getTextContent());
            sb.append("\n");
        }else{
            NodeList childs = n.getChildNodes();
            for (int i=0; i<childs.getLength(); i++){
                if (childs.item(i).getNodeType() == Node.ELEMENT_NODE)
                findText(childs.item(i), sb);
            }
        }
    }

    public void convertPresentationToText (File f, StringBuffer sb) throws IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //Using factory get an instance of document builder
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new IOException(ex);
        }

        ZipFile zip;
        Document dom;

        // Newer format, zip
        zip = new ZipFile(f);
        try{
            ZipEntry ze = zip.getEntry("content.xml");

            if (ze == null){
                zip.close();
                throw new IOException(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("INVALID OPENOFFICE PRESENTATION FILE"));
            }

            dom = db.parse(zip.getInputStream(ze));

            NodeList pagelist = dom.getElementsByTagName("draw:page");

            for (int i=0; i<pagelist.getLength(); i++){
                StringBuffer temp = new StringBuffer();
                findText(pagelist.item(i), temp);

                // if there is any text, add it
                String text = temp.toString().trim();
                if (text.length() > 0){
                    sb.append(text);
                    sb.append("\n");
                    if (i+1 < pagelist.getLength()){
                        sb.append(TextServiceItem.CHORUS_MARK);
                        sb.append("\n");
                    }
                }
            }
        }catch(SAXException e){
            throw new IOException(e);
        }finally{
            // Close the input stream
            zip.close();
        }
    }


    public void processOfficeFile(File officeFile) throws IOException, InterruptedException{

        // Determine the name
        String origname = officeFile.getName();
        origname = origname.substring(0, origname.lastIndexOf("."));

        // Find a valid name
        int count = 0;
        String name = origname;
        String path = ConfigObj.getActiveInstance().getStoragePathSongs();
        File songFile = new File(path + File.separator + name + ".song");
        while (songFile.exists()){
            count++;
            name = origname + count;
            songFile = new File(path + File.separator + name + ".song");
        }


        // Create song object
        Song song = new Song();
        song.setTitle(name);
        song.setFilePath(songFile.getAbsolutePath());
        song.setTemplate(DisplayControlConfig.getInstance().getDefaultTemplateSong());

        // If needed, convert the file to ODP
        File processFile = officeFile;
        if (officeFile.getName().toLowerCase().endsWith("ppt") ||
                officeFile.getName().toLowerCase().endsWith("pptx")){
            OpenofficeHelper helper = new OpenofficeHelper();
            String convFile = helper.convertToODP(officeFile);
            processFile = new File(convFile);
            if (!processFile.exists()){
                throw new IOException(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("UNABLE TO CONVERT DOCUMENT: ")+officeFile.getName());
            }
            helper.dispose();
        }

        // Extract text from Office file
        StringBuffer sb = new StringBuffer();
        convertPresentationToText(processFile, sb);
        song.setText(sb.toString());

        // If needed, cleanup converted ODP file
        if (processFile != officeFile){
            processFile.delete();
        }

        // Write the file
        try{
            Node node = song.writeObject(null);
            Document doc = node.getOwnerDocument();
            doc.appendChild( node);                        // Add Root to Document
            FileOutputStream fos = new FileOutputStream(song.getFilePath());

            Source source = new DOMSource(doc);

            // Prepare the output file
            Result result = new StreamResult(fos);

            // Write the DOM document to the file
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.setOutputProperty(OutputKeys.INDENT, "yes");
            xformer.transform(source, result);

            fos.close();

        } catch(Exception e){
            ShowDialog.showWriteFileError(song.getFileName(), e);
        }

        // Update table
        AllSongsListTable.getInstance().addItem(song);

    }

    public void showConvertDialog(){

        final JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setMultiSelectionEnabled(true);
        fc.addChoosableFileFilter( new FileNameExtensionFilter(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("PRESENTATION FILES")+" (*.odp,*.ppt,*.pptx)", "odp", "ppt", "pptx") );
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            jProgressBar1.setMaximum(fc.getSelectedFiles().length);
            lblName.setText("");
            setVisible(true);

            Thread process = new Thread(){
                public void run(){
                    int i = 0;
                    for (File f : fc.getSelectedFiles()){

                        // Update graphic
                        lblName.setText(f.getName());
                        jProgressBar1.setValue(++i);

                        // Process file
                        try {
                            processOfficeFile(f);
                        } catch (IOException ex) {
                            ShowDialog.showWriteFileError(f.getName(), ex);
                        } catch (InterruptedException ex2) {
                            ShowDialog.showWriteFileError(f.getName(), ex2);
                        }
                    }
                    AllSongsListTable.getInstance().sortByName();

                    OfficeTextExtractorFrame.this.dispose();
                }
            };

            process.start();
        }
    }


}
