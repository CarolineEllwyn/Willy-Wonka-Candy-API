package com.caroline.willywonka.Models.Repositories;

import com.caroline.willywonka.Models.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {
}
