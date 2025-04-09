
pipeline {
    agent any

    environment {
        MAVEN_HOME = '/usr/share/maven'   
        // JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64' // Adjust for your environment
        // PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Supriyaram/inventory-service', branch: 'main'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
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
