package jogo.da.velha;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class JogoDaVelha {
    
    public static Scanner   input               = new Scanner       (System.in);
    public static Tabuleiro t1                  = new Tabuleiro     ();
    public static Jogador   jogador1            = new Jogador       ();
    public static Jogador   jogador2            = new Jogador       ();
    public static Placar    p1                  = new Placar        ();
    public static ArrayList<String> jogadores   = new ArrayList<>   ();
    public static Random gerador                = new Random        ();
    
    public static int verificaOcupacao(String array[], int posicao, Boolean jogador){
        if (jogador == true){
            while (posicao < 0 || posicao > 9) {System.out.println("Informe a posição: ") ; posicao = input.nextInt();}
            
            while (array[posicao-1] != " "){
                System.out.println("Posição já ocupada. Informe outra posição: ");
                posicao = input.nextInt();
                while (posicao < 0 || posicao > 9) {System.out.println("Informe a posição: ") ; posicao = input.nextInt();}}
            
        } else {
            while (array[posicao-1] != " "){
                posicao = gerador.nextInt(8) + 1;
        }}
        
        return posicao;
    }
    
    public static int verificaVencedor(String array[], int verificador, int contador, String jogador1, String jogador2){

        if      (array[0] != " " && array[0] == array [1] && array[0] == array[2]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1; t1.resetaTabuleiro();}
        
        else if (array[3] != " " && array[3] == array [4] && array[3] == array[5]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1;t1.resetaTabuleiro();}
        
        else if (array[6] != " " && array[6] == array [7] && array[6] == array[8]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1;t1.resetaTabuleiro();}
        
        else if (array[0] != " " && array[0] == array [4] && array[0] == array[8]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1;t1.resetaTabuleiro();}
        
        else if (array[2] != " " && array[2] == array [4] && array[2] == array[6]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1;t1.resetaTabuleiro();}
        
        else if (array[0] != " " && array[0] == array [3] && array[0] == array[6]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1;t1.resetaTabuleiro();}
        
        else if (array[1] != " " && array[1] == array [4] && array[1] == array[7]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1;t1.resetaTabuleiro();}
        
        else if (array[2] != " " && array[2] == array [4] && array[2] == array[8]){   p1.acrescenta(contador) ; p1.printaPlacar(jogador1, jogador2) ; verificador = 1;t1.resetaTabuleiro();}
        
        else if (array[0] != " " && array[1] != " " && array[2] != " " && array[3] != " " && array[4] != " " && array[5] != " " && array[6] != " " && array[7] != " " && array[8] != " "){
                System.out.println("Deu velha!");
                p1.printaPlacar(jogador1, jogador2);
                t1.resetaTabuleiro();
                verificador = 1 ;}
        

        return verificador;}
    
    public static int continuar (int verificador){
        System.out.println("Deseja continuar?");
        System.out.print("Digite 1 para sim e 2 para não: ");
        
        int escolha = input.nextInt();
        
        if      (escolha == 1) {verificador = 0;}
        else if (escolha == 2) {verificador = 1;}
        else    {while (escolha != 1 || escolha != 2){
                    System.out.println("Escolha inválida. Digite 1 para sim e 2 para não: ");
                    escolha = input.nextInt();
                    if (escolha == 1 || escolha == 2){break;}}}

        if      (escolha == 1) {verificador = 0;}
        else if (escolha == 2) {verificador = 1;}

        return verificador;
    }
    
    public static void menu (){
        int escolha = -1 , contador = 0 , posicao , verificador = 0;
        p1.resetaPlacar();
        
        while (escolha < 0 || escolha > 3) {
            System.out.println  ("Menu: "                       );
            System.out.println  ("   1) Jogador vs Jogador"     );
            System.out.println  ("   2) Jogador vs IA nível 1"  );
            System.out.println  ("   3) Jogador vs IA nível 2"  );
            System.out.println  ("   4) Printar os jogadores"   );
            System.out.println  ("   5) Sair"                   );
            System.out.print    ("Escolha uma das opções: "     );
            escolha = input.nextInt();

            switch ( escolha ) {
                case 1 :System.out.print("Infome o nome do jogador1: ");
                        String var1 = input.next();
                        jogadores.add(var1);
                        jogador1.setNome(var1);
                        
                        System.out.print("Infome o nome do jogador2: ");
                        var1 = input.next();
                        jogadores.add(var1);
                        jogador2.setNome(var1);
                       
                        t1.printaTabuleiro();
                        
                        while (verificador == 0){
                            System.out.println("Informe a posição: ") ;
                            posicao = input.nextInt();
                            posicao = verificaOcupacao(t1.getTabuleiro(),posicao,true);
                            
                            jogador1.jogada(contador,posicao,t1.getTabuleiro());
                            
                            t1.printaTabuleiro();
                            verificador = verificaVencedor(t1.getTabuleiro(),verificador,contador,jogador1.getNome(),jogador2.getNome());
                            contador++;
                            if (verificador == 1){ verificador = continuar (verificador);  t1.printaTabuleiro() ; t1.resetaTabuleiro() ;}
                            if (verificador == 1){ menu() ; break ;}

                            
                            System.out.println("Informe a posição: ") ;
                            posicao = input.nextInt();
                            
                            posicao = verificaOcupacao(t1.getTabuleiro(),posicao,true);

                            jogador2.jogada(contador,posicao,t1.getTabuleiro());
                            t1.printaTabuleiro();
                            verificador = verificaVencedor(t1.getTabuleiro(),verificador,contador,jogador1.getNome(),jogador2.getNome());
                            contador++;
                            if (verificador == 1){ verificador = continuar (verificador) ; t1.printaTabuleiro() ; t1.resetaTabuleiro() ;}
                            if (verificador == 1){ menu(); break ;}
                        } break;
                    
                case 2 :System.out.print("Infome o nome do jogador: ");
                        var1 = input.next();
                        jogadores.add(var1);
                        jogador1.setNome(var1);
                        jogador2.setNome("BOT");
                        t1.printaTabuleiro();

                        while (verificador == 0){
                            System.out.println("Informe a posição: ") ; posicao = input.nextInt();
                            posicao = verificaOcupacao(t1.getTabuleiro(),posicao,true);

                            jogador1.jogada(contador,posicao,t1.getTabuleiro());
                            verificador = verificaVencedor(t1.getTabuleiro(),verificador,contador,jogador1.getNome(),jogador2.getNome());
                            contador++;
                            if (verificador == 1){ verificador = continuar (verificador);  t1.printaTabuleiro() ; t1.resetaTabuleiro() ;}
                            if (verificador == 1){ menu() ; break ;}

                            posicao = gerador.nextInt(8) + 1;
                            posicao = verificaOcupacao(t1.getTabuleiro(),posicao,false);
                            
                            System.out.println("O BOT jogou: " + posicao);
                            
                            jogador2.jogada(contador,posicao,t1.getTabuleiro());
                            t1.printaTabuleiro();
                            verificador = verificaVencedor(t1.getTabuleiro(),verificador,contador,jogador1.getNome(),jogador2.getNome());
                            contador++;
                            if (verificador == 1){ verificador = continuar (verificador) ; t1.printaTabuleiro() ; t1.resetaTabuleiro() ;}
                            if (verificador == 1){ menu(); contador = 0 ; break ;}
                        } break;

                case 3 : System.out.println("Em desenvolvimento"); break;

                case 4 : if (jogadores.size() < 1) { System.out.println("Não há jogadores."); menu();}
                         else { int i = 0 ; for (Object object: jogadores){System.out.print(" " + jogadores.get(i)); i++;}
                            System.out.print("\n") ; }break;
                         
                         
                case 5 : break;
            }
        }
    }

    public static void main (String[] args) { menu(); }}
