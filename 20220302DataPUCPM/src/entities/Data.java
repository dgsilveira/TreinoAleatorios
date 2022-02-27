package entities;

/**
 * Classe Comida: POO básica
 * Usando: encapsulamento, construtores, static.
 * <p>
 * Sem utilizar ferramentas de data e hora da linguagem
 * de programação, modele e implemente uma classe que
 * permita ao usuário criar e fazer as operações com datas:
 * <p>
 *  Só podemos criar datas válidas.
 *  Adicionar dias a uma data, criando uma nova data.
 *  Verificar, entre duas datas, qual é a mais futura.
 *  Imprimir a data no formato DD/MM/AAAA.
 */
public class Data {

    private static final int max_dia = 31;
    private static final int max_mes = 12;

    int dia;
    int mes;
    int ano;

    /*
     * método cria data se for válida
     * do contrário dia 01/01/01
     * (primeiro dia, primeiro mês, primeiro ano)
     * */
    public Data(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        }

    }

    public boolean validarData(int dia, int mes, int ano) {

        if ((dia >= 1 && dia <= max_dia) && (mes >= 1 && mes <= max_mes) && ano >= 1) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                return true;
            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30) {
                return true;
            } else {
                /*
                * Mes de fevereiro
                * Para ser bissexto temos 2 casos:
                * Caso 1 - ano divisível por 4, por 100 e por 400.
                * Caso 2 - ano divisível por 4 e não é por 100.
                * Demais fevereiros não são bissextos
                * */

                if (ano % 4 == 0) {
                    if (ano % 100 == 0) {
                        if (ano % 400 == 0) {
                            return true;
                        }
                    } else if (ano % 100 != 0) {
                        return true;
                    }
                } else {
                    if(dia <= 28){
                        return true;
                    }
                }
            }
        } else {
            return false;
        }

        return false;
    }
}
