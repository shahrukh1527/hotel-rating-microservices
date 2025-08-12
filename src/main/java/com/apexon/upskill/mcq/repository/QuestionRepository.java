package com.apexon.upskill.mcq.repository;

import com.apexon.upskill.mcq.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query(value = "SELECT * FROM question WHERE topic_id = :topicId ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Question> findRandomQuestionsByTopicId(@Param("topicId") Long topicId, @Param("count") int count);

}
