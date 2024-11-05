Feature: API Testing Put
@api
Scenario: Verify the request for put
 Given Load URL and Body fot put
 When Hit the put request
 Then Verify the response of put request 