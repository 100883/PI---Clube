/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classededados;

/**
 *
 * @author Aluno
 */
public class Dependente {

    //Atributos
    private String nome;
    private int telefone;
    private int CPF;

    //Metodos
    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public int getCPF() {
        return CPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

}
