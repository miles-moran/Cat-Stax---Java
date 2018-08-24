package org.launchcode.Cat.Stax.technical;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CatDao extends CrudRepository<Cat, Integer> {

}
