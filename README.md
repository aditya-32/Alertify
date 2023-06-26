# Alertify

Alertify is a java application used for fetching metrics from an endpoint from another JVM based service which exposes an APi to fetch those metrics details. Alerity uses Quartz (An open souce java scheduling framework) for fetching the metrics in regular interval and pushing it into MYSQL database 
The application is can be hosted on kubernetes cluster or locally using miniKube 
Steps for local setUp to deploy in miniKube:
  1. Build the docker file to create a latest image for deployment
  2. `docker build -t spring-boot-app:latest`
  3. Deploy all .yaml under mysql-kube folder as MYSQL is needed for application statup
  4. Deploy the .yaml files present under application-kube folder
  5. Run `minikube service app-svc`

mysql-kube: Folder contains all .yaml neccessary for mysql deployment as pods on miniKube/K8 cluster 
  1. `kubectl apply -f mysql-secret.yaml`
  2. `kubectl apply -f mysql-pvc.yaml`
  3. `kubectl apply -f mysql-pv.yaml`
  4. `kubectl apply -f mysql-deployment.yaml`
  5. `kubectl apply -f mysql-svc.yaml`
application-kube: Folder contains .yaml neccessary for application deployment on miniKube/K8 cluster
  1. `kubectl apply -f deployment.yaml`
  2. `kubectl apply -f app-svc.yaml`



# TODO


Integrate Helm for better k8 package management

Make endpoint configurable in runtime for future use case exposing UI for the purpose
