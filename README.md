# CIP-Project_Atakan_Mihail_Ognen
So our project concantrates on building a basic Online Polling System using the 5 CRUD operations:
@PostMapping
    public void createPoll(String question){
        Poll poll = new Poll();      //creates a poll
        poll.setQuestion(question);  //it sets the poll's question with the given questions

        pollService.addPoll(poll);        //adds the poll to the database.
        
@GetMapping
    public ResponseEntity<List<Poll>> getPolls(){
        List<Poll> polls = pollRepository.findAll();  //gets all the polls
        return ResponseEntity.ok(polls);    
  
  
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
  
  
  
  
