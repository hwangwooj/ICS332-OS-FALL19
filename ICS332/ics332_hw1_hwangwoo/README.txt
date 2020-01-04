Exercise #1: Spying on a the "du" program [16 pts]

Q1. What is the full absolute path to the standard C library file on your system?
A) open("/lib/x86_64-linux-gnu/libc.so.6", O_RDONLY|O_CLOEXEC) = 3

Q2. How many times does du try to open a file but fails? Explain how you counted this number (or just show your command-line if you used command-line tool to do this).
A) strace -c du -sh

Q3. How many different system calls does du place? Explain how you made this determination? (this should be a number between 0 and 30)
A) 16 different system calls. If I enter "strace -c du -sh" on command line, different system calls are displayed on the right side.

Q4. Cut-and-paste the output of time (which will vary slightly from one invocation to the next, just pick one)
A) 20M  .

real    0m0.007s
user    0m0.000s
sys     0m0.004s

Q5. Based on the output of time, what percentage of the execution time of the du command is spent doing I/O? Show your work.
A) I/O time = Real time - user time - system time = 0.007s - 0.000s - 0.004s = 0.003s
   (0.003s / 0.007s) * 100 = 42.857(%)

Q6. Based on the output of time and the strace output in previous question, how much CPU time, in microseconds, is spent on average to execute the instructions of a system call (counting only those calls that succeed)? Sh$
A)  Average time spent to execute is 0.000000s. This can be easily found by the result from "strace -c du -sh".


Exercise #2: Is wget getting what it's  asking for? [24 pts]

Q1. How many system calls are placed by wget before it receives the first bytes from the file content? Explain how you made that determination.
A)  First, enter command "sudo strace -x -o ex2_output wget http://norvig.com/big.txt".
    Second, enter command "grep -n "The Project Gutenberg" ex2_output".
    It displays "269:read(3, "The Project Gutenberg EBook of T"..., 8192) = 2896"
                "271:write(4, "The Project Gutenberg EBook of T"..., 2896) = 2896"
    Therefore, 268 system calls are placed by wget before it receives the first bytes from the file content.

Q2. How many bytes does wget typically attempts to read from the file at a time typically (e.g., the buffer size)? Justify your answer by giving in your report one line of the strace output as an example.
A)  read(3, "dents in that period, except Joh"..., 8192) = 1448
    wget typically attempts to read 8192 bytes.

Q3. How many times does  wget  attempt to read pieces of file content, in total? Explain how you made that determination.
A)  3760 in total. Command: grep -c "read(3" ex2_output prints only a count of the lines that match a pattern, which is "read(3".

Q4. Out of these, how many times the read system call does NOT receive the number of bytes it wants? Explain how you made this determination.
A)  0 time. There is 0 error from read system call when I use strace by using command: strace -c wget http://norvig.com/big.txt

Q5. Do you conclude that wget typically fills its buffer or not?
A)  It depends on whether its read buffer or write buffer. Read system call usually do not fill its buffer but write system call usually fills its buffer.

Q6. How many times does wget attempt to read pieces of file content, in total?
A)  3235 in total.

Q7. Out of these, how many times read does NOT receive the number of bytes it wants?
A)  0 time.

Q8. Do you conclude that wget typically fills its buffer or not?
A)  It depends on whether its read buffer or write buffer. Read system call usually do not fill its buffer but write system call usually fill its buffer.

Q9. Why do you think results are different than in the previous experiment?
A)  I think results are different because downloaded files are different.

