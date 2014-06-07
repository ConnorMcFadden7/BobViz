/**
 * @file   Table.java
 * @author Connor McFadden
 * @data   28 February 2013
 *
 * A simple class that displays data in a table visualisation
 *
 */

import java.awt.*;
import javax.swing.*;

public class Table extends JPanel {
    /**
    * @param m_data - the data to be passed from users to the table
    * @param m_headers - the headers to be passed to the table
    */
    public Table( String[][] m_data, String[] m_headers, String tableTitle ) {
        /**Instantiate a table taking in specific data from users*/
	JTable table = new JTable(m_data, m_headers);
	table.setBorder(BorderFactory.createLineBorder(Color.gray));
        JLabel title = new JLabel( tableTitle );
       
        JPanel panel = new JPanel();
        panel.add(title);
        /** Create a JScrollPane which adds the JTable*/
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        JPanel tableJPan = new JPanel();
        JButton disabledBut = new JButton("Change colour");
        disabledBut.setEnabled(false);
        tableJPan.add(scrollPane);
        
        JFrame test = new JFrame();
        test.setLayout(new BorderLayout());
        test.setSize( HEIGHT_FRAME, WIDTH_FRAME );
        test.setTitle("Table");
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.add(tableJPan, BorderLayout.CENTER);
        test.add(panel, BorderLayout.NORTH);
        test.setVisible(true);
        
        
    }
    
    private final int WIDTH_FRAME = 600;
    private final int HEIGHT_FRAME = 800;
}