public class CartaoId {
    private String Id;
    private Aluno alunoId;

  
// Constructor 
   public CartaoId (String Id){
        this.Id = Id;
    }
  
// Getters and Setters

    public void setId(String Id) {
        this.Id = Id;
    }
    public String getId() {
        return Id;
    }
    public void setAlunoId(Aluno alunoId){
        this.alunoId = alunoId;
    }
    public Aluno getAlunoId(){
        return alunoId;
    }
    
}