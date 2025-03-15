package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.application.dto.MessageDTO;
import co.edu.uco.core.domain.port.out.presenter.PresenterPort;
import co.edu.uco.core.domain.port.out.repository.SimplePage;
import co.edu.uco.core.domain.port.out.repository.SimplePageRequest;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageByCodeMessagePort;
import co.edu.uco.core.domain.usecase.handling.HandlingFindMessageEnvironmentPort;
import co.edu.uco.core.domain.usecase.handling.HandlingListMessageByApplicationPort;
import co.edu.uco.infrastructure.adapter.primary.FindMessagesController;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.MongoEnvironmentRepositoryAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${crosswords.api.path.message}")
@Tag(name = "Consulta de Mensajes", description = "Endpoints para obtener información de mensajes")
public class FindMessagesControllerImpl implements FindMessagesController {
    private static final Logger log = LoggerFactory.getLogger(FindMessagesControllerImpl.class);
    private final HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort;
    private final HandlingListMessageByApplicationPort handlingListMessageByApplicationPort;
    private final HandlingFindMessageEnvironmentPort handlingFindMessageEnvironmentPort;
    private final PresenterPort<MessageDTO> restPresenter;
    private final PresenterPort<SimplePage<MessageDTO>> restPresenterPage;

    public FindMessagesControllerImpl(HandlingFindMessageByCodeMessagePort handlingFindMessageByCodeMessagePort, HandlingListMessageByApplicationPort handlingListMessageByApplicationPort, HandlingFindMessageEnvironmentPort handlingFindMessageEnvironmentPort, PresenterPort<MessageDTO> restPresenter, PresenterPort<SimplePage<MessageDTO>> restPresenterPage, MongoEnvironmentRepositoryAdapter repositoryAdapter) {
        this.handlingFindMessageByCodeMessagePort = handlingFindMessageByCodeMessagePort;
        this.handlingListMessageByApplicationPort = handlingListMessageByApplicationPort;
        this.handlingFindMessageEnvironmentPort = handlingFindMessageEnvironmentPort;
        this.restPresenter = restPresenter;
        this.restPresenterPage = restPresenterPage;
    }

    @Override
    @GetMapping("${crosswords.api.path.message.application.code}")
    @Operation(
            summary = "Buscar mensaje por código de mensaje y id de aplicación",
            description = "Permite obtener el mensaje correspondiente a un código específico y una aplicación determinada. "
                    + "El endpoint recibe los parámetros 'messageCode' y 'id' y retorna el mensaje encontrado en cualquier formato aceptado por el servidor.",
            parameters = {
                    @Parameter(
                            name = "messageCode",
                            description = "Código del mensaje a buscar",
                            required = true,
                            example = "MSG001"
                    ),
                    @Parameter(
                            name = "id",
                            description = "Nombre o identificador de la aplicación asociada al mensaje",
                            required = true,
                            example = "App One"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Mensaje encontrado correctamente",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = MessageDTO.class)
                                    ),
                                    @Content(
                                            mediaType = "application/yaml",
                                            schema = @Schema(implementation = MessageDTO.class)
                                    ),
                                    @Content(
                                            mediaType = "application/xml",
                                            schema = @Schema(implementation = MessageDTO.class)
                                    ),
                                    @Content(
                                            mediaType = "text/plain",
                                            schema = @Schema(implementation = MessageDTO.class)
                                    ),
                                    @Content(
                                            mediaType = "text/html",
                                            schema = @Schema(implementation = MessageDTO.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Solicitud incorrecta, parámetros inválidos o faltantes"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Mensaje o aplicación no encontrado"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor"
                    ),
                    @ApiResponse(
                            responseCode = "406",
                            description = "Formato de respuesta no soportado"
                    )
            }
    )
    public void findByCodeMessageAndApplication(
            @PathVariable String messageCode,
            @PathVariable String id,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        MessageDTO messageDTO = handlingFindMessageByCodeMessagePort.execute(messageCode, id);
        restPresenter.presentRestSuccess(List.of(messageDTO), httpServletRequest, httpServletResponse);
    }

    @Override
    @GetMapping("${crosswords.api.path.message.application}")
    @Operation(
            summary = "Listar mensajes por aplicación",
            description = "Retorna una lista paginada de mensajes asociados a una aplicación. " +
                    "El endpoint recibe el identificador de la aplicación a través de la variable de ruta 'id', " +
                    "y opcionalmente parámetros de paginación 'page' y 'size' (definidos en SimplePageRequest).",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Identificador o nombre de la aplicación",
                            required = true,
                            example = "App One"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de mensajes obtenida correctamente",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = SimplePageRequest.class)
                                    ),
                                    @Content(
                                            mediaType = "application/yaml",
                                            schema = @Schema(implementation = SimplePageRequest.class)
                                    ),
                                    @Content(
                                            mediaType = "application/xml",
                                            schema = @Schema(implementation = SimplePageRequest.class)
                                    ),
                                    @Content(
                                            mediaType = "text/plain",
                                            schema = @Schema(implementation = SimplePageRequest.class)
                                    ),
                                    @Content(
                                            mediaType = "text/html",
                                            schema = @Schema(implementation = SimplePageRequest.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Solicitud incorrecta, parámetros inválidos o faltantes"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se encontraron mensajes para la aplicación especificada"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error interno del servidor"
                    ),
                    @ApiResponse(
                            responseCode = "406",
                            description = "Formato de respuesta no soportado"
                    )
            }
    )
    public void findByApplication(
            @PathVariable String id,
            @ModelAttribute SimplePageRequest simplePageRequest,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        SimplePage<MessageDTO> messageDTOSimplePage = handlingListMessageByApplicationPort.execute(id, simplePageRequest);
        restPresenterPage.presentRestSuccess(List.of(messageDTOSimplePage), httpServletRequest, httpServletResponse);
    }

    @Override
    @GetMapping("${crosswords.api.path.message.environment}")
    public void findByEnvironmentAndMessage(
                                            SimplePageRequest simplePageRequest,
                                            HttpServletRequest httpServletRequest,
                                            HttpServletResponse httpServletResponse
    ) {
        var environmentId = (String) httpServletRequest.getAttribute("environmentId");
        SimplePage<MessageDTO> messageDTOSimplePage = handlingFindMessageEnvironmentPort.execute(environmentId, simplePageRequest);
        restPresenterPage.presentRestSuccess(List.of(messageDTOSimplePage), httpServletRequest, httpServletResponse);
    }
}