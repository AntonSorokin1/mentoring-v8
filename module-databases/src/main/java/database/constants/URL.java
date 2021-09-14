package database.constants;

public final class URL {

  public static final String STUDENTS = "/students";
  public static final String TEACHERS = "/teachers";
  public static final String SUBJECTS = "/subjects";
  public static final String EXAM_RESULT = "/exam_result";

  public static final String CREATE = "/create";
  public static final String GET = "/get";
  public static final String GET_ALL = "/get_all";
  public static final String UPDATE = "/update";
  public static final String DELETE = "/delete";

  public static final String GET_BY_NAME = GET + "/by_name";
  public static final String GET_BY_SURNAME = GET + "/by_surname";

  public static final String GET_STUDENT_BY_PHONE_NUMBER = GET + "/by_phone_number";
  public static final String GET_TEACHERS_BY_TITLE = GET + "/by_title";
  public static final String GET_SUBJECT_BY_TEACHER_ID = GET + "/by_teacher_id";

  private URL() {
  }
}
