package com.chrisloarryn.demospringboot.interfaces.persistence.jdbc;

import com.chrisloarryn.demospringboot.domain.model.Store;
import com.chrisloarryn.demospringboot.domain.repository.StoreRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class JdbcStoreRepository implements StoreRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Store> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Store> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Store> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Store getOne(Long aLong) {
        return null;
    }

    @Override
    public Store getById(Long aLong) {
        return null;
    }

    @Override
    public Store getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Store> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Store> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Store> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Store> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Store> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Store> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Store, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Store> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Store> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Store> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Store> findAll() {
        return null;
    }

    @Override
    public List<Store> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Store entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Store> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Store> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Store> findAll(Pageable pageable) {
        return null;
    }
    // Implementa los métodos de acceso a datos utilizando JDBC
}