package edu.unicauca.SivriBackendApp.common.email.repository;

import edu.unicauca.SivriBackendApp.common.email.entity.Templates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends CrudRepository<Templates, Integer>{

}
