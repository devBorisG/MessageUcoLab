package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.infrastructure.adapter.primary.FindMessageByCodeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${crosswords.api.path.message.findByCode}")
final class FindMessageByCodeMessageControllerImpl implements FindMessageByCodeMessage {
    private final HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort;

    private final PresenterPort<MessageDTO> restPresenter;

    public FindMessageByCodeMessageControllerImpl(HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort, PresenterPort<MessageDTO> restPresenter) {
        this.handlingFindMessageByCodeMessagePort = handlingFindMessageByCodeMessagePort;
        this.restPresenter = restPresenter;
    }
    @Override
    @GetMapping()
    public void execute(@RequestParam String codeMessage, @RequestParam String application, HttpServletRequest request) {
        MessageDTO messageDTO = handlingFindMessageByCodeMessagePort.execute(codeMessage, application);
        restPresenter.presentRestSuccess(List.of(messageDTO), request);
    }
}