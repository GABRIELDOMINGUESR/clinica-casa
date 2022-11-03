package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.dao.EspecialdadaDAO;
import br.senai.sp.jandira.model.TipoOperacao;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class EspecialidadesPanel extends javax.swing.JPanel {

    int linha;

    public EspecialidadesPanel() {
        initComponents();
        criarTabelaEspecialidade();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEspecialidade = new javax.swing.JPanel();
        EspecialedadeText = new javax.swing.JLabel();
        scrollTableEspecialidade = new javax.swing.JScrollPane();
        tableEspecialidade = new javax.swing.JTable();
        buttonExcluirEspecialidade = new javax.swing.JButton();
        buttonAlterarEspecialiddade = new javax.swing.JButton();
        buttonAdicionarEspecialdade = new javax.swing.JButton();

        setLayout(null);

        jPanelEspecialidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelEspecialidade.setPreferredSize(new java.awt.Dimension(945, 370));
        jPanelEspecialidade.setLayout(null);

        EspecialedadeText.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        EspecialedadeText.setForeground(new java.awt.Color(102, 0, 102));
        EspecialedadeText.setText("Especialidade");
        jPanelEspecialidade.add(EspecialedadeText);
        EspecialedadeText.setBounds(20, 10, 180, 20);

        tableEspecialidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollTableEspecialidade.setViewportView(tableEspecialidade);

        jPanelEspecialidade.add(scrollTableEspecialidade);
        scrollTableEspecialidade.setBounds(20, 40, 905, 240);

        buttonExcluirEspecialidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/delete32-2.png"))); // NOI18N
        buttonExcluirEspecialidade.setToolTipText("Excluir Especialidade selecionado");
        buttonExcluirEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirEspecialidadeActionPerformed(evt);
            }
        });
        jPanelEspecialidade.add(buttonExcluirEspecialidade);
        buttonExcluirEspecialidade.setBounds(700, 294, 70, 60);

        buttonAlterarEspecialiddade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/edit32.png"))); // NOI18N
        buttonAlterarEspecialiddade.setToolTipText("Editar Especialidade selecionado");
        buttonAlterarEspecialiddade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarEspecialiddadeActionPerformed(evt);
            }
        });
        jPanelEspecialidade.add(buttonAlterarEspecialiddade);
        buttonAlterarEspecialiddade.setBounds(780, 294, 70, 60);

        buttonAdicionarEspecialdade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/add32.png"))); // NOI18N
        buttonAdicionarEspecialdade.setToolTipText("Adicionar Especialidade");
        buttonAdicionarEspecialdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarEspecialdadeActionPerformed(evt);
            }
        });
        jPanelEspecialidade.add(buttonAdicionarEspecialdade);
        buttonAdicionarEspecialdade.setBounds(860, 294, 70, 60);

        add(jPanelEspecialidade);
        jPanelEspecialidade.setBounds(0, 0, 945, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExcluirEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirEspecialidadeActionPerformed

        // Obtemos o índice da linha selecionada na tabela
        linha = tableEspecialidade.getSelectedRow();

        // Verificamos se a linha é diferente de -1
        // -1 significa que o usuário não selecionou nada
        if (linha != -1) {
            excluir();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione a especialidade  que você deseja excluir!",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_buttonExcluirEspecialidadeActionPerformed


    private void buttonAlterarEspecialiddadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarEspecialiddadeActionPerformed
        linha = tableEspecialidade.getSelectedRow();
        if (linha != -1) {
            editar();

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Porfavor, selecione a linha!!",
                    "Especialidade",
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_buttonAlterarEspecialiddadeActionPerformed

    private void editar() {
        Especialidade especialidade = EspecialdadaDAO.getEspecialidade(getCodigo());

        EspecialidadeDialog especialidadeDialog = new EspecialidadeDialog(
                null,
                true,
                TipoOperacao.ALTERAR,
                especialidade);

        especialidadeDialog.setVisible(true);

        criarTabelaEspecialidade();

    }

    private void excluir() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Você confirma a exclusão da Especialidade selecionada?",
                "Especialidade",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resposta == 0) {
            EspecialdadaDAO.excluir(getCodigo());
            criarTabelaEspecialidade();
        }

    }

    private Integer getCodigo() {
        String codigoStr = tableEspecialidade.getValueAt(linha, 0).toString();
        return Integer.valueOf(codigoStr);

    }


    private void buttonAdicionarEspecialdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarEspecialdadeActionPerformed

        EspecialidadeDialog especialidadeDialog = new EspecialidadeDialog(
                null,
                true,
                TipoOperacao.ADICIONAR,
                null);

        especialidadeDialog.setVisible(true);

        criarTabelaEspecialidade();
    }//GEN-LAST:event_buttonAdicionarEspecialdadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EspecialedadeText;
    private javax.swing.JButton buttonAdicionarEspecialdade;
    private javax.swing.JButton buttonAlterarEspecialiddade;
    private javax.swing.JButton buttonExcluirEspecialidade;
    private javax.swing.JPanel jPanelEspecialidade;
    private javax.swing.JScrollPane scrollTableEspecialidade;
    private javax.swing.JTable tableEspecialidade;
    // End of variables declaration//GEN-END:variables

    private void criarTabelaEspecialidade() {

        tableEspecialidade.setModel(EspecialdadaDAO.getTableModel());

        // Desativar o redimensionamento da JTable
        tableEspecialidade.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Definir a largura de cada coluna
        tableEspecialidade.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableEspecialidade.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableEspecialidade.getColumnModel().getColumn(2).setPreferredWidth(300);

        // Impedir/bloquear a movimentação das colunas
        tableEspecialidade.getTableHeader().setReorderingAllowed(false);

        // Bloquear edição das células
        tableEspecialidade.setDefaultEditor(Object.class, null);
    }

}
