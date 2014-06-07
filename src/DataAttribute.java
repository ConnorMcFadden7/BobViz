/**
* @file -DataAttribute.java
* @author - Matthew Rees
* @date -28 February 2013
*
* @brief A class which is responsible setting graph attributes
* 
* A class used to give attributes such as title and axis titles 
* to the data visualisation this class will be used throughout 
* the program and collaborate with many classes.
*/

public class DataAttribute {
    

    /** Get method returns the user defined axis label
    * @return Returns user defined axis X label
    */
    public String GetAxisLabelX(){
        return m_getAxisLabelX;
    }

    /** Get method returns the user defined axis label
    * @return Returns user defined axis y label
    */
    public String GetAxisLabelY(){
        return m_getAxisLabelY;
    }
    
    /** Gets the selected index of Axis X.
     * @return index reference of the X Axis.
     */
    public int GetSelectedXIndex() {
        return m_xAxisSelectedIndex;
    }
    
    
    /** Gets the selected index of axis Y.
     * @return index reference of axis Y. 
     */
    public int GetSelectedYIndex() {
        return m_yAxisSelectedIndex;
    }
    
    /** Get method returns the user defined axis label
    * @return Returns user defined title
    */
    public String GetTitle(){
        return m_getTitle;
    }

    /** This method uses unit tests and uses the user input from the GUI, if 
    * the input is blank then the default label is given. Another test ensures
    * if the axis label given is too long it will warn the user that it is too
    * long.
    * @param yAxis- User Input.
    */
    public boolean SetAxisLabelY( String axisY ){
        boolean test = true;
        m_getAxisLabelY = axisY;
        if( test ){
            System.out.println("DataAttribute::SetAxisLabelX() : " + 
            axisY);
        }
        if ( axisY.isEmpty() && test == true ) {
           System.err.println("*** Warning Data Attribute::SetAxisLabelY() " +
           "Axis Label set to Default Label " + m_defaultAxisLabelY);
           m_getAxisLabelY = m_defaultAxisLabelY;
        }
        if ( axisY.length() > 30 && test == true ){
           System.err.println("*** Warning Data Attribute::SetAxisLabelX() " +
           "axis y label is too large " + axisY);
        }
        return true;
    }

    /** This method uses unit tests and uses the user input from the GUI, if 
    * the input is blank then the default label is given. Another test ensures
    * if the axis label given is too long it will warn the user that it is too
    * long.
    * @param axisX- User Input.
    * @return boolean - if result is true
    */
    public boolean SetAxisLabelX( String axisX ){
        boolean test = true;
        m_getAxisLabelX = axisX;
        if( test ){
            System.out.println("DataAttribute::SetAxisLabelY() : "
            + axisX);
        }
        if ( axisX.isEmpty() && test == true ) {
           System.err.println("*** Warning DataAttribute::SetAxisLabelY() " +
           "Axis Label set to Default Label " + m_defaultAxisLabelX);
           m_getAxisLabelX = m_defaultAxisLabelX;
        }
        if ( axisX.length() > 30 && test == true ){
           System.err.println("*** Warning Data Attribute::SetAxisLabelY() " +
           "x label is too large " + axisX);
        }
        return true;
    }
    
    /** 
     * 
     */
    public boolean SetSelectedYIndex( int index ) {
        m_yAxisSelectedIndex = index;
        return true;
    }
    
    /** Sets the selected index of X axis
     * @param index
     */
    public boolean SetSelectedXIndex(int index) {
        m_xAxisSelectedIndex = index;
        return true;
    }

    /** This method checks the user input to ensure that 
    * the user defined title is present and if not the 
    * method will set the visualisation title to "Default
    * Title". The unit tests given here ensure that if the title is left blank
    * a default title is given it also ensures that if a title given is too 
    * large the user is warned.
    * @param title- returns user defined title
    */
    public boolean SetTitle( String title ){
        boolean test = true;

        if( test ){
          System.out.println("DataAttribute::SetTitle() title: " 
          + title);
        }

        if ( title.isEmpty() && test == true ) {
           System.err.println("*** Warning DataAttribute::SetTitle() " +
           "title set to default title " + m_defaultTitle);
           m_getTitle = m_defaultTitle;
        }

        if ( title.length() > 75 && test==true ){
           System.err.println("*** Warning DataAttribute::SetTitle() title" 
           + "title is too large " + title);
        } 
        m_getTitle = title;
        return true;
    }

    /**
    * @param bv - a GroupPDM2application object
    * @return TRUE on success
    */
    public boolean SetBV(GroupPDM2application bv) {
        boolean test = true;
        if(( test == true ) && ( bv == null) ) {
            System.err.println( "DataAttribute::SetBV() ***Warning, GroupPDM2"
                    + "application is null. Value sent: " + bv );
        } else if ( test == true ) {
            System.out.println( "DataAttribute::SetBV() GroupPDM2"
                    + "application. Value sent: " + bv );
        }
        m_BV = bv;
        return true;
    }
    
    /**
     * This method is used for testing purposes.
    * @param args - no user input needed.
    */
    public static void main( String args[] ){
        boolean test = true;
        if ( test ) {
            System.out.println( "DataAttribute::main() BEGIN unit test");
        }
        DataAttribute d = new DataAttribute();
        d.SetTitle( null );
        d.SetAxisLabelY( null );
        d.SetAxisLabelX( null );
    }
    
    /*Global variables used throughout data attribute to retrieve vital 
     * attributes which data visualisations will hold such as title
     * and axis titles.
     */
    private String m_getTitle;
    private String m_getAxisLabelY;
    private String m_getAxisLabelX;
    private String m_defaultTitle = "Default Title";
    private String m_defaultAxisLabelY = "Default Label";
    private String m_defaultAxisLabelX = "Default Label";
    private int m_xAxisSelectedIndex = 0;
    private int m_yAxisSelectedIndex = 0;

    /* create new GroupPDM2application object */
    private GroupPDM2application m_BV;

}