package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.Location;
import be.penance.finalfantasy.xv.comrades.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Long> {
    Location findById(Long id);
    Page<Location> findAllByOrderByIdDesc(Pageable pageable);
    Page<Location> findAllByOrderByNameDesc(Pageable pageable);
    Page<Location> findAllByOrderByDescDesc(Pageable pageable);
}
