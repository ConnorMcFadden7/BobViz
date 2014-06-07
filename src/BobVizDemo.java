/**
 * @file -GroupPDM2application.java
 * @author -Rhys Owen
 * @date -01/03/2013
 * 
 * @brief This class creates a new instance of GroupPDM2application and parses 
 * it to all panels to ensure only one instance of GroupPDM2application is 
 * ever used.
 */

public class BobVizDemo {
    
   /**
    * This class is used to execute all instances. This makes
    * object programming easier.
    * @param args -user input not used
    */
    public static void main( String[] args ) {
        /* create new instance of GroupPDM2application */
        GroupPDM2application bv = new GroupPDM2application();
        
        /* send all instances of bv to all classes */
        bv.GetViz().SetBV(bv);
        bv.GetImportJPan().SetBV(bv);
        bv.GetSettingJPan().SetBV(bv);
        bv.GetAboutJPan().SetBV(bv);
        bv.GetDataset().SetBV(bv);
        bv.GetStatusJPan().SetBV(bv);
        bv.GetVizTypeJPan().SetBV(bv);
        bv.GetGenerateVizJPan().SetBV(bv);
        bv.GetDataAtrribute().SetBV(bv);
    }
    
}