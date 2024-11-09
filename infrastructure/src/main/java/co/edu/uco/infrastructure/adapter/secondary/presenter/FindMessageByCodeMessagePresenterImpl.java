package co.edu.uco.infrastructure.adapter.secondary.presenter;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.port.out.presenter.FindMessageByCodeMessagePresenter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class FindMessageByCodeMessagePresenterImpl implements FindMessageByCodeMessagePresenter {

    @GetMapping
    public void execute(MessageCodeDTO dto, HttpServletResponse response) {
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
