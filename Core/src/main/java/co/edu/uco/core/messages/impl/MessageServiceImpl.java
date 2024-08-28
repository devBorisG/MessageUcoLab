package co.edu.uco.core.messages.impl;

import co.edu.uco.core.assembler.pojo.Message;
import co.edu.uco.core.messages.MessageService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Message> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Message> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Message> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Message getOne(String s) {
        return null;
    }

    @Override
    public Message getById(String s) {
        return null;
    }

    @Override
    public Message getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Message> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Message> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Message> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Message> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Message> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Message> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Message, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Message> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Message> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Message> findById(String s) {
        return Optional.ofNullable(new Message(s));
    }

    @Override
    public List<Message> findAll() {
        return List.of();
    }

    @Override
    public List<Message> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Message entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Message> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Message> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Message> findAll(Pageable pageable) {
        return null;
    }
}
