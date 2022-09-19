package jogo.da.velha;

public class Tabuleiro {
    public String tabuleiro[] = {" "," "," "," "," "," "," "," "," "};
    
    public void printaTabuleiro() {
	for (int i = 0 ; i < tabuleiro.length ; i++) {
                if (i == 0 || i == 3 || i ==6){System.out.print("|");}
		System.out.print(tabuleiro[i] + "|");
		if ((i+1)%3 == 0) {System.out.print("\n");} } }
    
    public void resetaTabuleiro() {
	for (int i = 0 ; i < tabuleiro.length ; i++) {
            tabuleiro[i] = " ";}}
    
    public String[] getTabuleiro() {
        return tabuleiro;
    }
    public void setTabuleiro(String[] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
