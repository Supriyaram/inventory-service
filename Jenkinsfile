// Jenkinsfile for creating and testing webhook pipeline
pipeline {
    agent any

    stages {
        // not needed when pipeline script from SCM is used
        // stage('Checkout') {
        //     steps {
        //         git url: 'https://github.com/Supriyaram/inventory-service.git', branch: 'main'
        //     }
        // }

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
            echo 'failed, Something went wrong during the build'
        }
    }
  }

