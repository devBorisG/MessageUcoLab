package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageByApplicationPort;
import co.edu.uco.infrastructure.adapter.primary.ListMessageByApplicationController;
import co.edu.uco.infrastructure.adapter.secondary.presenter.rest.RestPresenterImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${crosswords.api.path.message}")
final class ListMessageByApplicationControllerImpl implements ListMessageByApplicationController {
    private final HandlingListMessageByApplicationPort handlingListMessageByApplicationPort;
    private final RestPresenterImpl<SimplePage<MessageDTO>> restPresenter;
    public ListMessageByApplicationControllerImpl(HandlingListMessageByApplicationPort handlingListMessageByApplicationPort, RestPresenterImpl<SimplePage<MessageDTO>> restPresenter) {
        this.handlingListMessageByApplicationPort = handlingListMessageByApplicationPort;
        this.restPresenter = restPresenter;
    }
    @GetMapping
    @Override
    public ResponseEntity<Response<SimplePage<MessageDTO>>> execute(@RequestParam String application, @ModelAttribute SimplePageRequest request) {
        handlingListMessageByApplicationPort.execute(application, request, restPresenter);
        return restPresenter.getResponse();
    }
}