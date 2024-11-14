package co.edu.uco.infrastructure.adapter.secondary.presenter.rest;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.presenter.message.FindMessageByCodeMessagePresenter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public final class FindMessageByCodeMessageRestPresenter extends AbstractRestPresenter implements FindMessageByCodeMessagePresenter {

    private final HttpServletResponse response;
    private final MappingJackson2HttpMessageConverter jacksonConverter;

    public FindMessageByCodeMessageRestPresenter(HttpServletResponse response, MappingJackson2HttpMessageConverter jacksonConverter) {
        this.response = response;
        this.jacksonConverter = jacksonConverter;
    }

    @Override
    public void present(Response<MessageDTO> dto) {
        try {
            response.setStatus(HttpStatus.OK.value());
            jacksonConverter.write(dto, MediaType.APPLICATION_JSON, new ServletServerHttpResponse(response));
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}
