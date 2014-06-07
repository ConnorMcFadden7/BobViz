/**
* @file -Visualisation.java
* @author -Gavin Driscoll
* @date -01 March 2013
* @see -BobsViz.java
*
* @brief A class that displays specific data in a Column Chart visualiser.
*
*/
import javax.swing.JPanel;

public class Visualisation extends JPanel {
    
    public ColumnChart GetColChart() {
        return m_ColumnChart;
    }
    /**
    * creates a column chart. 
    * @param data - data used to create the visualisation.
    * @param chartTitle - sets title for the visualisation.
    * @param c1 - selects data from a first column.
    * @param c2 - selects data from a second column.
    * @param xLabel - sets a label for a x axis.
    * @param yLabel - sets a label for a y axis.
    * @param row - selects rows of data from a CSV file.
    * @param col - selects columns of data from a CSV file.
    */
    public boolean SetColChart( String data[][], String chartTitle, 
            int c1, int c2, String xLabel, String yLabel, int row, int col ) {
        m_ColumnChart = new ColumnChart( data, chartTitle, c1, c2, xLabel, 
                yLabel, row, col );
        
    /**
    * @boolean test
    * @returns - test results
    */
        boolean test = true;
        if(( test == true ) && ( data == null )) {
            System.err.println( "SetColChart::SetColChart() ***Warning, object"
                    + "data is null. Value sent: " + data );
        } 
        else if(( test == true ) && ( chartTitle == null )) {
            System.err.println( "SetColChart::SetColChart() ***Warning, object"
                    + "chartTitle is null. Value sent: " + chartTitle );
        }
        else if(( test == true ) && ( chartTitle.isEmpty() )) {
            System.err.println( "SetColChart::SetColChart() ***Warning, object"
                    + "chartTitle is empty. Value sent: " + chartTitle );
        }
        else if(( test == true ) && ( c1 < 0 )) {
            System.err.println( "SetColChart::SetColChart() ***Warning, object"
                    + "c1 is an invalid input. Value sent: " + c1 );
        }
        else if(( test == true ) && ( c2 < 0 )) {
            System.err.println( "SetColChart::SetColChart() ***Warning, object"
                    + "c2 is an invalid input. Value sent: " + c2 );
        }
            else if(( test == true ) && ( row < 0 )) {
            System.err.println( "SetColChart::SetColChart() ***Warning, object"
                    + "row has invalid input. Value sent: " + row );
        }
                else if(( test == true ) && ( col < 0 )) {
            System.err.println( "SetColChart::SetColChart() ***Warning, object"
                    + "col has invalid input. Value sent: " + col );
        }
        else if (test == true) {
            System.out.println( "AboutJPanel::SetBV() Object is valid. Value"
                    + "sent: " + m_BV );
        }
            
        return true;
    }
    
    public PieChart GetVizPieChart(){
        return m_PieChart;
    }
    /**
    * creates a pie chart.
    * @param col_data - data used to create the visualisation.
    * @param chartTitle - sets the visualisations title.
    * @param xLabel - sets the x axis label.
    * @param row - accepts data from rows in a CSV file.
    * @param col - accepts data from columns in a CSV file.
    */
    public boolean SetVizPieChart( String[] col_data, String chartTitle, 
            String xLabel, int row, int col ) {
            m_PieChart = new PieChart( col_data, chartTitle, xLabel, row,
                    col );
        /**
        * @boolean test
        * @returns - test results
        */    
        boolean test = true;
        if(( test == true ) && ( col_data == null )) {
        System.err.println( "SetVizPieChart::SetVizPieChart() "
          + "***Warning, object" + "col_data is null. Value sent: " 
          + col_data );
        } 
        else if(( test == true ) && ( chartTitle == null )) {
        System.err.println( "SetVizPieChart::SetVizPieChart() "
          + "***Warning, object" + "chartTitle is null. Value sent: " 
          + chartTitle );
        }
        else if(( test == true ) && ( chartTitle.isEmpty() )) {
        System.err.println( "SetVizPieChart::SetVizPieChart() "
          + "***Warning, object" + "chartTitle is empty. Value sent: " 
          + chartTitle );
        }
        else if(( test == true ) && ( row < 0 )) {
        System.err.println( "SetVizPieChart::SetVizPieChart() "
          + "***Warning, object" + "row has invalid input. Value sent: " 
          + row );
        }
        else if(( test == true ) && ( col < 0 )) {
        System.err.println( "SetVizPieChart::SetVizPieChart() "
          + "***Warning, object" + "col has invalid input. Value sent: " 
          + col );
        }
        
        return true;
    }
    
