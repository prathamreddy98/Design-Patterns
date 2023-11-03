import random
import os
import string
path = "studentCoursesMgmt/src/courseInfo"
courses = ["A","B","C","D","E","F","G","H","I"]
timing = ["11","22","33","44","55","66","77","88","99"]
maxSeats = 120
numFiles = 3
numLines = len(courses)

def random_course_info(course):
    seats = random.randint(1, maxSeats)
    time = random.choice(timing)
    return f"{course}:{seats}:{time}"

os.makedirs(path, exist_ok=True) #Checking for persmission

for fileNum in range(1, numFiles + 1):
    fileName = os.path.join(path,f"courseInfo{fileNum}.txt")
    with open(fileName, 'w') as file:
        for i in range(numLines):
            random_str = random_course_info(courses[i])
            file.write(random_str + '\n')

print(f"{numFiles} text files with courseInfo have been created.")