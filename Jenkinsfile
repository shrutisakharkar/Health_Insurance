@Library("Shared") _

pipeline {
    agent { label 'Neha' }

    environment {
        // Java version for Maven build
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
