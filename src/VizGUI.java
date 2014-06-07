/**
 * @file -VizGUI.java
 * @author -Rhys Owen
 * @date -02/03/2013
 * @see Table.java, ScatterPlotGraph.java, PieChart.java, ColumnChart.java
 * 
 * @brief This class creates a simple GUI to present all the types of 
 * visualisers.
 */
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VizGUI extends JFrame {
    
    public VizGUI(JPanel panel, JButton colourBut) {
        
        /* set frame title for BobViz */
        setTitle( FRAME_TITLE );
        /* set frame height and width for BobViz */
	setSize( FRAME_WIDTH, FRAME_HEIGHT );
        setLayout( new BorderLayout() );
	setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        
        /* add panel to VizGUI */
        add(panel, BorderLayout.NORTH);
        add(colourBut, BorderLayout.SOUTH);
        
        /* create new menu objects */
        JMenuBar menuBar;
        JMenu fileMenu;
        JMenu helpMenu;
        JMenuItem importCSVItem;
        JMenuItem exitItem;
        JMenuItem helpConItem;
        
        /* create new menu bar for BobViz */
        menuBar = new JMenuBar();

        /* create new menu */
        fileMenu = new JMenu( FILE_MENU );

        /* create new menu items */
        importCSVItem = new JMenuItem( SAVEAS_MENU_ITEM );
        exitItem = new JMenuItem( EXIT_MENU_ITEM );
        helpConItem = new JMenuItem( COLOUR_MENU_ITEM );
        
        /* add menu items to file menu */
        fileMenu.add( importCSVItem );
        fileMenu.add( exitItem );

        /* make new help menu */
        helpMenu = new JMenu( EDIT_MENU );
        
        /* add menu bars to menu */
        menuBar.add( fileMenu );
        menuBar.add( helpMenu );
        
        /* make new help content menu item */
        /* add helpConItem to menu */
        helpMenu.add( helpConItem );
        
        /* add menu bar to BobViz */
        setJMenuBar( menuBar );
        
        setVisible( true );
        
    }
    
    /** title frame of BobViz */
    private final String FRAME_TITLE = "BobViz Visualisation Viewer v1.0";
    /** width size of BobBiz */
    private final int FRAME_WIDTH = 800;
    /** height size of BobViz */
    private final int FRAME_HEIGHT = 600;
    
    private final String FILE_MENU = "File";
    private final String EDIT_MENU = "Edit";
    private final String COLOUR_MENU_ITEM = "Colour";
    private final String EXIT_MENU_ITEM = "Exit";
    private final String SAVEAS_MENU_ITEM = "Save As...";
    
}
