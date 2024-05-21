package co.edu.uco.infrastructure.adapter.secondary.presenter;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.ListMessagePresenter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class ListMessagePresenterImpl implements ListMessagePresenter{

    private final HttpServletResponse response;

    public ListMessagePresenterImpl(HttpServletResponse response) {
        this.response = response;
    }

    @GetMapping
    public void execute(MessageDTO messageDTO) {
        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            byte[] jsonResponse = new ObjectMapper().writeValueAsBytes(new ResponseEntity<>(messageDTO, HttpStatus.OK));
            String jsonResponseString = new String(jsonResponse, StandardCharsets.UTF_8);
            out.print(jsonResponseString);
            out.flush();
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}
