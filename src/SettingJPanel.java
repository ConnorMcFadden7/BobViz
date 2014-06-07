/**
 * @file -SettingJPanel.java
 * @author -Rhys Owen
 * @date -01/03/2013
 * @see GroupPDM2application.java
 * 
 * @brief This class provides the settings for each visualisation.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingJPanel extends JPanel {
    
    public SettingJPanel() {
        /* set new size dimensions */
        Dimension size = getPreferredSize();
        size.width = PAN_WIDTH;
        size.height = PAN_HEIGHT;
        setPreferredSize( size );
        
        setBorder( BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder( Color.GRAY ), SELECT_VIZ_PREF
                 ) );
        setLayout( new FlowLayout( FlowLayout.CENTER ) );
        
        /* create new JPanel */
        JPanel centerJPan = new JPanel();
        centerJPan.setLayout( new GridLayout( GRID_ROW, GRID_COL, GRID_VGAP, 
                GRID_HGAP ) );
        
        /* set default x and y axis */
        String[] xAxis = {""};
        String[] yAxis = {""};
        
        /* create new jlabels */
        JLabel chartTitJLab = new JLabel( "Chart title:" );
        JLabel xAxisJLab = new JLabel( "X axis:" );
        JLabel yAxisJLab = new JLabel( "Y axis:" );
        
        /* create new input fields */
        m_ChartTitJTextF = new JTextField( TEXT_FIELD_LEN );
        m_xAxisJCom = new JComboBox( xAxis );
        m_yAxisJCom = new JComboBox( yAxis );
        
        /* set all input fields disabled by default */
        m_ChartTitJTextF.setEnabled( false );
        m_xAxisJCom.setEnabled( false );
        m_yAxisJCom.setEnabled( false );
        
        /* add all components to centerJPan */
        centerJPan.add( chartTitJLab );
        centerJPan.add( m_ChartTitJTextF );
        centerJPan.add( xAxisJLab );
        centerJPan.add( m_xAxisJCom );
        centerJPan.add( yAxisJLab );
        centerJPan.add( m_yAxisJCom );
        
        /* add centerJPan to SettingJPanel */
        add( centerJPan );
        
        /* set listeners */
        SettingJPanelEventHandler iJEventHandler = new 
                SettingJPanelEventHandler();
        m_xAxisJCom.addActionListener( iJEventHandler );
        m_yAxisJCom.addActionListener( iJEventHandler );
        
    }
    
   /**
    * @param bv - a GroupPDM2application object
    * @return TRUE on success
    */
    public boolean SetBV(GroupPDM2application bv) {
        boolean test = true;
        if((test == true) && (bv == null)) {
            System.err.println( "SettingJPanel::SetBV() ***Warning, object"
                    + "is null. Value sent: " + bv );
        } else if (test == true) {
            System.out.println( "SettingJPanel::SetBV() Object is valid. Value"
                    + "sent: " + bv );
        }
        m_BV = bv;
        return true;
    }
    
   /**
    * This method sets the setting panel enabled or disabled. This
    * will prevent the user selecting x and y axis' values
    * before they have imported a file.
    * @param b - a boolean object
    * @return TRUE on success
    */
    public boolean SetSettingsEnabled(boolean b) {
       m_ChartTitJTextF.setEnabled(b);
       m_xAxisJCom.setEnabled(b);
       m_yAxisJCom.setEnabled(b);
       return true;
    }
    
   /**
    * This method sets the correct visualisation system type.
    * @param headings - an array list of current listed headings from the
    * CSV file.
    * @return TRUE on success
    */
    public boolean SetVizSysType(String[] headings) {
        m_xAxisJCom.removeAllItems();
        m_yAxisJCom.removeAllItems();
        for(String s: headings){
            m_xAxisJCom.addItem(s);
            m_yAxisJCom.addItem(s);
        }
        return true;
    }
    
   /**
    * This method will return the title of the visualisation.
    * @return String - the current title.
    */
    public String GetTitle() {
        m_Title = m_ChartTitJTextF.getText();
        return m_Title;
    }
    
   /**
    * This method will return the x axis label.
    * @return String - the current x axis label.
    */
    public String GetAxisLabelX() {
        return (String) m_xAxisJCom.getSelectedItem();
    }
    
   /**
    * This method will return the y axis label.
    * @return String - the current y axis label.
    */
    public String GetAxisLabelY() {
        return (String) m_yAxisJCom.getSelectedItem();
    }
      
   /**
    * This method will return the current x index.
    * @return int - the current selected x index.
    */
    public int GetSelectedXIndex() {
        return m_xAxisJCom.getSelectedIndex();
    }
    
   /**
    * This method will return the current y index.
    * @return int - the current selected y index.
    */
    public int GetSelectedYIndex() {
        return m_yAxisJCom.getSelectedIndex();
    }
   
   /**
    * This method will check if all settings are enabled.
    * @return boolean - the result of all setting objects (to
    * check if they're enabled).
    */
    public boolean GetSettingsEnabled() {
       return m_ChartTitJTextF.isEnabled()
               && m_xAxisJCom.isEnabled()
               && m_yAxisJCom.isEnabled();
   }
   
   /** width of SettingJPanel */
   private final int PAN_WIDTH = 500;
   /** height of SettingJPanel */
   private final int PAN_HEIGHT = 150;
    
   private final String SELECT_VIZ_PREF = "Select Visualization Preferences";
    
   /** the values of the grid */
   private final int GRID_ROW = 3;
   private final int GRID_COL = 2;
   private final int GRID_VGAP = 40;
   private final int GRID_HGAP = 5;
        
   /** the length of the text field */
   private final int TEXT_FIELD_LEN = 15;
    
   private JComboBox m_xAxisJCom;
   private JComboBox m_yAxisJCom;
    
   private JTextField m_ChartTitJTextF = new JTextField(TEXT_FIELD_LEN);
    
   private String m_Title;
    
   /** create new GroupPDM2application object */
   private GroupPDM2application m_BV;
    
   /* event handler for setting jpanel */
   private class SettingJPanelEventHandler implements ActionListener {
    
        @Override
        public void actionPerformed( ActionEvent e ) {
            if( e.getSource() == m_xAxisJCom ) {
                m_BV.GetDataAtrribute().SetSelectedXIndex( m_xAxisJCom.getSelectedIndex() );
            } else if( e.getSource() == m_yAxisJCom ) {
                m_BV.GetDataAtrribute().SetSelectedYIndex( m_yAxisJCom.getSelectedIndex() );
            }
        }
    }
    
}