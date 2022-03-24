package entities;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Turma {

    //#region Constantes
    private static final int MAX_ALUNOS = 20;
    private static final int SEMESTRE_LETIVO = 20;
    //#endregion

    //#region Atributos
    /*
    * Nível - a partir de 1.
    * Dia - domingo sendo 1, Segunda 2 ...
    * Turno - mManhã 1, tarde 2, noite 3.
    * */
    private int nivel;
    private int dia;
    private int turno;
    private int codigoTurma;
    private List<Aluno> listaDaTurma = new ArrayList<>();
    //#endregion

    //#region Construtores

    public Turma(int nivel, int dia, int turno) {
        this.nivel = nivel;
        this.dia = dia;
        this.turno = turno;
        this.codigoTurma = geraCodigoTurma();
    }

    //#endregion

    //#region Getter e Setter

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
        this.codigoTurma = geraCodigoTurma();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
        this.codigoTurma = geraCodigoTurma();
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
        this.codigoTurma = geraCodigoTurma();
    }

    public int getCodigoTurma() {
        return geraCodigoTurma();
    }

    /**
     * Para receber um aluno de uma determinada posição na lista
     * @param indice do aluno na lista (início é 0)
     * @return aluno da Lista
     */
    public Aluno getAlunoPosicaoLista(int indice){
        Aluno aux = null;
        if(!listaVazia() && indice < listaDaTurma.size()){
            aux = listaDaTurma.get(indice);
        }
        return aux;
    }

    public int getTamanhoLista(){
        return listaDaTurma.size();
    }

    //#endregion

    //#region Métodos Públicos
    public void adicionarAluno(Aluno aluno){
        if(alunoNaoEstaNaTurma(aluno) && !listaCheia()){
            aluno.setCodTurma(this.codigoTurma);
            listaDaTurma.add(aluno);
        }
    }

    @Override
    public String toString(){
        /*
        * relatório em ordem alfabética dos alunos, como nome,
        * nota e estado da aprovação
        * */
        return "fazer esse";
    }

    public int mediaNotasTurma() {
        int media = 0;
        int soma = 0;
        if(!listaVazia()){
            for (int i = 0; i < listaDaTurma.size(); i++)
                soma += getAlunoPosicaoLista(i).getNotaTotal();
            media = soma / listaDaTurma.size();
        } else{
            media = 0;
        }
        return media;
    }

    public int mediaFrequenciaTurma() {
        int media = 0;
        int soma = 0;
        if(!listaVazia()){
            for (int i = 0; i < listaDaTurma.size(); i++)
                soma += getAlunoPosicaoLista(i).getFrequencia();
            media = soma / listaDaTurma.size();
        } else{
            media = 0;
        }
        return media;
    }

    //#region Aluno com melhor Desempenho
    /**
     * Verifica o aluno com melhor desempenho
     * Combinação de nota (peso 80%) e frequência (peso 20%)
     * @return retorna o toString do Aluno com melhor desempenho
     */
    public String melhorDesempenho(){
        if(!listaVazia()){
            int indice = 0;
            double desempenho = calcularDesempenho(listaDaTurma.get(indice));
            if(listaDaTurma.size() > 1){
                for(int i = 1; i < listaDaTurma.size(); i++){
                    double atual = calcularDesempenho(listaDaTurma.get(i));
                    if(desempenho < atual){
                        indice = i;
                        desempenho = atual;
                    }
                }
            }
            return listaDaTurma.get(indice).toString();
        } else {
            return "Lista Vazia";
        }
    }
    //#endregion

    //#region Diário Final
    /**
     * Relatório em ordem alfabética dos alunos,
     * com nome, nota e estado de aprovação
     */
    public void diarioFinal(){
        if(!listaVazia()){
            if(listaDaTurma.size() > 1){
                Comparator<? super E> comparator = ;
                listaDaTurma.sort(comparator);
                
//                Aluno[] alunosArray = new Aluno[listaDaTurma.size()];
//                for(int i = 0; i < listaDaTurma.size(); i++)
//                    alunosArray[i] = listaDaTurma.get(i);
//                listaDaTurma.sort();

            } else {
                impressaoDiarioFinal(listaDaTurma.get(0));
            }
        }
    }
    //#endregion
    //#endregion

    //#region Métodos Privados
    private int geraCodigoTurma(){
        String aux = ""+this.nivel + this.dia + this.turno;
        return Integer.parseInt(aux);
    }

    private boolean alunoNaoEstaNaTurma(Aluno aluno) {
        boolean retorno = true;
        if(!listaVazia()){
                for(int i = 0; i< listaDaTurma.size(); i++){
                    if(listaDaTurma.get(i).getNome() == aluno.getNome()){
                        retorno = false;
                        i = listaDaTurma.size();
                    }
                }
        }
        return retorno;
    }

    private boolean listaVazia(){
        if (listaDaTurma.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean listaCheia() {
        if(listaDaTurma.size() >= 20){
            return true;
        } else{
            return  false;
        }
    }

    private double calcularDesempenho(@NotNull Aluno aluno) {
        /*
        * Nota (peso 80%) e frequência (peso 20%)
        * */
        return (aluno.getNotaTotal()*0.8)+(aluno.getFrequencia()*0.2);

    }

    /**
     * Impressão conforme o Diário Final.
     * Imprime nome, nota e estado da aprovação.
     * @param aluno base para impressão.
     */
    private void impressaoDiarioFinal(@NotNull Aluno aluno) {
        System.out.println(aluno.getNome());
        System.out.println(aluno.getNotaTotal());
        if (aluno.estadoDeAprovacao())
            System.out.println("Aprovado");
        else
            System.out.println("Reprovado");
    }
    //#endregion
}
