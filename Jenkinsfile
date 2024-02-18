/*def COLOR_MAP = [
    'SUCCESS': 'good', 
    'FAILURE': 'danger',
]*/

pipeline {
    agent any

    stages {
        stage ('fetch code') {
            steps {
                script {
                    echo "Pull source code from Git"
                    git branch: 'jenkins', url: 'https://github.com/seunayolu/jenkins_deploy_ec2.git'
                }
            }
        }

        /*stage ('Install Apache') {
            steps {
                script {
                    // Install Apache 2 On Ubuntu Server
                    def apache_install = 'sudo apt update && sudo apt install apache2 -y'
                    sshagent(['EC2-KEY']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@3.253.113.45 ${apache_install}"
                    }
                }
            }
        }*/
        
        stage ('Copy Files to EC2') {
            steps {
                script {
                    echo "Copying files to EC2 instance"
                    def git_clone = 'git clone https://github.com/seunayolu/jenkins_deploy_ec2 /opt/'
                    sshagent(['EC2-KEY']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@172.31.33.221 ${git_clone}"
                    }
                }
            }
        }
    }
}