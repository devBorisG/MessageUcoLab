package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageByApplicationPort;
import co.edu.uco.infrastructure.adapter.primary.ListMessageByApplicationController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${crosswords.api.path.message}")
class ListMessageByApplicationControllerImpl implements ListMessageByApplicationController {
    private final HandlingListMessageByApplicationPort handlingListMessageByApplicationPort;
    public ListMessageByApplicationControllerImpl(HandlingListMessageByApplicationPort handlingListMessageByApplicationPort) {
        this.handlingListMessageByApplicationPort = handlingListMessageByApplicationPort;
    }
    @GetMapping
    @Override
    public void execute(@RequestParam String application, @ModelAttribute SimplePageRequest request) {
        handlingListMessageByApplicationPort.execute(application, request);
    }
}