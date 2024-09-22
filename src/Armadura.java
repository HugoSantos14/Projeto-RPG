 class Armadura {
     private int ConstDefesa;
     private int redAgilidade;

     public Armadura(int constDefesa, int redAgilidade) {
         this.ConstDefesa = constDefesa;
         this.redAgilidade = redAgilidade;
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
