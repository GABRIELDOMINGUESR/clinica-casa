package br.senai.sp.jandira.dao;

import java.util.ArrayList;
import br.senai.sp.jandira.model.Especialidade;
import javax.swing.table.DefaultTableModel;

public class EspecialdadaDAO { // Simular nosso banco de dados

    private Especialidade especialidade;
    private static ArrayList<Especialidade> especialidades = new ArrayList<>();

    public EspecialdadaDAO(Especialidade especialidade) {
        this.especialidades.add(especialidade);
    }

    public EspecialdadaDAO() {

    }

    public static void gravar(Especialidade especialidade) {
        especialidades.add(especialidade);
    }

    public static boolean excluir(Integer codigo) {
        for (Especialidade e : especialidades) {
            if (e.getCodigo().equals(codigo)) {
                especialidades.remove(e);
                return true;
            }
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

    public static void crriarEspecialidadesTeste() {
        Especialidade e1 = new Especialidade("Cardiologia", "Trata do coração");
        Especialidade e2 = new Especialidade("Pediatra", "Especializado em Crianças");
        Especialidade e3 = new Especialidade("Terapeuta", "Aucilia no tratamento da Mente");
        Especialidade e4 = new Especialidade("Ortopedista", "Ajuda narecuoeração Ossea e muscular");
        Especialidade e5 = new Especialidade("Otorrinolaringologista", "Cuida do ouvido,naris e da garganta");

        especialidades.add(e1);
        especialidades.add(e2);
        especialidades.add(e3);
        especialidades.add(e4);
        especialidades.add(e5);
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

}
