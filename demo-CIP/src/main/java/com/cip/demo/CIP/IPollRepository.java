package com.cip.demo.CIP;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPollRepository extends JpaRepository<Poll, Long> {
   Poll save(Poll poll);
   List<Poll> findAll();
   Optional<Poll> findById(Long id);
   void deleteById(Long id);



}
