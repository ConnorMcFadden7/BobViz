/**
* @file -ColumnChart.java
* @author -Gavin Driscoll
* @date -01 March 2013
* @see -Dataset.java, BobViz.java
*
* @brief A class that displays specific data in a Column Chart visualiser.
*
*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class ColumnChart implements ActionListener {

    /**
    * Create a constructor taking in the following parameters:
    * @param data - the data to be passed from users to the table.
    * @param chartTitle - the title to be passed from users for the
    * chart.
    * @param xLabel - the label to be chosen by the user for the x axis.
    * @param yLabel - the label to be chosen by the user for the y axis.
    * @param int row - the rows of data to be read.
    * @param int col - the columns of data to be read.
    * @param int c1 - first column chosen from which data will be read.
    * @param int c2 - second column chosen from which data will be read.
    * Create the column chart dataset and instantiate it. 
    * JFreeChart.
    */
    public ColumnChart( String data[][], String chartTitle, int c1, int c2,
        String xLabel, String yLabel, int row, int col ) {
        m_Data = data;
        m_ChartTitle = chartTitle;
        m_XLabel = xLabel;
        m_YLabel = yLabel;
        m_Row = row;
        m_C1 = c1;
        m_C2 = c2;

        CategoryDataset m_dataset = createDataset();
        JFreeChart chart = createChart( m_dataset );
        final ChartPanel chartPanel = new ChartPanel( chart );

        m_ColChangeButton = new JButton( "Change Colours" );
        m_ColChangeButton.addActionListener( ColumnChart.this );	    

        JFrame test = new JFrame();
        test.setLayout( new BorderLayout() );
        test.setSize( HEIGHT_FRAME, WIDTH_FRAME );
        test.setTitle( "Column Chart" );
        test.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        test.add( chartPanel, BorderLayout.NORTH );
        test.add( m_ColChangeButton, BorderLayout.SOUTH );
        test.setVisible( true );
    }	

    /**
    * a test taking a String argument.
    * @param String - ChartTitle a String argument.
    * @return boolean - The test results.
    */
    public boolean SetChartTitle( String ChartTitle ){
        boolean test = true;
        if(test) {
            System.out.println( "ColumnChart::SetChartTitle()" +
            " ChartTitle: " + m_ChartTitle );
        }
        if( m_ChartTitle.length() < 2 ){
            System.err.println( "ColumnChart::SetChartTitle()" +
            " ChartTitle set to: " + m_ChartTitle );
        }
        m_ChartTitle = ChartTitle;
        return true;
    }

    private CategoryDataset createDataset() { 
        DefaultCategoryDataset result= new DefaultCategoryDataset();
        int c = 0,r = 0;
        for( r = 0; r < m_Row; r++ ) {
            double newValue = Double.parseDouble( ( m_Data[m_C1][r] ) );
            double newValue2 = Double.parseDouble ( m_Data[m_C2][r] );
            result.setValue( newValue, "Series "+r, ""+c );
            result.setValue( newValue2, "Series "+r, ""+c );
        }

        m_IndexCount = r;
        return result;
    }

    /**
    * Creates a column chart and set the appearance.
    * @param dataset - pass the data needed to create a column chart.
    * @param chartTitle - pass through the chart title.
    * @return JFreeChart - a column chart. 
    */
    private JFreeChart createChart( CategoryDataset dataset ) {
        final JFreeChart chart = ChartFactory.createBarChart( 
        m_ChartTitle, m_XLabel, m_YLabel, dataset,
        PlotOrientation.VERTICAL, false, true, false );

        m_Plot = chart.getCategoryPlot();
        
        m_Renderer = m_Plot.getRenderer();
        m_Renderer.setSeriesItemLabelsVisible( 0, Boolean.TRUE );

        return chart;
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if( e.getSource() == m_ColChangeButton ) {
            ColourMap cM = new ColourMap();
            cM.SetupData( m_IndexCount, m_Renderer );
            cM.setVisible( false );
        }
    }

    private CategoryItemRenderer m_Renderer;
    private JButton m_ColChangeButton;
    private CategoryPlot m_Plot;
    
    private int m_IndexCount;
    private String m_ChartTitle;
    
    /** an array of data for visualisation */
    private String m_Data[][];
    
    /** x and y label axis */
    private String m_XLabel;
    private String m_YLabel;
    
    /* amount of rows */
    private int m_Row;
    
    /** columns */
    private int m_C1;
    private int m_C2;
    
    /** width of Column Chart view frame */
    private final int WIDTH_FRAME = 600;
    /** height of Column Chart view frame */
    private final int HEIGHT_FRAME = 800;

}