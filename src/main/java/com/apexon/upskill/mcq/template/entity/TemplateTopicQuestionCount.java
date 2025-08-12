package com.apexon.upskill.mcq.template.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "template_topic_question_counts")
@Data
public class TemplateTopicQuestionCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic_id", nullable = false)
    private Long topicId;

    @Column(name = "count", nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;
}
