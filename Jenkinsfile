pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Continue build even if tests fail so report can generate
                bat 'mvn clean test -Dmaven.test.failure.ignore=true'
            }
        }
    }

    post {
        always {
            // Publish Allure report
            allure(
                includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
            )
        }
    }
}