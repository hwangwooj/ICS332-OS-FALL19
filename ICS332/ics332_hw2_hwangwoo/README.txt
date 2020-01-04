Exercise #1

q1. Explain why the main process is not blocked while the cp process is running

In case of exercise #1, as soon as the first if(!fork()) statement is executed, fork() creates a child process and the second line of if(!fork()) is executed in child process while the else statement is executed in main process. Then, the second line of if(!fork()) creates another child process (grandchild process). And then, the child process executes exit(0); while the grandchild process executes 3rd to 4th lines. While the cp process is running, the child process of the main process already returned an exit status and therefore wait(NULL) will no longer block the main process while the cp process is running in grandchild process. 

q2. Explain why no zombie is left over by this program

No zombie is left over by this program because wait(NULL) will block main process until any of its children has finished. 


Exercise #2

q1. 40 seconds
q2. 50 seconds
q3. PID = 11
q4. PID = 11
q5. 30 seconds
q6. 20 seconds
q7. PID = 89
q8. PID = 11
q9. PID = 11, 89, 123

