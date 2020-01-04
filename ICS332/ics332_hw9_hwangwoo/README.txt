Homework Assignment #9 – Distributed Computing [40 pts]
Woojoon Hwang


Question F.q1.20 [10 pts]

- Since each node has 80 GB, we can run all 20 tasks at a time by each node running 5 tasks ( (80/16) * 4 = 20 ).
  So, we run 1 20-task job for the top level of the workflow.
- 1 20-task job takes time: 20*(2000/125) + 3600 + 20*(2000/1250)  = 3952 sec
- So the top level runs in time 3952 sec
- The bottom level is: 20 * (2000 / 1250) + 300 + (2000 / 125) = 348 seconds
- So in total: 3952 + 348 = 4300 seconds
        (actual simulated time: 4316.84243 seconds)



[F.q1.21] How much faster did the workflow execute in this execution when compared to the previous one (the answer from F.q1.16)?

Previous one takes 15100 seconds, whereas the current one takes 4300 seconds. The cluster has 4 8-core compute nodes is 3.5x faster than the previous one. (15100 / 4300 = 3.511627...)


[F.q1.22] What is the parallel efficiency (when we consider the sequential baseline as executing using a single core in total)? Compute it as a percentage using a simple formula.

The parallel efficiency is defined as: T(1) / (n*T(n)).

Using analytical times:
	T(1) = 20 * (16 + 3600 + 1.6) + 20 * 1.6 + 300 + 16 = 72700.0
	T(8) = 4300 (from f.q1.20)

	Efficiency = 72700.0 / (4300 * 32) = 0.53 (=0.528343023255814..)



[F.q1.23] Assuming we had been able to purchase 4 5-core compute nodes instead of 4 8-core compute nodes, what would the parallel efficiency have been?

Using analytical times:
	T(1) = 20 * (16 + 3600 + 1.6) + 20 * 1.6 + 300 + 16 = 72700.0
	T(5) = 4300 (from f.q1.20)

	Efficiency = 72700.0 / (4300 * 20) = 0.85 (=0.845348837209302..)



[F.q1.24] Assuming that you can add an arbitrary number of 5-core nodes, with the same per-core compute speed, is it possible to decrease the workflow execution time?

No. As long as you can run all 20 tasks at a time for the top level of the workflow, the workflow execution time is constant (4300 seconds).



[F.q1.25] What is the minimum number of 3-core nodes that achieves this fastest possible execution time?

In order to achieve the fastest execution time with 3-core nodes, we should run the first level of the workflow as one 20-task job. In order to do that, we need at least 20 cores. 7 nodes make this possible ( 3 * 7 = 21) even though there is a core which will be idle during the first level of the workflow. Therefore the answer is 7.

