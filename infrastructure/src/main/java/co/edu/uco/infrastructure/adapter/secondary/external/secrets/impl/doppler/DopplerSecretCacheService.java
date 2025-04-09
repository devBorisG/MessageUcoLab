package co.edu.uco.infrastructure.adapter.secondary.external.secrets.impl.doppler;

import co.edu.uco.core.domain.port.out.repository.token.FindTokenCachePort;
import co.edu.uco.core.domain.port.out.secret.FindSecretTokenPort;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public final class DopplerSecretCacheService  implements FindTokenCachePort {
    private final Cache<String, Map<String, String>> dopplerSecretCache;
    private final FindSecretTokenPort findSecretTokenPort;
    public DopplerSecretCacheService(FindSecretTokenPort findSecretTokenPort) {
        this.findSecretTokenPort = findSecretTokenPort;
        this.dopplerSecretCache = Caffeine.newBuilder()
                .expireAfterWrite(15, TimeUnit.MINUTES)
                .maximumSize(500)
                .build();
    }
    @Override
    public Map<String, String> getSecret(String secretName) {
        return dopplerSecretCache.get(secretName, findSecretTokenPort::findSecretToken);
    }
}