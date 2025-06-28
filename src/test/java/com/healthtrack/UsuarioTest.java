package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void testGetNombre() {
        Usuario usuario = new Usuario("Carlos", 70.0);
        assertEquals("Carlos", usuario.getNombre(), "Se esperaba el nombre Carlos");
    }

    @Test
    void testGetPeso() {
        Usuario usuario = new Usuario("Ana", 65.5);
        assertEquals(65.5, usuario.getPeso(), "Se esperaba un peso de 65.5");
    }

    @Test
    void testActualizarPeso_ErrorEsperado() {
        Usuario usuario = new Usuario("Luis", 80.0);
        usuario.actualizarPeso(75.0);
        assertEquals(75.0, usuario.getPeso(), "El peso debería actualizarse a 75");
    }
}
