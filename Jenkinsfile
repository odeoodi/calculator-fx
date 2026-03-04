pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker_hub'
        DOCKERHUB_REPO = 'odeoodi/calculator-app'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/odeoodi/calculator-fx.git'
            }
        }

        stage('Build + Test') {
            steps {
                sh 'mvn -B clean verify'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(
                        credentialsId: env.DOCKERHUB_CREDENTIALS_ID,
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                      export PATH="/usr/local/bin:/opt/homebrew/bin:$PATH"
                      echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    '''
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                  export PATH="/usr/local/bin:/opt/homebrew/bin:$PATH"
                  docker version
                  docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} .
                '''
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                sh '''
                  export PATH="/usr/local/bin:/opt/homebrew/bin:$PATH"
                  docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}
                '''
            }
        }
    }
}