import networkx as nx
import matplotlib.pyplot as plt

graph = {'Sparkill': ['Detroit', 'New York'],
         'Detroit': ['Miami'],
         'New York': ['Boston', 'Washington'],
         'Boston': [],
         'Washington': {'Miami'},
         'Miami': []
         }


def bfs(graphs, start):
    visited = []
    queue = [start]
    while queue:
        node = queue.pop(0)
        if node not in visited:
            visited.append(node)
            neighbors = graphs[node]
            for neighbor in neighbors:
                queue.append(neighbor)
    return visited


print(bfs(graph, 'Sparkill'))
