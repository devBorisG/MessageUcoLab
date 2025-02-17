package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.catalog.strategy.MessageCatalogStrategy;
import co.edu.uco.core.application.catalog.strategy.inmemory.enums.DetailMessageEnum;
import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.application.mapper.entity.EntityMapper;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.utils.exception.BusinessException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public final class FindMessageByCodeMessageUseCase implements HandlingFindMessageByCodeMessagePort {
    private final MessageCatalogStrategy messageCatalogStrategy;
    private final EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper;
    public FindMessageByCodeMessageUseCase(MessageCatalogStrategy messageCatalogStrategy, EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
    }
    @Override
    public void execute(String codeMessage, String application, PresenterPort<MessageDTO> presenterPort, HttpServletResponse response) {
        try {
            MessageData messageData = messageCatalogStrategy.getMessage(codeMessage, application);
            MessageDTO messageDTO = entityMapper.mapperDTO(messageData);
            presenterPort.presentRestSuccess(Collections.singletonList(messageDTO), response);
        } catch (Exception exception) {
            String errorMessage = String.format(DetailMessageEnum.FUN_012.getContent(), codeMessage, application);
            log.error(errorMessage);
            throw BusinessException.buildUserException(errorMessage);
        }
    }
}