ICS332
Woojoon Hwang
Pencil-and-Paper Assignment [50 pts] – Scheduling

<Exercise #1>

Question #1: 

[q1 (2 pts)]: B would be the one consists of just one infinitely long CPU burst. 
Since B and D both execute for 6ms, either B or D is the answer for this question. However, D seems to have the I/O burst because D -> A -> B -> C -> A -> B -> C -> A -> D looks like D wasn't executed for a while due to I/O burst. Therefore, B is the only one possible to consist of just one infinitely long CPU burst.

[q2 (2 pts)]: The answer is a job D.

[q3 (2 pts)]: I think the answer is a job A. Interactive jobs such using a text editor typically has just occasional small CPU bursts and many I/O bursts. Therefore, A is most likely a text editor.

Question #2:

[q1 (10 pts)]: IoIoIoIoCCo

[q3 (4 pts) ]: 0.024ms
Assume that context-switching overhead spends x milliseconds.
5x / (6+5x) * 100 = 2(%) 
5x is because overhead happens t times from that pattern, 6 + 5x is because total amount of time from that pattern is 6 ( 4 I's and 2 C's) + 5 overheads.
x turns out to be 0.024ms.


<Exercise #2>

Question #1: 

[q1 (5 pts)]: Job A ends up in the mid-priority queue
	      Job B ends up in the high-priority queue
	      Job C ends up in the mid-priority queue
	      Job D ends up in the low-priority queue
	      Job E ends up in the low-priority queue

[q2 (10 pts)]: D is placed in the mid-priority queue at 14ms. AAAABBCCCCDDDDEEEE... is an execution sequence. As soon as D uses its full time quantum, it is demoted to the mid-priority queue. Therefore the answer is 14.

Question #2:

[q1 (5 pts)]: AA BBBB AA B AA B...

[q2 (5 pts)]: Yes, the CPU runs a job B more than 25 % of the time in the long-run. Assume that the pattern has repeated x times. Then, the total would be (3x + 6) and the time job B spent would be (x + 4). Then, the CPU runs job B (x+4)/(3x+6) * 100(%) of the time. If x goes to infinity, the CPU runs job B about 33% because 4 and 6 are just constants which can be ignored. 

[q3 (5 pts)]: AA BBBB AA B AA B AA BBBB AA B AA B AA BBBB AA B AA B AA BBB...

