package co.edu.uco.infrastructure.adapter.primary;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

public interface CreateTokenController {
    void createToken(CreateTokenDTO tokenDTO, UUID applicationId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
