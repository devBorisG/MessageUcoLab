package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.CreateTokenDTO;
import co.edu.uco.core.application.facade.token.CreateTokenUseCaseFacade;
import co.edu.uco.core.domain.data.TokenData;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.core.domain.port.out.repository.DataBaseTokenDataRepository;
import co.edu.uco.infrastructure.adapter.primary.CreateTokenController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("${crosswords.api.path.message}")
public class CreateTokenControllerImpl implements CreateTokenController {

    private final CreateTokenUseCaseFacade createTokenUseCaseFacade;
    private final PresenterPort<String> restPresenter;

    private final DataBaseTokenDataRepository dataBaseTokenDataRepository;

    public CreateTokenControllerImpl(CreateTokenUseCaseFacade createTokenUseCaseFacade, PresenterPort<String> restPresenter, DataBaseTokenDataRepository dataBaseTokenDataRepository) {
        this.createTokenUseCaseFacade = createTokenUseCaseFacade;
        this.restPresenter = restPresenter;
        this.dataBaseTokenDataRepository = dataBaseTokenDataRepository;
    }

    @PostMapping("${crosswords.api.path.token.application}")
    @Override
    public void createToken(
            @RequestBody CreateTokenDTO tokenDTO,
            @PathVariable UUID id,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        String result = createTokenUseCaseFacade.createToken(tokenDTO, id);
        Optional<TokenData> tokenData = dataBaseTokenDataRepository.findByAirbyteDataId(result);
        System.out.println(tokenData);
        restPresenter.presentRestSuccess(List.of(result), httpServletRequest, httpServletResponse);
    }
}
