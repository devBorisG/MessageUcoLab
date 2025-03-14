package co.edu.uco.core.domain.port.out.repository.token;

import co.edu.uco.core.domain.data.TokenData;

import java.util.List;
import java.util.Optional;

public interface FindTokenRepository {
    Optional<TokenData> findById(String id);
    String findId(String id);
    List<TokenData> findAll();
}