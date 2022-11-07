package br.senai.sp.jandira.model;

import java.util.ArrayList;

public class Medico extends Pessoa {

    private String crm;
    private ArrayList<Especialidade> especialidades;

    
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

}
