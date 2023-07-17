package br.com.ifrs.restinga.trabalhoPratico.DAO;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface GenericCrudRepository<Type, ID> extends Repository<Type, ID> {
    public <S extends Type> S save(S s);
    public <S extends Type> Iterable<S> saveAll(Iterable<S> iterable);
    public Optional<Type> findById(ID id);
    public boolean existsById(ID id);
    public Iterable<Type> findAll();
    public Iterable<Type> findAllById(Iterable<ID> iterable);
    public long count();
    public void deleteById(ID id);
    public void delete(Type t);
    public void deleteAll(Iterable<? extends Type> iterable);
    public void deleteAll();

}
