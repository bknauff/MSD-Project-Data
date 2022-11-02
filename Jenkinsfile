node {
    stage ("Checkout DataService"){
        git branch: 'main', url: 'https://github.com/bknauff/MSD-Project-Data.git'
    }
    
    stage ("Gradle Build - DataApi") {
        sh 'gradle clean build'
    }
    
    stage ("Gradle Bootjar-Package - DataApi") {
        sh 'gradle bootjar'
    }
    
    stage ("Containerize the app-docker build - DataApi") {
        sh 'docker build --rm -t msdevent-data:v1.0 .'
    }
    
    stage ("Inspect the docker image - DataApi"){
        sh "docker images msdevent-data:v1.0"
        sh "docker inspect msdevent-data:v1.0"
    }
    
    stage ("Run Docker container instance - DataApi"){
        sh "docker run -d --rm --name msdevent-data -p 8080:8080 msdevent-data:v1.0"
     }
    
    stage('User Acceptance Test - DataApi') {
	
	  def response= input message: 'Is this build good to go?',
	   parameters: [choice(choices: 'Yes\nNo', 
	   description: '', name: 'Pass')]
	
	  if(response=="Yes") {
	    stage('Deploy to Kubenetes cluster - DataApi') {
	      sh "kubectl create deployment msdevent-data --image=msdevent-data:v1.0"
	      sh "kubectl expose deployment msdevent-data --type=LoadBalancer --port=8080"
	    }
	  }
    }

    stage("Production Deployment View"){
        sh "kubectl get deployments"
        sh "kubectl get pods"
        sh "kubectl get services"
    }
  
}