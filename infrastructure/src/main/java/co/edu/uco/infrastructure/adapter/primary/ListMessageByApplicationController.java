package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.Response;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import org.springframework.http.ResponseEntity;

public interface ListMessageByApplicationController {
    ResponseEntity<Response<SimplePage<MessageDTO>>> execute(String application, SimplePageRequest request);
}