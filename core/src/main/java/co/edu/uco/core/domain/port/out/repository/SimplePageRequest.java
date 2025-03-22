package co.edu.uco.core.domain.port.out.repository;

import lombok.Data;

import static co.edu.uco.core.CrosswordsConstant.*;

@Data
public final class SimplePageRequest {
    private int page = REQUEST_PAGE_DEFAULT;
    private String sort = REQUEST_PAGE_SORT_ASC;
    private String columnSort = REQUEST_COLUMN_SORT_DEFAULT;
    private int size = REQUEST_SIZE_DEFAULT;

    /**
     * Método para establecer la página de forma segura, convirtiendo desde String a int
     * Si el valor proporcionado no es un entero válido, se mantiene el valor por defecto
     * @param pageStr Valor de page como String
     */
    public void setPageFromString(String pageStr) {
        if (pageStr != null) {
            try {
                this.page = Integer.parseInt(pageStr);
            } catch (NumberFormatException e) {
                // Si hay error de conversión, mantener el valor por defecto
                this.page = REQUEST_PAGE_DEFAULT;
            }
        }
    }

    /**
     * Método para establecer el tamaño de forma segura, convirtiendo desde String a int
     * Si el valor proporcionado no es un entero válido, se mantiene el valor por defecto
     * @param sizeStr Valor de size como String
     */
    public void setSizeFromString(String sizeStr) {
        if (sizeStr != null) {
            try {
                this.size = Integer.parseInt(sizeStr);
            } catch (NumberFormatException e) {
                // Si hay error de conversión, mantener el valor por defecto
                this.size = REQUEST_SIZE_DEFAULT;
            }
        }
    }
}