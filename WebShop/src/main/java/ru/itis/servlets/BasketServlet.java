//package ru.itis.servlets;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import ru.itis.models.User;
//import ru.itis.repositories.*;
//import ru.itis.services.LoginService;
//import ru.itis.services.LoginServiceImpl;
//import ru.itis.services.ProductsServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//
//@WebServlet("/products")
//public class BasketServlet extends HttpServlet {
//
//    private LoginService service;
//    private BasketRepository basketRepository;
//    private ObjectMapper mapper = new ObjectMapper();
//
//    @Override
//    public void init() throws ServletException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("qwerty007");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/web_shop");
//        UsersRepository userRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
//        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
//        this.basketRepository = new BasketRepositoryJdbcTemplateImpl(dataSource);
//        this.service = new LoginServiceImpl(authRepository, userRepository);
//    }
//
//    private User currentUser(HttpServletRequest req) {
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("auth")) {
//                if (service.isExistByCookie(cookie.getValue())) {
//                    return service.getIdByCookie(cookie.getValue());
//                }
//            }
//        }
//        return User.builder().name("guest").build();
//    }
//
//
//}
