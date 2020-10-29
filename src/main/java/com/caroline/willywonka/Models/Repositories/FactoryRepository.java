package com.caroline.willywonka.Models.Repositories;

import com.caroline.willywonka.Models.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Integer> {
}
