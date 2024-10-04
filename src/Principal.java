import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
     Converte converte = new Converte();
     int opcoes = 0;
     String[] moedas = {"BRL","USD","EUR","GBP","ARS","CAD"};
     Scanner leia = new Scanner(System.in);

     do {
         int opMoeda = 0;
         System.out.println("### -Conversor de moedas- ###");
         System.out.println("-- Escolha uma opcao: ");
         System.out.println(" 0) Mudar moeda Base"+" ["+converte.getBase_moeda()+"]");
         System.out.println(" 1) Mudar moeda alvo"+" ["+converte.getConverte_moeda()+"]");
         System.out.println(" 2) Converter ["+converte.getBase_moeda()+"] => ["+converte.getConverte_moeda()+"]");
         System.out.println(" 3) Para sair");
         opcoes = leia.nextInt();
         switch (opcoes){
             case 0:
                 System.out.println("### Moeda base ###");
                 menuMoedas(moedas);
                 opMoeda = leia.nextInt();
                 contarMoeda(opMoeda, moedas, converte, 1);
                 break;

             case 1:
                 System.out.println("### Moeda alvo ###");
                 menuMoedas(moedas);
                 opMoeda = leia.nextInt();
                 contarMoeda(opMoeda, moedas, converte, 2);
                 break;
             case 2:
                     System.out.println("Digite uma valor para converter para " + converte.getConverte_moeda() + ": ");
                     double valor = leia.nextDouble();
                     System.out.println("###############");
                     System.out.println(valor + " [" + converte.getBase_moeda() + "] equivalem " + converte.converter(valor)+" ["+converte.getConverte_moeda()+"]");
                     System.out.println("###############");
                     break;
         }
     }while(opcoes != 3);
    }


    public static void menuMoedas(String[] moedas){
        System.out.println("Escolha um numero: ");
        for (int i = 0; i < moedas.length; i++) {
            System.out.println(i+") "+moedas[i]);
        }
    }
    public static void contarMoeda(int opMoeda, String[]moedas, Converte converte, int op){
        if (opMoeda >= moedas.length){
            System.out.println("Moeda invalida!");
        }else {
            switch (op) {
                case 1:
                    converte.setBase_moeda(moedas[opMoeda]);
                    System.out.println("Moeda selecionada: " + converte.getBase_moeda());
                    break;
                case 2:
                    converte.setConverte_moeda(moedas[opMoeda]);
                    System.out.println("Moeda selecionada: " + converte.getConverte_moeda());
                    break;
            }
        }
    }
}
