def call(String repoUrl){
pipeline{
  agent any
  stages{
  	stage('git-checkout'){
  		steps{
  			checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'c6cc7d2f-a647-4055-b461-69cd231119bd', url: 'https://github.com/Appbank-Etech/Jenkins-parallel-job-team1.git']]])
  	  }
    } 
    stage('parallel-job by Mercy, Tunde, Yvonne'){
      parallel{
        stage('sub-job1 by Mercy'){
          steps{
            sh 'uptime'
          }
        }
        stage('sub-job2 by Tunde'){
          steps{
            sh 'free -m'
          }
        }
        stage('sub-job3 by Yvonne'){
            steps{
                sh 'ls -i'
            }
        }
      }
    }
    stage('parallel-job by Juliet & Yainkain'){
          parallel{
            stage('sub-job4 by Juliet'){
              steps{
                  sh 'ps -ef'
                }
              }
              stage('sub-job5 by Juliette'){
                steps{
                  sh 'du -h'
                }
              }
              stage('sub-job6 by yainkain'){
                steps{
                  echo "deployment"
                }
              }
            }
          }
    stage('parallel-job by Chris & Lydia'){
          parallel{
            stage('sub-job7 by Chris'){
              steps{
                  sh 'uname'
                }
              }
              stage('sub-job8 by Mercy'){
                steps{
                  echo 'My time has come'
                }
              }
              stage('sub-job9 by Lydia'){
                steps{
                  echo "DevOps is good"
                  echo "study DevOps now with your family"
                }
              }
            }
          }
    stage('user-info'){
      steps{
    	  sh 'cat /etc/passwd'
    	}
    }
    stage('Build Success'){
      steps{
        echo 'Hello This build is a success'
      }    
    }
    stage('Jenkins status check'){
      steps{
        sh 'bash /var/lib/jenkins/workspace/Appbank-jenkins-parallel-job/jenkins-status.sh'
      }
    }
  }
}

