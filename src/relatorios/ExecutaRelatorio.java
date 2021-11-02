package relatorios;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import util.ConfigurationFactory;
import static util.ConfigurationFactory.IMPRESSORACUPOM;
import util.ConnectionFactory;
import util.Impressoras;
import util.ReportUtils;

/**
 * Ponto de entrada do projeto.
 *
 * @author David Buzatto
 */
public class ExecutaRelatorio {

    //static String caminho = System.getProperty("user.dir");
    String rel = "";

    /**
     * @param args the command line arguments
     */
    //   public static void main(String[] args) {
    //       new ExecutaRelatorio().abrirRelatorioClientes(rel);
    //   }
    public void abrirRelatorioClientes(String relatorio) {

        rel = relatorio;
        /*
         * Obtendo o arquivo do relatório. Note que estamos utilizando um
         * InputStream para obter o arquivo que está dentro do nosso projeto.
         * Fazendo isso, não teremos problema quando nosso projeto for
         * empacotado em um .jar.
         *
         * Note que o caminho do .jasper inicia com /, ou seja, a raiz da
         * localização das classes compiladas do nosso projeto (o pacote
         * default).
         *
         * Utilize a aba Files (canto superior esquerdo) e veja que os arquivos
         * .jasper e .jrxml são copiados para o diretório /build/classes e por
         * consequencia para o .jar que for criado.
         *
         * Se não os estiver vendo, mande dar um Clean and Build no projeto
         * (botão direito no nó raiz do projeto, Clean and Build (Limpar e
         * Construir)
         *
         */
        //InputStream inputStream = getClass().getResourceAsStream("../relatorios/" + rel);
        InputStream inputStream = getClass().getResourceAsStream(rel);

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();

        try {

            // abre o relatório
            ReportUtils.openReport("Relatorio de Venda", inputStream, parametros,
                    ConnectionFactory.getConnection());

        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }

    }

    public void abrirRelatorioParcelasConvenio(Object convenio, Object periodo, Object periodofinal, Object empresa) {

        InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasConvenio.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("CONVENIO", convenio);
        parametros.put("PERIODO", periodo);
        parametros.put("PERIODOFINAL", periodofinal);
        parametros.put("EMPRESA", empresa);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Parcelas por Convênio", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }

    }

    public void abrirRelatorioParcelasConvenioNovo(Object convenio, Object periodo, Object periodofinal, Object empresa) {

        InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasConvenioNovo.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("CONVENIO", convenio);
        parametros.put("PERIODO", periodo);
        parametros.put("PERIODOFINAL", periodofinal);
        parametros.put("EMPRESA", empresa);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Parcelas por Convênio", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }

    }

