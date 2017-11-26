package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Long> {
    Item findById(Long id);
    Page<Item> findAllByOrderByIdDesc(Pageable pageable);
    Page<Item> findAllByOrderByNameDesc(Pageable pageable);
    Page<Item> findAllByOrderByDescDesc(Pageable pageable);
}
