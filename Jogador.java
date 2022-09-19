package jogo.da.velha;
public class Jogador {
    public String simbolo[] = {"X", "O"};
    public String nome;

    public String getNome(){
        return this.nome;
    }
    public void setNome(String n){
        this.nome = n;
    }

    public void jogada(int cont , int posicao , String array[]){
        if (cont%2 == 0){array[posicao - 1] = simbolo[0];}
        else {array[posicao - 1] = simbolo[1];}
    }
}
