package br.com.cwi.crescer.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.maven.Matematica;


public class MatematicaTest {

    @Test
    public void deveSomarResultando4() {
        assertEquals(4, Matematica.somar(2, 2));
    }

}
