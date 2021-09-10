/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;

/**
 *
 * @author Nasser
 */
public class ConfigurationFactory {

    private static final Ini ini = null;
    public static String DBNAME;
    public static String DBHOST;
    public static String DATABASE;
    public static String DBUSER;
    public static String DBPASSWORD;
    public static String DBPORT;
    public static String DBDIR;
    public static File DBFILE;
    public static String ARCHITECTURE;
    public static String BACKUP;
    private static Section config;
    public static Logger LOG;
    public static String DBEMPRESA;

    public static Logger getLOG() {
        if (LOG == null) {
            try {
                FileReader arq = new FileReader("./src/convenio/logtestes.properties");
                PropertyConfigurator.configure("./src/convenio/logtestes.properties");
                LOG = Logger.getLogger("testecategoria");
            } catch (FileNotFoundException nfe) {
                try {
                    FileReader arq = new FileReader("./logtestes.properties");
                    PropertyConfigurator.configure("./logtestes.properties");
                    LOG = Logger.getLogger("testecategoria");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Não encontrado arquivo de propriedades");
                }
            }
        }
        return LOG;
    }

    public ConfigurationFactory(String secao) throws FileNotFoundException {
        if (secao == null) {
            config = getConfiguration();
        } else {
            config = getConfiguration(secao);
        }
    }

    public static Section getConfiguration(String section) throws FileNotFoundException {
        if (ini != null) {

            return ini.get(section);
        }
        Ini ini = getIni();
        config = ini.get(section);
        if (ini.size() != 0) {
            DBNAME = config.get("db.name");
            DBHOST = config.get("db.host");
            DATABASE = config.get("db.database");
            DBPORT = config.get("db.port");
            DBUSER = config.get("db.user");
            DBPASSWORD = config.get("db.password");
            ARCHITECTURE = System.getProperty("os.arch");
            DBDIR = "mysql";
            DBFILE = new File(DBDIR);
            BACKUP = config.get("db.backup");
            DBEMPRESA = config.get("db.empresa");
        }
        if (DBDIR == null) {
            DBDIR = "mysql";
            DBFILE = new File(DBDIR);
        }
        return config;
    }

    private static String preencheArquivo(String arquivo) {
        String temp = arquivo;
        String arquivoFinal = "";
        char[] tempChar = temp.toCharArray();
        for (int i = 0; i < temp.length(); i++) {
            String teste = "" + tempChar[i];
            if (teste.equals("\\")) {
                arquivoFinal = arquivoFinal + "/";
            } else {
                arquivoFinal = arquivoFinal + tempChar[i];
            }
        }
        return arquivoFinal;
    }

    public static Section getConfiguration() {

        if (ini != null) {
            return ini.get("main");
        }
        Ini ini = getIni();
        if (ini.size() != 0) {
            config = ini.get("main");
            DBNAME = config.get("db.name");
            DATABASE = config.get("db.database");
            DBHOST = config.get("db.host");
            DBPORT = config.get("db.port");
            DBUSER = config.get("db.user");
            DBPASSWORD = config.get("db.password");
            DBDIR = "mysql";
            DBFILE = new File(DBDIR);
            BACKUP = config.get("db.backup");
            DBEMPRESA = config.get("db.empresa");
        }
        return config;
    }

    private static Ini getIni() {
        Ini ini = new Ini();
        try {

            FileReader arq = new FileReader("./config.ini");
            ini.load(arq);

        } catch (FileNotFoundException ex) {
            File arquivo1 = new File("config.ini");//cria o file do arquivo informado 
            try {
                arquivo1.createNewFile();
                ini.load(arquivo1);
            } catch (IOException ex1) {
                getLOG().error("não foi encontrado arquivo de configuração " + ex1.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo de configuração");
            getLOG().error("não foi encontrado arquivo de configuração " + ex.getMessage());
        } catch (IOException ex) {
            getLOG().error("não foi encontrado arquivo de configuração " + ex.getMessage());
        }
        return ini;
    }

    public static void gravaConfiguracao() {

        DBDIR = preencheArquivo(DBDIR);

        File arquivo1 = new File("config.ini");//cria o file do arquivo informado  
        try {
            arquivo1.createNewFile();//arquivo criado  
            /*LEITURA*/
            FileReader fileR = new FileReader(arquivo1);//arquivo para ser lido  
            BufferedReader buffR = new BufferedReader(fileR);//arquivo buferizado  
            /*ESCREVER*/
            FileWriter fileW = new FileWriter(arquivo1);//arquivo para escrita  
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write("[main]");
            buffW.newLine();
            buffW.write("db.name=" + DBNAME);
            buffW.newLine();
            buffW.write("db.host=" + DBHOST);
            buffW.newLine();
            buffW.write("db.port=" + DBPORT);
            buffW.newLine();
            buffW.write("db.database=" + DATABASE);
            buffW.newLine();
            buffW.write("db.user=" + DBUSER);
            buffW.newLine();
            buffW.write("db.password=" + DBPASSWORD);
            buffW.newLine();
            buffW.write("db.dir=" + DBDIR);
            buffW.newLine();
            buffW.write("db.empresa=" + DBEMPRESA);
            buffW.newLine();
           

            buffR.close();
            buffW.close();

            JOptionPane.showMessageDialog(null, "Configurações gravadas com êxito");
        } catch (IOException io) {
            String erro = io.getMessage();
            LOG.info("erro na gravacao do arquivo de configuracao: " + erro);
            JOptionPane.showMessageDialog(null, "Não foi possível gravar as alterações");
        }

    }
}
