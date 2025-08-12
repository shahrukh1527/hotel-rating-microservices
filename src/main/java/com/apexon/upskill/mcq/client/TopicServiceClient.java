package com.apexon.upskill.mcq.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TopicServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public void validateTopic(Long topicId,Long skillId){
        String url = "http://topic-service/api/topics/"+ topicId;

        TopicResponse response = restTemplate.getForObject(url, TopicResponse.class);
        if(response==null){
            throw new TopicNotFoundException("Topic not found"+ topicId);
        }

        if(!response.getSkillId().equals(skillId)){
            throw new SkillNotFoundException("Skill mismatch for topic"+topicId);
        }
    }

}
