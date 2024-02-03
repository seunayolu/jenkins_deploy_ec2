def COLOR_MAP = [
    'SUCCESS': 'good', 
    'FAILURE': 'danger',
]

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

        stage (deploy_to_ec2_) {
            steps {
                script {
                    echo "push content to ec2-ubuntu-server"
                    def cp_html = 'sudo cp -r /home/ubuntu/* /var/www/html/'
                    sshagent(['ec2-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@18.201.29.201 ${cp_html}"
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Slack Notifications.'
            slackSend channel: '#september-2023-foundation-class',
                color: COLOR_MAP[currentBuild.currentResult],
                message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL}"
        }
    }
}
