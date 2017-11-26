package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.Quest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepo extends JpaRepository<Quest,Long> {
    Quest findById(Long id);
    Page<Quest> findAllByOrderByIdDesc(Pageable pageable);
    Page<Quest> findAllByOrderByNameDesc(Pageable pageable);
    Page<Quest> findAllByOrderByDescriptionDesc(Pageable pageable);
}
