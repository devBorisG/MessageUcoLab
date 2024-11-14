package co.edu.uco.infrastructure.adapter.secondary.presenter.rest;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.message.ListMessageByApplicationPresenter;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public final class ListMessageByApplicationRestPresenter extends AbstractRestPresenter implements ListMessageByApplicationPresenter {
    private final HttpServletResponse response;
    private final MappingJackson2HttpMessageConverter jacksonConverter;
    public ListMessageByApplicationRestPresenter(HttpServletResponse response, MappingJackson2HttpMessageConverter jacksonConverter) {
        this.response = response;
        this.jacksonConverter = jacksonConverter;
    }
    @Override
    public void present(SimplePage<MessageDTO> dto) {
        try {
            response.setStatus(HttpStatus.OK.value());
            jacksonConverter.write(dto, MediaType.APPLICATION_JSON, new ServletServerHttpResponse(response));
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}