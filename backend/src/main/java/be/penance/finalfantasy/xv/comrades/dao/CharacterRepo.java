package be.penance.finalfantasy.xv.comrades.dao;

import be.penance.finalfantasy.xv.comrades.domain.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends JpaRepository<Character,Long> {
    Character findById(Long id);
    Page<Character> findAllByOrderByIdDesc(Pageable pageable);
    Page<Character> findAllByOrderByNameDesc(Pageable pageable);
    Page<Character> findAllByOrderByDescriptionDesc(Pageable pageable);
}
