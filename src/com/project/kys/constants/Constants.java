package com.project.kys.constants;

public class Constants {
	
	public static class DB {
		public static String CLASS = "com.mysql.jdbc.Driver";
		public static String NAME = "KnowYourSubject";
		public static String URL = "jdbc:mysql://localhost:3306/" + NAME;
		public static String USER = "knowyoursubject";
		public static String PWD = "kn0wy0ursubject";
		
	}
	
	public static class RestResourcePaths {
		
		public static class RegistrationPath {
			public static final String CLASS = "/registration";
			public static final String REGISTER_USER = "/registeruser";
		}
		
		public static class AuthenticationPath {
			public static final String CLASS = "/authentication";
			public static final String LOGIN = "/login";
			public static final String RETRIEVE_PASSWORD = "/retrievepassword";
			public static final String CHANGE_PASSWORD = "/changepassword";
		}
		
		public static class ProfessorPath {
			public static final String CLASS = "/professor";
			public static final String ADD_PROFESSOR = "/addprofessor";
			public static final String UPDATE_PROFESSOR = "/updateprofessor";
			public static final String DELETE_PROFESSOR = "/deleteprofessor";
			public static final String GET_PROFESSOR_LIST_4_COURSE = "/getprofessorlist4course";
			public static final String GET_PROFESSOR = "/getprofessor";
			public static final String GET_ALL_PROFESSOR = "/getallprofessors";
		}
		
		public static class CoursePath {
			public static final String CLASS = "/course";
			public static final String ADD_COURSE = "/addcourse";
			public static final String UPDATE_COURSE = "/updatecourse";
			public static final String DELETE_COURSE = "/deletecourse";
			public static final String GET_COURSE_LIST_4_MAJOR = "/getcourselist4major";
			public static final String GET_COURSE_LIST_4_PROFESSOR = "/getcourselist4professor";
			public static final String GET_COURSE = "/getcourse";
		}
		
		public static class MajorPath {
			public static final String CLASS = "/major";
			public static final String ADD_MAJOR = "/addmajor";
			public static final String UPDATE_MAJOR = "/updatemajor";
			public static final String DELETE_MAJOR = "/deletemajor";
			public static final String GET_MAJOR_LIST_4_DEPARTMENT = "/getmajorlist4department";
			public static final String GET_MAJOR = "/getmajor";
		}
		
		public static class DepartmentPath {
			public static final String CLASS = "/department";
			public static final String ADD_DEPARTMENT = "/adddepartment";
			public static final String UPDATE_DEPARTMENT = "/updatedepartment";
			public static final String DELETE_DEPARTMENT = "/deletedepartment";
			public static final String GET_DEPARTMENT_LIST_4_DISCIPLINE = "/getdepartmentlist4discipline";
			public static final String GET_DEPARTMENT = "/getdepartment";
			public static final String GET_ALL_DEPARTMENT = "/getalldepartments";
		}
		
		public static class DisciplinePath {
			public static final String CLASS = "/discipline";
			public static final String ADD_DISCIPLINE = "/adddiscipline";
			public static final String UPDATE_DISCIPLINE = "/updatediscipline";
			public static final String DELETE_DISCIPLINE = "/deletediscipline";
			public static final String GET_DISCIPLINE_LIST_4_UNIVERSITY = "/getdisciplinelist4university";
			public static final String GET_DISCIPLINE = "/getdiscipline";
		}
		
		public static class UniversityPath {
			public static final String CLASS = "/university";
			public static final String ADD_UNIVERSITY = "/adduniversity";
			public static final String UPDATE_UNIVERSITY = "/updateuniversity";
			public static final String DELETE_UNIVERSITY = "/deleteuniversity";
			public static final String GET_UNIVERSITY_LIST = "/getuniversitylist";
			public static final String GET_UNIVERSITY = "/getuniversity";
		}
		
		public static class FeedbackPath {
			public static final String CLASS = "/feedback";
			public static final String ADD_FEEDBACK = "/addfeedback";
			public static final String UPDATE_FEEDBACK = "/updatefeedback";
			public static final String DELETE_FEEDBACK = "/deletefeedback";
			public static final String GET_FEEDBACK_LIST_4_USER = "/getfeedbacklist4user";
			public static final String GET_FEEDBACK_LIST_4_COURSE = "/getfeedbacklist4course";
			public static final String GET_FEEDBACK_LIST_4_PROFESSOR = "/getfeedbacklist4professor";
			public static final String GET_FEEDBACK_LIST_4_COMMENT = "/getfeedbacklist4comment";
			public static final String GET_FEEDBACK_FOR_USER_FOR_COURSE = "/getfeedbackforuserforcourse";
		}

