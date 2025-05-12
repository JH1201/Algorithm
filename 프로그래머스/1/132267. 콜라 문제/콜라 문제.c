#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b, int n) {
    int answer = 0;
    
    while(n >= a) {

        int cola = (n/a) * b;
        answer += cola;
        n = (n%a) + cola;
        
    }
    return answer;
}
