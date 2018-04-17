package org.activityplanner.DAOs;

import org.activityplanner.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public interface UserDao {

//    public User getUser();
    public String getUsername();
    public String getPassword();

    public void setUsername(String username);
    public void setPassword(String Password);


}
