pipeline{
agent any

stages{
stage('Checkout'){
steps{
checkout scm
}
}
stage('Build & Test'){
steps{
bat 'mvn verify'
}
}
}

post {
    always {
        script {
            if (fileExists('target/cucumber-html-report')) {
                publishHTML(target: [
                    reportDir: 'target/cucumber-html-report',
                    reportFiles: 'feature-overview.html',
                    reportName: 'Cucumber Test Reports'
                ])
            } else {
                echo 'Report folder not found — skipping publish'
            }
        }
    }
}