    /**
    * creates a table visualisation.
    * @param data - data used to create a visualisations. 
    * @param headers - gets the headers for the table visualisation.
    * @return - table visualisation
    */
    public boolean SetTable( String[][] data, String[] headers, String title) {
        m_Table = new Table( data, headers, title );
        boolean test = true;
        
        if(( test == true ) && ( data == null )) {
        System.err.println( "SetTable::SetTable() ***Warning, object"
                    + "data is null. Value sent: " + data );
        }
           else if(( test == true ) && ( headers == null )) {
        System.err.println( "SetTable::SetTable() ***Warning, object"
                    + "headers is null. Value sent: " + headers );
        }
        
        return true;
    }
    
    public Table GetTable(){
        //Returns a Table
        return m_Table;
    }
    
    /**
    * creates a scatter plot graph visualisation.
    * @param data - used to create the visualisation.
    * @param graphTitle - sets the visualisations title.
    * @param c1 - selects data from a first column.
    * @param c2 - selects data from a second column.
    * @param xLabel - sets the x axis label. 
    * @param yLabel - sets the y axis label.
    * @param col - obtains data from columns in a CSV file.
    * @param row - obtains data from rows in a CSV file.
    * @return - scatter plot graph visualisation. 
    */
    public boolean SetScatterPlotGraph( String[][] data, 
            String graphTitle, int c1, int c2, String xLabel, 
            String yLabel, int col, int row ) {
        m_ScatterPlotGraph = new ScatterPlotGraph( data, graphTitle, c1, 
            c2, xLabel, yLabel, col, row );
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        
        boolean test = true;
        if(( test == true ) && ( data == null )) {
        System.err.println( "Visualisation::SetScatterPlotGraph() "
          + "***Warning, object" + "data is null. Value sent: " + data );
        } 
        else if(( test == true ) && ( graphTitle == null )) {
        System.err.println( "Visualisation::SetScatterPlotGraph() "
          + "***Warning, object" + "graphTitle is null. "
          + "Value sent: " + graphTitle );
        }
        else if(( test == true ) && ( graphTitle.isEmpty() )) {
        System.err.println( "Visualisation::SetScatterPlotGraph() "
            + "***Warning, object" + "chartTitle is empty. Value sent:"
            + " " + graphTitle );
        }
         else if(( test == true ) && ( c1 < 0 )) {
            System.err.println( "Visualisation::SetScatterPlotGraph() "
            + "***Warning, object"+ "c1 is an invalid input. Value sent: " 
            + c1 );
        }
        else if(( test == true ) && ( c2 < 0 )) {
            System.err.println( "Visualisation::SetScatterPlotGraph() "
             + "***Warning, object"+ "c2 is an invalid input. Value sent: " 
             + c2 );
        }
             else if(( test == true ) && ( row < 0 )) {
        System.err.println( "Visualisation::SetScatterPlotGraph() "
             + "***Warning, object"+ "row has invalid input. Value sent: " 
             + row );
        }
        else if(( test == true ) && ( col < 0 )) {
        System.err.println( "Visualisation::SetScatterPlotGraph() "
             + "***Warning, object"+ "col has invalid input. Value sent: " 
             + col );
        }
        
        return true;
    }
    
    public ScatterPlotGraph GetScatterPlotGraph(){
        //Returns a Table
        return m_ScatterPlotGraph;
    }
    
      /**
    * creates test instances. 
    */
    public static void main(String[][] args) {
        Visualisation v = new Visualisation();
        String[][] test_data;
        String graphTitle;
        int c1;
        int c2;
        String xLabel; 
        String yLabel;
        int col;
        int row;
        
        v.SetScatterPlotGraph( null,null, -1 , -1 , null, null,-1,-1 );
        v.SetTable( null,null, null );
        v.SetVizPieChart( null, null, null, -1, -1 );
        v.SetColChart(null, null, -1, -1, null, null, -1, -1);
    }
 
            
           
    /**
    * @return - returns the visualisation. 
    */
    public boolean SetBV( GroupPDM2application bv ) {
        boolean test = true;
        if(( test == true ) && ( bv == null) ) {
            System.err.println( "Visualisation::SetBV() ***Warning, GroupPDM2"
                    + "application is null. Value sent: " + bv );
        } else if ( test == true ) {
            System.out.println( "Visualisation::SetBV() GroupPDM2"
                    + "application. Value sent: " + bv );
        }
        m_BV = bv;
        return true;
    }
    
      /**
    * creates a scatter plot graph visualisation.
    * @param m_PieChart - creates an instance of a pie chart.
    * @param m_Table - creates an instance of a table.
    * @param m_ScatterPlotGraph - creates an instance of a scatter plot graph.
    * @param m_BV - creates the visualisation.
    * @param m_ColumnChart - creates an instance of a column chart.
    */
    private PieChart m_PieChart;
    private Table m_Table;
    private ScatterPlotGraph m_ScatterPlotGraph;
    private GroupPDM2application m_BV;
    private ColumnChart m_ColumnChart;

}