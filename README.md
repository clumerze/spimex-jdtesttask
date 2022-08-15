**Service endpoints**

    curl -i -X POST 'http://localhost:8080/api/payment/{shop|online}/{amount}'

    curl -i 'http://localhost:8080/api/bankAccountOfEMoney'

**Scripts and other files**
    
- build_and_launch.sh - builds a project and runs it in docker. Requires a jdk along the path /opt/java/17_0_2.
- test.sh - makes the requests listed in the task
- test-result.json - example of test result


