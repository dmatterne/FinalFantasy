package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long> {
    Skill findById(Long id);
    Page<Skill> findAllByOrderByIdDesc(Pageable pageable);
    Page<Skill> findAllByOrderByNameDesc(Pageable pageable);
    Page<Skill> findAllByOrderByDescriptionDesc(Pageable pageable);
}