		public static class UserPath {
			public static final String CLASS = "/user";
			public static final String UPDATE_USER = "/updateuser";
			public static final String DELETE_USER = "/deleteuser";
			public static final String GET_USER = "/getuser";
			public static final String GET_USER_LIST_4_DEPARTMENT = "/getuserlist4department";
		}


		
	}

	public static class Keys {

		public static class UserTable {
			public static final String ID = "Email_ID";
			public static final String DEPT_ID = "DeptID";
			public static final String PASSWORD = "Password";
			public static final String FNAME = "FName";
			public static final String LNAME = "LName";
			public static final String SECR_QUE = "SecQue";
			public static final String SECR_ANSWR = "SecAnswr";
			public static final String IS_ADMIN = "IsAdmin";
			public static final String DOB = "DOB";
			public static final String CONTACT = "Contact";
			public static final String ZIP_CODE = "ZIPCode";

		}

		public static class ProfessorTable {
			public static final String ID = "ProfID";
			public static final String NAME = "PName";
			public static final String EMAIL = "PEmail";
			public static final String CONATCT = "PContact";
			public static final String URL = "PUrl";
		}

		public static class ProfessorCourseTable {
			public static final String ID = "ProfCourseID";
			public static final String PROF_ID = "ProfID";
			public static final String COURSE_ID = "CourseID";
		}

		public static class CourseTable {
			public static final String ID = "CourseID";
			public static final String MAJOR_ID = "MajorID";
			public static final String CODE = "CCode";
			public static final String NAME = "CName";
			public static final String INITIALS = "CInitials";
			public static final String SUMMARY = "CSummary";
			public static final String NO_OF_FEEDBACK = "CNoFeedback";
			public static final String RATINGS = "CRating";
		}

		public static class MajorTable {
			public static final String ID = "MajorID";
			public static final String DEPT_ID = "DeptID";
			public static final String NAME = "MName";
			public static final String INITIALS = "MInitials";
			public static final String SUMMARY = "MSummary";
		}

		public static class DepartmentTable {
			public static final String ID = "DeptID";
			public static final String DISP_ID = "DispID";
			public static final String NAME = "DeptName";
			public static final String INITIALS = "DeptInitials";
			public static final String SUMMARY = "DeptSummary";
		}

		public static class DisciplineTable {
			public static final String ID = "DispID";
			public static final String UID = "UID";
			public static final String NAME = "DispName";
			public static final String INITIALS = "DispInitials";
			public static final String SUMMARY = "DispSummary";
		}

		public static class UniversityTable {
			public static final String ID = "UID";
			public static final String NAME = "UName";
			public static final String INITIALS = "UInitials";
			public static final String CITY = "UCity";
			public static final String STATE = "UState";
			public static final String COUNTRY = "UCountry";
			public static final String SUMMARY = "USummary";
		}

		public static class FeedbackTable {
			public static final String ID = "FeedbackID";
			public static final String USER_ID = "UserID";
			public static final String COURSE_ID = "CourseID";
			public static final String PROF_ID = "ProfID";
			public static final String TITLE = "Title";
			public static final String COMMENT = "Comment";
			public static final String RATINGS = "Rating";
			public static final String SUBMIT_TIME = "SubmitTime";
			public static final String HELPFUL_CNT = "Helpfulness_cnt";
			public static final String UNHELPFUL_CNT = "UnHelpfulness_cnt";
			public static final String IS_SPAM = "IsSpam";
			public static final String IS_ANONYMOUS = "IsAnonymous";
		}
	}
	
	public static class ClassAttributes{
		
		public static class DisciplineAttributes{
			public static final String MDISCIPLINEID="mDisciplineId";
			public static final String MDISCIPLINENAME="mDisciplineName";
			public static final String MDISCIPLINEINITIALS="mDisciplineInitials";
			public static final String MDISCIPLINESUMMARY="mDisciplineSummary";
		}
		
		public static class DepartmentAttributes{
			public static final String MDEPARTMENTID="mDepartmentId";
			public static final String MDEPARTMENTNAME="mDepartmentName";
			public static final String MDEPARTMENTINITIALS="mDepartmentInitials";
			public static final String MDEPARTMENTSUMMARY="mDepartmentSummary";
			public static final String MDEPARTMENTDISCIPLINEID="mDiscipline.mDisciplineId";
		}
		
		public static class MajorAttributes{
			public static final String MMAJORID ="mMajorId";
			public static final String MMAJORNAME="mMajorName";
			public static final String MMAJORINITIALS ="mMajorInitials";
			public static final String MMAJORSUMMARY="mMajorSummary";
			public static final String MMAJORDEPARTMENTID="mDepartment.mDepartmentId";
		}
	}

}
