package br.senai.sp.jandira.dao;

import java.util.ArrayList;
import br.senai.sp.jandira.model.Especialidade;
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

public class EspecialdadaDAO { // Simular nosso banco de dados

    private Especialidade especialidade;
    private static ArrayList<Especialidade> especialidades = new ArrayList<>();

    private static final String ARQUIVO = "C:\\Users\\22283347\\java\\Especialidade.txt";
    private static final String ARQUIVO_TEMP = "C:\\Users\\22283347\\java\\EspecialidadeTemp.txt";
    private static final Path PATH = Paths.get(ARQUIVO);
    private static final Path PATH_TEMP = Paths.get(ARQUIVO_TEMP);

    public EspecialdadaDAO(Especialidade especialidade) {
        this.especialidades.add(especialidade);
    }

    // Gravar a especialidade em um arquivo .txt
    public EspecialdadaDAO() {

    }

    public static void gravar(Especialidade especialidade) {
        especialidades.add(especialidade);
        try {
            //GRAVAR PLANO DE SAUDE EM ARQUIVO
            BufferedWriter bw = Files.newBufferedWriter(
                    PATH,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            String novoplanodeSaude = especialidade.getEspecialideSeparadoPorPontoEVirgula();

            bw.write(novoplanodeSaude);
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Houve um problema au abrir o arquivo", "Erro ao gravar", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static boolean excluir(Integer codigo) {
        for (Especialidade e : especialidades) {
            if (e.getCodigo().equals(codigo)) {
                especialidades.remove(e);
                break;
            }
        }
        //reconstruir arquivo atulizado sem o plano removido

        // Passo 01 Criar representação dos arquivos
        File arquivoAtual = new File(ARQUIVO);
        File arquivoTemp = new File(ARQUIVO_TEMP);

        try {

            arquivoTemp.createNewFile();

            BufferedWriter bwTEMP = Files.newBufferedWriter(
                    PATH_TEMP,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            for (Especialidade e : especialidades) {
                bwTEMP.write(e.getEspecialideSeparadoPorPontoEVirgula());
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

        return false;
    }

    public static Especialidade getEspecialidade(Integer codigo) {

        for (Especialidade e : especialidades) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }

    public static void atualizar(Especialidade especialidade) {
        for (Especialidade e : especialidades) {
            if (e.getCodigo().equals(especialidade.getCodigo())) {
                especialidades.set(especialidades.indexOf(e), especialidade);
                break;
            }
        }
    }

    public static ArrayList<Especialidade> listarTodos() {
        return especialidades;
    }

    public static void gravarEspecialidade(Especialidade especialidade) {
        especialidades.add(especialidade);
        try {
            //GRAVAR PLANO DE SAUDE EM ARQUIVO
            BufferedWriter bw = Files.newBufferedWriter(
                    PATH,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            String novoplanodeSaude = especialidade.getEspecialideSeparadoPorPontoEVirgula();

            bw.write(novoplanodeSaude);
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Houve um problema au abrir o arquivo", "Erro ao gravar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static DefaultTableModel getTableModel() {
        // Matriz que receberá os planos de saúde
        // que serão utilizados na Tabela (JTable)
        Object[][] dados = new Object[especialidades.size()][3];
        // For Each, para extrair cada objeto plano de saúde do
        // arraylist planos e separar cada dado na matriz dados
        int i = 0;
        for (Especialidade e : especialidades) {
            dados[i][0] = e.getCodigo();
            dados[i][1] = e.getNome();
            dados[i][2] = e.getDescricao();
            i++;
        }
        // Definir um vetor com os nomes das colulas da tabela
        String[] titulos = {"Código", "Especialidade", "Descrição"};
        // Criar o modelo que será utilizado pela JTable 
        // para exibir os dados dos planos
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);

        return tableModel;
    }

    public static void lerListaDeEspecialidade() {
        try {
            BufferedReader br = Files.newBufferedReader(PATH);

            String linha = br.readLine();

            while (linha != null && !linha.isEmpty()) {
                String[] linhaVetor = linha.split(";");
                Especialidade novoPlanodeSaude = new Especialidade(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2]);
                especialidades.add(novoPlanodeSaude);
                linha = br.readLine();

            }
            br.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro ao ler o arquivo", "Erro de leitura", JOptionPane.ERROR_MESSAGE);
        }

    }
}
