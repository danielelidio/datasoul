/* 
 * Copyright 2005-2010 Samuel Mello & Eduardo Schnell
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 or later of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

/*
 * TextServiceItem.java
 *
 * Created on February 10, 2006, 9:39 PM
 *
 */

package datasoul.serviceitems.text;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import datasoul.config.DisplayControlConfig;
import datasoul.serviceitems.ServiceItem;
import datasoul.util.ObjectManager;

/**
 *
 * @author samuelm
 */
public class TextServiceItem extends ServiceItem {
    
    private String text;
    public final static String SLIDE_BREAK = "==";
    public final static String CHORUS_MARK = "===";
    
    /** Creates a new instance of TextServiceItem */
    public TextServiceItem() {
        super();
        this.text = "";
        this.template = DisplayControlConfig.getInstance().getDefaultTemplateText();
        cellEditor = new TextAreaCellEditor();
    }
    
    protected void registerProperties() {
        super.registerProperties();
        properties.add("Text");        
    }
             
    public void setText(String text){
        
        this.text = text.trim().replace("\r\n", "\n");
        
        String chorus[];
        chorus = this.text.trim().split("\n"+TextServiceItem.CHORUS_MARK+"\n");
        
        slides.clear();
        for (int k=0; k<chorus.length; k++){

            String slidesStr[] = chorus[k].split("\n"+TextServiceItem.SLIDE_BREAK+"\n");
            TextServiceItemRenderer j;
            for (int i=0; i<slidesStr.length; i++){
                j = new TextServiceItemRenderer();
                String str = slidesStr[i].replace("\n\n","\n \n");
                j.setText(str);
                if (i==0){
                    j.setMark(true);
                }
                slides.add(j);
            }
        }
    }
    
    public String getText(){
        return this.text;
    }

    public String getSlideText (int rowIndex){
        
        try{
            TextServiceItemRenderer r = (TextServiceItemRenderer) slides.get(rowIndex);
            return r.getText();
        }catch(Exception e){
            return "";
        }
        
    }
    
    @Override 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1){
            return true;
        }else{
            return false;
        }
            
    }

    
    public class TextAreaCellEditor extends AbstractCellEditor implements TableCellEditor {
        
        /**
		 * 
		 */
		private static final long serialVersionUID = 2088586522613763045L;

		public Object getCellEditorValue() {
            fireTableChanged();
            return null;
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            TextServiceItemRenderer r = (TextServiceItemRenderer) slides.get(row);
            return r.getComponent(false, true);
        }
        
        public boolean isCellEditable(EventObject anEvent) {
            if (anEvent instanceof MouseEvent) {
                return ((MouseEvent)anEvent).getClickCount() >= 2;
            }
            return false;
        }        
        
    }
    
    @Override
    public String getDefaultMonitorTemplate(){
        return DisplayControlConfig.getInstance().getMonitorTemplateText();
    }

    @Override
    public Color getBackgroundColor(){
        return Color.decode("0xffffdd");
    }

    @Override
    public void edit(){
        TextServiceItemEditorForm tsief = new TextServiceItemEditorForm(this);
        tsief.setLocationRelativeTo(ObjectManager.getInstance().getDatasoulMainForm());
        tsief.setVisible(true);
    }

    
    private static final Icon icon = new ImageIcon(TextServiceItem.class .getResource("/datasoul/icons/v2/font-x-generic.png"));
    @Override
    public Icon getIcon(){
        return icon;
    }

    @Override
    public String getJSon(){
        
        StringBuffer sb = new StringBuffer();
        sb.append(super.getJSon());
        
        if (this.getText().trim().length() > 0){
            sb.append(",");
            sb.append("text: '");
            sb.append(ServiceItem.escapeJson(this.getText()));
            sb.append("'\n");
        }
        
        return sb.toString();
    }
    
}