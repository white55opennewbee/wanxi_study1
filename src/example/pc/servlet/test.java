package example.pc.servlet;

public class test {
    public static void main(String[] args) {
//        String  s = "2020-11-12";
//        Date date;
//        try {
//           date = DateTransfer.toDate(s);
//            System.out.println(date.getYear());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        File file = FileReaderUtil.getFile("E:\\test1\\head.txt");
//        String[] strings = FileReaderUtil.readFile(",", ";info:", ";", file);
//        System.out.println(strings);


//        Connection connection = Jdbc_Utils.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from nav");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<HashMap> list = new ArrayList<>();
//            while (resultSet.next()){
//                HashMap<String,String> map = new HashMap<>();
//                map.put("NavDesc",resultSet.getString("NavDesc"));
//                map.put("Navhref",resultSet.getString("Navhref"));
//                map.put("title",resultSet.getString("title"));
//                list.add(map);
//            }
//            list.stream().forEach(x->{
//                System.out.println(x.toString());
//            });
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

//        String[] adImgUrl = null;
//        String[] adInfo = null;
//        Connection connection = Jdbc_Utils.getConnection();
//        try {
//            PreparedStatement info = connection.prepareStatement("select info,imgUrl from company_advice");
//            ResultSet resultSet = info.executeQuery();
//            resultSet.last();
//            adImgUrl = new String[resultSet.getRow()];
//            adInfo = new String[resultSet.getRow()];
//
//            if (resultSet.isBeforeFirst() == false) {
//                resultSet.beforeFirst();
//            }
//            int cursor = 0;
//            while (resultSet.next()) {
//                    adImgUrl[cursor] = resultSet.getString("imgUrl");
//                    adInfo[cursor] = resultSet.getString("info");
//                    cursor ++;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        //System.out.println(Jdbc_Utils.class.getClass().getResource("/").getPath());

       // System.out.println(test.class.getClassLoader().getResource("jdbc_properties.properties").getPath());

//        ClassReflictionForDaoUtil.getAllMethods(User.class);

//        List<Object> allEntity = ClassReflictionForDaoUtil.getAllEntity(User.class, Jdbc_Utils.getResultSet("select * from user"));
//        for (Object user:allEntity){
//            user = (User)user;
//            System.out.println(user.toString());
//        }

//        List<Production> allproduction = ClassReflictionForDaoUtil.getEntities(Production.class, Jdbc_Utils.getResultSet("select * from production"));
//        for (Production production:allproduction){
//
//            System.out.println(production.toString()+production.getId()+production.getStatus());
//        }




//    Production production = new Production();
//    production.setPrice("1000");
//    production.setProductionName("CXAJS-123");
//    String production1 = ClassReflictionForDaoUtil.insertSQL(production, "production");
//    System.out.println(production1);

//        Production production = new Production();
//
//        Field[] declaredFields = production.getClass().getDeclaredFields();
//        Class<?> superclass = production.getClass().getSuperclass();
//        Field[] declaredFields1 = superclass.getDeclaredFields();
//        if (superclass!=null){
//            for (Field field : declaredFields1){
//                field.setAccessible(true);
//                try {
//                    field.set(production,1);
//                    System.out.println(field.get(production));
//
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(field.getName());
//            }
//        }
//        for (Field field : declaredFields){
//            field.setAccessible(true);
//            System.out.println(field.getName());
//        }

//        Comment comment = new Comment();
//        comment.setId(1);
//        comment.setStatus(1);
//        comment.setUserEmail("88888888@qq.com");
//        String common = ClassReflictionForDaoUtil.updateSQL(comment, "common");
//        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(common);
//        try {
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        Page page =new Page();
//        page.setCurrentPage(2);
//        page.setMaxsize(4);
//        IProductionService service = new ProductionServiceImpl();
//        List<Production> productionByPage = service.getProductionByPage(page);
//        for (Production production:productionByPage){
//            System.out.println(production.toString());
//        }
//        Page page = new Page();
//        page.setMaxsize(8);
//        page.setCurrentPage(1);
//        JSONObject object = new JSONObject();
//        Object o = JSONObject.toJSON(page);
//        System.out.println(JSON.toJSONString(page));

//        Page page = new Page();
//        page.setMaxsize(8);
//        page.setCurrentPage(1);
//        ProductionServiceImpl productionService = new ProductionServiceImpl();
//        String productions = JSON.toJSONString(productionService.getProductionByPage(page));
//        System.out.println(productions);
//        String ii = "searchByName=&lowestPrice=&maxPrice=&selection=全部&maxSize=8&currentPage=1";
//
//        String s = JSONObject.toJSONString(ii);
//        Comment comment = new Comment();
//        try {
//            Field commonTime = Comment.class.getDeclaredField("commonTime");
//            System.out.println(commonTime.getType().getName());
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }



    }
}
