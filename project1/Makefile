all:
	ant -buildfile studentCoursesMgmt/src/build.xml all
run:
	ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=coursePref1.txt -Darg1=courseInfo1.txt -Darg2=regResults.txt -Darg3=regConflicts.txt -Darg4=errorLog.txt
clean:
	rm -rf studentCoursesMgmt/src/BUILD
	rm -rf studentCoursesMgmt/errorLog.txt
	rm -rf studentCoursesMgmt/regConflicts.txt
	rm -rf studentCoursesMgmt/regResults.txt
	rm -rf studentCoursesMgmt/registration_results.txt
	clear