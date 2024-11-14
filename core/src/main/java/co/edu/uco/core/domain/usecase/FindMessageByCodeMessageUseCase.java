package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.presenter.message.FindMessageByCodeMessagePresenter;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.core.mapper.entity.EntityMapper;
import co.edu.uco.core.message.strategy.MessageCatalogStrategy;
import co.edu.uco.utils.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public final class FindMessageByCodeMessageUseCase implements HandlingFindMessageByCodeMessagePort {

    private final MessageCatalogStrategy messageCatalogStrategy;
    private final EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper;
    private final FindMessageByCodeMessagePresenter presenter;

    public FindMessageByCodeMessageUseCase(MessageCatalogStrategy messageCatalogStrategy, EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper, FindMessageByCodeMessagePresenter presenter) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
        this.presenter = presenter;
    }

    @Override
    public void findMessageByCode(String codeMessage, String application) {
        try {
            MessageData messageData = messageCatalogStrategy.getMessage(codeMessage, application);
            MessageDTO messageDTO = entityMapper.mapperDTO(messageData);
            Response<MessageDTO> response = new Response<>(Collections.singletonList(messageDTO));
            presenter.present(response);
        } catch (Exception exception) {
            log.error( exception.getMessage());
            throw BusinessException.buildUserException("No existe un mensaje con el código " + codeMessage + " para la aplicación " + application);
        }
    }
}
