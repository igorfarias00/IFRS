package br.com.ifrs.restinga.aula0628.DAO;

import br.com.ifrs.restinga.aula0628.model.Empresa;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaDAO extends GenericCrudRepository<Empresa, Long>{

}
