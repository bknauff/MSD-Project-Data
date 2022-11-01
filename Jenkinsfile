node {
    stage ("Checkout DataService"){
        git branch: 'master', url: 'https://github.com/bknauff/MSD-Project-Data.git'
    }
    
    stage ("Gradle Build - DataService") {
	
        sh 'gradle clean build'

    }
    
    stage ("Gradle BootJar-Package - DataService") {
        sh 'gradle bootJar'
    }
    
    stage('User Acceptance Test - DataService') {
	
	  def response= input message: 'Is this build good to go?',
	   parameters: [choice(choices: 'Yes\nNo', 
	   description: '', name: 'Pass')]
	
	  if(response=="Yes") {

	    stage('Release- DataService') {
	     sh 'gradle build -x test -b spring-boot-project/build.gradle'
	     sh 'echo DataService is ready to release!'

	    }
	  }
    }
}
