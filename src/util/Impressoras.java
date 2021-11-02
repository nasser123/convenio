/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Nasser
 */
public class Impressoras {

    /**
     * Retorna impressora padrão definida no sistema operacional
     */
    public static PrintService getImpressoraPadrao() {
        PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
        return impressora;
    }

    /**
     * @return PrintService[] retorna lista de impressoras
     */
    public static PrintService[] getListaImpressoras() {
        return PrintServiceLookup.lookupPrintServices(null, null);
    }

    /**
     * @return ArrayList<String> retorna lista de impressoras no formato de
     * string
     */
    public static ArrayList<String> getListaImpressorasArray() {
        ArrayList<String> listaImpressorasArray = new ArrayList<>();
        PrintService[] lista = getListaImpressoras();
        for (int i = 0; i < lista.length; i++) {
            listaImpressorasArray.add(lista[0].getName());
        }
        return listaImpressorasArray;
    }

    public static String[] getListaImpressorasMatriz() {
        String[] listaImpressorasMatriz = new String[getListaImpressoras().length];
        PrintService[] lista = getListaImpressoras();
        for (int i = 0; i < lista.length; i++) {
            listaImpressorasMatriz[i] = lista[i].getName();
        }
        return listaImpressorasMatriz;
    }

    /**
     * @return boolean verifica se a impressora existe
     * @param String impressora
     */
    public static boolean existeImpressora(String impressora) {
        ArrayList<String> listaImpressorasArray = new ArrayList<>();

        for (int i = 0; i < listaImpressorasArray.size(); i++) {
            if (impressora.equals(listaImpressorasArray.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna a impressora configurada como padrão para impressao de cupons
     *
     * @return String impressora
     */
    public static String getImpressoraCupomString() {
        String impressora = ConfigurationFactory.IMPRESSORACUPOM;
        return impressora;

    }

    public static PrintService getImpressoraCupom() {
        String impressora = ConfigurationFactory.IMPRESSORACUPOM;
        for (int i = 0; i < getListaImpressoras().length; i++) {
            if (getListaImpressoras()[i].getName().equals(impressora)) {
                return getListaImpressoras()[i];
            }
        }
        return getImpressoraPadrao();

    }

    /**
     * Retorna número de vias configuradas para impressao do cupom
     *
     * @return Integer nrvias
     */
    public static Integer getNrViasCupom() {
        return ConfigurationFactory.NRVIAS;

    }
}
