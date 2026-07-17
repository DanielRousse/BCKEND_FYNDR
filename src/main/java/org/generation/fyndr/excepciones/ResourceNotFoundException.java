package org.generation.fyndr.excepciones;

/**
 * Excepción personalizada para cuando un recurso no es encontrado en la base de datos.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " no encontrado(a) con id: " + id);
    }
}
