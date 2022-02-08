import math

#ESTIMATE THE VALUE OF PI USING ARCHIMEDES METHOD
#Created by Gianni Esposito

def archimedes_method():
    polygon_sides = 8
    angle_b = 360.0 / polygon_sides
    angle_a = angle_b / 2
    half_of_side_s = math.sin(math.radians(angle_a))
    side_s = half_of_side_s * 2
    polygon_circumference = polygon_sides * side_s
    estimated_pi = polygon_circumference / 2
    print(f"Estimated value of pi: {estimated_pi}")


archimedes_method()
