package it.unisalento.se.saw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unisalento.se.saw.domain.ExamHasUser;

@Repository
public interface ExamHasUserRepository extends JpaRepository<ExamHasUser, Integer>  {

}
