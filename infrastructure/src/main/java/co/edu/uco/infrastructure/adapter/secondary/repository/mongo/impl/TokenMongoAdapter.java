package co.edu.uco.infrastructure.adapter.secondary.repository.mongo.impl;

import co.edu.uco.core.domain.data.TokenData;
import co.edu.uco.core.domain.port.out.repository.token.FindTokenRepository;
import co.edu.uco.infrastructure.adapter.secondary.repository.data.TokenDocumentMapper;
import co.edu.uco.infrastructure.adapter.secondary.repository.mongo.TokenMongoRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public final class TokenMongoAdapter implements FindTokenRepository {
    private final TokenMongoRepositoryAdapter tokenMongoRepositoryAdapter;
    private final TokenDocumentMapper mapper;
    public TokenMongoAdapter(TokenMongoRepositoryAdapter tokenMongoRepositoryAdapter, TokenDocumentMapper mapper) {
        this.tokenMongoRepositoryAdapter = tokenMongoRepositoryAdapter;
        this.mapper = mapper;
    }
    @Override
    public Optional<TokenData> findById(String id) {
        return tokenMongoRepositoryAdapter.findById(id).map(mapper::mapperData);
    }
    @Override
    public String findId(String token) {
        return tokenMongoRepositoryAdapter.findById(token).get().getSecretName();
    }
    @Override
    public List<TokenData> findAll() {
        return tokenMongoRepositoryAdapter.findAll().stream().map(mapper::mapperData).toList();
    }
}