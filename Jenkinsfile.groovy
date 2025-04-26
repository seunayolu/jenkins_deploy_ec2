pipeline {
    agent any

    parameters {
        string(name: 'EC2_IP', defaultValue: '54.75.33.241', description: 'EC2 Instance IP Address')
        string(name: 'GIT_BRANCH', defaultValue: 'jenkins', description: 'Git Branch to checkout')
        string(name: 'GIT_URL', defaultValue: 'https://github.com/seunayolu/jenkins_deploy_ec2.git', description: 'Git Repository URL')
        string(name: 'SSH_CREDENTIALS', defaultValue: 'ec2', description: 'SSH Credentials ID')
        string(name: 'REMOTE_USER', defaultValue: 'ubuntu', description: 'Remote SSH User')
    }

    stages {
        stage('Execute Pipeline') {
            steps {
                script {
                    // Load and execute the pipeline logic from script.groovy
                    def pipelineScript = load 'script.groovy'
                    pipelineScript.runPipeline(this)
                }
            }
        }
    }
}