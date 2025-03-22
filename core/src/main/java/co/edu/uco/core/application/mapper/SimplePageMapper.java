package co.edu.uco.core.application.mapper;

import co.edu.uco.core.application.dto.PageRequestDTO;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import org.springframework.stereotype.Component;

import static co.edu.uco.core.CrosswordsConstant.*;
import static co.edu.uco.utils.helper.UtilText.getDefault;

/**
 * Mapper responsable de convertir entre PageRequestDTO y SimplePageRequest
 * Realiza conversiones seguras de tipo y maneja errores de conversión
 */
@Component
public class SimplePageMapper {
    /**
     * Convierte de PageRequestDTO a SimplePageRequest
     * Realiza conversiones seguras de tipo de String a int para page y size
     * 
     * @param dto El DTO con los datos de paginación
     * @return SimplePageRequest con los valores convertidos
     */
    public SimplePageRequest toSimplePageRequest(PageRequestDTO dto) {
        if (dto == null) {
            return new SimplePageRequest();
        }
        SimplePageRequest request = new SimplePageRequest();
        // Conversión segura de page
        request.setPage(convertToInt(dto.getPage(), REQUEST_PAGE_DEFAULT));
        // Conversión segura de size
        request.setSize(convertToInt(dto.getSize(), REQUEST_SIZE_DEFAULT));
        // Establecer valores de string
        request.setSort(getDefault(dto.getSort(), REQUEST_PAGE_SORT_ASC));
        request.setColumnSort(getDefault(dto.getColumnSort(), REQUEST_COLUMN_SORT_DEFAULT));
        return request;
    }
    
    /**
     * Convierte un SimplePageRequest a PageRequestDTO
     * 
     * @param request El objeto SimplePageRequest a convertir
     * @return PageRequestDTO con los valores convertidos a String
     */
    public PageRequestDTO toPageRequestDTO(SimplePageRequest request) {
        if (request == null) {
            return new PageRequestDTO();
        }
        return PageRequestDTO.builder()
                .page(String.valueOf(request.getPage()))
                .size(String.valueOf(request.getSize()))
                .sort(request.getSort())
                .columnSort(request.getColumnSort())
                .build();
    }
    /**
     * Método utilitario para convertir un String a int de forma segura
     * 
     * @param value El String a convertir
     * @param defaultValue Valor por defecto en caso de error
     * @return El valor convertido o el valor por defecto
     */
    private int convertToInt(String value, int defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}