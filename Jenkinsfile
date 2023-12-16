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

        stage (deploy_to_ec2) {
            steps {
                script {
                    def cp_html = 'sudo cp -r /home/ubuntu/* /var/www/html/'
                    sshagent(['ec2-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@54.194.76.102 ${cp_html}"
                    }
                }
            }
        }
    }
}
