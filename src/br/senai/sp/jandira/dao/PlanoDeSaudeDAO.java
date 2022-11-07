package br.senai.sp.jandira.dao;

import java.util.ArrayList;

import br.senai.sp.jandira.model.PlanoDeSaude;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PlanoDeSaudeDAO { // Simular nosso banco de dados

    private PlanoDeSaude planoDeSaude;
    private static ArrayList<PlanoDeSaude> planos = new ArrayList<>();

    private static final String ARQUIVO = "C:\\Users\\22283347\\java\\PlanodeSaude.txt";
    private static final String ARQUIVO_TEMP = "C:\\Users\\22283347\\java\\PlanodeSaudeTemp.txt";
    private static final Path PATH = Paths.get(ARQUIVO);
    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);

    public PlanoDeSaudeDAO(PlanoDeSaude planoDeSaude) {
        this.planos.add(planoDeSaude);
    }

    public PlanoDeSaudeDAO() {

    }

    public static void gravar(PlanoDeSaude planoDeSaude) {
        planos.add(planoDeSaude);

        try {
            //GRAVAR PLANO DE SAUDE EM ARQUIVO
            BufferedWriter bw = Files.newBufferedWriter(
                    PATH,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            String novoplanodeSaude = planoDeSaude.getPlanodesaudeSeparadoPorPontoEVirgula();

            bw.write(novoplanodeSaude);
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Houve um problema au abrir o arquivo", "Erro ao gravar", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static boolean excluir(Integer codigo) {
        for (PlanoDeSaude p : planos) {
            if (p.getCodigo().equals(codigo)) {
                planos.remove(p);
                break;
            }
            atualizararArquivo();
        }
        

        return false;
    }

    public static PlanoDeSaude getPlanoDeSaude(Integer codigo) {

        for (PlanoDeSaude p : planos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public static void atualizar(PlanoDeSaude planoDeSaude) {
        for (PlanoDeSaude p : planos) {
            if (p.getCodigo().equals(planoDeSaude.getCodigo())) {
                planos.set(planos.indexOf(p), planoDeSaude);
                break;
            }
        }
    }
    
    private static void atualizararArquivo(){
        //reconstruir arquivo atulizado sem o plano removido
        //reconstruir arquivo atulizado sem o plano removido

        // Passo 01 Criar representação dos arquivos
        File arquivoAtual = new File(ARQUIVO);
        File arquivoTemp = new File(ARQUIVO_TEMP);

        try {
            //boolean criou = arquivoTemp.createNewFile();
            arquivoTemp.createNewFile();

            BufferedWriter bwTEMP = Files.newBufferedWriter(
                    PATH_TEMP,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);
            //Interara na lista para adicionar no arquivo
            for (PlanoDeSaude p : planos) {
                bwTEMP.write(p.getPlanodesaudeSeparadoPorPontoEVirgula());
                bwTEMP.newLine();
            }
            //fechar arquivotemp
            bwTEMP.close();

            //excluirarquivo atual
            arquivoAtual.delete();
            
            //renomear arquivo TEMP
            arquivoTemp.renameTo(arquivoAtual);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao criar o arquivo!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static DefaultTableModel getTableModel() {

        // Matriz que receberá os planos de saúde
        // que serão utilizados na Tabela (JTable)
        Object[][] dados = new Object[planos.size()][3];

        // For Each, para extrair cada objeto plano de saúde do
        // arraylist planos e separar cada dado na matriz dados
        int i = 0;
        for (PlanoDeSaude p : planos) {
            dados[i][0] = p.getCodigo();
            dados[i][1] = p.getOperadora();
            dados[i][2] = p.getTipoDoPlano();
            i++;
        }

        // Definir um vetor com os nomes das colulas da tabela
        String[] titulos = {"Código", "Nome da operadora", "Tipo do plano"};

        // Criar o modelo que será utilizado pela JTable 
        // para exibir os dados dos planos
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);

        return tableModel;

    }
    public static void lerListaDePlanoDeSaude() {
        try {
            BufferedReader br = Files.newBufferedReader(PATH);

            String linha = br.readLine();

            while (linha != null && !linha.isEmpty()) {
                String[] linhaVetor = linha.split(";");
               PlanoDeSaude novoPlanodeSaude = new PlanoDeSaude(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2]);
                planos.add(novoPlanodeSaude);
                linha = br.readLine();

            }
            br.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro ao ler o arquivo", "Erro de leitura", JOptionPane.ERROR_MESSAGE);
        }

    }
    

}
