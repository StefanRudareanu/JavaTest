package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCarte {

    @Test
    public void  test_NrPagini(){
        Carte carte = new Carte("abcs","As",2024,23);
        assertEquals(27600,carte.getNrCuvinte());

    }
}
