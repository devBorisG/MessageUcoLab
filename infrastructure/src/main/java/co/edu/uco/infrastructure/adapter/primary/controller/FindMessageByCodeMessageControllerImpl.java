package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.infrastructure.adapter.primary.FindMessageByCodeMessage;
import co.edu.uco.infrastructure.adapter.primary.presenter.RestPresenterImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${crosswords.api.path.message.findByCode}")
final class FindMessageByCodeMessageControllerImpl implements FindMessageByCodeMessage {
    private final HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort;
    private final RestPresenterImpl<MessageDTO> restPresenter;
    public FindMessageByCodeMessageControllerImpl(HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort, RestPresenterImpl<MessageDTO> restPresenter) {
        this.handlingFindMessageByCodeMessagePort = handlingFindMessageByCodeMessagePort;
        this.restPresenter = restPresenter;
    }
    @Override
    @GetMapping()
    public ResponseEntity<Response<MessageDTO>> execute(@RequestParam String codeMessage, @RequestParam String application) {
        handlingFindMessageByCodeMessagePort.execute(codeMessage, application, restPresenter);
        return restPresenter.getResponse();
    }
}