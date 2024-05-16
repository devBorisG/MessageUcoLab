package co.edu.uco.core.port.out.presenter;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.port.GenericReturnPort;
import org.springframework.http.ResponseEntity;

public interface ListMessagePresenter extends GenericReturnPort<ResponseEntity<String>, MessageDTO> {
}
