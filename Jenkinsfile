@Library("Shared") _
pipeline {
    agent { label 'Neha' }

    stages {

        stage("hello") {
            steps {
                script {
                    hello()
                }
            }
        }

        stage("Cloning") {
            steps {
                script {
                    clone('https://github.com/ai-sciencers/Health_Insurance.git', 'main')
                }
            }
        }

        stage('Build Backend') {
            steps {
                dir('Backend') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Deploy (Docker Compose)') {
            steps {
                dir('.') {
                    sh 'docker-compose up -d --build'
                }
            }
        }
    }
}
