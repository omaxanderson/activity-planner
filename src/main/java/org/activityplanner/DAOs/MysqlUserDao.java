package org.activityplanner.DAOs;

import org.activityplanner.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// auto implemented by Spring
@Repository
public interface MysqlUserDao extends CrudRepository<User, Long> {

    List<User> findByFirstName(String firstName);

}
