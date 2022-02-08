import matplotlib.pyplot as plt
import numpy as np
from sklearn.cluster import KMeans

# customer data
age = np.array([18, 21, 22, 24, 26, 26, 27, 30, 31, 35, 39, 40, 41, 42, 44, 46, 47, 48, 49, 54])
spend = np.array([10, 11, 22, 15, 12, 13, 14, 33, 39, 37, 44, 27, 29, 20, 28, 21, 30, 31, 23, 24])
# create a 2D array
data = np.column_stack((age, spend))
plt.figure(1)
plt.scatter(age, spend)
# Specify the number of clusters (3) and fit the data X
kmeans = KMeans(n_clusters=3, random_state=0).fit(data)
y_kmeans = kmeans.fit_predict(data)
# Plotting the cluster centers and the data points on a 2D plane
plt.figure(2)
plt.scatter(data[:, 0], data[:, 1], c=y_kmeans)
plt.scatter(kmeans.cluster_centers_[:, 0], kmeans.cluster_centers_[:, 1], c='black')
plt.show()
