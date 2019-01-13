# MusicPlatform
App for creating a music platform which can support user creation, playlist and tagging.

## Steps to run the application:
Import the project as a maven project.
run the below command:
```mvn spring-boot:run```

## Architecture diagram

<img src="https://github.com/sovitjain/musicPlatform/blob/master/docs/Architecture_Diagram.png" alt="architecture diagram" width="600" height="200">

## AWS infrastructure diagram

<img src="https://github.com/sovitjain/musicPlatform/blob/master/docs/AWS_Infra.png" alt="aws infra diagram" width="700" height="500">

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
Display paginated playlist and sorted based on views along with selected tags:
http://localhost:8080/playlist?size=2&page=1
Method: GET
Note: default pagesize is 20 and page starts with index of 0
Sample response:
{
    "content": [
        {
            "id": 677,
            "playlistName": "down the noise8",
            "views": 500,
            "user": {
                "id": 675,
                "name": "sovit6"
            },
            "tags": [
                {
                    "id": 678,
                    "tagName": "indi6"
                }
            ]
        },
        {
            "id": 676,
            "playlistName": "down the noise7",
            "views": 500,
            "user": {
                "id": 675,
                "name": "sovit6"
            },
            "tags": [
                {
                    "id": 1569,
                    "tagName": "indi12"
                },
                {
                    "id": 678,
                    "tagName": "indi6"
                },
                {
                    "id": 803,
                    "tagName": "indi10"
                },
                {
                    "id": 707,
                    "tagName": "indi7"
                },
                {
                    "id": 1601,
                    "tagName": "indi13"
                },
                {
                    "id": 835,
                    "tagName": "indi11"
                },
                {
                    "id": 1633,
                    "tagName": "indi14"
                },
                {
                    "id": 739,
                    "tagName": "indi8"
                },
                {
                    "id": 771,
                    "tagName": "indi9"
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
    "totalPages": 3,
    "totalElements": 6,
    "last": false,
    "size": 2,
    "number": 1,
    "numberOfElements": 2,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": false,
    "empty": false
}
```
