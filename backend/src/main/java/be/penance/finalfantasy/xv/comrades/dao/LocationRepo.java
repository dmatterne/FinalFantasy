package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location,Long> {
    Location findById(Long id);
    Page<Location> findAllByOrderByIdDesc(Pageable pageable);
    Page<Location> findAllByOrderByNameDesc(Pageable pageable);
    Page<Location> findAllByOrderByDescriptionDesc(Pageable pageable);
}
