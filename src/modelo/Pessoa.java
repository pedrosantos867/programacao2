package modelo;

import java.util.LinkedList;

public abstract class Pessoa extends Identificador {
    protected LinkedList<Aula> aulas;

    public Pessoa(String nome, long numero) {
        super(nome, numero);
        aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas(){
        return new LinkedList<>(aulas);
    }

    public LinkedList<Aula> getAulas(Horario horario) {

        LinkedList<Aula> aux = new LinkedList<>();

        for(Aula aula : aulas){
            if(aula.getHorario().isSobre(horario)){
                aux.add(aula);
            }
        }
        return aux;
    }

    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    public void remover(Aula aula) {
        if (!aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        desassociar(aula);
    }

    protected abstract void desassociar(Aula aula);

    protected abstract void associar(Aula aula);

    protected abstract void escreverSumario(Aula aula);

    protected void assinarSumario(Aula aula){
        aula.adicionarLinhaSumario(nome);
    }
}
