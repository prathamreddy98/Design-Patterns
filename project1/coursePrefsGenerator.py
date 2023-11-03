import random
import os
import string

def random_course_pref():
    random.shuffle(studentIDs)
    studentID = studentIDs[i]
    random.shuffle(courses)
    course_str = ' '.join(courses)
    student_record = f'{studentID} {course_str};'
    return student_record

studentIDs = list(range(111, 1000))
path = "studentCoursesMgmt/src/coursePrefs"
courses = ["A", "B", "C", "D", "E", "F", "G", "H", "I"]
numFiles = 3
numLines = 10  # lines in each file

os.makedirs(path, exist_ok=True)  # Checking for permission


for fileNum in range(1, numFiles + 1):
    fileName = os.path.join(path,f"coursePref{fileNum}.txt")
    with open(fileName, 'w') as file:
        for i in range(numLines):
            random_str = random_course_pref()
            file.write(random_str + '\n')

print(f"{numFiles} text files with coursePref have been created.")
