Feature: Create Announce

    Scenario: Create a new announce
        Given the request body is:
            """
            {
                "title": "test",
                "description": "test",
                "price": 100,
                "type": "VEHICLE"
            }
            """
        When the client sends a POST request to "/api/annonce"
        Then the response status code should be 201 CREATED