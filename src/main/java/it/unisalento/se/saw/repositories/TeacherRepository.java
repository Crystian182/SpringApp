package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unisalento.se.saw.domain.Building;
import it.unisalento.se.saw.domain.User;

@Repository
public interface TeacherRepository extends JpaRepository<User, Integer> {

}
