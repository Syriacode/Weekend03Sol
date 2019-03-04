package example.org.test.weekend03sol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static example.org.test.weekend03sol.EmployeeDatabaseContract.COLUMN_BIRTH;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.COLUMN_HIRE;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.COLUMN_ID;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.COLUMN_IMAGE;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.COLUMN_NAME;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.COLUMN_WAGE;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.DATABASE_NAME;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.DATABASE_VERSION;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.TABLE_NAME;
import static example.org.test.weekend03sol.EmployeeDatabaseContract.getWhereClauseById;

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {
    public EmployeeDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(EmployeeDatabaseContract.createQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        onCreate(database);
    }

    //Insert an employee into the database
    public long insertEmployeeIntoDatabse (@NonNull Employee employee){
        SQLiteDatabase writeableDatebase = this.getWritableDatabase();
        // data container
        ContentValues contentValues = new ContentValues();

        //// insert car value pairs into the contentViewer container
        contentValues.put(COLUMN_NAME, employee.getEmployeeName());
        contentValues.put(COLUMN_BIRTH, employee.getEmployeeBirthDate());
        contentValues.put(COLUMN_WAGE, employee.getEmployeeWage());
        contentValues.put(COLUMN_HIRE, employee.getEmployeeHireDate());
        contentValues.put(COLUMN_IMAGE, employee.getEmployeeImage());
        return writeableDatebase.insert(TABLE_NAME, null, contentValues);
    }
    // Get All Employees from Database and return an ArrayList
    public ArrayList<Employee> getAllEmployeesFromDatabase(){
        ArrayList<Employee> returnEmployeeList = new ArrayList<>();
        SQLiteDatabase readableDatabse = this.getReadableDatabase();
        // hold results in Cursor
        Cursor cursor = readableDatabse.rawQuery(EmployeeDatabaseContract.getAllEmployeesQuery(), null);
        // Check if we have any results
        if(cursor.moveToFirst()){
            // while we have results get the values and place in list
            do{
            int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String birth = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTH));
            String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE));
            String hire = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE));
            String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));

            returnEmployeeList.add(new Employee(name, birth, wage, hire, image, id));
            } while (cursor.moveToNext());
            // return the result in a list
        }
            cursor.close();
            return returnEmployeeList;
    }

    // Get one entry from the database
    public Employee getEmployeeById (int id){
        SQLiteDatabase readableDatabse = this.getReadableDatabase();
        // Employee to return
        Employee returnEmplyee = new Employee();
        //Cursor
        Cursor cursor = readableDatabse.rawQuery(EmployeeDatabaseContract.getOneEmployeeById(id), null);
        if (cursor.moveToFirst()){
            int idFromDB = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String birth = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTH));
            String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE));
            String hire = cursor.getString(cursor.getColumnIndex(COLUMN_HIRE));
            String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));
            returnEmplyee = new Employee(name, birth, wage, hire, image, idFromDB);
        }
        cursor.close();
        return returnEmplyee;
    }
    // update an item in the database
    public long updateEmployeeInDatabase(@NonNull Employee newEmployeeInfo){
        SQLiteDatabase writeableDatabse = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, newEmployeeInfo.getEmployeeName());
        contentValues.put(COLUMN_BIRTH, newEmployeeInfo.getEmployeeBirthDate());
        contentValues.put(COLUMN_WAGE, newEmployeeInfo.getEmployeeWage());
        contentValues.put(COLUMN_HIRE, newEmployeeInfo.getEmployeeHireDate());
        contentValues.put(COLUMN_IMAGE, newEmployeeInfo.getEmployeeImage());
        return writeableDatabse.update(TABLE_NAME, contentValues, getWhereClauseById(), new String[]{String.valueOf(newEmployeeInfo.getEmployeeId())});

    }
    public long deleteFromDatabaseById (String[] name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, getWhereClauseById() +  name[0], null);
    }
}
