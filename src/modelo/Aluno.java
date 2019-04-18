package modelo;


public class Aluno extends Pessoa{


    public Aluno(String nome, long numero){
        super(nome, numero);
    }

    public void adicionar(Aula aula){
        if(aula == null || aulas.contains(aula)){
            return;
        }
        aulas.add(aula);
        aula.adicionar(this); //adiciona este aluno à lista de alunos da aula
    }

    public void remover(Aula aula){
        if(!aulas.contains(aula)){ //se a aula a remover não se encontra na lista de aulas do aluno
            return;
        }
        aulas.remove(aula);
        aula.remover(this);
    }

    @Override
    protected void desassociar(Aula aula) {
        aula.remover(this);
    }

    @Override
    protected void associar(Aula aula) {
    }

    @Override
    protected void escreverSumario(Aula aula) {
        assinarSumario(aula);
    }

    public void preencherSumario(Aula aula) {

    }
}
