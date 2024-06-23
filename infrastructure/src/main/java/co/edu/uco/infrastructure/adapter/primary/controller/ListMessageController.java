package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageInputPort;
import co.edu.uco.infrastructure.adapter.AbstractRestController;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messageucolab/v1/message")
public class ListMessageController extends AbstractRestController {

    private final HandlingListMessageInputPort handlingListMessageInputPort;

    public ListMessageController(HandlingListMessageInputPort handlingListMessageInputPort) {
        this.handlingListMessageInputPort = handlingListMessageInputPort;
    }

    @GetMapping()
    public void execute(@RequestParam String codeMessage, HttpServletResponse response) {
        MessageDTO message = MessageDTO.builder().code(codeMessage).build();
        handlingListMessageInputPort.listMessage(message, response);
    }
}
