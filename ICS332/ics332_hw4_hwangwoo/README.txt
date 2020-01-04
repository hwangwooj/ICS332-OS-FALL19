Exercise 1)
Q1) graph size: 200 took 27.008 seconds.

Q3) 1 Thread:  (52.803 + 52.743 + 52.899 + 52.36 + 52.627)  /5 = 52.686
    2 Threads: (26.554 + 26.434 + 26.534 + 26.604 + 26.478) /5 = 26.521
    3 Threads: (17.808 + 17.823 + 17.737 + 17.811 + 17.771) /5 = 17.79
    4 Threads: (13.399 + 13.393 + 13.452 + 13.576 + 13.357) /5 = 13.435
    5 Threads: (11.032 + 10.585 + 10.687 + 10.744 + 10.873) /5 = 10.784
    6 Threads: (9.335 + 9.538 + 9.697 + 10.181 + 9.946)     /5 = 9.739
    7 Threads: (9.493 + 9.669 + 9.802 + 9.91 + 9.628 )      /5 = 9.700
    8 Threads: (9.883 + 9.636 + 9.72 + 10.088 + 9.822)      /5 = 9.830
    9 Threads: (9.395 + 10.17 + 10.129 + 10.71 + 10.352)    /5 = 10.151
   10 Threads: (9.703 + 9.819 + 10.071 + 9.81 + 10.207)     /5 = 9.922

[q1] How much faster does the program run with 2 threads when compared to using 1 thread?
1.99x faster

[q2] How many physical cores do you have on your machine?
6 cores

[q3] Is using more threads than the number of physical cores useful on your machine?
Not really. Using more threads makes it faster until using 6 threads, but using threads more than 6 seems not making it faster.

[q4] What is the largest acceleration factor you observe in your results when compared to the 1-thread case, and with how many threads?
The largest acceleration factor is the number of cores that are avilable to use.
How many threads? 2 threads.
