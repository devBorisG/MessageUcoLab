package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageInputPort;
import co.edu.uco.infrastructure.adapter.primary.ListMessageController;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${crosswords.api.path.message}")
public class ListMessageControllerImpl extends AbstractRestController implements ListMessageController {
    private final HandlingListMessageInputPort handlingListMessageInputPort;
    public ListMessageControllerImpl(HandlingListMessageInputPort handlingListMessageInputPort) {
        this.handlingListMessageInputPort = handlingListMessageInputPort;
    }
    @GetMapping("/{codeMessage}")
    public void execute(@PathVariable String codeMessage, HttpServletResponse response) {
        MessageCodeDTO message = MessageCodeDTO.create(codeMessage);
        handlingListMessageInputPort.listMessage(message, response);
    }
}