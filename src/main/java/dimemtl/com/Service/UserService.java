package dimemtl.com.Service;

import com.j256.ormlite.dao.Dao;
import dimemtl.com.Model.User;

public class UserService extends AbstractService<User, Integer>{

    public UserService(Dao<User, Integer> dao){
        super(dao);
    }
}
