package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageCacheInputPort;
import co.edu.uco.infrastructure.adapter.primary.ListMessageCacheController;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${crosswords.api.path.message}/1")
public class ListMessageCacheControllerImpl extends AbstractRestController implements ListMessageCacheController {

    private final HandlingListMessageCacheInputPort handlingListMessageInputPort;

    public ListMessageCacheControllerImpl(HandlingListMessageCacheInputPort handlingListMessageInputPort) {
        this.handlingListMessageInputPort = handlingListMessageInputPort;
    }

    @GetMapping("/cache/{codeMessage}")
    public void execute(@PathVariable String codeMessage, HttpServletResponse response) {
        MessageCodeDTO message = MessageCodeDTO.create(codeMessage);
        handlingListMessageInputPort.listMessage(message, response);
    }
}
