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

post{
always{
publishHTML(target:[
reportDir: 'target/cucumber-html-report',
reportName: 'Cucumber Test Reports',
reportFiles: 'feature-overview.html'


])



}

}

}