package br.prysthon.aws.project.repositories;

import br.prysthon.aws.project.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseInterface extends JpaRepository<House, Long> {
}
