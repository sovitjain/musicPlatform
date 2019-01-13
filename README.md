# MusicPlatform
App for creating a music platform which can support user creation, playlist and tagging.

## Technology Used:
Java, Spring Boot, JpaRepository, H2 DB

## Steps to run the application:
Import the project as a maven project.
run the below command:
```mvn spring-boot:run```

## Architecture diagram

<img src="https://github.com/sovitjain/musicPlatform/blob/master/docs/Architecture_Diagram.png" alt="architecture diagram" width="600" height="200">

## AWS infrastructure diagram

<img src="https://github.com/sovitjain/musicPlatform/blob/master/docs/AWS_Infra.png" alt="aws infra diagram" width="700" height="500">

### Alternate Serverless approach:

<img src="https://github.com/sovitjain/musicPlatform/blob/master/docs/Serverless_Approach.png" alt="aws infra diagram" width="700" height="400">

``` Note: To go for serverless vs EC2 approach will solely depend upon traffic pattern. A couple of MM transaction a day is fine with serverless beyond that EC2 approach will win. To further reduce the cost of EC2, we can opt for ECS approach, where we can share the container with another apps and leverage full utilization of hardware capacity.```

## DB design:
<img src="https://github.com/sovitjain/musicPlatform/blob/master/docs/DB_design.PNG" alt="db design" width="800" height="400">

## AWS hosting
The spring boot application is hosted in EC2 instance.
```IP address - 3.89.98.255 (replace localhost with this ip address)```

## Following endpoint is exposed:
```
Create a User:
http://localhost:8080/user
Header
Content-Type:application/json
Body:
{
  "name":"sovit"
}
Sample response:
{
    "id": 3,
    "name": "sovit"
}
```
```
Create a Playlist:
http://localhost:8080/user/{userId}/playlist
Header
Content-Type:application/json
Body:
{
"playlistName":"down the noise",
"views":500
}
Sample response:
{
    "id": 4,
    "playlistName": "down the noise",
    "views": 500,
    "user": {
        "id": 3,
        "name": "sovit"
    }
}
```
```
Create a Tag:
http://localhost:8080/playlist/{playlistId}/tags
Header
Content-Type:application/json
Body:
{
"tagName":"indi15"
}
Sample response:
{
    "id": 1635,
    "tagName": "indi15"
}
```
```
AutoSuggestTag - When a person submits a tag(or part of), search all tags and find the occurance of those tags in the playlist:
http://localhost:8080/autoSuggestTags?inputTagName=i
Method: GET
Sample response:
[
    {
        "tagName": "indie rock",
        "playlistCount": 2
    },
    {
        "tagName": "indie pop",
        "playlistCount": 1
    },
    {
        "tagName": "ind",
        "playlistCount": 1
    }
]
```
```
DisplaySuggestedTag - When a person selects a tag, search for that tag in all the playlist and recommend him tags based on the playlist and sort based on frequency of occurance:
http://localhost:8080/displaySuggestedTags?inputTagName=indie rock
Method: GET
Sample response:
[
    {
        "tagName": "FloFilz"
    },
    {
        "tagName": "indie rock"
    },
    {
        "tagName": "Philanthrope"
    },
    {
        "tagName": "Evil Needle"
    },
    {
        "tagName": "indie pop"
    },
    {
        "tagName": "summer"
    },
    {
        "tagName": "ind"
    }
]
```
```
Display paginated playlist and sorted based on views along with selected tags:
http://localhost:8080/playlist?size=2&page=1
Method: GET
Note: default pagesize is 20 and page starts with index of 0
Sample response:
{
    "content": [
        {
            "id": 3,
            "playlistName": "CoffeeHouse",
            "views": 200,
            "user": {
                "id": 3,
                "name": "Tim"
            },
            "tags": [
                {
                    "id": 5,
                    "tagName": "indie rock"
                },
                {
                    "id": 8,
                    "tagName": "ind"
                },
                {
                    "id": 1,
                    "tagName": "FloFilz"
                },
                {
                    "id": 3,
                    "tagName": "Evil Needle"
                },
                {
                    "id": 6,
                    "tagName": "summer"
                },
                {
                    "id": 2,
                    "tagName": "Philanthrope"
                },
                {
                    "id": 4,
                    "tagName": "indie pop"
                }
            ]
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 2,
        "pageNumber": 1,
        "pageSize": 2,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalElements": 3,
    "totalPages": 2,
    "size": 2,
    "number": 1,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "numberOfElements": 1,
    "first": false,
    "empty": false
}
```
## Testing via SQL:
The sql files necessary for testing is stored in docs folder:
https://github.com/sovitjain/musicPlatform/blob/master/docs/dml_script_test.sql
https://github.com/sovitjain/musicPlatform/blob/master/docs/query_to_test_problem_statement.sql

![user playlist](https://github.com/sovitjain/musicPlatform/blob/master/docs/user_playlist.screenshot.PNG)
![tags playlist](https://github.com/sovitjain/musicPlatform/blob/master/docs/tags_playlist.screenshot.PNG)
![problem statement 1 and 2](https://github.com/sovitjain/musicPlatform/blob/master/docs/problem_statement_1_2.PNG)
![problem statement 3](https://github.com/sovitjain/musicPlatform/blob/master/docs/problem_statement_3.PNG)
