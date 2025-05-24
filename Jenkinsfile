pipeline {
    agent any
    environment {
        MAVEN_HOME = '/usr/share/maven'
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64' // Adjust for your environment
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
        IMAGE_NAME = 'inventory-service'
        AWS_REGION = 'us-east-1' // Change this to your AWS region
        ECR_REGISTRY = '203918864735.dkr.ecr.us-east-1.amazonaws.com/images-repo'
        ECR_REGISTRY_URL = '203918864735.dkr.ecr.us-east-1.amazonaws.com'
        ECR_REPO_NAME = 'inventory-repo'
        ECR_REPO_URI = "${ECR_REGISTRY_URL}/${ECR_REPO_NAME}"

}
    

    stages {
        stage('Checkout stage') {
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

        stage('Docker Build') {
            steps {
                sh ' docker build -t $IMAGE_NAME .'
            }
        }

        stage('Docker Tag') {
            steps {
                sh ' docker tag $IMAGE_NAME $ECR_REPO_URI:latest'
            }
        }

        stage('Docker Login to ECR') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'aws-creds', usernameVariable: 'AWS_ACCESS_KEY_ID', passwordVariable: 'AWS_SECRET_ACCESS_KEY')]) {
                sh '''
                    export AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID
                    export AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY
                    aws ecr get-login-password --region $AWS_REGION | \
                    docker login --username AWS --password-stdin $ECR_REGISTRY
                '''
                }

            }
        }


        













        stage('Push to ECR') {
            steps {
                sh ' docker push $ECR_REPO_URI:latest'
            }
        }
        
        stage('Approval for Deploy') {
            steps {
                input message: 'Proceed to deploy to Production?', ok: 'Deploy'
            }
        }


        stage('Deploy to Prod') {
            steps {
                script {
                    def deploymentFile = 'deploymentFile.yaml' // Adjust path
                    sh "sed -i 's|IMAGE_PLACEHOLDER|${ECR_REPO_URI}:latest|' ${deploymentFile}"
                    sh "kubectl apply -f ${deploymentFile} --namespace prod"
                }
            }
        }

        stage('Run Smoke Tests') {
            steps {
                sh './scripts/smoke_test.sh' // optional sanity check script
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
