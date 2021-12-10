package p04.restricted_generic;

import java.util.Arrays;

public class RestrictedGenericEx {
	public static void main(String[] args) {
		Course<Person> personCourse = new Course("일반인과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> workerCouse = new Course("직장인과정", 5);
//		workerCouse.add(new Person("일반인"));
		workerCouse.add(new Worker("직장인"));
//		workerCouse.add(new Student("학생"));
//		workerCouse.add(new HighStudent("고등학생"));		

		Course<Student> studentCourse = new Course("학생과정", 5);
//		studentCourse.add(new Person("일반인"));
//		studentCourse.add(new Worker("직장인"));
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		
		Course<HighStudent> highStudentCourse = new Course("고등학생과정", 5);
//		highStudentCourse.add(new Person("일반인"));
//		highStudentCourse.add(new Worker("직장인"));
//		highStudentCourse.add(new Student("학생"));
		highStudentCourse.add(new HighStudent("고등학생"));
		
		registerCourse(personCourse);
		registerCourse(workerCouse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		
//		registerCourseStudent(personCourse);
//		registerCourseStudent(workerCouse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCouse);
//		registerCourseWorker(studentCourse);
//		registerCourseWorker(highStudentCourse);	
	}
	
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()));
	}
	
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()));
	}
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생: " + 
				Arrays.toString(course.getStudents()));
	}
	
}
