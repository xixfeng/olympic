package cn.xixfeng.olympic.Entity.Repository;



import cn.xixfeng.olympic.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByWxUid(Long wxUid);
}