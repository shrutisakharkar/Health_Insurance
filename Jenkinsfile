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
                 script{      
                clone('https://github.com/ai-sciencers/Health_Insurance.git','main') 
                   } 
            }
        }
        stage('build') {
            steps {
                script {
                   dir ('Frontend'){
                    sh "docker build -t health-insurance:latest ."
                   }
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
