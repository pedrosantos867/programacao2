package modelo;

import java.util.LinkedList;

public class Sala {
    String nome;
    LinkedList<Aula> aulas;
    boolean estadoPorta;

    Sala(String nome, boolean estadoPorta){
        this.nome = nome;
        this.estadoPorta = estadoPorta;
    }

    public LinkedList<Aula> getAulas(Horario){

    }



    public String getNome() {
        return nome;
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    public boolean isEstadoPorta() {
        return estadoPorta;
    }



}
