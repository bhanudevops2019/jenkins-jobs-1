node('SLAVE') {
    stage('SHELL'){
        sh 'hostname'
    }
}