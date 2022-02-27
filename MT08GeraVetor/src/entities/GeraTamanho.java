package entities;

import java.util.Random;

public class GeraTamanho {
    private int tamanho;

    public GeraTamanho() {
        tamanho = geraTamanho();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    private int geraTamanho() {

        Random rand;
        rand = new Random();

        int min = Math.abs(rand.nextInt()) + 2;
        int max;
        do max = Math.abs(rand.nextInt()); while (max < min + 2);

        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    public String toString() {
        return "GeraTamanho{" +
                "tamanho=" + tamanho +
                '}';
    }
}
