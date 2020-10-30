package com.caroline.willywonka.Repositories;

import com.caroline.willywonka.Models.OompaLoompa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OompaLoompaRepository extends JpaRepository<OompaLoompa, Integer> {
}


