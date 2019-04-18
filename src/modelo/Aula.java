package modelo;

import java.util.LinkedList;

public class Aula extends Identificador{
    private String sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;
    private Horario horario;

    //construtor
    public Aula(String nome, long numero, Horario horario){
        this(nome, numero,  horario, null, new LinkedList<Aluno>());
    }

    //construtor
    public Aula(String nome, long numero, Horario horario, Professor professor, LinkedList<Aluno> alunos){
        super(nome, numero);
        this.sumario = "";
        setProfessor(professor);
        this.alunos = new LinkedList<>();
        for (Aluno aluno : alunos){
            adicionar(aluno);
        }
        this.horario = horario;
    }

    public void setProfessor(Professor professor) {
        if (professor == null || this.professor == professor) { //se o professor recebido é nulo ou professor recebido já é o professor associado à aula
            return;
        }
        if (this.professor != null) {              // Se a aula já tem professor atribuido
            this.professor.remover(this);    //vamos remover-lo
        }
        this.professor = professor;//1            //e adicionar o novo professor recebido por parâmetro
        this.professor.adicionar(this);//2  //Adicionar esta aula à lista de aulas do professor
    }

    public void desassociarProfessor() {
        if (professor == null) {                 //Se o professor a desassociar for nulo
            return;
        }
        Professor professorARemover = professor; //variavel auxiliar para guardar o professor a eliminar
        professor = null;                        //Apaga a referência
        professorARemover.remover(this);    //Remove esta aula da lista de aulas do professor
    }

    public Professor getProfessor(){
        return professor;
    }

    public String getSumario(){
        return sumario;
    }

    public Horario getHorario(){
        return horario;
    }

    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos); //utiliza por base a lista ligada alunos (replicação)
    }

    public void adicionar(Aluno aluno) {
        if (aluno == null || alunos.contains(aluno)) { //se o aluno é inválido ou se já está adicionado
            return;
        }
        alunos.add(aluno);
        aluno.adicionar(this); //adiciona esta aula à lista de aulas do aluno
    }

    public void remover(Aluno aluno){
        if(!alunos.contains(aluno)){
            return;
        }
        alunos.remove(aluno);
        aluno.remover(this);

    }

    public void adicionarLinhaSumario(String linha){
        StringBuilder sb = new StringBuilder(sumario);
        sb.append(linha).append("\n");
        sumario = sb.toString();
    }


    public void desassociarProfessor(Professor professor) {
        if(professor == null || this.professor != professor){
            return;
        }
    }
}
