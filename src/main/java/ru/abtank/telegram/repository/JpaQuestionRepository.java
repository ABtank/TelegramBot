package ru.abtank.telegram.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.abtank.telegram.entity.Question;

@Repository
@Transactional(readOnly = true)
public interface JpaQuestionRepository extends JpaRepository<Question, Integer> {

    @Query(nativeQuery = true, value = "SELECT *  FROM java_quiz ORDER BY random() LIMIT 1")
    Question getRandomQuestion();
}
