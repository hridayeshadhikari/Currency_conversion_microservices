The currency-network is a Docker bridge network specifically created for the microservices architecture of the currency exchange application. 
It enables secure communication and data exchange between the different components of the system. 
This network is defined within the docker-compose.yml file and is used by all services listed below to ensure seamless interaction:

1. currency-exchange: Service responsible for handling currency exchange operations.
2. currency-conversion: Service responsible for currency conversion calculations.
3. api-gateway: Service acting as the entry point for clients, routing requests to the appropriate microservices.
4. zipkin-server: Server for distributed tracing, facilitating visibility into requests across services.
5. service-registry: Registry for service discovery and registration using Eureka.
6. rabbitmq: Message broker facilitating asynchronous communication between services.

Using a dedicated network isolates the application's internal traffic, enhancing security and encapsulating the communication channels within the Docker ecosystem. 
This approach simplifies deployment and maintenance, ensuring efficient operation of the currency exchange application.

