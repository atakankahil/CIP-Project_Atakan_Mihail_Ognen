# CIP-Project_Atakan_Mihail_Ognen

1.Create Poll (POST):

Endpoint: /polls
Method: POST
Description: This API creates a new poll by accepting a question as a parameter in the request body. It initializes a Poll object, sets the provided question, and adds the poll to the database using the pollService.addPoll() method.

2.Get All Polls (GET):

Endpoint: /polls
Method: GET
Description: This API retrieves all the polls available in the database. It calls the pollRepository.findAll() method to fetch a list of all polls and returns it as a response.

3.Get Poll by ID (GET):

Endpoint: /polls/{id}
Method: GET
Description: This API retrieves a specific poll based on the provided id parameter. It calls the pollRepository.findById(id) method to find the poll in the database and returns it as a response.

4.Update Poll (PUT):

Endpoint: /polls/{id}
Method: PUT
Description: This API updates an existing poll identified by the provided id parameter. It checks if the poll exists in the database using pollRepository.findById(id). If found, it sets the id of the updated poll to the provided id and saves it to the database using pollRepository.save(updatedPoll). The updated poll is then returned in the response.

5.Delete Poll (DELETE):

Endpoint: /polls/{id}
Method: DELETE
Description: This API deletes a specific poll from the database based on the provided id parameter. It uses pollRepository.deleteById(id) to remove the poll, and returns a response with no content if the deletion is successful.

6.Vote in a Poll (PUT):

Endpoint: /polls/{id}/vote
Method: PUT
Description: This API allows users to vote in a poll by incrementing the vote count of a specific answer identified by the answerId parameter. It fetches the poll using pollRepository.findById(id) and increments the vote count of the corresponding answer. The updated poll is saved to the database using pollRepository.save(poll), and the updated poll is returned in the response.
  
