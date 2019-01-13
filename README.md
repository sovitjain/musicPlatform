# musicPlatform
App for creating a music platform which can support user creation, playlist and tagging.

## Steps to run the application:
Import the project as a maven project.
run the below command:
```mvn spring-boot:run```

Following endpoint is exposed:
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
"tagName":"indi11"
}
Sample response:
{
    "id": 835,
    "tagName": "indi11",
    "playlist": [
        {
            "id": 676,
            "playlistName": "down the noise7",
            "views": 500,
            "user": {
                "id": 675,
                "name": "sovit6"
            }
        }
    ]
}
```
```
AutoSuggestTag - When a person submits a tag(or part of), search all tags and find the occurance of those tags in the playlist:
http://localhost:8080/autoSuggestTags?inputTagName=indi1
Method: GET
Sample response:
[
    {
        "tagName": "indi11",
        "playlistCount": 1
    },
    {
        "tagName": "indi10",
        "playlistCount": 1
    }
]
```
```
DisplaySuggestedTag - When a person selects a tag, search for that tag in all the playlist and recommend him tags based on the playlist and sort based on frequency of occurance:
http://localhost:8080/displaySuggestedTags?inputTagName=indi6
Method: GET
Sample response:
[
    {
        "tagName": "indi6"
    },
    {
        "tagName": "indi10"
    },
    {
        "tagName": "indi11"
    },
    {
        "tagName": "indi5"
    },
    {
        "tagName": "indi7"
    },
    {
        "tagName": "indi8"
    },
    {
        "tagName": "indi9"
    }
]
```
```
Display paginated playlist and sorted based on views:
http://localhost:8080/playlist?size=2&page=1
Method: GET
Note: default pagesize is 20 and page starts with index of 0
Sample response:
{
    "content": [
        {
            "id": 676,
            "playlistName": "down the noise7",
            "views": 500,
            "user": {
                "id": 675,
                "name": "sovit6"
            }
        },
        {
            "id": 677,
            "playlistName": "down the noise8",
            "views": 500,
            "user": {
                "id": 675,
                "name": "sovit6"
            }
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "offset": 2,
        "pageSize": 2,
        "pageNumber": 1,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 6,
    "totalPages": 3,
    "size": 2,
    "number": 1,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "numberOfElements": 2,
    "first": false,
    "empty": false
}
```
