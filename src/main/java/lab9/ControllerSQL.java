package lab9;

import javax.xml.transform.Result;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class ControllerSQL {
    private String DB_URL;
    private String USER;
    private String PASS;

    public ControllerSQL(String DB_URL, String USER, String PASS) {
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASS = PASS;
    }

    private Connection Connect(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if (!connection.isClosed()){
                //System.out.println("Cоединение с бд установлено - " + this.getClass().getSimpleName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void Close() {
        try {
            Connect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CreateTable(Object obj) {
        for (Annotation annotation : obj.getClass().getAnnotations()){
            if (annotation instanceof Table) {
                try {
                    Statement statement = Connect().createStatement();
                    try {
                        String dropSQL = "DROP TABLE " + ((Table) annotation).name() + ";";
                        System.out.println(dropSQL);
                        statement.execute(dropSQL);
                        System.out.println("Таблица " + ((Table) annotation).name() + " удалена");
                    } catch (SQLException e){
                        e.printStackTrace();
                        System.out.println("Таблица " + ((Table) annotation).name() + " не удалена");
                    }

                    try {
                        String createSQL = "CREATE TABLE " + ((Table) annotation).name() + "();";
                        System.out.println(createSQL);
                        statement.execute(createSQL);
                        System.out.println("Таблица " + ((Table) annotation).name() + " добавлена");
                    } catch (SQLException e){
                        e.printStackTrace();
                        System.out.println("Таблица " + ((Table) annotation).name() + " не добавлена");
                    }

                    for(Field field : obj.getClass().getDeclaredFields()){
                        for (Annotation annotationsField : field.getAnnotations()){
                            if (annotationsField instanceof Column){
                                String alterSQL = "ALTER TABLE " + ((Table) annotation).name() +
                                                  " ADD COLUMN " + ((Column) annotationsField).name() +
                                                  " " + ((Column) annotationsField).type() + ";";

                                String pkSQL = "";
                                if (((Column) annotationsField).PK()){
                                    pkSQL = "ALTER TABLE " + ((Table) annotation).name() +
                                            " ADD PRIMARY KEY (" + ((Column) annotationsField).name() + ");";
                                }

                                statement.execute(alterSQL);
                                System.out.println(alterSQL);
                                if (pkSQL != "") {
                                    statement.execute(pkSQL);
                                    System.out.println(pkSQL);
                                }
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        Close();
    }

    public Boolean InsertToTable(Object obj){
        Annotation table = null;
        for (Annotation annotation : obj.getClass().getAnnotations()) {
            if (annotation instanceof Table) {
                table = annotation;
            }
        }
        if (table == null) {
            System.out.println("Класс объекта нельзя записать в таблицу");
            return false;
        }

        ArrayList<Annotation> columns = new ArrayList<>();
        HashMap<Annotation, Field> fields = new HashMap<>();

        for(Field field : obj.getClass().getDeclaredFields()) {
            for (Annotation annotationsField : field.getAnnotations()){
                if (annotationsField instanceof Column && !((Column) annotationsField).type().equals("serial")){
                    columns.add(annotationsField);
                    fields.put(annotationsField, field);
                }
            }
        }

        String insertSQL = "INSERT INTO " + ((Table)table).name() + "(";
        for (int i = 0; i < columns.size() - 1; i++) {
            insertSQL += ((Column) columns.get(i)).name() + ", ";
        }
        insertSQL += ((Column) columns.get(columns.size() - 1)).name() + ") VALUES (";

        for (int i = 0; i < columns.size(); i++) {
            try {
                Field value = fields.get(columns.get(i));
                value.setAccessible(true);
                insertSQL += "'" + value.get(obj) + "', ";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        insertSQL = insertSQL.substring(0, insertSQL.length() - 2) + ");";

        System.out.println(insertSQL);

        try {
            Statement statement = Connect().createStatement();
            statement.execute(insertSQL);
            Close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //    public void InsertToTable(Object obj){
//        Annotation table = null;
//        for (Annotation annotation : obj.getClass().getAnnotations()) {
//            if (annotation instanceof Table) {
//                table = annotation;
//            }
//        }
//
//        ArrayList<Annotation> columns = new ArrayList<Annotation>();
//        HashMap<Annotation, Field> fields = new HashMap<>();
//
//        for(Field field : obj.getClass().getDeclaredFields()) {
//            for (Annotation annotationsField : field.getAnnotations()){
//                if (annotationsField instanceof Column && !((Column) annotationsField).type().equals("serial")){
//                    columns.add(annotationsField);
//                    fields.put(annotationsField, field);
//                }
//            }
//        }
//
//        String insertSQL = "INSERT INTO " + ((Table)table).name() + "(";
//        for (int i = 0; i < columns.size() - 1; i++) {
//            insertSQL += ((Column) columns.get(i)).name() + ", ";
//        }
//        insertSQL += ((Column) columns.get(columns.size() - 1)).name() + ") VALUES (";
//
//        for (int i = 0; i < columns.size(); i++) {
//            try {
//                Field value = fields.get(columns.get(i));
//                value.setAccessible(true);
//                insertSQL += "'" + value.get(obj) + "', ";
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        insertSQL = insertSQL.substring(0, insertSQL.length() - 2) + ");";
//
//        try {
//            Statement statement = Connect().createStatement();
//            statement.execute(insertSQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println(insertSQL);
//    }
}
