pipeline {
    agent any

    // environment {
    //     MAVEN_HOME = '/usr/share/maven'   // Adjust if your Maven is installed elsewhere
    // }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Supriyaram/inventory-service.git', branch: 'main'
            }
        }

        stage('Build with Maven') {
            steps {
                // sh 'mvn clean install'
                echo 'doneeeeeeeee'
            }
        }

    //     stage('Archive Artifact') {
    //         steps {
    //             archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    //         }
    //     }
    }

    post {
        success {
            echo 'Build and archive successful!'
        }
        failure {
            echo 'Something went wrong during the build.'
        }
    }
  }

