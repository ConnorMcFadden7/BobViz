/**
* @file   PieChart.java
* @author Connor McFadden
* @date   28 February 2013
*
* \brief A simple class that displays data in a Pie chart visualisation
*
*/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JFrame implements Chart, ActionListener {
    
    /**
    * create a constructor which will be called to pass through the following
    * data:
    * @param col_data - the data to be passed from users to the table
    * @param chartTitle - the title to be passed from users for the
    * chart
    * @param xLabel - the xLabel to be passed from the users for the 
    * chart
    * @param noOfRows - number of rows which are passed through to be displayed
    * on the pie chart
    * @parama noOfCols - number of columns which are passed through to be
    * displayed on the pie chart
    */
    public PieChart( String[] col_data, String chartTitle, String xLabel,
                    int noOfRows, int noOfCols ) {
        m_IntData = col_data;
	m_NoOfRows = noOfRows;
	m_NoOfCols = noOfCols;
        /* create the Pie dataset and instansiate it with 
         *   JFreeChart. 
         */
	PieDataset dataset = createDataset();         
        JFreeChart chart = createChart( dataset, chartTitle );         
	ChartPanel chartPanel = new ChartPanel( chart );           
		    
	/* instantiate colour options */
	JPanel colourButtonPanel = new JPanel( new BorderLayout() );
	colChangeButton = new JButton( "Change Colours" );
	colourButtonPanel.add( colChangeButton,BorderLayout.SOUTH );
        colChangeButton.addActionListener( PieChart.this );
	    
        JFrame test = new JFrame();
        test.setLayout(new BorderLayout());
        test.setSize( HEIGHT_FRAME, WIDTH_FRAME );
        test.setTitle("Pie Chart");
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.add(chartPanel, BorderLayout.NORTH);
        test.add(colourButtonPanel, BorderLayout.SOUTH);
        test.setVisible(true);
	    
    }
    /*
     * empty contructor for unit tests 
     */
    public PieChart() {
            
    }
    /**
     * @return - return a variable which stores the data.
     */
    public String[] GetData() {
        return m_IntData;
    }
    /**
     * @return - return a variable with the current index 
     * of each pie slice.
     */
    public int GetIndexCount() {
        return m_IndexCount;
    }
    /**
     * @return - a variable which returns the current number of columns
     */
    public int GetNoCols() {
        return m_NoOfCols;
    }
    /**
     * @return - a variable which returns the current number of rows
     */
    public int GetNoRows() {
        return m_NoOfRows;
    }
    /**
     * @param xLabel - the xLabel to be passed from the users to the chart
     */
    @Override
    public String SetLabelX( String xLabel ) {
        boolean test = true;
        
        if ( ( ( xLabel.isEmpty() )||( xLabel.length() > 25 ) ) 
			   && ( test == true ) ) {
            System.err.println( "ScatterPlotGraph::SetLabelX " + xLabel );
	}
        
        return xLabel;
    }
    /**
     * @param data - variable to test if m_IntData has any errors
     * @return - returns boolean if test is true
     */
    public boolean SetData( String[] data ) {
        boolean test = true;
        if ( data == null && test == true ) {
            System.err.println( "PieChart::setData() ***Warning, data set to: " 
                    + data );
        }
        else if ( test == true ) {
            System.out.println( "PieChart::setData() file location set to: "
                    + data );
        }
            m_IntData = data;
            return true;
    }
    /**
     * @param index - variable to test if m_IndexCount has any errors
     * @return - returns boolean if test is true
     */
    public boolean SetIndexCount( int index ) {
        boolean test = true;
        if ( index < 0 && test == true ) {
            System.err.println( "PieChart::setIndexCount() ***Warning, index "
                        + "set to: " + index );
        }
        else if ( test == true ) {
            System.out.println( "PieChart::setIndexCount() index set to: " 
                    + index );
        }
        m_IndexCount = index;
        return true;
    }
    /**
     * @param cols - variable to test if m_NoOfCols has any errors
     * @return - returns boolean if test is true
     */
    public boolean SetNoCols( int cols ) {
        boolean test = true;
        if ( cols < 0 && test == true ) {
            System.err.println( "PieChart::setNoCols() ***Warning, cols "
                        + "set to: " + cols );
        }
        else if ( test == true ) {
            System.out.println( "PieChart::setNoCols() cols set to: " 
                    + cols );
        }
        m_NoOfCols = cols;
        return true;
    }
    /**
     * @param rows - variable to test if m_NoOfRows has any errors
     * @return - returns boolean if test is true
     */
    public boolean SetNoRows( int rows ) {
        boolean test = true;
        if ( rows < 0 && test == true ) {
            System.err.println( "PieChart::setNoRows() ***Warning, rows "
                        + "set to: " + rows );
        }
        else if ( test == true ) {
            System.out.println( "PieChart::setNoRows() rows set to: " 
                    + rows );
        }
        m_NoOfRows = rows;
        return true;
    }
    /**
     * @param m_chartTitle - the title to be passed from users for the chart
     */
    @Override
    public String SetTitle( String m_chartTitle ) {
        boolean test = true;
        
        if ( ( ( m_chartTitle.isEmpty() )||( m_chartTitle.length() > 35 ) ) 
			   && ( test == true ) ) {
            System.err.println( "ScatterPlotGraph::SetTitle " + m_chartTitle );
        }
        
        return m_chartTitle;
    }
    /**
     * @param e - action button to allow choosers to select a colour
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        if( e.getSource() == colChangeButton ) {
            ColourMap cM = new ColourMap();
            cM.SetupData( m_IndexCount,plotChart );
            cM.setVisible( false );
        }
    }
    
    /**
     * create the 3D pie chart and set the appearance 
     * @param dataset - pass the pie dataset through
     * @param chartTitle - pass through the chart title
     * @return - a 3D piechart
     */
    private JFreeChart createChart( PieDataset dataset, String m_chartTitle ) {
        
        JFreeChart chart = ChartFactory.createPieChart3D( m_chartTitle,
        	dataset, true,                          
            true, false );
        
        //xyPlot = chart.getXYPlot();
        plotChart  = ( PiePlot3D ) chart.getPlot();      
        plotChart.setStartAngle( START_ANGLE );
        plotChart.setDirection( Rotation.CLOCKWISE ); 
        plotChart.setForegroundAlpha(TRANSPARENCY); 
        return chart;       
    }
    /**
     * create a dataset which will store data chosen by the user
     * @return - data ready to be displayed
     */
    private PieDataset createDataset() {
        DefaultPieDataset m_dataset = new DefaultPieDataset();       
        /* loop through the rows and store them in m_IntData */
        
        for( int r = 0; r < m_NoOfRows; r++ ) {
            double m_dataInput = Double.parseDouble(m_IntData[r]);
            double m_pieSlice = (m_dataInput/m_NoOfRows)*TOTAL_PERCENTAGE;
            int i = 0;
            m_dataset.insertValue(i, m_IntData[r], m_pieSlice); 
            i++;       									
        }      
        
        m_IndexCount = m_dataset.getItemCount();
        return m_dataset;     
    }
     
    /**
     * Main method which implement 3 unit tests for each 'set' method
     * @param args - no user input needed
     */
    public static void main( String[] args ){
        PieChart pieChart = new PieChart();
        /* test for null data */
	System.out.println( " " );
	System.out.println( "Unit test 1: null data" );
	pieChart.SetData( null );
        pieChart.SetIndexCount( -1 );
        pieChart.SetNoCols( -1 );
        pieChart.SetNoRows( -1 );
        
        /* test for large data */
	System.out.println( " " );
	System.out.println( "Unit test data 2: Large Data" );
	pieChart.SetIndexCount( 2000000000 );
        pieChart.SetNoCols( 2000000000 );
        pieChart.SetNoRows( 2000000000 );
	
        /* test for standard data */
	System.out.println( " " );
	System.out.println( "Unit test 3: Standard data" );
	pieChart.SetIndexCount( 10 );
        pieChart.SetNoCols( 5 );
        pieChart.SetNoRows( 100 );
    }
    
    /** declare variables */  
    private String[] m_IntData;
    /** the number of rows */
    private int m_NoOfRows;
    /** the number of columns */
    private int m_NoOfCols;
    /** the angle of the pie chart */
    private final int START_ANGLE = 290;
    /** the transparency of the pie chart */
    private final float TRANSPARENCY = 0.6f;
    /** the button for colour use */
    private JButton colChangeButton; 
    private PiePlot3D plotChart; 
    /** IndexCount declared for each part of the visualiser */
    private int m_IndexCount = 0;
    /** the total percentage for the pie slice */
    private final int TOTAL_PERCENTAGE = 100;
    
    private final int WIDTH_FRAME = 600;
    private final int HEIGHT_FRAME = 800;
}