# Framework
    Springboot
    Java
# Design Pattern
   Factory
   Singleton
   MVC
# Rest Methods
   Get
   Put
   Post
# Database
   H2 Inbuild Memory
# Restservice
     Consumes Restservice
     RestServiceTemplate.java uses RestTemplate to consume restservice
     It is designed to consume any restservice calls
# Hosted
      Hosted in AWS EC2
# Sample URLS
     GET : http://52.36.153.114:8080/product-services/product/13860428
     POST : http://52.36.153.114:8080/product-services/product
          {"productId":13867787,"price":29.1,"code":"USD"}
     PUT : http://52.36.153.114:8080/product-services/product/13867787
           {"productId":13867787,"price":39.1,"code":"USD"}
# Validation :
      The Post body and Get URL path variables are validated

# Logging : Log4J 
      Following MDC Pattern for logging
      Config details in Log4J.properties
# Output
   Json Response
# Splunk Reports 

	https://github.com/ganeshrs1984/Consuming-Restservice/blob/master/workspace-pricing/Splunk%20Dashboard%20-%20Product%20RestService.pdf
