package com.caroline.willywonka.Models.Repositories;

import com.caroline.willywonka.Models.OompaLoompa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OompaLoopaRepository extends JpaRepository<OompaLoompa, Integer> {
}


