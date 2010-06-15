/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SongChordEditorPanel.java
 *
 * Created on Mar 27, 2010, 1:02:27 AM
 */

package datasoul.serviceitems.song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

/**
 *
 * @author samuel
 */
public class SongChordEditorPanel extends javax.swing.JPanel {

    private enum TransposeDirection{
        Transpose_Up,
        Transpose_Down
    };

    private static HashMap<String, String> mapTranspUpFlat;
    private static HashMap<String, String> mapTranspUpSharp;
    private static HashMap<String, String> mapTranspDownFlat;
    private static HashMap<String, String> mapTranspDownSharp;

    /** Creates new form SongChordEditorPanel */
    public SongChordEditorPanel() {
        initComponents();
        textChords.setChords(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTabs = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnlGridTabs = new javax.swing.JPanel();
        pnlTabsNotFound = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNotFound = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRefreshTabs = new javax.swing.JButton();
        btnTabsCatalog = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textChords = new datasoul.util.HighlightTextArea();
        transposeToolbar = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTranspose = new javax.swing.JComboBox();
        btnTransposeUp = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnlTabs.setPreferredSize(new java.awt.Dimension(100, 221));
        pnlTabs.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlGridTabs.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane4.setViewportView(pnlGridTabs);

        pnlTabs.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        pnlTabsNotFound.setLayout(new java.awt.GridLayout(2, 1));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        jLabel2.setText(bundle.getString("NOT FOUND:")); // NOI18N
        pnlTabsNotFound.add(jLabel2);

        lblNotFound.setText("jLabel3");
        pnlTabsNotFound.add(lblNotFound);

        pnlTabs.add(pnlTabsNotFound, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        btnRefreshTabs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/view-refresh.png"))); // NOI18N
        btnRefreshTabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTabsActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefreshTabs, java.awt.BorderLayout.LINE_START);

        btnTabsCatalog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/gtk-edit.png"))); // NOI18N
        btnTabsCatalog.setText(bundle.getString("EDIT")); // NOI18N
        btnTabsCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabsCatalogActionPerformed(evt);
            }
        });
        jPanel2.add(btnTabsCatalog, java.awt.BorderLayout.CENTER);

        pnlTabs.add(jPanel2, java.awt.BorderLayout.NORTH);

        add(pnlTabs, java.awt.BorderLayout.EAST);

        textChords.setColumns(20);
        textChords.setRows(5);
        textChords.setFont(new java.awt.Font("Courier New", 0, 13));
        jScrollPane3.setViewportView(textChords);

        add(jScrollPane3, java.awt.BorderLayout.CENTER);

        transposeToolbar.setFloatable(false);
        transposeToolbar.setRollover(true);

        jLabel3.setText("  ");
        transposeToolbar.add(jLabel3);

        jLabel1.setText(bundle.getString("TRANSPOSE USING")); // NOI18N
        transposeToolbar.add(jLabel1);

        jLabel4.setText("  ");
        transposeToolbar.add(jLabel4);

        cbTranspose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "#", "b" }));
        cbTranspose.setMaximumSize(new java.awt.Dimension(60, 32767));
        transposeToolbar.add(cbTranspose);

        btnTransposeUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/view-sort-ascending.png"))); // NOI18N
        btnTransposeUp.setBorderPainted(false);
        btnTransposeUp.setFocusable(false);
        btnTransposeUp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransposeUp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTransposeUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransposeUpActionPerformed(evt);
            }
        });
        transposeToolbar.add(btnTransposeUp);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/view-sort-descending.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        transposeToolbar.add(jButton2);

        add(transposeToolbar, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshTabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTabsActionPerformed
        updateTabs();
}//GEN-LAST:event_btnRefreshTabsActionPerformed

    private void btnTabsCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabsCatalogActionPerformed
        ChordsManagerFrame cmf = new ChordsManagerFrame();
        cmf.setLocationRelativeTo(this);
        cmf.setVisible(true);
    }//GEN-LAST:event_btnTabsCatalogActionPerformed

    private void btnTransposeUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransposeUpActionPerformed
        transposeChords(TransposeDirection.Transpose_Up);
    }//GEN-LAST:event_btnTransposeUpActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        transposeChords(TransposeDirection.Transpose_Down);
    }//GEN-LAST:event_jButton2ActionPerformed


    public void init(){
        textChords.setCaretPosition(0);
    }

    public void setText(String s){
        textChords.setText(s);
    }

    public String getText(){
        return textChords.getText();
    }

    public void setTransposeVisible(boolean b){
        transposeToolbar.setVisible(b);
    }

    public void setTabsVisible(boolean b){
        pnlTabs.setVisible(b);
        if (b){
            updateTabs();
        }
    }

    private void updateTabs(){

        /* clean up */
        pnlGridTabs.removeAll();

        /* get used chords */
        ArrayList<String> usedChords = Song.getUsedChords(textChords.getText());

        /* Process it */
        ArrayList<String> notFound = new ArrayList<String>();
        ChordsDB chordsDB = ChordsDB.getInstance();
        for(String chordStr : usedChords){
            Chord chord = chordsDB.getChordByName(chordStr);
            if(chord!=null){
                ChordShapePanel csp = new ChordShapePanel(2, chord.getName(),chord.getShape());
                csp.setEditable(false);
                pnlGridTabs.add(csp);
            }else{
                if (!notFound.contains(chordStr)){
                    notFound.add(chordStr);
                }
            }
        }

        pnlTabsNotFound.setVisible(notFound.size() > 0);
        StringBuffer sb = new StringBuffer();
        for (String nf : notFound){
            sb.append(nf);
            sb.append(" ");
        }
        lblNotFound.setText(sb.toString());

        pnlGridTabs.revalidate();

    }

    private static synchronized void initTransposeMaps(){

        mapTranspUpFlat = new HashMap<String,String>();
        mapTranspUpSharp = new HashMap<String,String>();
        mapTranspDownFlat = new HashMap<String,String>();
        mapTranspDownSharp = new HashMap<String,String>();

        // Up using flats
        mapTranspUpFlat.put("Ab", "A" );
        mapTranspUpFlat.put("A",  "Bb");
        mapTranspUpFlat.put("A#", "B" );
        mapTranspUpFlat.put("Bb", "B" );
        mapTranspUpFlat.put("B",  "C" );
        mapTranspUpFlat.put("B#", "Db");
        mapTranspUpFlat.put("Cb", "C" );
        mapTranspUpFlat.put("C",  "Db");
        mapTranspUpFlat.put("C#", "D" );
        mapTranspUpFlat.put("Db", "D" );
        mapTranspUpFlat.put("D",  "Eb");
        mapTranspUpFlat.put("D#", "E" );
        mapTranspUpFlat.put("Eb", "E" );
        mapTranspUpFlat.put("E",  "F" );
        mapTranspUpFlat.put("E#", "Gb");
        mapTranspUpFlat.put("Fb", "F" );
        mapTranspUpFlat.put("F",  "Gb");
        mapTranspUpFlat.put("F#", "G" );
        mapTranspUpFlat.put("Gb", "G" );
        mapTranspUpFlat.put("G",  "Ab");
        mapTranspUpFlat.put("G#", "A" );

        // Up using Sharps
        mapTranspUpSharp.put("Ab", "A" );
        mapTranspUpSharp.put("A",  "A#");
        mapTranspUpSharp.put("A#", "B" );
        mapTranspUpSharp.put("Bb", "B" );
        mapTranspUpSharp.put("B",  "C" );
        mapTranspUpSharp.put("B#", "C#");
        mapTranspUpSharp.put("Cb", "C" );
        mapTranspUpSharp.put("C",  "C#");
        mapTranspUpSharp.put("C#", "D" );
        mapTranspUpSharp.put("Db", "D" );
        mapTranspUpSharp.put("D",  "D#");
        mapTranspUpSharp.put("D#", "E" );
        mapTranspUpSharp.put("Eb", "E" );
        mapTranspUpSharp.put("E",  "F" );
        mapTranspUpSharp.put("E#", "F#");
        mapTranspUpSharp.put("Fb", "F" );
        mapTranspUpSharp.put("F",  "F#");
        mapTranspUpSharp.put("F#", "G" );
        mapTranspUpSharp.put("Gb", "G" );
        mapTranspUpSharp.put("G",  "G#");
        mapTranspUpSharp.put("G#", "A" );

        // Down using flats
        mapTranspDownFlat.put("Ab", "G" );
        mapTranspDownFlat.put("A",  "Ab");
        mapTranspDownFlat.put("A#", "A" );
        mapTranspDownFlat.put("Bb", "A" );
        mapTranspDownFlat.put("B",  "Bb");
        mapTranspDownFlat.put("B#", "B" );
        mapTranspDownFlat.put("Cb", "Bb");
        mapTranspDownFlat.put("C",  "B" );
        mapTranspDownFlat.put("C#", "C" );
        mapTranspDownFlat.put("Db", "C" );
        mapTranspDownFlat.put("D",  "Db");
        mapTranspDownFlat.put("D#", "D" );
        mapTranspDownFlat.put("Eb", "D" );
        mapTranspDownFlat.put("E",  "Eb");
        mapTranspDownFlat.put("E#", "E" );
        mapTranspDownFlat.put("Fb", "Eb");
        mapTranspDownFlat.put("F",  "E" );
        mapTranspDownFlat.put("F#", "F" );
        mapTranspDownFlat.put("Gb", "F" );
        mapTranspDownFlat.put("G",  "Gb");
        mapTranspDownFlat.put("G#", "G" );

        // Down using sharps
        mapTranspDownSharp.put("Ab", "G" );
        mapTranspDownSharp.put("A",  "G#");
        mapTranspDownSharp.put("A#", "A" );
        mapTranspDownSharp.put("Bb", "A" );
        mapTranspDownSharp.put("B",  "A#");
        mapTranspDownSharp.put("B#", "B" );
        mapTranspDownSharp.put("Cb", "A#");
        mapTranspDownSharp.put("C",  "B" );
        mapTranspDownSharp.put("C#", "C" );
        mapTranspDownSharp.put("Db", "C" );
        mapTranspDownSharp.put("D",  "C#");
        mapTranspDownSharp.put("D#", "D" );
        mapTranspDownSharp.put("Eb", "D" );
        mapTranspDownSharp.put("E",  "D#");
        mapTranspDownSharp.put("E#", "E" );
        mapTranspDownSharp.put("Fb", "D#");
        mapTranspDownSharp.put("F",  "E" );
        mapTranspDownSharp.put("F#", "F" );
        mapTranspDownSharp.put("Gb", "F" );
        mapTranspDownSharp.put("G",  "F#");
        mapTranspDownSharp.put("G#", "G" );


    }

    private String transposeSingleChord(TransposeDirection direction, String from){

        HashMap<String,String> map;

        if (mapTranspDownFlat == null){
            SongChordEditorPanel.initTransposeMaps();
        }

        // sharp or flags
        if ( cbTranspose.getSelectedItem().toString().equals("#")){
            if (direction == TransposeDirection.Transpose_Up){
                map = SongChordEditorPanel.mapTranspUpSharp;
            }else{
                map = SongChordEditorPanel.mapTranspDownSharp;
            }
        }else{
            if (direction == TransposeDirection.Transpose_Up){
                map = SongChordEditorPanel.mapTranspUpFlat;
            }else{
                map = SongChordEditorPanel.mapTranspDownFlat;
            }
        }

        if (map.containsKey(from)){
            return map.get(from);
        }else{
            return from;
        }

    }

    private void transposeLine(String line, StringBuffer output, TransposeDirection direction){

        int addspace = 0;
        int readsize = 0;
        String transposed;

        // First, expand any tabs
        line = line.replaceAll("\t", "        ");

        for (int i=0; i<line.length(); i++){

            // Need to transpose
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'G'){

                // Check for # or b
                if ((i+1 < line.length()) && (line.charAt(i+1)=='b' || line.charAt(i+1)=='#')){
                    readsize = 2;
                    transposed = transposeSingleChord(direction, Character.toString(line.charAt(i)) + Character.toString(line.charAt(i+1)) );
                    i++;
                }else{
                    readsize = 1;
                    transposed = transposeSingleChord(direction, Character.toString(line.charAt(i)) );
                }

                output.append(transposed);

                // If needed add or remove blank spaces
                if (readsize == 2 && transposed.length() == 1){
                    addspace++;
                }else if (readsize == 1 && transposed.length() == 2){
                    addspace--;
                }
            } else if (addspace != 0 && line.charAt(i)==' '){

                // Check for spaces
                if (addspace < 0){
                    addspace++;
                    continue;
                }

                while (addspace > 0){
                    output.append(" ");
                    addspace--;
                }
                
                output.append(" ");
                
            } else {
                // Copy any other char
                output.append(line.charAt(i));
            }

        }// for each char
    }


    private void transposeChords(TransposeDirection direction){

        int pos;

        StringBuffer output = new StringBuffer();
        for (String line : textChords.getText().split("\n")){
            Matcher m = Song.CHORDS_REGEX_PATTERN.matcher(line);
            if (m.find()){
                transposeLine(line, output, direction);
            }else{
                output.append(line);
            }
            output.append("\n");
        }

        pos = textChords.getCaretPosition();

        textChords.setText(output.toString());

        textChords.setCaretPosition(pos);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefreshTabs;
    private javax.swing.JButton btnTabsCatalog;
    private javax.swing.JButton btnTransposeUp;
    private javax.swing.JComboBox cbTranspose;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNotFound;
    private javax.swing.JPanel pnlGridTabs;
    private javax.swing.JPanel pnlTabs;
    private javax.swing.JPanel pnlTabsNotFound;
    private datasoul.util.HighlightTextArea textChords;
    private javax.swing.JToolBar transposeToolbar;
    // End of variables declaration//GEN-END:variables

}
