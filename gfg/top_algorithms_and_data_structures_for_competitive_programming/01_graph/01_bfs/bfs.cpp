#include <bits/stdc++.h>

using namespace std;

class Graph
{
private:
    int V;
    list<int> *adj;

public:
    Graph(int V);
    void addEdge(int v, int w);
    void BFS(int s);
};

Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w);
}

void Graph::BFS(int s)
{
    bool *visited = new bool[V];

    for (int i = 0; i < V; i++) {
        visited[i] = false;
    }

    list<int> queue;
    queue.push_back(s);

    list<int>::iterator i;

    while (!queue.empty()) {
        int u = queue.front();
        cout << u << " ";
        queue.pop_front();

        for (i = adj[u].begin(); i != adj[u].end(); i++) {
            if (!visited[*visited]) {
                visited[*i] = true;
                queue.push_back(*i);
            }
        }
    }
}

int main()
{
    Graph g(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    g.BFS(2);

    return 0;
}
