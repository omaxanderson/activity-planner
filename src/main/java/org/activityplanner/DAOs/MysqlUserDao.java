package org.activityplanner.DAOs;

import org.activityplanner.Entities.User;
import org.springframework.data.repository.CrudRepository;

// auto implemented by Spring
public interface MysqlUserDao extends CrudRepository<User, Long> {

    public String getUsername();
    public String getPassword();

    public void setUsername(String username);
    public void setPassword(String password);

}
