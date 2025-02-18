package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.infrastructure.adapter.primary.FindMessageByCodeMessage;
import co.edu.uco.infrastructure.adapter.secondary.presenter.rest.HttpPresenterAdapter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${crosswords.api.path.message.findByCode}")
final class FindMessageByCodeMessageControllerImpl implements FindMessageByCodeMessage {
    private final HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort;

    private final PresenterPort<MessageDTO> restPresenter;

    public FindMessageByCodeMessageControllerImpl(HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort, HttpServletResponse response) {
        this.handlingFindMessageByCodeMessagePort = handlingFindMessageByCodeMessagePort;
        this.restPresenter = new HttpPresenterAdapter<>(response);
    }
    @Override
    @GetMapping()
    public void execute(@RequestParam String codeMessage, @RequestParam String application) {
        MessageDTO messageDTO = handlingFindMessageByCodeMessagePort.execute(codeMessage, application);
        restPresenter.presentRestSuccess(List.of(messageDTO));
    }
}