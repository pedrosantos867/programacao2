package modelo;

import java.util.LinkedList;

public class Professor extends Pessoa {


    public Professor(String nome, long numero){
        super(nome, numero);
    }

    @Override
    protected void desassociar(Aula aula) {
        aula.desassociarProfessor(this);
    }

    @Override
    protected void associar(Aula aula) {
        aula.setProfessor(this);
    }



    @Override
    protected void escreverSumario(Aula aula){
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(aula.getNumero() + "");
        assinarSumario(aula);
        for (Aluno aluno : aula.getAlunos()){
            aluno.preencherSumario(aula);
        }
    }


}
