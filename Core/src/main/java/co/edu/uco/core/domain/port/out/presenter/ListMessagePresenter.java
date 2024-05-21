package co.edu.uco.core.domain.port.out.presenter;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.GenericReturnPort;
import org.springframework.http.ResponseEntity;

public interface ListMessagePresenter extends GenericReturnPort<MessageDTO> {
}
