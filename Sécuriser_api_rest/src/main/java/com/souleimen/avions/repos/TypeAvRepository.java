package com.souleimen.avions.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.souleimen.avions.entities.TypeAv;


@RepositoryRestResource(path = "typ")
public interface TypeAvRepository extends JpaRepository<TypeAv, Long> {

}
