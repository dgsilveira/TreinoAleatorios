package program;

import entities.GeraTamanho;

public class Program {
    public static void main(String[] args) {
        System.out.println("Será criado um vetor com tamanho aleatório");
        System.out.println();
        int[] vetor = criaVetor();

        preencheImprimeVetor(vetor);
    }

    private static void preencheImprimeVetor(int[] vetor) {
        System.out.println("Conteúdo do vetor:");
       for(int i = 0; i < vetor.length; i++){
           vetor[i] = i+1;
           System.out.println(vetor[i]);
       }
    }

    private static int[]  criaVetor() {
        GeraTamanho gera = new GeraTamanho();
        int[] vetor;
        if(gera.getTamanho() <= 30)
            vetor = new int[gera.getTamanho()];

        else{
            vetor = new int[30];
            System.out.print("O tamanho aleatório criado foi: "+ gera.getTamanho() + ".\n");
            System.out.println("Para evitar uso desnecessário da memória o vetor foi criado com tamanho 30");
        }
        return vetor;
    }
}
