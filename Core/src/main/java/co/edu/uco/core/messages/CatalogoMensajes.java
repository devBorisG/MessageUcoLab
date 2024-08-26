package co.edu.uco.core.messages;

import co.edu.uco.core.messages.properties.CatalogMessagesProperties;
import jakarta.annotation.PostConstruct;

public abstract class CatalogoMensajes {
    public abstract void cargarCatalogo();

    public abstract void recargarCatalogo();

    public abstract String obtenerMensaje(String key);

    public abstract void agregarMensaje(String key, String mensaje);

    public abstract boolean contieneMensaje(String key);

    /*
    public static String buscarMensaje(CatalogMessageEnum key) {
        return obtenerCatalogo(key.getSource()).obtenerMensaje(key.getKey());
    }
    */

    // Cargar primero los criticos que estaran contenidos en el properties
    /*public static CatalogoMensajes loadCriticalCatalog() {
        return CatalogMessagesProperties.getInstance();
    }*/

    /*private static CatalogoMensajes obtenerCatalogo(MessageCatalogSource source) {
        return switch (source) {
            case DATABASE -> CatalogMessagesProperties.getInstance();
            case FILE -> CatalogMessagesProperties.getInstance();
            case NETWORK -> CatalogMessagesProperties.getInstance();
            default -> throw new IllegalStateException("Unexpected value: " + source);
        };
    }
    */
}
