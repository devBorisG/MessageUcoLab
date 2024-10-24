package co.edu.uco.core.domain.usecase;

import co.edu.uco.core.application.dto.MessageCodeDTO;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindMessageByCodeMessageUseCase implements HandlingFindMessageByCodeMessagePort {


    @Override
    public void findMessageByCode(MessageCodeDTO message, HttpServletResponse response) {

    }
}
