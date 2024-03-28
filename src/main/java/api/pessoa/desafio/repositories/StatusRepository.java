package api.pessoa.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.pessoa.desafio.entities.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    
}
