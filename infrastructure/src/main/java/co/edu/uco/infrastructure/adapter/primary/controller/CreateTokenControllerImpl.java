package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.dto.TokenDTO;
import co.edu.uco.core.application.facade.token.CreateTokenUseCaseFacade;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.infrastructure.adapter.primary.CreateTokenController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${crosswords.api.path.token.application}")
public class CreateTokenControllerImpl implements CreateTokenController {

    private final CreateTokenUseCaseFacade createTokenUseCaseFacade;
    private final PresenterPort<TokenDTO> restPresenter;


    public CreateTokenControllerImpl(CreateTokenUseCaseFacade createTokenUseCaseFacade, PresenterPort<TokenDTO> restPresenter) {
        this.createTokenUseCaseFacade = createTokenUseCaseFacade;
        this.restPresenter = restPresenter;
    }

    @PostMapping
    @Override
    public void createToken(
            @RequestBody CreateTokenDTO tokenDTO,
            @PathVariable UUID id,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        TokenDTO result = createTokenUseCaseFacade.createToken(tokenDTO, id);
        restPresenter.presentRestSuccess(List.of(result), httpServletRequest, httpServletResponse);
    }
}
