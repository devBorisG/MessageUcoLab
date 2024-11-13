package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.data.MessageData;
import co.edu.uco.core.domain.domains.MessageDomain;
import co.edu.uco.core.domain.port.out.presenter.FindMessageByCodeMessagePresenter;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.core.mapper.dto.DTOMapper;
import co.edu.uco.core.mapper.entity.EntityMapper;
import co.edu.uco.core.message.strategy.MessageCatalogStrategy;
import co.edu.uco.utils.exception.BusinessException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindMessageByCodeMessageUseCase implements HandlingFindMessageByCodeMessagePort {

    private final MessageCatalogStrategy messageCatalogStrategy;
    private final EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper;
    private final FindMessageByCodeMessagePresenter presenter;

    public FindMessageByCodeMessageUseCase(MessageCatalogStrategy messageCatalogStrategy, EntityMapper<MessageData, MessageDomain, MessageDTO> entityMapper, FindMessageByCodeMessagePresenter presenter) {
        this.messageCatalogStrategy = messageCatalogStrategy;
        this.entityMapper = entityMapper;
        this.presenter = presenter;
    }

    @Override
    public void findMessageByCode(MessageCodeDTO message, String application,HttpServletResponse response) {
        try {
            MessageData messageData = messageCatalogStrategy.getMessage(message.getCode(), application);
            MessageDTO messageDTO = entityMapper.mapperDTO(messageData);
            presenter.execute(messageDTO, response);
        } catch (Exception exception) {
            log.error("ERROCITO UWU"+ exception.getMessage());
        }
    }
}
