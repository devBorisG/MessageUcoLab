package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageByApplicationPort;
import co.edu.uco.infrastructure.adapter.primary.FindMessagesController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${crosswords.api.path.message}")
public class FindMessagesControllerImpl implements FindMessagesController {
    private final HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort;
    private final HandlingListMessageByApplicationPort handlingListMessageByApplicationPort;
    private final PresenterPort<MessageDTO> restPresenter;
    private final PresenterPort<SimplePage<MessageDTO>> restPresenterPage;

    public FindMessagesControllerImpl(HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort, HandlingListMessageByApplicationPort handlingListMessageByApplicationPort, PresenterPort<MessageDTO> restPresenter, PresenterPort<SimplePage<MessageDTO>> restPresenterPage) {
        this.handlingFindMessageByCodeMessagePort = handlingFindMessageByCodeMessagePort;
        this.handlingListMessageByApplicationPort = handlingListMessageByApplicationPort;
        this.restPresenter = restPresenter;
        this.restPresenterPage = restPresenterPage;
    }

    @Override
    @GetMapping("${crosswords.api.apth.message.application.code}")
    public void findByCodeMessageAndApplication(@RequestParam String codeMessage,@RequestParam String application, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        MessageDTO messageDTO = handlingFindMessageByCodeMessagePort.execute(codeMessage, application);
        restPresenter.presentRestSuccess(List.of(messageDTO), httpServletRequest, httpServletResponse);
    }

    @Override
    @GetMapping("${crosswords.api.apth.message.application}")
    public void findByApplication(@RequestParam String application, @ModelAttribute SimplePageRequest simplePageRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        SimplePage<MessageDTO> messageDTOSimplePage = handlingListMessageByApplicationPort.execute(application, simplePageRequest);
        restPresenterPage.presentRestSuccess(List.of(messageDTOSimplePage), httpServletRequest, httpServletResponse);
    }
}
