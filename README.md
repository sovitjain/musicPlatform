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
