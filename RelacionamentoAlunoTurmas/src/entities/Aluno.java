package entities;

import java.util.Arrays;

public class Aluno {
    //#region Atributos
    private String nome;
    private final int[] notaProva;
    private int faltas;
    private int codTurma;
    //#endregion

    //region Construtores
    public Aluno(String nome){
        this.nome = nome;
        this.notaProva = new int[4];
    }
    //endregion

    //region Getter e Setter
    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public int getNotaTotal() {
        int notaTotal = 0;
        for(int nota: this.notaProva){
            notaTotal+= nota;
        }
        return notaTotal;
    }

    /**
     * Para receber a nota de uma avaliação específica.
     * @param provaNum Valor de 1 a 4
     * @return Valor da nota solicitada
     */
    public int getNotaProva(int provaNum) {
        if(provaNum > 0 && provaNum < 5){return this.notaProva[provaNum-1];}
        else return 0;
    }

    /**
     * Para editar a nota de uma avaliação específica.
     * @param provaNum Valor de 1 a 4
     * @param nota Valor da nota
     */
    public void setNotaProva(int provaNum, int nota) {
        if(provaNum > 0 && provaNum <5)
            if((nota >= 0) && (nota <= 25))
                this.notaProva[provaNum-1] = nota;
    }

    public int getFaltas() {
        return faltas;
    }

    public void addFaltas() {
        if(this.faltas <20)
            this.faltas++;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public int getFrequencia(){
        return calculaFrequencia();
    }
    //endregion

    //region Métodos

    /**
     * Verifica se o aluno foi aprovado.
     * Condições: Mínimo 75% de frequência e mínimo 60 pontos.
     * @return true se aprovado ou false se reprovado.
     */
    public boolean estadoDeAprovacao(){
        //Um aluno será aprovado se conseguir no mínimo 60 pontos e 75% de frequência às aulas.
        if ((calculaFrequencia() >= 75) && (this.getNotaTotal() >= 60)) {
            return true;
        } else {
            return false;
        }
    }

    private int calculaFrequencia() {
        return 100 - ((100 * this.faltas) / 20);
    }

    @Override
    public String toString() {
        return "Aluno: " + nome +
                "\nNotas Provas = " + Arrays.toString(notaProva) +
                "\nNota Total: " + getNotaTotal() +
                "\nFaltas: " + faltas +
                "\nFrequência: " + getFrequencia() + "%" +
                "\nCódigo Turma: " + codTurma;
    }

    //endregion
}
