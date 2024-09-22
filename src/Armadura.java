 class Armadura {
    private String nome;
     private int ConstDefesa;
     private int redAgilidade;

     public Armadura(int constDefesa, String nome, int redAgilidade) {
         this.ConstDefesa = constDefesa;
         this.nome = nome;
         this.redAgilidade = redAgilidade;
     }

     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public int getConstDefesa() {
         return ConstDefesa;
     }

     public void setConstDefesa(int constDefesa) {
         ConstDefesa = constDefesa;
     }

     public int getRedAgilidade() {
         return redAgilidade;
     }

     public void setRedAgilidade(int redAgilidade) {
         this.redAgilidade = redAgilidade;
     }
 }
