package entities.test;

import entities.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    //#region Preparação para Testes
    Aluno aluno;

    @BeforeEach
    public void init(){
        aluno = new Aluno("Douglas");
    }
    //#endregion

    //#region Teste Criar Aluno
    @Test
    public void criarAluno(){
        assertEquals("Douglas", aluno.getNome());
    }
    //endregion

    //#region Teste Editar Notas das 4 Provas limitadas a 25 pontos
    @Test
    public void notaLimite25porProva(){
        aluno.setNotaProva(1,26);
        assertEquals(0,aluno.getNotaProva(1));
        aluno.setNotaProva(2,26);
        assertEquals(0,aluno.getNotaProva(1));
        aluno.setNotaProva(3,26);
        assertEquals(0,aluno.getNotaProva(1));
        aluno.setNotaProva(4,26);
        assertEquals(0,aluno.getNotaProva(1));
    }

    @Test
    public void receberEEditarNotaDasProvas(){
        assertEquals(0,aluno.getNotaTotal());
        aluno.setNotaProva(1,5);
        aluno.setNotaProva(2,10);
        aluno.setNotaProva(3,15);
        aluno.setNotaProva(4,20);
        assertEquals(5, aluno.getNotaProva(1));
        assertEquals(10, aluno.getNotaProva(2));
        assertEquals(15, aluno.getNotaProva(3));
        assertEquals(20, aluno.getNotaProva(4));
        assertEquals(50, aluno.getNotaTotal());
    }

    @Test
    public void receberQuantidadeEAdicionarFaltas(){
        assertEquals(0,aluno.getFaltas());
        aluno.addFaltas();//incrementado 1 falta
        assertEquals(1,aluno.getFaltas());
        for(int i = 0; i < 4; i++)
            aluno.addFaltas();
        assertEquals(5,aluno.getFaltas());
        for(int i = 0; i < 20; i++)
            aluno.addFaltas();
        assertEquals(20,aluno.getFaltas());
    }
    //#endregion

    //region Teste Estado de Aprovação
    /*
    * Teste para o método estadoDeAprovacao() e suas dependências
    * Testes se Aluno for aprovado e reprovado
    * */
    @Test
    public void estadoAprovado(){
        aluno.setNotaProva(1,25);
        aluno.setNotaProva(2,25);
        aluno.setNotaProva(3,60);
        assertEquals(true, aluno.estadoDeAprovacao());
        aluno.setNotaProva(4,25);
        assertEquals(true, aluno.estadoDeAprovacao());
        for(int i = 0; i < 5; i++)
            aluno.addFaltas();
        assertEquals(true, aluno.estadoDeAprovacao());
    }

    @Test
    public void estadoReprovado(){
        assertEquals(false, aluno.estadoDeAprovacao());
        aluno.setNotaProva(1,20);
        aluno.setNotaProva(2,20);
        aluno.setNotaProva(3,19);
        assertEquals(false, aluno.estadoDeAprovacao());
        for(int i = 0; i < 6; i++)
            aluno.addFaltas();
        assertEquals(false, aluno.estadoDeAprovacao());
        for(int i = 0; i < 14; i++)
            aluno.addFaltas();
        assertEquals(false, aluno.estadoDeAprovacao());
    }
    //endregion

    //#region Teste GetFrequencia
    @Test
    public void getFrequencia(){
        for(int i = 0; i < 5; i++)
            aluno.addFaltas();
        assertEquals(75, aluno.getFrequencia());
    }
    //#endregion

    //#region Teste toString
    @Test
    public void testeToString(){
        aluno.setNotaProva(1,10);
        aluno.setNotaProva(2,15);
        aluno.setNotaProva(3,20);
        aluno.setNotaProva(4,25);
        for(int i = 0; i < 5; i++)
            aluno.addFaltas();
        aluno.setCodTurma(123);

        System.out.println(aluno.toString());
    }
    //#endregion

}