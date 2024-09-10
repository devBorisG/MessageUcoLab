package co.edu.uco.core.assembler.pojo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

@Setter
@Getter
@Document(collection = "message")
@RedisHash("0")
public class Message {
    @Id
    private String id;
    private String code;
    private String title;
    private String content;
    private String type;
    private String category;
    private String status;
    private String application;
    private String functionality;
}
