package id.co.mp.midleware.service;

import id.co.mp.midleware.model.User;
import id.co.mp.midleware.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public List<User> list() {
        return repository.list();
    }

    @Transactional
    public void save(User param) {
       repository.save(param);
    }

    @Transactional
    public void update(User param) {
        repository.update(param);
    }

    @Transactional
    public void changePasswd(User param) {
        repository.update(param);
    }

}
