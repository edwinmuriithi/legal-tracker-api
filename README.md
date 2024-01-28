# Legal Tracker Portal

We will be running 2 services
* Database
1. We will be pulling the MySQL image from dockerhub
2. It will contain volumes to allow for data persistance
3. It will be containing networks to allow for all services to be on the same network
* Backend
1. This will contain the image we were building earlier for the backend side.
2. It will be containing networks to allow for all services to be on the same network
> Client sends a request to the backend, backend either posts or fetches necessary data to/from database depending on the request type.

* To run the backend run the command below

       sudo docker compose up
         
---  