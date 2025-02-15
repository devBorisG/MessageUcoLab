package co.edu.uco.core.domain.usecase.handling;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;

public interface HandlingFindMessageByCodeMessagePort {
    void execute(String codeMessage, String application, PresenterPort<MessageDTO> presenter);
}