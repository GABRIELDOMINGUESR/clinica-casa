package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.EspecialdadaDAO;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.TipoOperacao;
import java.awt.Label;
import javax.swing.JOptionPane;

public class EspecialidadeDialog extends javax.swing.JDialog {

    private TipoOperacao tipoOperacao;
    private Especialidade especialidade;

    public EspecialidadeDialog(
            java.awt.Frame parent,
            boolean modal,
            TipoOperacao tipoOperacao,
            Especialidade especialidade) {

        super(parent, modal);
        initComponents();
        this.tipoOperacao = tipoOperacao;
        this.especialidade = especialidade;

        // Preencher os campos, caso o tipo de operação for ALTERAR
        if (tipoOperacao == TipoOperacao.ALTERAR) {
            preencherFormulario();
        }

    }

    private void preencherFormulario() {
        jlabelTitulo.setText("Especialidade -" + tipoOperacao);
        jlabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/edit32.png")));
        textCodigo.setText(especialidade.getCodigo().toString());
        textNomeDaEspecialidade.setText(especialidade.getNome());
        textDescricao.setText(especialidade.getDescricao());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jEspecialidade = new javax.swing.JPanel();
        jlabelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        jLabelespecialidade = new javax.swing.JLabel();
        textNomeDaEspecialidade = new javax.swing.JTextField();
        jLabelDiscricacao = new javax.swing.JLabel();
        textDescricao = new javax.swing.JTextField();
        buttonCancelar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jEspecialidade.setBackground(new java.awt.Color(255, 255, 255));
        jEspecialidade.setLayout(null);

        jlabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jlabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/add32.png"))); // NOI18N
        jlabelTitulo.setText("Cadastro Especialidade - NOVO");
        jEspecialidade.add(jlabelTitulo);
        jlabelTitulo.setBounds(10, 10, 530, 30);

        getContentPane().add(jEspecialidade);
        jEspecialidade.setBounds(0, 0, 810, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes da Especialidade:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(153, 0, 51))); // NOI18N
        jPanel2.setLayout(null);

        jLabelCodigo.setText("Código:");
        jPanel2.add(jLabelCodigo);
        jLabelCodigo.setBounds(30, 50, 110, 16);

        textCodigo.setEditable(false);
        jPanel2.add(textCodigo);
        textCodigo.setBounds(30, 70, 71, 30);

        jLabelespecialidade.setText("Nome da Especialidade:");
        jPanel2.add(jLabelespecialidade);
        jLabelespecialidade.setBounds(30, 110, 230, 16);
        jPanel2.add(textNomeDaEspecialidade);
        textNomeDaEspecialidade.setBounds(30, 130, 500, 30);

        jLabelDiscricacao.setText("Descriação:");
        jPanel2.add(jLabelDiscricacao);
        jLabelDiscricacao.setBounds(30, 170, 230, 16);

        textDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescricaoActionPerformed(evt);
            }
        });
        jPanel2.add(textDescricao);
        textDescricao.setBounds(30, 190, 500, 30);

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/cancel32.png"))); // NOI18N
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCancelar);
        buttonCancelar.setBounds(370, 260, 80, 60);

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/imagens/save32.png"))); // NOI18N
        buttonSalvar.setToolTipText("Salvar Cadastro");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSalvar);
        buttonSalvar.setBounds(460, 260, 80, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 60, 560, 340);

        setBounds(500, 500, 599, 447);
    }// </editor-fold>//GEN-END:initComponents

    private void textDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescricaoActionPerformed
        
    }//GEN-LAST:event_textDescricaoActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed

        if (tipoOperacao == TipoOperacao.ADICIONAR) {
            gravar();

        } else {
            atualizar();
        }

    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
     dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void atualizar() {
        especialidade.setNome(textNomeDaEspecialidade.getText());
        especialidade.setDescricao(textDescricao.getText());
        if (validarCadastro()) {
            EspecialdadaDAO.atualizar(especialidade);

            JOptionPane.showMessageDialog(
                    null,
                    "Especialidade atualizada com sucesso!!",
                    "Especialidade",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }

    private void gravar() {
        // Criar um objeto Especialidade
        Especialidade especialidade = new Especialidade();
        especialidade.setNome(textNomeDaEspecialidade.getText());
        especialidade.setDescricao(textDescricao.getText());

        if (validarCadastro()) {
            EspecialdadaDAO.gravar(especialidade);
            JOptionPane.showMessageDialog(
                    this,
                    "Especialidade gravada com sucesso!!",
                    "Especialidade",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();

        }

    }

    private boolean validarCadastro() {
        if (textNomeDaEspecialidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o nome da Especialidade",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);

            textNomeDaEspecialidade.requestFocus();

            return false;

        }

        if (textDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha a Descrição!",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);

            textDescricao.requestFocus();
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JPanel jEspecialidade;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDiscricacao;
    private javax.swing.JLabel jLabelespecialidade;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlabelTitulo;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textNomeDaEspecialidade;
    // End of variables declaration//GEN-END:variables
}
