package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.infrastructure.adapter.primary.FindMessageByCodeMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${crosswords.api.path.message.findByCode}")
public final class FindMessageByCodeMessageControllerImpl extends AbstractRestController implements FindMessageByCodeMessage {
    private final HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort;
    public FindMessageByCodeMessageControllerImpl(HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort) {
        this.handlingFindMessageByCodeMessagePort = handlingFindMessageByCodeMessagePort;
    }
    @Override
    @GetMapping()
    public void execute(@RequestParam String codeMessage, @RequestParam String application) {
        handlingFindMessageByCodeMessagePort.execute(codeMessage, application);
    }
}