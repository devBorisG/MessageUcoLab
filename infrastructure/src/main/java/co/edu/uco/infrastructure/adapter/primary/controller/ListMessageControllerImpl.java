package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.builder.MessageCodeDTOBuilder;
import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageInputPort;
import co.edu.uco.infrastructure.adapter.AbstractRestController;
import co.edu.uco.infrastructure.adapter.primary.ListMessageController;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${crosswords.api.path.message}")
public class ListMessageControllerImpl extends AbstractRestController implements ListMessageController {

    private final HandlingListMessageInputPort handlingListMessageInputPort;

    public ListMessageControllerImpl(HandlingListMessageInputPort handlingListMessageInputPort) {
        this.handlingListMessageInputPort = handlingListMessageInputPort;
    }

    @GetMapping("/{codeMessage}")
    public void execute(@PathVariable String codeMessage, HttpServletResponse response) {
        MessageCodeDTO message = MessageCodeDTOBuilder.getInstance().setCode(codeMessage).build();
        handlingListMessageInputPort.listMessage(message, response);
    }
}
