pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn -B clean test package'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t expense-tracker:latest .'
            }
        }
    }
    post {
        success { echo 'Expense Tracker pipeline completed successfully.' }
        failure { echo 'Pipeline failed. Check the console output.' }
    }
}
