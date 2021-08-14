pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'Java'
    }
    stages {
        stage('Clean Complile Stage') {
            steps {
                echo 'Complile Stage'
                script {
                    bat 'mvn clean compile'
                }
            }
        }
        stage('Test Stage') {
            steps {
                echo 'Test Stage'
                script {
                    bat 'mvn test'
                }
            }
        }
        stage('Cucumber Reports') {
            steps {
	            echo 'Cucumber Reports'
                cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "**/*.json",
                jsonReportDirectory: 'target'
            }
        }
    }
}
