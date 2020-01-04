Homework Assignment #6 - Main Memory

<Exercise #1>

Question #1.
The heap allocates new chunks of RAM at the end of holes in memory. The 480-byte chunk was allocated at address 2144, which means that if the heap allocator allocates at the beginning of holes, it has to be allocated at address 2592(2112 + 480). Since it was allocated at the end, it was allocated at address 2144(2624 - 480). 

Question #2.
The heap allocator uses worst fit.
Once 100, 200, and 100-byte chunks are allocated and it's the 80-byte chunk's turn to be allocated, there are two options which are a space size of 112(512 - 100 - 200 - 100) and 128. If it was either first fit or the best fit, the 80-byte chunk would have allocated at address 2144, but instead it was allocated at address 3696. The 80-byte chunk was allocated at address 3969 because 128 was the biggest size when the 80-byte chuck is allocated.

Question #3.
The heap allocator uses none of the above.
If it was the first fit or the best fit, the 40-byte chuck would have allocated at address 1048. Or if it was the worst fit, the 40-byte chuck would have allocated at address 2584. 

Question #4.

The 40-byte chunk was allocated at address 2224
The 400-byte chunk was allocated at address 3676
The 80-byte chunk was allocated at address 2214
The 60-byte chunk was allocated at address 2204