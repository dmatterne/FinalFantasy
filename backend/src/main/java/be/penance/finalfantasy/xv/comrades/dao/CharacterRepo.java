package be.penance.finalfantasy.xv.comrades.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepo extends JpaRepository<Character,Long> {
    Character findById(Long id);
    Page<Character> findAllByOrderByIdDesc(Pageable pageable);
    Page<Character> findAllByOrderByNameDesc(Pageable pageable);
    Page<Character> findAllByOrderByDescDesc(Pageable pageable);
}
