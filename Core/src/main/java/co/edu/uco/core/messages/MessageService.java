package co.edu.uco.core.messages;

import co.edu.uco.core.assembler.pojo.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageService extends JpaRepository<Message, String> {
    Optional<Message> findById(String id);
}
