import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int idade;
    private String CEP;
    private String contato;
    private CartaoId cartaoId;
    private ArrayList<Disciplina> listadisciplina;

// Constructor 
    public Aluno (String nome, int idade, String CEP, String contato, CartaoId cartaoId){
        this.nome = nome;
        this.idade = idade;
        this.CEP = CEP;
        this.contato = contato;
        this.cartaoId = cartaoId;
        this.listadisciplina = new ArrayList<>();
    }

// Getters and Setters
      public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCEP() {
        return CEP;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    public String getCartaoId() {
        return cartaoId.getId();
    }
    public void setCartaoId(CartaoId cartaoId) {
        this.cartaoId = cartaoId;
    }
    public ArrayList<Disciplina> getDisciplina() {
        return listadisciplina;
    }
    public void setDisciplina(ArrayList<Disciplina> disciplina) {
        this.listadisciplina = disciplina;
    }

// ADICIONAR DISCIPLINAS AO ALUNO
    public void addDisciplina(Disciplina disciplina) {
        this.listadisciplina.add(disciplina);
    }
    public void removeDisciplina(Disciplina disciplina) {
        this.listadisciplina.remove(disciplina);
    }    
    public void ImprimirDisciplinasdoAluno(){
        System.out.println("\n------ DISCIPLINA MATRICULADAS -------" + listadisciplina);
    }

// REMOVE CARTAO ID DO ALUNO
    public void removeCartaoId(CartaoId CartaoId) {
        this.cartaoId = null;
    }    

// FICHA DO ESTUDANTE (toString)

    @Override
    public String toString(){
        return "\n" + "---FICHA ESTUDANTE---" + "\n" + "Nome Estudante:" + nome + "\n" + "ID do Estudante:" + cartaoId.getId() + "\n" ;
    }

}