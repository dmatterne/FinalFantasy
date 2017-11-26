package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.EquipmentItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentItemRepo extends JpaRepository<EquipmentItem,Long> {
    EquipmentItem findById(Long id);
    Page<EquipmentItem> findAllByOrderByIdDesc(Pageable pageable);
    Page<EquipmentItem> findAllByOrderByNameDesc(Pageable pageable);
    Page<EquipmentItem> findAllByOrderByDescriptionDesc(Pageable pageable);
}
