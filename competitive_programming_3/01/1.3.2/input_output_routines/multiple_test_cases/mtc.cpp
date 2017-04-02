#include <stdio.h>

/**
   ./mtc < input.txt
   3
   12
   9
 */
int main()
{
    int N;   // No. of test cases
    int a;   // first value on each line
    int b;   // second value on each line

    scanf("%d", &N);
    while (N--) {  // until N is zero
        scanf("%d %d", &a, &b);
        printf("%d\n", a + b);
    }
}
