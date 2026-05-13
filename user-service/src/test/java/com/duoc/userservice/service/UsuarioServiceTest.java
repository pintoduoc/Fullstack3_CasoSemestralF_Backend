package com.duoc.userservice.service;

import com.duoc.userservice.model.Usuario;
import com.duoc.userservice.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Esta anotación habilita Mockito
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    // Simula la base de datos (no hace peticiones reales)
    @Mock
    private UsuarioRepository usuarioRepository;

    // Inyecta la base de datos simulada en nuestro servicio real
    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuarioMock;

    // Esto se ejecuta antes de cada prueba para tener datos limpios
    @BeforeEach
    void setUp() {
        usuarioMock = new Usuario();
        usuarioMock.setId(1L);
        usuarioMock.setRut("11111111-1");
        usuarioMock.setNombreCompleto("Juan Perez");
        usuarioMock.setRol(Usuario.Rol.CIUDADANO);
    }

    @Test
    void testBuscarPorRut_Exitoso() {
        // 1. Preparación (Arrange): Le decimos al mock qué responder
        // Asumiendo que tu repositorio tiene un método findByRut
        when(usuarioRepository.findByRut("11111111-1")).thenReturn(usuarioMock);

        // 2. Ejecución (Act): Llamamos al método real de nuestro servicio
        // Ajusta este llamado según cómo se llame el método en tu UsuarioService real
        Usuario resultado = usuarioService.findByRut("11111111-1");

        // 3. Verificación (Assert): Comprobamos que el resultado sea el esperado
        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getNombreCompleto());
        assertEquals("11111111-1", resultado.getRut());
    }

    @Test
    void testGuardarUsuario() {
        // Arrange
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioMock);

        // Act
        // Ajusta este llamado según cómo se llame el método en tu UsuarioService real
        Usuario guardado = usuarioService.save(usuarioMock);

        // Assert
        assertNotNull(guardado);
        assertEquals(Usuario.Rol.CIUDADANO, guardado.getRol());
        // Verificamos que el repositorio intentó guardar exactamente 1 vez
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }
}