// Jenkinsfile for creating and testing webhook pipeline
pipeline {
    agent any

    stages {

        stage('Build with webhook') {
            steps {
                echo 'basic webhook setup'
            }
        }
    }

    post {
        success {
            echo 'setup success'
        }
        failure {
            echo 'Something went wrong during the build'
        }
    }
  }

