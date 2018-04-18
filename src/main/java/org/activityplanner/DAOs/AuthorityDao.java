package org.activityplanner.DAOs;

import org.activityplanner.Entities.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityDao extends CrudRepository<Authority, String> {

}
