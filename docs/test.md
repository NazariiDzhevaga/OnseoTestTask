
<p align="center">
 <img title="Jenkins" src="./images/jenkins-emblem.png" width="400" height="250"/>
</p>

# <p name="Contents">Contents</p>

+ [Path to the Automation Jenkins site](#jenkins_site)
+ [Jobs description](#jobs_description)
  + [Test Automation job](#main_automation_job)
  + [Test Automation Ondemand job](#ondemand_job)
  + [Jenkins backup job](#backup_job)
  + [Test vault job](#vault_job)
+ [Job Build](#job_build)
+ [Job Configure](#job_configure)
  + [Add new test suite](#new_test_suite)
    + [Via Jenkins job configuration page](#via_Jenkins)
    + [Via the jenkinsfile](#via_jenkinsfile)
  + [Change number of build to keep](#change_build_number)
  + [Changing the branch to read the jenkinsfile](#change_branch)
  + [Changing the job run schedule](#change_job_schedule)
+ [Restart Jenkins node](#restart_Jenkins_node)

## <a name="jenkins_site">Path to the Automation Jenkins site:</a>

#### [https://lsm-web-jenkins.infra.ls-g.net/](https://lsm-web-jenkins.infra.ls-g.net/)

## <a name="jobs_description">Jobs description</a>

### <a name="main_automation_job">[Test Automation job](https://lsm-web-jenkins.infra.ls-g.net/job/Test-Automation/)</a>

Runs on a scheduled basis and sends the results via email
![img_2.png](images/main_job.png)

### <a name="ondemand_job">[Test Automation Ondemand job](https://lsm-web-jenkins.infra.ls-g.net/job/Test-Automation-Ondemand/)</a>

Executes primarily using the configuration specified in the test_config.xml file to obtain test results. You can also
run individual test suites from this configuration as needed
![img_2.png](images/test_ondemand.png)

### <a name="backup_job">[Jenkins backup job](https://lsm-web-jenkins.infra.ls-g.net/job/lsm_web_jenkins_backup/)</a>

This job automatically performs a backup, preserving important configurations and data for recovery purposes
![img_2.png](images/backup_job.png)

### <a name="vault_job">[Test vault job](https://lsm-web-jenkins.infra.ls-g.net/job/test-vault/)</a>

This job manages credential storage by interacting with a secure vault, ensuring sensitive information is stored and
accessed securely
![img_2.png](images/test_vault.png)

## <a name="job_build">Job Build</a>

+ Test Suite: Choose the desired test suite by selecting the XML name from the list of tests. Each job can run one or
  multiple test suites, though running a single test suite is recommended for greater stability
+ Environment: Choose the environment in which you want to run the tests from the Environment dropdown
+ Branch: In the Branch section, select the preferred branch to run the job. The default branch is main
+ SEND_MAIL Option: Enable the SEND_MAIL option to send Allure report results to the email addresses specified in the
  jenkinsfile.v2
  ![img_2.png](images/job_configure.png)

## <a name="job_configure">Job Configure</a>

### <a name="new_test_suite">Add new test suite</a>

There are two methods to add a new test suite XML file to a job configuration:

#### <a id="via_Jenkins">Via Jenkins job configuration page</a>

+ Navigate to the job’s Configure page on the Jenkins site
+ Scroll down to the section listing all test suites
+ Add the path to the new XML file
+ Click Save to apply the changes
  ![img_2.png](images/add_test_suite_via_jenkins_ui.png)

#### <a name="via_jenkinsfile">Via the jenkinsfile</a>

+ Open the Jenkinsfile associated with the job
+ Locate the section that lists all test suites
+ Add the path to the new XML file here

To apply the changes made in the Jenkinsfile, run any test from a branch containing the updated Jenkinsfile. This action
will trigger Jenkins to recognize the new XML file, and it should then appear in the Jenkins job configuration

![img_2.png](images/add_test_suite_via_jenkins_file.png)

### <a name="change_build_number">Change number of build to keep</a>

The Jenkins UI is limited to 30 builds. You may accessing older builds via the url with the build number, e.g.
lsm-web-jenkins.infra.ls-g.net/job/Test-Automation-Ondemand/{number of build}/
To change number of build to keep and time to save build navigate to job configure and find 'Discard old builds' section
![img_2.png](images/build_to_save.png)

### <a name="change_branch">Changing the branch to read the jenkinsfile</a>

If you need to use a modified Jenkinsfile from a branch other than main:

+ Navigate to the job’s Configuration page in Jenkins
+ Locate Pipeline > Branches to build > Branch Specifier
+ Change the branch specifier to the desired branch to read the updated Jenkinsfile
+ Apply and save
  This will configure the job to use the Jenkinsfile from the specified branch
  ![img_2.png](images/change_branch_to_read_jenkinsfile.png)

### <a name="change_job_schedule">Changing the job run schedule</a>

[Test Automation job](https://lsm-web-jenkins.infra.ls-g.net/job/Test-Automation/) is running with schedule. Every test
suite is defined with specific time to run
To apply new changes navigate to Job configuration -> Build Triggers
Define the following:

+ #Language-Specific-Tests: it is a commented name of test suite, for more understanding
+ Test Suite: specify the test suite XML file
+ Schedule: set the schedule using a cron expression
+ Branch: select the desired branch
+ SEND_MAIL: enable email notifications for test results
+ Environment: choose the environment to run the tests

We keep the data in the Jenkinsfile as an example, which is commented for reference

![img_2.png](images/job_schedule.png)

## <a name="restart_Jenkins_node">Restart Jenkins node</a>

After the remote machine is rebooted, the 'web-slave' node needs to be restarted. Follow the instructions below. If you
encounter any difficulties, please ask the DevOps team for assistance

+ ssh to slave
+ screen -ls ## check runned screens
+ scren -x <number of active screen> ## if screen exist, else:
+ screen -S jenkins_agent ## create new screen
+ export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home ## set needful java vers
+ echo $JAVA_HOME ## check java version in screen
+ '## run agent connection'
+ while :
  do
  DATE=`date -Iseconds`
  curl -sO https://lsm-web-jenkins.infra.ls-g.net/jnlpJars/agent.jar
  java -jar agent.jar -url https://lsm-web-jenkins.infra.ls-g.net/ -secret
  e87b6a3d33702043146b7e9ab8ddcf8a113007d4a7e4b931612a9d237a025cf8 -name "web-slave" -webSocket -workDir "
  /Users/jenkins" -failIfWorkDirIsMissing > lsm-web-jenkins-agent-logs/${DATE}.log 2>&1
  sleep 3600
+ done
+ CTRL A D ## to exit from screen
