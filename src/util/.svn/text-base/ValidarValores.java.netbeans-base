/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author Produção
 */
public class ValidarValores {

    /**
     * Conver
     *
     * @param valorStr
     * @return
     */
    public static double converterDoubleDoisDecimais(String valorStr) {
        // DecimalFormat fmt = new DecimalFormat("0.00");
        String valorInteiro = "";
        String valorDecimal = "";
        
        String[] part = valorStr.split("[,]");
        
        double preco = 0.0;
        try {
            valorInteiro = part[0];
            valorDecimal = part[1];

        } catch (ArrayIndexOutOfBoundsException aioe) {
            valorDecimal = "00";
        }
        
        try {
            String completa = valorInteiro + "." + valorDecimal;
            preco = Double.parseDouble(completa);

        } catch (NumberFormatException nfe) {
            
        }

        return preco;
    }

    public static double round(double valor, int casas) {
        Double p = Math.pow(10, casas);
        return Math.round(valor * p) / p;
    }
    
    public static float round(float valor, int casas) {
        float p = (float) Math.pow(10, casas);
        return Math.round(valor * p) / p;
    }


    /*
     */
    /**
     *
     * @param v Double valor a ser convertido
     * @param np número de casas decimais
     * @return retorna um valor com o número de casas decimais especificado
     */
    public static ArrayList calculaParcelas(Float v, int np) {
        ArrayList<Float> parcelas = new ArrayList();
        int nrParcelas = np;
        float valorTotal = v;
        float parcela = 0.0f;
        float ultimaParcela = 0.0f;

        parcela = valorTotal / nrParcelas;

        double d = round(parcela, 2);
        float f = (float) d;
        parcela = f;
        for (int i = 0; i < nrParcelas - 1; i++) {
            parcelas.add(parcela);
        }

        ultimaParcela = valorTotal - (parcela * (nrParcelas - 1));
        d = round(ultimaParcela, 2);
        ultimaParcela = (float) d;
        parcelas.add(ultimaParcela);

        return parcelas;
    }
}
