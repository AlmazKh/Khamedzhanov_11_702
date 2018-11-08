package ru.itis.servlets;

import javax.servlet.http.HttpServlet;

//@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

//    private UsersService usersService;
//
//    @SneakyThrows
//    @Override
//    public void init() throws ServletException {
//        Class.forName("org.postgresql.Driver");
//        Properties properties = new Properties();
//        properties.load(new FileReader("C:\\Users\\Almaz\\Desktop\\Khamedzhanov_11_702\\Hospitals\\src\\main\\resources\\application.properties"));
//        Connection connection =
//                DriverManager.getConnection(properties.getProperty("db.url"),
//                        properties.getProperty("db.user"),
//                        properties.getProperty("db.password"));
//        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(connection);
//        usersService = new UsersServiceImpl(usersRepository);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserForm userForm = UserForm.builder()
//                .firstName(req.getParameter("first_name"))
//                .lastName(req.getParameter("last_name"))
//                .password(req.getParameter("password"))
//                .build();
//
//        usersService.signUp(userForm);
//        resp.sendRedirect("/signUp");
//    }
}
