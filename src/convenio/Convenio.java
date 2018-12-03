/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convenio;

import java.io.File;
import java.util.Properties;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.Logger;
import telas.TelaPrincipal;
import util.ConfigurationFactory;

/**
 *
 * @author Produção
 */
public class Convenio {

    public static Logger log;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        String teste = prop.getProperty("user.dir");
        System.out.println(teste);
        teste = teste + "/convenio/";
        System.out.println(teste);
        
//        File dir = new File("./src/convenio");
//        String arqs[] = dir.list();
//        for (int i = 0 ; i < arqs.length ; i++){
//            System.out.println(arqs[i].toString());
//        }
        log = ConfigurationFactory.getLOG();
        log.info("Abertura de sistema");
    
        
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException ex) {
                    ConfigurationFactory.getLOG().warn(ex.getMessage());
                } catch (InstantiationException ex) {
                    ConfigurationFactory.getLOG().warn(ex.getMessage());
                } catch (IllegalAccessException ex) {
                    ConfigurationFactory.getLOG().warn(ex.getMessage());
                } catch (UnsupportedLookAndFeelException ex) {
                    ConfigurationFactory.getLOG().warn(ex.getMessage());
                }
                break;
            }
        }

        new TelaPrincipal().setVisible(true);

    }
    
    
    
    

    
}
