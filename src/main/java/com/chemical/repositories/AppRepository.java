package com.chemical.repositories;

import com.chemical.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
    Optional<App> findByName(String name);

}
