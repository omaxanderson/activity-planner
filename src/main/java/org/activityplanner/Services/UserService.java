package org.activityplanner.Services;

import org.activityplanner.DAOs.MysqlUserDao;
import org.springframework.beans.factory.annotation.Autowired;

// I don't think I need this, the MysqlUserDao interface and auto-generated service is
// enough of an abstraction layer to allow for easy dependency injection
public class UserService {

    /*
    @Autowired
    private MysqlUserDao mysqlUserDao;

    public String getUsername() {
        return mysqlUserDao.getUsername();
    }

    public String getPassword() {
        return mysqlUserDao.getPassword();
    }

    public void setUsername(String username) {
        mysqlUserDao.setUsername(username);
    }

    public void setPassword(String password) {
        mysqlUserDao.setPassword(password);
    }
    */

}
