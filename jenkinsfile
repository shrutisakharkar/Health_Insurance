@Library("Shared") _
pipeline {
   agent { label 'shruti' }
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
                 script{      
                clone('https://github.com/shrutisakharkar/django-notes-app.git','main') 
                   } 
            }
        }
        stage('build') {
            steps {
                script {
                    docker_build("notes-app", "latest", "shrutisakharkar")
                }
            }
        }
        stage("push to dockerhub") {
            steps {
                script {
                    docker_push("notes-app", "latest", "shrutisakharkar")
                }
            }
        }
        stage('deploying') {
            steps {
                echo "deploying"
                sh "docker compose up -d"
            }
        }
    }
}
