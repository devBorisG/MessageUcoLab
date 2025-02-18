package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageByApplicationPort;
import co.edu.uco.infrastructure.adapter.primary.ListMessageByApplicationController;
import co.edu.uco.infrastructure.adapter.secondary.presenter.rest.HttpPresenterAdapter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${crosswords.api.path.message}")
final class ListMessageByApplicationControllerImpl implements ListMessageByApplicationController {
    private final HandlingListMessageByApplicationPort handlingListMessageByApplicationPort;
    private final PresenterPort<SimplePage<MessageDTO>> restPresenter;

    public ListMessageByApplicationControllerImpl(HandlingListMessageByApplicationPort handlingListMessageByApplicationPort, HttpServletResponse response) {
        this.handlingListMessageByApplicationPort = handlingListMessageByApplicationPort;
        this.restPresenter = new HttpPresenterAdapter<>(response);
    }
    @GetMapping
    @Override
    public void execute(@RequestParam String application, @ModelAttribute SimplePageRequest request) {
        SimplePage<MessageDTO> messageDTOSimplePage = handlingListMessageByApplicationPort.execute(application, request);
        restPresenter.presentRestSuccess(List.of(messageDTOSimplePage));
    }
}