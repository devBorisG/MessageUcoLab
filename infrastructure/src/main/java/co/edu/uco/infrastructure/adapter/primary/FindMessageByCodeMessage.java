package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.Response;
import org.springframework.http.ResponseEntity;

public interface FindMessageByCodeMessage {
    ResponseEntity<Response<MessageDTO>> execute(String codeMessage, String application);
}
