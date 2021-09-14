package database.constants;

import static java.lang.String.format;

public final class SQL {

  // Tables
  public static final String STUDENTS = "students";
  public static final String TEACHERS = "teachers";
  public static final String SUBJECTS = "subjects";
  public static final String EXAM_RESULTS = "exam_results";

  // Fields
  public static final String ID_FIELD = ".id";
  public static final String UPDATED_FIELD = ".updated";
  public static final String NAME_FIELD = ".name";
  public static final String SURNAME_FIELD = ".surname";
  public static final String PHONE_NUMBER_FIELD = ".phone_number";
  public static final String BIRTH_DATE_FIELD = ".birth_date";
  public static final String TITLE_FIELD = ".title";
  public static final String MARK_FIELD = ".mark";
  public static final String TEACHER_ID_FIELD = ".teacher_id";
  public static final String SUBJECT_ID_FIELD = ".subject_id";
  public static final String STUDENT_ID_FIELD = ".student_id";

  // Keywords
  public static final String INSERT = "INSERT";
  public static final String INTO = "INTO";
  public static final String VALUES = "VALUES";
  public static final String SELECT = "SELECT";
  public static final String FROM = "FROM";
  public static final String WHERE = "WHERE";
  public static final String UPDATE = "UPDATE";
  public static final String SET = "SET";
  public static final String DELETE = "DELETE";

  // Shortcuts
  public static final String INSERT_INTO = INSERT + " " + INTO;
  public static final String SELECT_ALL_FROM = SELECT + " * " + FROM;
  public static final String WHERE_ID = WHERE + " %s" + ID_FIELD;
  public static final String DELETE_FROM = DELETE + " " + FROM;

  // Commands
  // Insert
  public static final String INSERT_TEMPLATE = INSERT_INTO + " %s " + VALUES + " ";
  public static final String INSERT_STUDENT =
      format(INSERT_TEMPLATE, STUDENTS) + "(?, ?, ?, ?, ?, ?, ?);";
  public static final String INSERT_TEACHER =
      format(INSERT_TEMPLATE, TEACHERS) + "(?, ?, ?, ?, ?, ?, ?);";
  public static final String INSERT_SUBJECT =
      format(INSERT_TEMPLATE, SUBJECTS) + "(?, ?, ?, ?, ?);";
  public static final String INSERT_EXAM_RESULT =
      format(INSERT_TEMPLATE, EXAM_RESULTS) + "(?, ?, ?, ?, ?, ?);";

  // Select
  public static final String SELECT_ALL_TEMPLATE = SELECT_ALL_FROM + " %s;";
  public static final String SELECT_ALL_STUDENTS = format(SELECT_ALL_TEMPLATE, STUDENTS);
  public static final String SELECT_ALL_TEACHERS = format(SELECT_ALL_TEMPLATE, TEACHERS);
  public static final String SELECT_ALL_SUBJECTS = format(SELECT_ALL_TEMPLATE, SUBJECTS);
  public static final String SELECT_ALL_EXAM_RESULTS = format(SELECT_ALL_TEMPLATE, EXAM_RESULTS);

  public static final String SELECT_BY_ID_TEMPLATE = SELECT_ALL_FROM + " %s ";
  public static final String SELECT_STUDENT_BY_ID = format(SELECT_BY_ID_TEMPLATE, STUDENTS)
      + format(WHERE_ID, STUDENTS) + "=?;";
  public static final String SELECT_TEACHER_BY_ID = format(SELECT_BY_ID_TEMPLATE, TEACHERS)
      + format(WHERE_ID, TEACHERS) + "=?;";
  public static final String SELECT_SUBJECT_BY_ID = format(SELECT_BY_ID_TEMPLATE, SUBJECTS)
      + format(WHERE_ID, SUBJECTS) + "=?;";
  public static final String SELECT_EXAM_RESULT_BY_ID = format(SELECT_BY_ID_TEMPLATE, EXAM_RESULTS)
      + format(WHERE_ID, EXAM_RESULTS) + "=?;";

  // Update
  public static final String UPDATE_TEMPLATE = UPDATE + " %s " + SET + " ";
  public static final String UPDATE_STUDENT_BY_ID = format(UPDATE_TEMPLATE, STUDENTS)
      + STUDENTS + UPDATED_FIELD + "=?,"
      + STUDENTS + NAME_FIELD + "=?,"
      + STUDENTS + SURNAME_FIELD + "=?,"
      + STUDENTS + BIRTH_DATE_FIELD + "=?,"
      + STUDENTS + PHONE_NUMBER_FIELD + "=? "
      + format(WHERE_ID, STUDENTS) + "=?;";
  public static final String UPDATE_TEACHER_BY_ID = format(UPDATE_TEMPLATE, TEACHERS)
      + TEACHERS + UPDATED_FIELD + "=?,"
      + TEACHERS + NAME_FIELD + "=?,"
      + TEACHERS + SURNAME_FIELD + "=?,"
      + TEACHERS + BIRTH_DATE_FIELD + "=?,"
      + TEACHERS + TITLE_FIELD + "=? "
      + format(WHERE_ID, TEACHERS) + "=?;";
  public static final String UPDATE_SUBJECT_BY_ID = format(UPDATE_TEMPLATE, SUBJECTS)
      + SUBJECTS + UPDATED_FIELD + "=?,"
      + SUBJECTS + NAME_FIELD + "=?,"
      + SUBJECTS + TEACHER_ID_FIELD + "=? "
      + format(WHERE_ID, SUBJECTS) + "=?;";
  public static final String UPDATE_EXAM_RESULT_BY_ID = format(UPDATE_TEMPLATE, EXAM_RESULTS)
      + EXAM_RESULTS + UPDATED_FIELD + "=?,"
      + EXAM_RESULTS + SUBJECT_ID_FIELD + "=?,"
      + EXAM_RESULTS + STUDENT_ID_FIELD + "=?,"
      + EXAM_RESULTS + MARK_FIELD + "=? "
      + format(WHERE_ID, EXAM_RESULTS) + "=?;";

  // Delete
  public static final String DELETE_TEMPLATE = DELETE_FROM + " %s ";
  public static final String DELETE_STUDENT_BY_ID = format(DELETE_TEMPLATE, STUDENTS)
      + format(WHERE_ID, STUDENTS) + "=?;";
  public static final String DELETE_TEACHER_BY_ID = format(DELETE_TEMPLATE, TEACHERS)
      + format(WHERE_ID, TEACHERS) + "=?;";
  public static final String DELETE_SUBJECT_BY_ID = format(DELETE_TEMPLATE, SUBJECTS)
      + format(WHERE_ID, SUBJECTS) + "=?;";
  public static final String DELETE_EXAM_RESULT_BY_ID = format(DELETE_TEMPLATE, EXAM_RESULTS)
      + format(WHERE_ID, EXAM_RESULTS) + "=?;";

  private SQL() {
  }
}
