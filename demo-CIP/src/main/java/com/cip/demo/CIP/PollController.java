package com.cip.demo.CIP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polls")

public class PollController {

    private final IPollRepository pollRepository;

    private final PollService pollService;

    public PollController(IPollRepository pollRepository, PollService pollService) {
        this.pollRepository = pollRepository;
        this.pollService = pollService;
    }

    @PostMapping
    public void createPoll(String question){
        Poll poll = new Poll();      //creates a poll
        poll.setQuestion(question);  //it sets the poll's question with the given questions

        pollService.addPoll(poll);        //adds the poll to the database.

    }

    @GetMapping
    public ResponseEntity<List<Poll>> getPolls(){
        List<Poll> polls = pollRepository.findAll();  //gets all the polls
        return ResponseEntity.ok(polls);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id){
        Optional<Poll> poll = pollRepository.findById(id);  //gets the poll by id using the provided id
        return poll.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Poll> updatePoll (@PathVariable Long id, @RequestBody Poll updatedPoll){
        Optional<Poll> existingPoll  = pollRepository.findById(id);  //finds the existin poll by id using the provided id
        if(existingPoll.isPresent()){
            updatedPoll.setId(id);     //sets the old poll's id to the updated Poll which is provided
            Poll savedPoll = pollRepository.save(updatedPoll);   //saves the new poll to database
            return ResponseEntity.ok(savedPoll);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoll(@PathVariable Long id){
        Optional<Poll> existingPoll = pollRepository.findById(id);  //gets the poll by id
        if(existingPoll.isPresent()){
            pollRepository.deleteById(id);   //this deletes it from databse
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }
    //Method not working error
    @PutMapping("/{id}/vote")
    public ResponseEntity vote(@PathVariable Long id, @RequestParam Long answerId){
        Optional<Poll> optionalPoll = pollRepository.findById(id);  // we get the poll by id
        if(optionalPoll.isPresent()){
            Poll poll = optionalPoll.get();
            List<Answer> answers = poll.getAnswerList();  //this gets the answers from the poll

            for(Answer answer : answers){   // we iterate through each vote
                if(answer.getId().equals(answerId)){     //untill we find the vote with answerId
                    answer.setVoteCount(answer.getVoteCount()+1);  //we increment its vote count
                    break;
                }
            }

            Poll updatedPoll = pollRepository.save(poll);  // we update the old poll
            return ResponseEntity.ok(updatedPoll);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


    //this is hard coded
    @Autowired
    public void addPoll() {
        Poll poll = new Poll();
        poll.setQuestion("Favorite Color?");


        Answer ans1 = new Answer();
        Answer ans2 = new Answer();
        Answer ans3 = new Answer();
        ans1.setText("Answ1");
        ans2.setText("Ans2");
        ans3.setText("Ans3");


        poll.setAnswerList(Arrays.asList(ans1,ans2,ans3));
        Poll poll1 = new Poll();
        poll1.setQuestion("Favorite Animal?");
        // Set other attributes


        pollRepository.save(poll);
        pollRepository.save(poll1);
    }

}
