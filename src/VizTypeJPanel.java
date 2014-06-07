/**
 * @file -VizTypeJPanel.java
 * @author -Rhys Owen
 * @date -01/03/2013
 * @see Dataset.java
 * 
 * @brief This class provides the user with a list of different
 * visualisation types to choose from.
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

public class VizTypeJPanel extends JPanel {
    
    public VizTypeJPanel() {
        /* set new dimension for VizTypeJPanel */
        Dimension size = getPreferredSize();
        
        /* set height and size for VizTypeJPanel */
        size.width = PAN_WIDTH;
        size.height = PAN_HEIGHT;
        setPreferredSize( size );
        
        /* set new layout */
        setLayout( new FlowLayout( FlowLayout.CENTER ) );
        /* add a new border name */
        setBorder( BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), SELECT_VIZ_TYPE ) );
        
        /* create new JPanel */
        JPanel centerJPan = new JPanel();
        /* set new layout for centerJPan */
        centerJPan.setLayout( new GridLayout( GRID_ROW, GRID_COL, GRID_VGAP, 
                GRID_HGAP ) );
        
        /* types of visualisation systems */
        m_VizSys[0] = "Chart";
        m_VizSys[1] = "Graph";
        m_VizSys[2] = "View";
        
        /* types of charts */
        m_VizChartType[0] = "Column";
        m_VizChartType[1] = "Pie";
        
        /* types of graphs */
        m_VizGraphType[0] = "Scatter";
        
        /* types of views */
        m_VizViewType[0] = "Table";
        
        /* create new visualisation system label */
        m_VizSysJLab = new JLabel( VIZ_SYS );
        /* create new visualisation type label */
        m_VizTypeJLab = new JLabel( VIZ_TYPE );
        
        /* create new visualisation system combo box */
        m_VizSysJCom = new JComboBox( m_VizSys );
        /* create new visualisation type combo box */
        m_VizTypeJCom = new JComboBox( m_VizChartType );
        
        /* add all components to centerJPan */
        centerJPan.add( m_VizSysJLab );
        centerJPan.add( m_VizTypeJLab );
        centerJPan.add( m_VizSysJCom );
        centerJPan.add( m_VizTypeJCom );
        
         /* add centerJPan to VizTypeJPanel */
        add( centerJPan );
        
        /* set listeners */
        VizTypeJPanelEventHandler vTEventHandler = new 
                VizTypeJPanelEventHandler();
        m_VizSysJCom.addActionListener( vTEventHandler );
        m_VizTypeJCom.addActionListener( vTEventHandler );
    }
    
    public VizTypeJPanel(boolean b) {
        
    }
    
   /**
    * This updates the Visualisation type combo box. When the user
    * selects a new visualisation system, this method will
    * dynamically update the visualisation types.
    * @param type -the new types of visualisation.
    */
    public boolean SetVizSysType( String[] type ) {
        boolean test = true;
        if( ( test == true ) && ( type == null ) ) {
            System.err.println( "VizTypeJPanel::SetVizSysType() ***Warning, "
                    + "object is null. Value sent: " + type );
        } else if ( test == true ) {
            System.out.println( "VizTypeJPanel::SetVizSysType() Object is valid."
                    + "Value sent: " + type );
        }
        m_VizTypeJCom.removeAllItems();
        for( String s: type ){
            m_VizTypeJCom.addItem( s );
        }
        return true;
    }
    
   /**
    * This method gets the selected system.
    * @return String - the selected visualisation system.
    */
    public String GetSelectedSys() {
        return m_SelectedSys;
    }
    
   /**
    * This method gets the selected visualisation.
    * @return String - the current selected visualisation.
    */
    public String GetSelectedViz() {
        return (String) m_VizTypeJCom.getSelectedItem();
    }
    
    /* event handler for VizTypeJPanel */
    private class VizTypeJPanelEventHandler implements ActionListener {
    
        @Override
        public void actionPerformed( ActionEvent e ) {
            if( e.getSource() == m_VizSysJCom ) {
                /* chart is selected */
                if( m_VizSysJCom.getSelectedItem().equals( CHART_SYS ) ) {
                    SetSelectedSys( CHART_SYS );
                    m_BV.GetVizTypeJPan().SetVizSysType( m_VizChartType );
                    /* graph is selected */
                } else if( m_VizSysJCom.getSelectedItem().equals( GRAPH_SYS ) ) 
                {
                    SetSelectedSys( GRAPH_SYS );
                    m_BV.GetVizTypeJPan().SetVizSysType( m_VizGraphType );
                    /* view is selected */
                } else if( m_VizSysJCom.getSelectedItem().equals( VIEW_SYS ) ) {
                    SetSelectedSys( VIEW_SYS );
                    m_BV.GetVizTypeJPan().SetVizSysType( m_VizViewType );
                }
            }
        }
    }
    
   /**
    * @param bv - a GroupPDM2application object
    * @return TRUE on success
    */
    public boolean SetBV( GroupPDM2application bv ) {
        boolean test = true;
        if( ( test == true ) && ( bv == null ) ) {
            System.err.println( "VizTypeJPanel::SetBV() ***Warning, object"
                    + "is null. Value sent: " + bv );
        } else if ( test == true ) {
            System.out.println( "VizTypeJPanel::SetBV() Object is valid. Value"
                    + "sent: " + bv );
        }
        m_BV = bv;
        return true;
    }
    
   /**
    * This method sets the selected system. The user can select
    * a visualisation system from VizTypeJPanel.
    * @param type -the type of Visualisation system.
    */
    public boolean SetSelectedSys( String type ) {
        boolean test = true;
        if( ( test == true ) && ( type.isEmpty() ) ) {
            System.err.println( "VizTypeJPanel::SetVizSysType() ***Warning, "
                    + "object is empty: " + type );
        } else if ( ( test == true ) && ( type == null ) ) {
            System.err.println( "VizTypeJPanel::SetVizSysType() ***Warning, "
                    + "object is null: " + type );
        } else if ( test == true ) {
            System.out.println( "VizTypeJPanel::SetVizSysType() Object is valid"
                    + "Value sent: " + type );
        }
        m_SelectedSys = type;
        return true;
    }
    
    public static void main(String[] args) {
        VizTypeJPanel vTypeJPan = new VizTypeJPanel(true);
        String empty = "";
        String[] emptyArray = new String[1];
        vTypeJPan.SetBV(null);
        vTypeJPan.SetSelectedSys(null);
        vTypeJPan.SetSelectedSys(empty);
        vTypeJPan.SetVizSysType(emptyArray);
    }
    
    /** width of VizTypeJPanel */
    private final int PAN_WIDTH = 500;
    /** height of VizTypeJPanel */
    private final int PAN_HEIGHT = 100;
    
    /** grid row size for GridLayout */
    private final int GRID_ROW = 2;
    /** grid col size for GridLayout */
    private final int GRID_COL = 2;
    /** grid vgap size for GridLayout */
    private final int GRID_VGAP = 100;
    /** grid hgap size for GridLayout */
    private final int GRID_HGAP = 0;
    
    /** amount of visualisers */
    private final int VIZ_SYS_AMT = 3;
    
    /** amount of charts */
    private final int VIZ_CHART_AMT = 2;
    /** amount of graphs */
    private final int VIZ_GRAPH_AMT = 1;
    /** amount of views */
    private final int VIZ_VIEW_AMT = 1;
    
    /** default selected system type */
    private String m_SelectedSys = "Chart";
    
    /** make new String arrays which store all visualiser names */
    private String[] m_VizSys = new String[VIZ_SYS_AMT];
    private String[] m_VizChartType = new String[VIZ_CHART_AMT];
    private String[] m_VizGraphType = new String[VIZ_GRAPH_AMT];
    private String[] m_VizViewType = new String[VIZ_VIEW_AMT];
    
    /** create new visualiser system JLabel */
    private JLabel m_VizSysJLab;
    /** create new visualiser type JLabel */
    private JLabel m_VizTypeJLab;
    /** create new visualiser system JComboBox */
    private JComboBox m_VizSysJCom;
    /** create new visualiser type JComboBox */
    private JComboBox m_VizTypeJCom;
    
    /** types of systems */
    private final String CHART_SYS = "Chart";
    private final String VIEW_SYS = "View";
    private final String GRAPH_SYS = "Graph";
    
    /** various String messages for centerJPanel */
    private final String SELECT_VIZ_TYPE = "Select Visualization Type";
    private final String VIZ_SYS = "Visualization system:";
    private final String VIZ_TYPE = "Visualization type:";
    
    /** the GroupPDM2application instance **/
    private GroupPDM2application m_BV;
    
}