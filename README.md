# link

Functionality:
The simple Spring application provides the following functionality:

1-User Authentication:

Users can log in to the application using their email and OTP (One-Time Password).


2-Note Management APIs:

Get All Notes: Retrieve all existing notes from the database.
Save a New Note: Create and store a new note in the database.
Update a Note: Modify the content of an existing note by its ID.
Delete a Note: Remove a note from the database based on its ID.
Note: The application's functionality is exposed via API endpoints that can be accessed using appropriate HTTP requests.
Note: When making requests to these APIs, ensure that the userId is included in the request body to access and perform operations on the notes associated with that specific user.

Also a postman collection is available, please import it in postman to understand how apis works, what are the responses and requests should be look like.
(https://github.com/mohamadjavadx/link/blob/master/link.postman_collection.json)



Running the Project:
To run the project, follow the steps below:

Step 1: Set up PostgreSQL Database

Ensure Docker is installed on your system.
Open a terminal or command prompt.
Execute the following command to run a PostgreSQL container with the necessary configuration:

docker run --name link-postgres -e POSTGRES_USER=mohamadjavad -e POSTGRES_PASSWORD=0022700900 -p 5432:5432 -d postgres

This command creates a PostgreSQL container named "link-postgres" and sets the username as "mohamadjavad" and password as "0022700900". The container will run on port 5432.

Step 2: Run the Application Locally

Ensure you have IntelliJ IDEA installed on your system.
Open IntelliJ IDEA.
Import the project into IntelliJ IDEA. (https://github.com/mohamadjavadx/link.git) (https://github.com/mohamadjavadx/link)
Configure the project's dependencies if necessary.
Build the project to ensure all dependencies are resolved.
Run the project using the appropriate run configuration in IntelliJ IDEA.
