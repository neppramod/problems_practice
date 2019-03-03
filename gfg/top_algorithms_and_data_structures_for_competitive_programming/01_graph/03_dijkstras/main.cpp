#include <bits/stdc++.h>
#define V 9

using namespace std;

void printSolution(int dist[V], int n)
{
    for (int i = 0; i < n; i++) {
        cout << dist[i] << " ";
    }
    cout << endl;
}

int getMinimumIndex(int dist[V], bool sptSrc[V])
{
    int min_value = INT_MAX;
    int min_index;

    for (int i = 0; i < V; i++) {
        if (sptSrc[i] == false && dist[i] < min_value) {
            min_value = dist[i], min_index = i;
        }

    }

    return min_index;
}

void dijkstra(int graph[V][V], int source)
{
    int dist[V];
    bool sptSrc[V];

    for (int i = 0; i < V; i++) {
        dist[i] = INT_MAX;
        sptSrc[i] = false;
    }

    dist[source] = 0;

    for (int i = 0; i < V-1; i++) {
        int minIndex = getMinimumIndex(dist, sptSrc);
        sptSrc[minIndex] = true;

        for (int j = 0; j < V; j++) {
            if (!sptSrc[j] && graph[minIndex][j] && dist[minIndex] != INT_MAX && dist[minIndex] + graph[minIndex][j] < dist[j])
                dist[j] = dist[minIndex] + graph[minIndex][j];
        }
    }

    printSolution(dist, V);
}

int main()
{
    int graph[V][V] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                       {4, 0, 8, 0, 0, 0, 0, 11, 0},
                       {0, 8, 0, 7, 0, 4, 0, 0, 2},
                       {0, 0, 7, 0, 9, 14, 0, 0, 0},
                       {0, 0, 0, 9, 0, 10, 0, 0, 0},
                       {0, 0, 4, 14, 10, 0, 2, 0, 0},
                       {0, 0, 0, 0, 0, 2, 0, 1, 6},
                       {8, 11, 0, 0, 0, 0, 1, 0, 7},
                       {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

    dijkstra(graph, 0);

    return 0;
}
