/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

/**
 *
 * @author Rafael
 */
public class ConfigurationFactory_old {

    private static final Ini ini = null;
    
    public static Section getConfiguration(String section)  {
        if(ini != null){
            
            return ini.get(section);
        }
        Ini ini = getIni(); 
        Section sect = ini.get(section);
        return sect;
    }
    
    public static Section getConfiguration()  {
       
        
        if(ini != null){
            return ini.get("main");
        }
        Ini ini = getIni();
        Section sect = ini.get("main");
        return sect;
    }

    private static Ini getIni() {
        Ini ini = new Ini();
        try {
            FileReader arq = new FileReader("config.ini");
            ini.load(arq);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo de configuração");
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        } catch (IOException ex) {
            ConfigurationFactory.getLOG().warn(ex.getMessage());
        }
        return ini;
    }
}
