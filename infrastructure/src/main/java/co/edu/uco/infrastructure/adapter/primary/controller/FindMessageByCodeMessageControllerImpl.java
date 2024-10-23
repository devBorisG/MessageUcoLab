package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.builder.MessageCodeDTOBuilder;
import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.infrastructure.adapter.AbstractRestController;
import co.edu.uco.infrastructure.adapter.primary.FindMessageByCodeMessage;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${crosswords.api.path.message.findByCode}")
public class FindMessageByCodeMessageControllerImpl extends AbstractRestController implements FindMessageByCodeMessage {

    private final HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort;

    public FindMessageByCodeMessageControllerImpl(HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort) {
        this.handlingFindMessageByCodeMessagePort = handlingFindMessageByCodeMessagePort;
    }

    @Override
    @GetMapping("/{codeMessage}")
    public void execute(@PathVariable String codeMessage, HttpServletResponse response) {
        MessageCodeDTO message = MessageCodeDTOBuilder.getInstance().setCode(codeMessage).build();
        handlingFindMessageByCodeMessagePort.findMessageByCode(message, response);
    }
}
