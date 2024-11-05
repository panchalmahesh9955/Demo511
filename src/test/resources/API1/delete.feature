Feature: API Testing delete
@api
Scenario: Verify the request for delete
 Given Load URL and Body for delete
 When Hit the delete request
 Then Verify the response of delete request 