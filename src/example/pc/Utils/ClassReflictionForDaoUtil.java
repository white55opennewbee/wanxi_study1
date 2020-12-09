package example.pc.Utils;


import java.lang.reflect.Field;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

public class ClassReflictionForDaoUtil {
    private static List<String> getAllVariables(Class classType) {
        List<String> variables = new ArrayList<>();
        Field[] fields = classType.getDeclaredFields();

        for (Field s : fields) {
            s.setAccessible(true);
            variables.add(s.getName());
            s.setAccessible(false);
        }
        return variables;
    }


    public static <T> List<T> getEntities(Class type, ResultSet resultSet) {
        List<Object> list = new ArrayList<>();
        List<String> variables = getAllVariables(type);
//        List<String> fatherVariables = getAllVariables(type.getSuperclass());
        List<String> allVariables = getAllVariables(type);
        allVariables.addAll(getAllVariables(type.getSuperclass()));


        try {
            if (!resultSet.isBeforeFirst()) {
                resultSet.beforeFirst();
            }
            while (resultSet.next()) {
                Object object = type.newInstance();
                for (int i = 0; i < allVariables.size(); i++) {
                    Object value = resultSet.getObject(allVariables.get(i));
                    Field field = null;
                    if (!variables.contains(allVariables.get(i))) {
                        field = type.getSuperclass().getDeclaredField(allVariables.get(i));
                    } else {
                        field = type.getDeclaredField(allVariables.get(i));
                    }
                    if (field.getType().getName().equals("java.sql.Date")){
                        value = new Date(((Timestamp) value).getTime());
                    }
                    field.setAccessible(true);
                    field.set(object, value);
                    field.setAccessible(false);
                }
                list.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return (List<T>) list;
    }

    public static String updateSQL(Object o, String tableName) {
        return SQLSet(o, tableName, "update");
    }


    private static String SQLSet(Object o, String tableName, String type) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        Field[] fatherDeclaredFields = o.getClass().getSuperclass().getDeclaredFields();
        List<String> names = new ArrayList<>();
        List<Object> values = new ArrayList<>();


        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Object value = field.get(o);
                if (value != null) {
                    names.add(field.getName());
                    values.add(value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        for (Field field : fatherDeclaredFields) {
            field.setAccessible(true);
            try {
                Object value = field.get(o);
                if (value != null) {
                    names.add(field.getName());
                    values.add(value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        StringBuffer start = new StringBuffer();
        if (type.equals("update")) {
            start.append("update " + tableName+" set " );
            for (int i = 0; i < names.size(); i++) {
                start.append(names.get(i)+" = '"+ values.get(i)+"'");
                if (i != names.size() - 1) {
                    start.append(",");
                }
            }

            try {
                start.append("  where id = " + o.getClass().getSuperclass().getDeclaredField("id").get(o) + "");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } else if (type.equals("insert")) {
            start.append(" insert into " + tableName + " (");
            int idnum = -1;
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).equals("id")){
                    idnum = i;
                    continue;
                }
                start.append(names.get(i));
                if (i != names.size() - 1) {
                    start.append(",");
                }
            }
            start.append(") values (");
            for (int i = 0; i < values.size(); i++) {
                if (i == idnum){
                    continue;
                }
                start.append("'" + values.get(i) + "'");
                if (i != values.size() - 1) {
                    start.append(",");
                }
            }
            start.append(" );");
        }

        System.out.println(start.toString());
        return start.toString();
    }


    public static String insertSQL(Object o, String tableName) {
        return SQLSet(o, tableName, "insert");
    }


}
