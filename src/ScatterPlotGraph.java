/**
* @file    -ScatterPlotGraph.java
* @author  -Phill Davies
* @date    -27/02/13
* @see     -
* @brief   - A class that creates a Scatter Plot Graph visualisation from 
* a 2D Array of data
*/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ScatterPlotGraph implements ActionListener, Graph {
	
    /**
    * creates a constructor taking in the following parameters:
    * 
    * @param m_data - the data to be passed from users to the scatter
    * graph
    * @param m_graphTitle - the title to be passed from users for the
    * scatter graph
    * @param m_xLabel - the x axis label to be passed from the users for 
    * the scatter graph
    * @param m_yLabel - the y axis label to be passed from the users for 
    * the scatter graph
    * @param m_c1 - the value of the first selected column to be passed 
    * from the users for the scatter graph
    * @param m_c2 - the value of the second selected column to be passed 
    * from the users for the scatter graph
    * @param m_cols - the number of columns present in the csv file
    * @param m_rows - the number of rows present in the csv file 
    */
    public ScatterPlotGraph ( String[][] m_data, String m_graphTitle, int m_c1, 
    			      int m_c2, String m_xLabel, String m_yLabel, 
    			      int m_cols, int m_rows ) {
        
        createDataset( m_data, m_c1, m_c2, m_cols, m_rows );
        showGraph( dataset, m_graphTitle, m_xLabel, m_yLabel );
    }  
    
    /**
    * second empty constructor for JUnit Tests
    */
    public ScatterPlotGraph () {}
	
    /** allows user to select the colour of the points on the 
    * scatter graph
    */
    @Override
    public void actionPerformed( ActionEvent e ) {
        if( e.getSource() == colChangeButton ) {
            ColourMap cM = new ColourMap();
            cM.SetupData( plot.getSeriesCount(), 
                          renderer );
            cM.setVisible( false );
        }
    }
	
    /** 
    * @param m_xLabel - the x axis label passed from users to the graph 
    * @return  m_labelX - returns the user's x label value
    */
    @Override
    public String SetLabelX( String m_xLabel ) {
    String m_labelX = m_xLabel;
		
        boolean test = true;
        if ( ( ( m_xLabel.isEmpty() )||( m_xLabel.length() > 25 ) ) 
                 && ( test == true ) ) {
            System.err.println( "ScatterPlotGraph::SetLabelX() " + 
                                m_xLabel );
        }
        return m_labelX;
    }
	
    /** 
    * @param m_yLabel - the y axis label passed from users to the graph
    * @return m_labelY - returns the user's y label value
    */
    @Override
    public String SetLabelY( String m_yLabel ) {
        String m_labelY = m_yLabel;
		
        boolean test = true;
        if ( ( ( m_yLabel.isEmpty() )||( m_yLabel.length() > 25 ) ) 
                 && ( test == true ) ) {
            System.err.println( "ScatterPlotGraph::SetLabelY() " + 
                                m_yLabel );
        }
        return m_labelY;
    }
    
    /** 
    * @param m_graphTitle - the title passed from users to the graph 
    * @return m_labelY - returns the user's title value
    */
    @Override
    public String SetTitle( String m_graphTitle ) {
        String m_title = m_graphTitle;
		
        boolean test = true;
        if ( ( ( m_graphTitle.isEmpty() )||( m_graphTitle.length() > 35 ) ) 
                 && ( test == true ) ) {
            System.err.println( "ScatterPlotGraph::SetTitle() " + 
                                m_graphTitle );
        }	
        return m_title;
    } 
  	
    /**
    * creates an XY data set for the two selected columns
    * 
    * @param m_data - pass the 2d array through
    * @param m_c1 - pass the first column value through
    * @param m_c2 - pass the second column value through
    * @param m_cols - pass the total number of columns through
    * @param m_rows - pass the total number of rows through
    * 
    * @return dataset - returns the new data set with new values
    */
    private XYDataset createDataset( String[][] m_data, int m_c1, int m_c2, 
    				     int m_cols, int m_rows ) {
        dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries( Key ); 
        
        /* goes through each row and each column in the table */
            for( int c = 0; c < m_cols; c++ ) {
                for( int r = 0; r < m_rows; r++ ) {
	    		
                    /* takes every row value for the two selected columns,
                    * parses them as doubles, then adds them to the xy 
                    * data series 
                    */
                    data.add( Double.parseDouble( m_data[m_c1][r] ), 
                              Double.parseDouble( m_data[m_c2][r] ));  		
	        }
	    }
	    
        dataset.addSeries( data );     
        return dataset;
    }
    
    /**
    * creates a Scatter Plot Graph using the XY data set 
    * and sets the appearance and plot orientation
    * 
    * @param dataset - passes the XY data set through
    * @param m_graphTitle - passes the graph title through
    * @param m_xLabel - passes the x axis label value through
    * @param m_yLabel - passes the y axis label value through
    * 
    * @return graph - returns the graph with selected title, x and y labels,
    * and data to be displayed
    */
    private JFreeChart createGraph( XYDataset dataset, String m_graphTitle, 
                                    String m_xLabel, String m_yLabel ) {
        JFreeChart graph = ChartFactory.createScatterPlot(
            SetTitle( m_graphTitle ),			
            SetLabelX( m_xLabel ),          
            SetLabelY( m_yLabel ),          
            dataset,                  		
            /* sets the range (y) axis to vertical */
            PlotOrientation.VERTICAL,
            /* include legend */
            true,
            /* tool tips */
            true,
            /* URLs*/
            false);
        
        plot = graph.getXYPlot();
            
        renderer = plot.getRenderer();
        
        return graph;
    }
    
    /**
    *  visualises the scatter graph using JFreeChart and sets the 
    * default size and appearance of the window and graph
    * 
    * @param dataset - passes the XY data set through
    * @param m_graphTitle - passes the graph title value through
    * @param m_xLabel - passes the x axis label value through
    * @param m_yLabel - passes the y axis label value through
    *  
    * @return true - returns test results
    */
    private boolean showGraph( XYDataset dataset, String m_graphTitle, 
                               String m_xLabel, String m_yLabel ) {
    	
        JFreeChart graph = createGraph( dataset, m_graphTitle, m_xLabel, 
				   	m_yLabel );
    	ChartPanel chartPanel = new ChartPanel( graph );
    	chartPanel.setPreferredSize( new java.awt.Dimension( 600, 400 ) );
    	JPanel colourButtonPanel = new JPanel(new BorderLayout());

    	colChangeButton = new JButton( "Change Colours" );
    	colourButtonPanel.add( colChangeButton,BorderLayout.SOUTH );
    	colChangeButton.addActionListener( this );

    	JFrame SCATTER_TEST = new JFrame();
    	SCATTER_TEST.setLayout( new BorderLayout() );
    	SCATTER_TEST.setSize( HEIGHT_FRAME, WIDTH_FRAME );
    	SCATTER_TEST.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    	SCATTER_TEST.add( chartPanel, BorderLayout.NORTH );
    	SCATTER_TEST.add( colourButtonPanel,BorderLayout.SOUTH );
    	SCATTER_TEST.setVisible( true );

    	return true;
    }
    
    /**
    * main method to carry out JUnit Tests
    */
    public static void main( String[] args ) {
		
    ScatterPlotGraph scatterTest = new ScatterPlotGraph();
    System.out.println( "Unit test 1:: null" );
    scatterTest.SetTitle( "" );
    scatterTest.SetLabelX( "" );
    scatterTest.SetLabelY( "" );
		
    System.out.println( "Unit test 2:: string" );
    scatterTest.SetTitle( "a" );
    scatterTest.SetLabelX( "a" );
    scatterTest.SetLabelY( "a" );
		
    System.out.println( "Unit test 3:: large string" );
    scatterTest.SetTitle( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" );
    scatterTest.SetLabelX( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" );
    scatterTest.SetLabelY( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" );
    }
    
    /** represents a series of vertices to be used as a data set */
    private XYSeriesCollection dataset;
    
    /** renders the visual representation of the (x,y) items */
    private XYItemRenderer renderer;
    
    /** displays a button that can select different colour options */
    private JButton colChangeButton;
    
    /** plots data in the form (x,y) */
    private XYPlot plot; 
	
    /** labels the key of the graph */
    private final String Key = "Data";
    
    /** sets the frame width */
    private final int WIDTH_FRAME = 600;
    
    /** sets the frame height */
    private final int HEIGHT_FRAME = 800;
    
    
}