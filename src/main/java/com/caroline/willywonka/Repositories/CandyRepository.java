package com.caroline.willywonka.Repositories;

import com.caroline.willywonka.Models.Candy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {

}
