package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.assembler.pojo.Message;
import co.edu.uco.core.messages.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/messageucolab/v1/db")
@Slf4j
public class DummyPostgresController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Message>> obtenerUsuarioPorId(@PathVariable String id) {
        /*Configuration configuration = new Configuration();
        configuration.configure("hibernate.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.get(Message.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }*/

        SessionFactory sessionFactory = new Configuration().configure("hibernate.xml").buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       log.info("Datos {}", session.get(Message.class, "hola").getTitle());
        //session.save(new Message("hola", "1", "1", "1", "1", "1", "1", "1", "1"));

        transaction.commit();
        session.close();

        sessionFactory.close();

        return ResponseEntity.ok(messageService.findById(id));
    }


}
