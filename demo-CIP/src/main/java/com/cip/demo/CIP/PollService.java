package com.cip.demo.CIP;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//we need PollService to save a poll to database
@Service

public class PollService {
    private final IPollRepository pollRepository;

    public PollService(IPollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @PostMapping
    public  void addPoll(Poll poll){
//        Poll poll = new Poll();
//        poll.setQuestion(request.question());
       // poll.setAnswerList(request.answerList());
        pollRepository.save(poll);
    }

}
