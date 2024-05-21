package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.domain.entities.MessageEntity;
import co.edu.uco.core.domain.port.in.ListMessageInPort;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class ListMessageController {

    private final ListMessageInPort useCase;
    public ListMessageController(ListMessageInPort useCase) {
        this.useCase = useCase;
    }

    @GetMapping()
    public void execute(@RequestParam String codeMessage, HttpServletResponse response) {
        MessageEntity message = new MessageEntity(codeMessage, "Mensaje de prueba");
        useCase.execute(message, response);
    }
}
