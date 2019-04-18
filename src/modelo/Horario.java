package modelo;

public class Horario {
    private DiaSemana diaSemana;
    private int horaInicio;
    private int duracao;

    //construtor
    public Horario(DiaSemana diaSemana, int horaInicio, int duracao){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    //getters & setters
    public DiaSemana getDiaSemana(){
        return diaSemana;
    }

    public int getHoraInicio(){
        return horaInicio;
    }

    public int getDuracao(){
        return duracao;
    }

    public boolean isSobre(Horario horario){
        int horaInicioAula = horaInicio;
        int horaFimAula = horaInicioAula + duracao;
        int inicioPeriodoA = horario.getHoraInicio();
        int fimPeriodoA = horario.getHoraInicio() + horario.getDuracao();

        return diaSemana == horario.getDiaSemana() && fimPeriodoA >= horaInicioAula && horaFimAula >= inicioPeriodoA;
    }

}