    public void abrirRelatorioVendasClientePorPeriodo(Object cliente, Object periodo, Object periodofinal, Object empresa) {

        InputStream inputStream = getClass().getResourceAsStream("RelatorioVendasPorClientePorPeriodo.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("CLIENTE", cliente);
        parametros.put("PERIODO", periodo);
        parametros.put("PERIODOFINAL", periodofinal);
        parametros.put("EMPRESA", empresa);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Vendas por Cliente", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }

    }

    public void abrirRelatorioVendasCliente(Object cliente, Object empresa) {

        InputStream inputStream = getClass().getResourceAsStream("RelatorioVendasPorCliente.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("CLIENTE", cliente);
        parametros.put("EMPRESA", empresa);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Vendas por Cliente", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    public void abrirRelatorioVendasClientePeriodo(Object dataIni, Object dataFim, Object cliente, Object empresa) {

        InputStream inputStream = getClass().getResourceAsStream("RelatorioVendasPorCliente.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("dataInicial", dataIni);
        parametros.put("dataFinal", dataFim);
        parametros.put("CLIENTE", cliente);
        parametros.put("EMPRESA", empresa);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Vendas por Cliente por Periodo", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    public void abrirRelatorioVendaPorPeriodo(Object dataIni, Object dataFim, Object ordem1, Object empresa) {
        InputStream inputStream = getClass().getResourceAsStream("RelatorioVenda.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("dataInicial", dataIni);
        parametros.put("dataFinal", dataFim);
        parametros.put("ordem1", ordem1);
        parametros.put("EMPRESA", empresa);

        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Vendas por Período", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    public void abrirRelatorioClientesPorConvenio(Integer convenio, Integer empresa) {
        InputStream inputStream = getClass().getResourceAsStream("RelatorioClientesPorConvenio.jasper");
        Map<String, Integer> parametros = new HashMap<String, Integer>();
        parametros.put("CONVENIO", convenio);
        parametros.put("EMPRESA", empresa);
        try {
            // abre o relatório
            ReportUtils.openReport("Relatório de Clientes por Convenio", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    public void abrirRelatorioParcelasConvenioComprovante(Object datapgto, Object convenio, Object empresa) {
        InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasConvenioComprovante.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("DATA_PGTO", datapgto);
        parametros.put("CONVENIO", convenio);
        parametros.put("EMPRESA", empresa);
        try {
            // abre o relatório
            ReportUtils.openReport("Comprovante de pagamento por Convenio", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    public void abrirRelatorioParcelasClienteComprovante(Object datapgto, Object cliente, Object empresa) {
        InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasClienteComprovante.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("DATA_PGTO", datapgto);
        parametros.put("CLIENTE", cliente);
        parametros.put("EMPRESA", empresa);
        try {
            // abre o relatório
            ReportUtils.openReport("Comprovante de pagamento por Cliente", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    public void abrirRelatorioParcelasCliente(Object datainicial, Object datafinal, Object cliente, Object empresa) {
        InputStream inputStream = getClass().getResourceAsStream("RelatorioParcelasCliente.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("PERIODO", datainicial);
        parametros.put("PERIODOFINAL", datafinal);
        parametros.put("CLIENTE", cliente);
        parametros.put("EMPRESA", empresa);
        try {
            // abre o relatório
            ReportUtils.openReport("Relatorio de Parcelas por Cliente", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    /**
     * @param datainicial data inicial do relatorio
     * @param datafinal data final do relatorio
     * @param empresa empresa
     * @param situacao busca a partir da situação
     *
     * 0 - busca somente não pagos 1 - busca somente pagos 2 - busca todos os
     * lançamentos
     */
    public void abrirRelatorioContasReceber(Object datainicial, Object datafinal, Object empresa, String situacao) {
        InputStream inputStream = getClass().getResourceAsStream("RelatorioContasReceber.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("PERIODO", datainicial);
        parametros.put("PERIODOFINAL", datafinal);
        parametros.put("EMPRESA", empresa);
        parametros.put("SITUACAO", situacao);
        try {
            // abre o relatório
            ReportUtils.openReport("Relatorio de Parcelas por Cliente", inputStream, parametros, ConnectionFactory.getConnection());
        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    public void abrirRelatorioCupom(Integer idvenda, Integer empresa) {
        InputStream inputStream = getClass().getResourceAsStream("RelatorioCupom.jasper");
        Map<String, Integer> parametros = new HashMap<String, Integer>();
        parametros.put("IDVENDA", idvenda);
        parametros.put("EMPRESA", empresa);
        try {
            // abre o relatório
            //ReportUtils.openReport("Relatório de Clientes por Convenio", inputStream, parametros, ConnectionFactory.getConnection());

            /*teste para salvar em PDF*/
            Map<String, Object> parametrosNovo = new HashMap<String, Object>();
            Object oVenda = idvenda;
            Object oEmpresa = empresa;
            parametrosNovo.put("IDVENDA", oVenda);
            parametrosNovo.put("EMPRESA", oEmpresa);
            File file = new File("./parcelas.pdf");

            JasperPrint printNovo;
            InputStream inputStreamNovo = getClass().getResourceAsStream("RelatorioCupom.jasper");
            printNovo = JasperFillManager.fillReport(inputStreamNovo, parametrosNovo, ConnectionFactory.getConnection());
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, printNovo);
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE, file);
            pdfExporter.exportReport();
            teste(file, 2);

        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }
    }

    /*teste de impressao de arquivo PDF*/
    public void teste(File file, int copias) {
        try {
            //        String[] args = new String[1];
//        args[0] = file.getAbsolutePath();
//        try {
//            for (int i = 0; i < copias; i++) {
//                Printing.main(args);
//            }
//
//        } catch (PrinterException ex) {
//            ConfigurationFactory.getLOG().warn(ex.getMessage());
//        } catch (IOException ex) {
//            ConfigurationFactory.getLOG().warn(ex.getMessage());
//        }

            for (int i = 0; i < ConfigurationFactory.NRVIAS; i++) {
                Impressao.imprimir(Impressoras.getImpressoraCupom(), file.toString(), 1);
            }

        } catch (PrinterException ex) {
            Logger.getLogger(ExecutaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExecutaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void abrirRelatorioClientes(String relatorio, HashMap param) {

        rel = relatorio;
        /*
         * Obtendo o arquivo do relatório. Note que estamos utilizando um
         * InputStream para obter o arquivo que está dentro do nosso projeto.
         * Fazendo isso, não teremos problema quando nosso projeto for
         * empacotado em um .jar.
         *
         * Note que o caminho do .jasper inicia com /, ou seja, a raiz da
         * localização das classes compiladas do nosso projeto (o pacote
         * default).
         *
         * Utilize a aba Files (canto superior esquerdo) e veja que os arquivos
         * .jasper e .jrxml são copiados para o diretório /build/classes e por
         * consequencia para o .jar que for criado.
         *
         * Se não os estiver vendo, mande dar um Clean and Build no projeto
         * (botão direito no nó raiz do projeto, Clean and Build (Limpar e
         * Construir)
         *
         */
        //InputStream inputStream = getClass().getResourceAsStream("../relatorios/" + rel);
        InputStream inputStream = getClass().getResourceAsStream(rel);

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        HashMap parametros = new HashMap();
        parametros = param;

        try {

            // abre o relatório
            ReportUtils.openReport("RelatorioVenda", inputStream, parametros,
                    ConnectionFactory.getConnection());

        } catch (JRException exc) {
            ConfigurationFactory.getLOG().warn(exc.getMessage());
        }

    }
}
