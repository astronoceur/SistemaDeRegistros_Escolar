import java.util.ArrayList;

public class Professor {
    private String nome;
    private String formacao;
    private String contato;
    private ArrayList<Disciplina> listadisciplina;
  
  // Constructor 
    public Professor(String nome, String formacao, String contato) {
        this.nome = nome;
        this.formacao = formacao;
        this.contato = contato;
        this.listadisciplina = new ArrayList<>();
    }
  
  // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFormacao() {
        return formacao;
    }
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    public ArrayList<Disciplina> getDisciplina() {
        return listadisciplina;
    }
    public void setDisciplina(ArrayList<Disciplina> disciplina) {
        this.listadisciplina = disciplina;
    }

// Vincular disciplina ao professsor
    public void addDisciplina(Disciplina disciplina) {
        listadisciplina.add(disciplina);
    }

    public void removeDisciplina(Disciplina disciplina) {
        listadisciplina.remove(disciplina);
    }

    
    @Override
    public String toString(){
        return "\n" + "---FICHA PROFESSOR---" + "\n" + "Nome:" + nome + "\n" + "Formacao:" + formacao+ "\n" + "Contato:" + contato;
    }

  }