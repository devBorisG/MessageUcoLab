package co.edu.uco.infrastructure.adapter.secondary.repository.postgresql.impl;

import co.edu.uco.core.domain.data.TokenData;
import co.edu.uco.core.domain.port.out.repository.token.TokenRepository;
import co.edu.uco.infrastructure.adapter.secondary.repository.data.TokenDataMapper;
import co.edu.uco.infrastructure.adapter.secondary.repository.postgresql.PostgreSQLRepository;
import org.springframework.stereotype.Component;

import static co.edu.uco.infrastructure.configuration.InfrastructureConstant.POSTGRESQL_ADAPTER;

@Component(POSTGRESQL_ADAPTER)
public class PostgreSQLRepositoryAdapterToken implements TokenRepository {

    private final PostgreSQLRepository postgreSQLRepository;
    private final TokenDataMapper tokenDataMapper;

    public PostgreSQLRepositoryAdapterToken(PostgreSQLRepository postgreSQLRepository, TokenDataMapper tokenDataMapper) {
        this.postgreSQLRepository = postgreSQLRepository;
        this.tokenDataMapper = tokenDataMapper;
    }

    @Override
    public TokenData save(TokenData tokenData) {
        return tokenDataMapper.mapperData(
                postgreSQLRepository.save(
                        tokenDataMapper.mapperModel(tokenData)
                )
        );
    }
}
