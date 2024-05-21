package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.facade.message.ListMessageFacade;
import co.edu.uco.core.domain.port.in.ListMessageInPort;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class ListMessageController {

    private final ListMessageFacade facade;

    public ListMessageController(ListMessageFacade facade) {
        this.facade = facade;
    }

    @GetMapping()
    public void execute(@RequestParam String codeMessage, HttpServletResponse response) {
        MessageDTO message = MessageDTO.builder().code(codeMessage).build();
        facade.execute(message, response);
    }
}
