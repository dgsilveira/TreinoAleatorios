package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    Data data;

    //dia, mês e ano == negativo -- return FALSE
    @Test
    void validarData1() {
       Data data = new Data(1, 1, 1);
        assertFalse(data.validarData(-1, 1, 1));
        assertFalse(data.validarData(1, -1, 1));
        assertFalse(data.validarData(1, 1, -1));
    }

    //dia, mês e ano == 0 -- return FALSE
    @Test
    void validarData2() {
        data = new Data(1, 1, 1);
        assertFalse(data.validarData(0, 1, 1));
        assertFalse(data.validarData(1, 0, 1));
        assertFalse(data.validarData(1, 1, 0));
    }

    //dia, mês e ano >= 1 -- return TRUE
    @Test
    void validarData3() {
        data = new Data(1, 1, 1);
        assertTrue(data.validarData(1, 1, 1));
    }

    //meses 1, 3, 5, 7, 8, 10 e 12 <= 31 -- return TRUE
    @Test
    void validarData4() {
        data = new Data(1, 1, 1);
        assertFalse(data.validarData(31, 1, 1));
        assertFalse(data.validarData(31, 3, 1));
        assertFalse(data.validarData(31, 5, 1));
        assertFalse(data.validarData(31, 7, 1));
        assertFalse(data.validarData(31, 8, 1));
        assertFalse(data.validarData(31, 10, 1));
        assertFalse(data.validarData(31, 12, 1));
    }

}