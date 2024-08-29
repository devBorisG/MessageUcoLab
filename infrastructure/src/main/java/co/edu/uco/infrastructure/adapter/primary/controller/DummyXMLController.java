package co.edu.uco.infrastructure.adapter.primary.controller;

import co.edu.uco.core.assembler.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${crosswords.api.path.message.find}")
@Slf4j
public class DummyXMLController {

    @GetMapping("/{id}")
    public void getUserById(@PathVariable String id) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.xml").buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       log.info("Datos {}", session.get(Message.class, id).getTitle());
        Message title = session.get(Message.class, id);

        transaction.commit();
        session.close();

        sessionFactory.close();
    }
}
