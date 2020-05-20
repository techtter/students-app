# students-app

## Sample Spring Boot Application
This is a simple Spring Boot App( students-app) uses MysQL database to store the students information.
The goal of this project is how we can build and deploy Spring Boot and MySQL on Kubernetes cluster.

## Create the jar file for Spring application
```
mvn clean install  
 or 
mvn -Dmaven.test.skip=true clean install     ## to skip the unit tests
```

## How to install Minikube on laptop
Follow the instructions here: https://kubernetes.io/docs/tasks/tools/install-minikube/

## How to install kubectl on laptop
Follow the instructions here: https://kubernetes.io/docs/tasks/tools/install-kubectl/

## Start Minikube
````
minikube start
````
## Connect your cli tool to docker-env of Kubernetes cluster
You should run this command after running 'minikube start'
````
eval $(minikube docker-env)  
````

## Commands To encode the admin password of mysql && username and password
````
echo -n 'admin123' | base64
echo -n 'testuser' | base64
echo -n 'testuser@123' | base64
````

## Build docker image for Spring Boot app
Before running this command ensure you already build the jar that is available in your project /target folder
````
docker build -t students-app:1.0 . 
````

## Pull MySQL docker image to your K8s docler-env
```
docker pull mysql:5.6
```

## Deploying Spring Boot & MySQL apps on K8s cluster
cd to /kuberenetes folder
````
kubectl apply -f mysql-configmap.yml

kubectl apply -f mysql-admin-secrets.yml

kubectl apply -f mysql-users-secrets.yml

kubectl apply -f mysql-deployment.yml

kubectl apply -f student-deployment.yml
````

## To check pods, services, deployments, confih maps are deployed successfully
````
kubectl get pods
kubectl get configmaps
kubectl get secrets
kubectl get deployments
`````

## Minikube dashboard overview
````
minikube dashboard
````
## To delete deployments, services etc
cd to /kuberenetes folder
````
kubectl delete -f .
````
## To stop Kubernetes cluster
````
minikube stop
````