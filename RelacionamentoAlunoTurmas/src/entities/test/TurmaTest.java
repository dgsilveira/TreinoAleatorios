package entities.test;

import entities.Aluno;
import entities.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {
    //#region Preparação para Testes
    Turma turma1;
    Turma turma2;

    @BeforeEach
    public void init(){
        //#region Turma1
        turma1 = new Turma(1,2,3);
        //#endregion

        //#region Turma2
        //Alunos: 4 - Média nota: 64 - Media frequência: 68.75
        turma2 = new Turma(2,3,4);
        //Aluno001 Douglas - Nota Total: 74 - Frequência: 95%
        Aluno aluno001 = new Aluno("Douglas");
        aluno001.setNotaProva(1,20);
        aluno001.setNotaProva(2,19);
        aluno001.setNotaProva(3,18);
        aluno001.setNotaProva(4,17);
        aluno001.addFaltas();
        turma2.adicionarAluno(aluno001);

        //Aluno002 Andréa - Nota Total: 58 - Frequência: 90%
        Aluno aluno002 = new Aluno("Andréa");
        aluno002.setNotaProva(1,16);
        aluno002.setNotaProva(2,15);
        aluno002.setNotaProva(3,14);
        aluno002.setNotaProva(4,13);
        for(int i = 0; i < 2; i++){
            aluno002.addFaltas();
        }
        turma2.adicionarAluno(aluno002);

        //Aluno003 Paulo - Nota Total: 74 - Frequência: 50%
        Aluno aluno003 = new Aluno("Paulo");
        aluno003.setNotaProva(1,20);
        aluno003.setNotaProva(2,19);
        aluno003.setNotaProva(3,18);
        aluno003.setNotaProva(4,17);
        for(int i = 0; i < 10; i++){
            aluno003.addFaltas();
        }
        turma2.adicionarAluno(aluno003);

        //Aluno004 João - Nota Total: 50 - Frequência: 40%
        Aluno aluno004 = new Aluno("Joao");
        aluno004.setNotaProva(1,14);
        aluno004.setNotaProva(2,13);
        aluno004.setNotaProva(3,12);
        aluno004.setNotaProva(4,11);
        for(int i = 0; i < 15; i++){
            aluno004.addFaltas();
        }
        turma2.adicionarAluno(aluno004);
        //#endregion
    }
    //endregion

    //#region Teste Criar Turma
    @Test
    public void criarTurma(){
        assertEquals(1, turma1.getNivel());
        assertEquals(2, turma1.getDia());
        assertEquals(3, turma1.getTurno());
        assertEquals(123, turma1.getCodigoTurma());
    }
    //#endregion

    //#region Add Aluno, Ñ add repetido, lista cheia e código da turma é passado para aluno
    /*
    * Verificado:
    * >Adiciona aluno
    * >Não adiciona o mesmo aluno
    * >Não adiciona alunos com a lista cheia
    * */
    @Test
    public void adicionarAlunoEVerificacoes(){
        //#region Adiciona Aluno
        Aluno aluno1 = new Aluno("Douglas");
        turma1.adicionarAluno(aluno1);
        assertEquals(1, turma1.getTamanhoLista());
        assertEquals(aluno1, turma1.getAlunoPosicaoLista(0));
        //Próxima linha verifica se o código da turma foi inserido no código do Aluno
        assertEquals(turma1.getCodigoTurma(), turma1.getAlunoPosicaoLista(0).getCodTurma());
        Aluno aluno2 = new Aluno("Andréa");
        turma1.adicionarAluno(aluno2);
        assertEquals(2, turma1.getTamanhoLista());
        assertEquals(aluno2, turma1.getAlunoPosicaoLista(1));
        //#endregion

        //#region Não adiciona o mesmo aluno
        Aluno alunoNegado = new Aluno("Andréa");
        turma1.adicionarAluno(alunoNegado);
        assertEquals(2, turma1.getTamanhoLista());
        //#endregion

        //#region Não adiciona alunos com a lista cheia
        Aluno aluno3 = new Aluno("Jesus");
        turma1.adicionarAluno(aluno3);
        Aluno aluno4 = new Aluno("Mateus");
        turma1.adicionarAluno(aluno4);
        Aluno aluno5 = new Aluno("Marcos");
        turma1.adicionarAluno(aluno5);
        Aluno aluno6 = new Aluno("Lucas");
        turma1.adicionarAluno(aluno6);
        Aluno aluno7 = new Aluno("Joao");
        turma1.adicionarAluno(aluno7);
        Aluno aluno8 = new Aluno("Sansao");
        turma1.adicionarAluno(aluno8);
        Aluno aluno9 = new Aluno("Jose");
        turma1.adicionarAluno(aluno9);
        Aluno aluno10 = new Aluno("Maria");
        turma1.adicionarAluno(aluno10);
        Aluno aluno11 = new Aluno("Davi");
        turma1.adicionarAluno(aluno11);
        Aluno aluno12 = new Aluno("Salomao");
        turma1.adicionarAluno(aluno12);
        Aluno aluno13 = new Aluno("Jonas");
        turma1.adicionarAluno(aluno13);
        Aluno aluno14 = new Aluno("Naum");
        turma1.adicionarAluno(aluno14);
        Aluno aluno15 = new Aluno("Miqueias");
        turma1.adicionarAluno(aluno15);
        Aluno aluno16 = new Aluno("Lazaro");
        turma1.adicionarAluno(aluno16);
        Aluno aluno17 = new Aluno("Pedro");
        turma1.adicionarAluno(aluno17);
        Aluno aluno18 = new Aluno("Barnabe");
        turma1.adicionarAluno(aluno18);
        Aluno aluno19 = new Aluno("Rute");
        turma1.adicionarAluno(aluno19);
        Aluno aluno20 = new Aluno("Judas");
        turma1.adicionarAluno(aluno20);
        Aluno alunoListaCheia = new Aluno("Samuel");
        turma1.adicionarAluno(alunoListaCheia);
        assertEquals(20, turma1.getTamanhoLista());
        assertEquals(aluno1, turma1.getAlunoPosicaoLista(0));
        assertEquals(aluno2, turma1.getAlunoPosicaoLista(1));
        assertEquals(aluno3, turma1.getAlunoPosicaoLista(2));
        assertEquals(aluno4, turma1.getAlunoPosicaoLista(3));
        assertEquals(aluno5, turma1.getAlunoPosicaoLista(4));
        assertEquals(aluno6, turma1.getAlunoPosicaoLista(5));
        assertEquals(aluno7, turma1.getAlunoPosicaoLista(6));
        assertEquals(aluno8, turma1.getAlunoPosicaoLista(7));
        assertEquals(aluno9, turma1.getAlunoPosicaoLista(8));
        assertEquals(aluno10, turma1.getAlunoPosicaoLista(9));
        assertEquals(aluno11, turma1.getAlunoPosicaoLista(10));
        assertEquals(aluno12, turma1.getAlunoPosicaoLista(11));
        assertEquals(aluno13, turma1.getAlunoPosicaoLista(12));
        assertEquals(aluno14, turma1.getAlunoPosicaoLista(13));
        assertEquals(aluno15, turma1.getAlunoPosicaoLista(14));
        assertEquals(aluno16, turma1.getAlunoPosicaoLista(15));
        assertEquals(aluno17, turma1.getAlunoPosicaoLista(16));
        assertEquals(aluno18, turma1.getAlunoPosicaoLista(17));
        assertEquals(aluno19, turma1.getAlunoPosicaoLista(18));
        assertEquals(aluno20, turma1.getAlunoPosicaoLista(19));
        //#endregion

    }
    //#endregion

    //#region Calcular média das notas da Turma
        @Test
    void mediaNotasTurma(){
        assertEquals(64,turma2.mediaNotasTurma());
    }
    //#endregion


    //#region Teste Calcular média da frequência da Turma
    @Test
    void mediaFrequenciaTurma(){
        assertEquals(65, turma2.mediaFrequenciaTurma());
    }
    //#endregion


    //#region Teste melhor Desempenho
    @Test
    public void melhorDesempenho(){
        System.out.println(turma2.melhorDesempenho());
    }
    //endregion

    @Test
    public void diarioFinal(){

    }


}