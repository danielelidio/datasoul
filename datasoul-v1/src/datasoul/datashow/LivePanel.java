package datasoul.datashow;
import datasoul.ConfigObj;
import datasoul.render.ContentManager;
import datasoul.song.Song;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author  Administrador
 */
public class LivePanel extends javax.swing.JPanel implements ListSelectionListener {

    private AutomaticChanger automaticChanger;
    
    private int lastSelectedIndex;
    
    /**
     * Creates new form LivePanel
     */
    public LivePanel() {
        initComponents();
        serviceItemTable1.addTableListener(this);
        automaticChanger = new AutomaticChanger();
    }

    public void setFocusInTable(){
        serviceItemTable1.setFocusInTable();
    }
    
    public void showItem(ServiceItem serviceItem){

        ContentManager cm = ContentManager.getInstance();
        cm.saveTransitionImage();
        cm.setTemplateLive(serviceItem.getTemplate());
        cm.setTitleLive(serviceItem.getTitle());
        if(serviceItem instanceof Song)
            cm.setSongAuthorLive( ((Song)serviceItem).getSongAuthor() );
        this.serviceItemTable1.setServiceItem(serviceItem);
        cm.setSlideLive( serviceItemTable1.getSlideText() );
        cm.setNextSlideLive( serviceItemTable1.getNextSlideText() );
        cm.slideChange(ConfigObj.getInstance().getSlideTransitionTime());
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        labelLive = new javax.swing.JLabel();
        serviceItemTable1 = new datasoul.datashow.ServiceItemTable();
        cbAutoChange = new javax.swing.JCheckBox();
        spnTimer = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDoubleBuffered(false);
        labelLive.setFont(new java.awt.Font("Dialog", 3, 10));
        labelLive.setText(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("LIVE"));

        serviceItemTable1.setDoubleBuffered(false);

        cbAutoChange.setText("Change every");
        cbAutoChange.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbAutoChange.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cbAutoChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutoChangeActionPerformed(evt);
            }
        });

        jLabel1.setText("seconds");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(labelLive)
                .addContainerGap(402, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(cbAutoChange)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(spnTimer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addContainerGap(205, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, serviceItemTable1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(labelLive)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cbAutoChange)
                    .add(spnTimer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .add(7, 7, 7)
                .add(serviceItemTable1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbAutoChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutoChangeActionPerformed

        if (cbAutoChange.isSelected()){
            automaticChanger.startChanging( Integer.parseInt(spnTimer.getValue().toString()) * 1000 );
        }else{
            automaticChanger.stopChanging();
        }

        
    }//GEN-LAST:event_cbAutoChangeActionPerformed

    public void valueChanged(ListSelectionEvent e) {

        // when changing slides with mouse, two events are generated for
        // the same change, one for pressing and other for releasing the mouse button
        // this check avoids processing twice, what makes the transiction effect broken
        if ( serviceItemTable1.getSlideIndex() == lastSelectedIndex || serviceItemTable1.getSlideIndex() < 0){
            return;
        }else{
            lastSelectedIndex = serviceItemTable1.getSlideIndex();
        }
        
        
        ContentManager cm = ContentManager.getInstance();
        cm.saveTransitionImage();
        cm.setSlideLive( serviceItemTable1.getSlideText() );
        cm.setNextSlideLive( serviceItemTable1.getNextSlideText() );
        cm.slideChange(ConfigObj.getInstance().getSlideTransitionTime());
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbAutoChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelLive;
    private datasoul.datashow.ServiceItemTable serviceItemTable1;
    private javax.swing.JSpinner spnTimer;
    // End of variables declaration//GEN-END:variables
    
    
    private class AutomaticChanger extends Thread {
        
        boolean stopThread = false;
        long timer;
        
        public AutomaticChanger(){
            this.start();
        }
        
        public void startChanging(int timer){
            this.timer = timer;
            stopThread = false;
            synchronized(this){
                this.notify();
            }
        }
        
        public void stopChanging(){
            stopThread = true;
            this.interrupt();
        }
        
        private void change(){
            
            int maxSlide = serviceItemTable1.getSlideCount();
            int showSlide = serviceItemTable1.getSlideIndex() + 1;

            if (showSlide >= maxSlide){
                showSlide = 0;
            }
            
            serviceItemTable1.setSlideIndex(showSlide);
        }
        
        public void run(){

            long t1, t2;

            while (true){
                
                synchronized(this){
                    try {
                        this.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                
                while (!stopThread){

                    t1 = System.currentTimeMillis();

                    change();

                    // go sleep!
                    t2 = System.currentTimeMillis();
                    if ( (timer - (t2 - t1)) > 1 ){
                        try {
                            Thread.sleep( timer - (t2 - t1) );
                        } catch (InterruptedException ex) {
                            //ignore. just exist form sleep
                        }
                    }

                }//while stopthread
            }//while true
        }// run
    }
    
}
