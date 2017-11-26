package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findById(Long id);
    Page<User> findAllByOrderByIdDesc(Pageable pageable);
    Page<User> findAllByOrderByNameDesc(Pageable pageable);
    Page<User> findAllByOrderByDescriptionDesc(Pageable pageable);
}
