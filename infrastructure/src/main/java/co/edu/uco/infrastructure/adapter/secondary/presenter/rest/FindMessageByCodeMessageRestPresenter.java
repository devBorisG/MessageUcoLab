package co.edu.uco.infrastructure.adapter.secondary.presenter.rest;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.message.FindMessageByCodeMessagePresenter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class FindMessageByCodeMessageRestPresenter implements FindMessageByCodeMessagePresenter {

    public void execute(MessageDTO dto, HttpServletResponse response) {
        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            byte[] jsonResponse = new ObjectMapper().writeValueAsBytes(new ResponseEntity<>(dto, HttpStatus.OK));
            String jsonResponseString = new String(jsonResponse, StandardCharsets.UTF_8);
            out.print(jsonResponseString);
            out.flush();
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}
