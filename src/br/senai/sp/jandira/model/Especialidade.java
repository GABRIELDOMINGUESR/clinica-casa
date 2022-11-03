package br.senai.sp.jandira.model;

public class Especialidade {

    private static int contador = 100;
    private Integer codigo;
    private String nome;
    private String descricao;

//        construtores
     public Especialidade(String nome) {
        this.nome = nome;
        atualizarCodigo();
    }
    
    public Especialidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.contador = this.codigo;
        atualizarCodigo();
    }

    private void atualizarCodigo() {
        contador++;
        this.codigo = contador;
    }

    public Especialidade() {
        atualizarCodigo();
    }

    // Métodos de acesso getters and setters
    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getContador() {
        return contador;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getEspecialideSeparadoPorPontoEVirgula() {
        String planoDeSaudeStr = this.codigo + ";" + this.nome + ";" + this.descricao;
        return planoDeSaudeStr;
    }

    public Especialidade(Integer codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        contador++;

    }

}
