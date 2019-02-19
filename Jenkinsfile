pipeline {
  agent any
  stages {
    stage('Git Clone') {
      agent {
        node {
          label 'SLAVE'
        }

      }
      steps {
        git(url: 'https://github.com/citb34/studentapp-ui.git', branch: 'master')
      }
    }
    stage('Package') {
      agent {
        node {
          label 'SLAVE'
        }

      }
      steps {
        sh 'mvn package'
      }
    }
  }
}