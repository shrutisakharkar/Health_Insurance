@Library("Shared") _

pipeline {
    agent { label 'Neha' }

    environment {
        // Java 17 for Maven build
        JAVA_HOME = "/usr/lib/jvm/java-17-temurin"
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage("Hello") {
            steps {
                script {
                    hello()
                }
            }
        }

        stage("Clone Repository") {
            steps {
                script {
                    clone('https://github.com/ai-sciencers/Health_Insurance.git','main')
                }
            }
        }

        stage("Build Frontend") {
            steps {
                dir('Frontend') {
                    script {
                        sh "npm ci --silent"
                        sh "npm run build"
                        sh "docker build -t health-insurance-frontend:latest ."
                    }
                }
            }
        }

        stage("Build Backend") {
            steps {
                dir('Backend') {
                    script {
                        sh "mvn clean package -DskipTests"
                        sh "docker build -t health-insurance-backend:latest ."
                    }
                }
            }
        }

        stage("Deploy Services") {
            steps {
                dir("${WORKSPACE}") {
                    script {
                        sh "docker compose build --no-cache"
                        sh "docker compose up -d"
                        sh "docker compose ps"
                    }
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline finished"
            sh "docker compose logs --tail=50 || true"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
