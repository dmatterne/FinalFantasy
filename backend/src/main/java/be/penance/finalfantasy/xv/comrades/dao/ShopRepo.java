package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends JpaRepository<Shop,Long> {
    Shop findById(Long id);
    Page<Shop> findAllByOrderByIdDesc(Pageable pageable);
    Page<Shop> findAllByOrderByNameDesc(Pageable pageable);
    Page<Shop> findAllByOrderByDescriptionDesc(Pageable pageable);
}
