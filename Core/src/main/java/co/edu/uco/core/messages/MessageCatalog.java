package co.edu.uco.core.messages;

public abstract class MessageCatalog {
    public abstract void loadCatalog();

    public abstract void reloadCatalog();

    public abstract String getMessage(String key);

    public abstract void addMessage(String key, String message);

    public abstract boolean isExist(String key);

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
