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
                bat 'mvn clean verify -Dmaven.test.failure.ignore=true'
            }
        }
    }

    post {
        always {
            script {
                def reportPath = 'target/cucumber-html-report/feature-overview.html'

                if (fileExists(reportPath)) {
                    echo "Publishing Cucumber Report..."

                    publishHTML(target: [
                        reportDir: 'target/cucumber-html-report',
                        reportFiles: 'feature-overview.html',
                        reportName: 'Cucumber Test Reports',
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true
                    ])
                } else {
                    echo "⚠ Cucumber report not found. Skipping publish step."
                }
            }
        }
    }
}