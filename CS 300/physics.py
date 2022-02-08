import numpy as np


# Finds the sequence of times when the ball passes each half meter assuming the ball is dropped at t=0
# Create a NumPy array named y that goes from 10 to 0 in increments of -0.5 using the arrange function
# Solve position equation given above for t
# Then using this equation create a NumPy array called t to hold the times when the ball passes each half meter.
# Find the avg velocity for each time interval and store the results in an array called Y using the two arrays (y and t)
# Remember (from physics) that the average velocity over an interval \Delta t is defined as \bar{v} = \Delta y/\Delta t
# Output all three arrays.
# by Gianni Esposito

# Function to find the time it takes
def find_time(a, height_at_zero):
    # gravity = 9.8 m/s
    gravity = 9.8
    time = np.sqrt(2 * (height_at_zero - a) / gravity)
    return time


# create array from 10 to 0 in increments of -0.5 and find the time when the ball passes each half meter
y = np.arange(10, 0, -0.5)
start_height = 10
times = find_time(y, start_height)

# find average velocity using the previous stored times
deltaY = y[1:] - y[:-1]
deltaT = times[1:] - times[:-1]
velocity = deltaY / deltaT

# Print all 3 arrays
print('heights: {}'.format(y))
print('times: {}'.format(times))
print('velocity: {}'.format(velocity))
