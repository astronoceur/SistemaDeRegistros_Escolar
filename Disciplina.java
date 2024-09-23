import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private String tema; 
    private Professor professores;
    private String horario;
    private ArrayList<Aluno> alunosMatriculados;
  
  // Constructor 
    public Disciplina (String nome, String tema, String horario, Professor professor){
        this.nome = nome;
        this.tema = tema;
        this.professores = professor;
        this.horario = horario;
        this.alunosMatriculados = new ArrayList<>();
    }
  
  // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public Professor getProfessor() {
        return professores;
    }
    public void setProfessor(Professor professor) {
        this.professores = professor;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }
    public void setAlunosMatriculados(ArrayList<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    // METODOS MATRICULA E DESMATRICULA

    public void Matricular (Aluno idAliuno, Disciplina nomeDisciplina){
        alunosMatriculados.add(idAliuno);
        System.out.println("Você está matriculado em" + nomeDisciplina.nome);
        }

    public void Desmatricular(Aluno idAliuno, Disciplina nomeDisciplina){
        alunosMatriculados.remove(idAliuno);
        System.out.println("Você está desmatriculado em" + nomeDisciplina.nome);
    }
    
    public void ImprimirLista(Disciplina nomeDisciplina){
        System.out.println("\n----- TURMA DA DISCIPLINA - "+ nome +" -----\n" + alunosMatriculados);
    }

    // REMOVER PROFESSOR
    
    public void removeProfessor() {
        this.professores = null;
    }

    @Override
    public String toString(){
        return "\n-------FICHA DISCIPLINAS-------" + "\n" +
                     "Nome:" + nome + "\n" +
                     "Descrição da matéria:" + tema + "\n" + 
                     "Horario:" + horario + "\n" +
                     "Professor:" + professores.getNome() + "\n";
    }
  }