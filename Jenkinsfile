pipeline {
    agent any

    // environment {
    //     MAVEN_HOME = '/usr/share/maven'   // Adjust if your Maven is installed elsewhere
    // }

    stages {
        

        stage('Build with Maven') {
            steps {
                // sh 'mvn clean install'
                echo 'done dana doneeeeeeeee'
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
            echo 'Build and webhook aaaaaaaaaaaa successful'
        }
        failure {
            echo 'Something went wrong during the build.'
        }
    }
  }

