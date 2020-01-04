#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
   int chunk_sizes[4];
   

   if ((argc != 2) || 
       (sscanf(argv[1], "%d,%d,%d,%d", &chunk_sizes[0], &chunk_sizes[1], &chunk_sizes[2], &chunk_sizes[3]) != 4) ||
       (chunk_sizes[0] < 0) || (chunk_sizes[1] < 0) || (chunk_sizes[2] < 0) || (chunk_sizes[3] < 0) ) {
      fprintf(stderr,"Usage: %s < a , b, c, d>\n", argv[0]);
      fprintf(stderr,"       where a, b, c, and d above must be >=0 integers (chunk sizes)\n");
      exit(1);
   }

   char *ptrs[9];
   unsigned long sizes[9] = {1024, 64, 1024, 512, 1024, 128, 1024, 64, 1024}; 

   for (int i=0; i < 9; i++) {
      ptrs[i] = (char *)calloc(sizes[i], sizeof(char));
      printf("%ld | ", (unsigned long)(ptrs[i]));
   }
   printf("\n--------------\n");

   for (int i=1; i < 9; i += 2) {
      free(ptrs[i]);
   }

   for (int i=0; i < 4; i++) {
	  if (chunk_sizes[i] > 0) {
   		char *chunk = (char *)calloc(chunk_sizes[i], sizeof(char));
   		printf("The %d-byte chunk was allocated at address %ld\n", chunk_sizes[i], (unsigned long)chunk);
	  }
   }
   exit(0);
}
