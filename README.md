# Alertify

Alertify is a java application used for fetching metrics from an endpoint from another JVM based service which exposes an APi to fetch those metrics details. Alerity uses Quartz (An open souce java scheduling framework) for fetching the metrics in regular interval and pushing it into MYSQL database 
The application is can be hosted on kubernetes cluster or locally using miniKube 
Steps for local setUp to deploy in miniKube:
  1. Build the docker file to create a lates image for deployment
  2. docker build -t spring-boot-aoo:latest
  3. Deploy all .yaml under mysql-kube folder as MYSQL is needed for application statup
  4. Deploy the .yaml files present under application-kube folder
  5. Run minikube service app-svc

app-scv : The Kubernetes Service for accessign the application in k8 enrviroment
mysql-kube: Folder contains all .yaml neccessary for mysql deployment as pods on miniKube/K8 cluster 
application-kube: Folder contains .yaml neccessary for application deployment on miniKube/K8 cluster 
