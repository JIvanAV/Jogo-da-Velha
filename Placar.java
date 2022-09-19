package jogo.da.velha;
public class Placar {
    public int pontuacao1 = 0;
    public int pontuacao2 = 0;

    public int getPontuacao1() {
        return pontuacao1;
    }
    public void setPontuacao1(int pontuacao1) {
        this.pontuacao1 = pontuacao1;
    }

    public int getPontuacao2() {
        return pontuacao2;
    }
    public void setPontuacao2(int pontuacao2) {
        this.pontuacao2 = pontuacao2;
    }
    
    public void resetaPlacar(){
        this.pontuacao1 = 0 ;
        this.pontuacao2 = 0 ;
    }

    public void acrescenta(int num){
        if (num % 2 == 0){this.pontuacao1++;}
        else {this.pontuacao2++;}
    }
 
    public void printaPlacar (String jogador1, String jogador2){
        System.out.println("Placar:");
        System.out.println ("   " + jogador1 + ": " + this.pontuacao1 + " " + jogador2 + ": " + this.pontuacao2);
    }
}
