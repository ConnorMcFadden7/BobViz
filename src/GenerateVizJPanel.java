/**
 * @file -GenerateVizJPanel.java
 * @author -Rhys Owen
 * @date -02/03/2013
 * @see Table.java, ColumnChart.java, ScatterGraph.java, PieChart.java
 * 
 * @brief This class passes the data from the GUI to the constructors of the
 * visualisation types.
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GenerateVizJPanel extends JPanel {
    
    public GenerateVizJPanel() {
        
        /* create new visualisation button */
        m_VisualizeJBut = new JButton( "Generate Visualization!" );
        /* set visualisation font */
        m_VisualizeJBut.setFont( new Font( "Courier", Font.BOLD, FONT_SIZE ) );
        m_VisualizeJBut.setEnabled( false );
        add( m_VisualizeJBut );
        
        /* set listeners */
        GenerateVizJPanelEventHandler iJEventHandler = new 
                GenerateVizJPanelEventHandler();
        m_VisualizeJBut.addActionListener( iJEventHandler );
    }
    
   /**
    * This method will cast the GroupPDM2application instance from
    * BobVizDemo.
    * @param bv -a GroupPDM2application object
    */
    public boolean SetBV( GroupPDM2application bv ) {
        boolean test = true;
        if( ( test == true ) && ( bv == null ) ) {
            System.err.println( "GenerateVizJPanel::SetBV() ***Warning, object"
                    + "is null. Value sent: " + bv );
        } else if ( test == true ) {
            System.out.println( "GenerateVizJPanel::SetBV() Object is valid. "
                    + "Value sent: " + bv );
        }
        m_BV = bv;
        return true;
    }
    
   /**
    * This method changes the enabled state of the visualisation button.
    * @param b -a boolean object
    */
    public boolean SetVizJButEnabled( boolean b ) {
        boolean test = true;
        if ( test == true ) {
            System.out.println( "GenerateVizJPanel::SetVizJButEnabled() m_"
                    + "VisualizeJBut enabled status: " + b );
        }
        m_VisualizeJBut.setEnabled( b );
        return true;
    }
    
    /**
     * @return the state of visualise button
     */
    public boolean GetVizJButEnabled() {
        return m_VisualizeJBut.isEnabled();
    }
    
    /* event handler for GenerateVizJPanel */
    private class GenerateVizJPanelEventHandler implements ActionListener {
    
        @Override
        public void actionPerformed( ActionEvent e ) {
            if( e.getSource() == m_VisualizeJBut ) {
                /* store title in DataAttribute */
                m_BV.GetDataAtrribute().SetTitle( m_BV.GetSettingJPan().
                        GetTitle() );
                /* store axis label x in DataAttribute */
                m_BV.GetDataAtrribute().SetAxisLabelX( m_BV.
                        GetSettingJPan().GetAxisLabelX() );
                /* store axis label y in DataAttribute */          
                m_BV.GetDataAtrribute().SetAxisLabelY( m_BV.
                        GetSettingJPan().GetAxisLabelY() );
                /* get selected system (e.g. chart, graph) */
                switch ( m_BV.GetVizTypeJPan().GetSelectedSys() ) {
                    case CHART:
                        if( m_BV.GetVizTypeJPan().GetSelectedViz().equals
                                ( PIE_CHART ) ) {
                            /* set title */
                            m_BV.GetDataAtrribute().SetTitle( 
                                    m_BV.GetSettingJPan().GetTitle() );
                            /* create pie chart */
                            m_BV.GetViz().SetVizPieChart( m_BV.GetDataset().
                                    GetColumn( m_BV.GetDataAtrribute().
                                    GetSelectedXIndex() )
                                    , m_BV.GetDataAtrribute().GetTitle()
                                    , m_BV.GetDataAtrribute().GetAxisLabelX()
                                    , m_BV.GetDataset().GetNoOfRows()
                                    , m_BV.GetDataset().GetNoOfCols() );
                            }  else if (m_BV.GetVizTypeJPan().GetSelectedViz().
                                    equals(COLUMN_CHART)) {
                                m_BV.GetViz().SetColChart(
                                    m_BV.GetDataset().GetArray(),
                                    m_BV.GetDataAtrribute().GetTitle(), 
                                    m_BV.GetDataAtrribute().GetSelectedXIndex(), 
                                    m_BV.GetDataAtrribute().GetSelectedYIndex(), 
                                    m_BV.GetDataAtrribute().GetAxisLabelX(),
                                    m_BV.GetDataAtrribute().GetAxisLabelY(), 
                                    m_BV.GetDataset().GetNoOfRows(), 
                                    m_BV.GetDataset().GetNoOfCols() );
                            }
                            break;
                    case VIEW:
                        if( m_BV.GetVizTypeJPan().GetSelectedViz().
                                equals( TABLE )) {
                            /* set title */
                            m_BV.GetDataAtrribute().SetTitle( 
                                    m_BV.GetSettingJPan().GetTitle() );
                            /* create table */
                            m_BV.GetViz().SetTable( m_BV.GetDataset().
                                    GetArrayBackwards(),
                                    m_BV.GetDataset().GetColHeaders(),
                                    m_BV.GetDataAtrribute().GetTitle());
                        }
                        break;
                    case GRAPH:
                        if( m_BV.GetVizTypeJPan().GetSelectedViz().equals
                                (SCATTER_GRAPH)) {
                            /* set title */
                            m_BV.GetDataAtrribute().SetTitle( 
                                    m_BV.GetSettingJPan().GetTitle() );
                            System.out.println("******* " + m_BV.GetDataAtrribute().GetTitle());
                            /* create graph */
                            m_BV.GetViz().SetScatterPlotGraph(
                                    m_BV.GetDataset().GetArray(),
                                    m_BV.GetDataAtrribute().GetTitle(), 
                                    m_BV.GetDataAtrribute().GetSelectedXIndex(), 
                                    m_BV.GetDataAtrribute().GetSelectedYIndex(), 
                                    m_BV.GetDataAtrribute().GetAxisLabelX(),
                                    m_BV.GetDataAtrribute().GetAxisLabelY(), 
                                    m_BV.GetDataset().GetNoOfCols(), 
                                    m_BV.GetDataset().GetNoOfRows() );
                        }
                        break;
                }
            }
        }
    }
    
    /** create visualisation JButton */
    private JButton m_VisualizeJBut;
    /** font size of visualisation button JLabel */
    private final int FONT_SIZE = 13;
    
    /** create GroupPDM2application object */
    private GroupPDM2application m_BV;
    
    /** types of visualisation systems */
    private final String CHART = "Chart";
    private final String GRAPH = "Graph";
    private final String VIEW = "View";
    
    /** types of visualisation types */
    private final String PIE_CHART = "Pie";
    private final String COLUMN_CHART = "Column";
    private final String SCATTER_GRAPH = "Scatter";
    private final String TABLE = "Table";
    
}