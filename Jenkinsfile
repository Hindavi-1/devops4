pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk-25.0.2'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/Hindavi-1/devops4.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                deploy adapters: [
                    tomcat9(
                        credentialsId: 'tomcat-creds',
                        path: '',
                        url: 'http://localhost:8081'
                    )
                ],
                contextPath: 'exp4',
                war: 'target/*.war'
            }
        }
    }
}