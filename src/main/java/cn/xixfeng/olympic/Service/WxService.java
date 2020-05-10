package cn.xixfeng.olympic.Service;

import cn.xixfeng.olympic.Entity.Repository.UserRepository;
import cn.xixfeng.olympic.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxService {
    private UserRepository userRepository;

    @Autowired
    public void setRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserInfo(User user){
        userRepository.save(user);
    }
}
