#include <stdio.h>
#include <unistd.h>

int main(int arc, char *argv[]){
char * const args[] = {"./hello", "-1", "ls", NULL};
execv("/Users/Kai/desktop/college/19_UH_FALL/ICS332/HW2/hello", args);
printf("This never gets executed...\n");
return 0;
}


