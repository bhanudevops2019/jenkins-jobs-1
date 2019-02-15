job('sample') {
    label('SLAVE')
    steps {
        shell('hostname')
    }
}

pipelineJob('StudentProject-UI-CI') {
  description('StudentProject-UI-CI')
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps@2.63') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git@4.0.0-rc') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/citb34/jenkins-jobs.git')\
          }
        }

        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('pipeline-jobs/ci-jobs/Jenkinsfile')
      'lightweight'(true)
    }
  }
}

pipelineJob('StudentProject-UI-CI-CD-Release') {
  description('StudentProject-UI-CI-CD-Release')
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps@2.63') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git@4.0.0-rc') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/citb34/jenkins-jobs.git')\
          }
        }

        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('pipeline-jobs/cd-job/Jenkinsfile')
      'lightweight'(true)
    }
  }
}

pipelineJob('multi-repos-check') {
  description('multi-repos-check')
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps@2.63') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git@4.0.0-rc') {
        'configVersion'(2)
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/citb34/jenkins-jobs.git')\
          }
        }

        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/master')
          }
        }
      }
      'scriptPath'('pipeline-jobs/multi-repos.groovy')
      'lightweight'(true)
    }
  }
}

folder('harness-') {
    displayName('Project A')
    description('Folder for project A')
}

folder('project-a/testing') {
    description('Folder containing all QA jobs for project A')
}