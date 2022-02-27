package entities.test;

import entities.GeraTamanho;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeraTamanhoTest {

    GeraTamanho tamanho;

    //Se o número criado é maior ou igual a 2 (para ser um vetor)
    @Test
    void retornaNumero(){
        tamanho = new GeraTamanho();
        assertTrue(numero(tamanho.getTamanho()));
    }

    private boolean numero(int tamanho) {
        if(tamanho >= 2)
            return true;
        else
            return false;
    }

}