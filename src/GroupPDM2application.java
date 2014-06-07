/**
 * @file -GroupPDM2application.java
 * @author -Rhys Owen
 * @date -01/03/2013
 * 
 * @brief This class provides the user with a simple GUI system. It initiates
 * all instances used throughout the application.
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GroupPDM2application extends JFrame {
    
    public GroupPDM2application() {
        
        /* create new menu objects */
        JMenuBar menuBar;
        JMenu fileMenu;
        JMenu helpMenu;
        JMenuItem importCSVItem;
        JMenuItem exitItem;
        JMenuItem helpConItem;

        /* create new JPanel which will hold all GUI components */
        JPanel top = new JPanel();
        /* create a new JPanel which will hold the current status of program */
        m_StatusJPan = new StatusJPanel();
        
        /* set frame title for GroupPDM2application */
        setTitle( FRAME_TITLE );
        /* set frame height and width for GroupPDM2application */
	setSize( FRAME_WIDTH, FRAME_HEIGHT );
	setResizable( false );
        setLayout( new BorderLayout() );
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        /* create new menu bar for GroupPDM2application */
        menuBar = new JMenuBar();

        /* create new menu */
        fileMenu = new JMenu( FILE_MENU );

        /* create new menu items */
        importCSVItem = new JMenuItem( FILE_IMPORTCSV );
        exitItem = new JMenuItem( FILE_EXIT );
        helpConItem = new JMenuItem( FILE_HELPCON );
        
        /* add menu items to file menu */
        fileMenu.add( importCSVItem );
        fileMenu.add( exitItem );

        /* make new help menu */
        helpMenu = new JMenu( FILE_HELP );
        
        /* add menu bars to menu */
        menuBar.add( fileMenu );
        menuBar.add( helpMenu );
        
        /* make new help content menu item */
        /* add helpConItem to menu */
        helpMenu.add( helpConItem );
        
        /* add menu bar to GroupPDM2application */
        setJMenuBar( menuBar );
        
        /* create new logo for GroupPDM2application */
        ImageIcon bvIcon = new ImageIcon( LOGO_DIR );
        /* add icon to JLabel */
        JLabel bobTitleJPan = new JLabel( bvIcon );
        
        /* make new instances of all panels */
        m_AboutJPan = new AboutJPanel();
        m_ImportJPan = new ImportJPanel();
        m_VizTypeJPan = new VizTypeJPanel();
        m_SettingJPan = new SettingJPanel();
        m_GenerateVizJPan = new GenerateVizJPanel();
        
        /* set top panel with FlowLayout layout */
        top.setLayout( new FlowLayout( FlowLayout.CENTER ) );
        /* add all panels and titles to top JPanel */
        top.add( bobTitleJPan );
        top.add( m_AboutJPan );
        top.add( m_ImportJPan );
        top.add( m_VizTypeJPan );
        top.add( m_SettingJPan );
        top.add( m_GenerateVizJPan );
        
        /* add top and m_StatusJPan to GroupPDM2application */
        add( top, BorderLayout.CENTER );
        add( m_StatusJPan, BorderLayout.SOUTH );
        
        setVisible( true );
  
    }
    
    /**
     * @return the AboutJPanel instance
     */
    public AboutJPanel GetAboutJPan() {
        return m_AboutJPan;
    }
    
    /**
     * @return the DataAttribute instance
     */
    public DataAttribute GetDataAtrribute() {
        return m_DataAttribute;
    }
    
    /**
     * @return the Dataset instance
     */
    public Dataset GetDataset() {
        return m_Dataset;
    }
    
    /**
     * @return the ImportJPanel instance
     */
    public ImportJPanel GetImportJPan() {
        return m_ImportJPan;
    }
    
    /**
     * @return the SettingJPanel instance
     */
    public SettingJPanel GetSettingJPan() {
        return m_SettingJPan;
    }
    
    /**
     * @return the VizTypeJPanel instance
     */
    public VizTypeJPanel GetVizTypeJPan() {
        return m_VizTypeJPan;
    }
    
    /**
     * @return the StatusJPanel instance
     */
    public StatusJPanel GetStatusJPan() {
        return m_StatusJPan;
    }
    
    /**
     * @return the GenerateVizJPanel instance
     */
    public GenerateVizJPanel GetGenerateVizJPan() {
        return m_GenerateVizJPan;
    }
    
    /**
     * @return the Visualisation instance
     */
    public Visualisation GetViz() {
        return m_Visualisation;
    }
    
    /** AboutJPanel type object */
    private AboutJPanel m_AboutJPan;
    /** ImportJPanel type object */
    private ImportJPanel m_ImportJPan;
    /** VizTypeJPanel type object */
    private VizTypeJPanel m_VizTypeJPan;
    /** SettingJPanel type object */
    private SettingJPanel m_SettingJPan;
    /** StatusJPanel type object */
    private StatusJPanel m_StatusJPan;
    /** GenerateJPanel type object */
    private GenerateVizJPanel m_GenerateVizJPan;
    /** Visualisation new instance */
    private Visualisation m_Visualisation = new Visualisation();
    /** DataAttribute new instance */
    private DataAttribute m_DataAttribute = new DataAttribute();
    /** Dataset new instance */
    private Dataset m_Dataset = new Dataset();
    
    /** add new file menu */
    private final String FILE_MENU = "File";
    /** add new exit menu */
    private final String FILE_EXIT = "Exit";
    /** add new help menu */
    private final String FILE_HELP = "Help";
    
    /** add new import csv menu item */
    private final String FILE_IMPORTCSV = "Import CSV...";
    /** add new help content menu item */
    private final String FILE_HELPCON = "Help Contents";
    
    /** set logo directory */
    private final String LOGO_DIR = "images/png/bv_logo.png";
    
    /** title frame of GroupPDM2application */
    private final String FRAME_TITLE = "BobViz v1.0";
    /** width size of BobBiz */
    private final int FRAME_WIDTH = 556;
    /** height size of GroupPDM2application */
    private final int FRAME_HEIGHT = 600;
    
}