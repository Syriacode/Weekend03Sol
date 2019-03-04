package example.org.test.weekend03sol;

import android.util.Log;

import java.util.Locale;

public class EmployeeDatabaseContract {

    public static final String DATABASE_NAME = "employee_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Employees";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_BIRTH = "birth";
    public static final String COLUMN_WAGE = "wage";
    public static final String COLUMN_HIRE = "hire";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_ID = "id";

    public static String createQuery(){
        StringBuilder queryBuilder = new StringBuilder();
        // Creating the Table
        queryBuilder.append("CREATE TABLE");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        // Unique primary key
        queryBuilder.append(COLUMN_ID);
        queryBuilder.append(" ");
        queryBuilder.append(" INT NONNULL IDENTITY PRIMARY KEY, ");
        // Adding the columns
        queryBuilder.append(COLUMN_NAME);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_BIRTH);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_WAGE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_HIRE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_WAGE);
        queryBuilder.append(" TEXT, ");

        Log.d("TAG", "createQuery: " + queryBuilder.toString());

        return queryBuilder.toString();

    }
    public static String getAllEmployeesQuery(){ return "SELECT * FROM " + TABLE_NAME;};

    public static String getOneEmployeeById (int id){
        return String.format("SELECT * FROM %s WHERE %s = \"%d\"", TABLE_NAME, COLUMN_ID, id);
    }
    public static String getWhereClauseById(){
        return  String.format(Locale.US, "%s = ", COLUMN_ID);
    }
}
