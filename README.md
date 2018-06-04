
Skeleton project for Backend Technical Assessment.

Includes
--------
- Maven - [pom.xml](pom.xml)
- Application properties - [application.yml](src/main/resources/application.yml)
- Runnable Spring Boot Application - [BackendTechAssessmentApplication](src/main/java/com/intuit/cg/backendtechassessment/BackendTechAssessmentApplication.java)
- REST endpoints - [RequestMappings.java](src/main/java/com/intuit/cg/backendtechassessment/controller/requestmappings/RequestMappings.java)

Requirements
------------
See Backend Technical Assessment document for detailed requirements.

Supports following URLS:

Create Project: 
URL = http://localhost:8080/projects
Method = POST
Body = {
	"name": "Project1",
	"description": "Description for Project1",
	"bidDeadline": "2018-06-04T03:40:00.511Z",
	"postedBy": "seller1"
}

Create a Bid:
URL = http://localhost:8080/bids
Method = POST
Body = {
	"projectId": "Project1",
	"bidAmount": "45",
	"bidderId": "buyer2"
	
}

Update a Bid:
URL = http://localhost:8080/bids/Project1buyer1
where "Project1buyer1" => Bid ID (formed by concatenating ProjectId and BidderId)
Method = PUT
Body = {
	"projectId": "Project1",
	"bidAmount": "40",
	"bidderId": "buyer1"
	
}

Get a Project by Id:
Method = GET
URL = http://localhost:8080/projects/Project2

Get All Bids for a Project
URL = http://localhost:8080/projects/Project1/bids
where "Project1" = project id


Exercise Difficulty: Easy
How did you feel about the exercise itself? 10
How do you feel about coding an exercise as a step in the interview process?  10
What would you change in the exercise and/or process? Nothing