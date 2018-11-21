package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.forms.LoginForm;
import ru.itis.forms.ProductForm;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.repositories.*;
import ru.itis.services.LoginService;
import ru.itis.services.LoginServiceImpl;
import ru.itis.services.ProductsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/products")
public class BasketServlet extends HttpServlet {

    private LoginService service;
    private BasketRepository basketRepository;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/web_shop");
        UsersRepository userRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        this.basketRepository = new BasketRepositoryJdbcTemplateImpl(dataSource);
        this.service = new LoginServiceImpl(authRepository, userRepository);
    }

    private User currentUser(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("auth")) {
                if (service.isExistByCookie(cookie.getValue())) {
                    return service.getIdByCookie(cookie.getValue());
                }
            }
        }
        return User.builder().name("******").build();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product = req.getParameter("product");
        User user = currentUser(req);
        req.setAttribute("UserName", user.getName());
        List<Product> products = basketRepository.findProductsByName(user.getName());
        req.setAttribute("products", products );
        req.getRequestDispatcher("jsp/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = currentUser(req).getName();
//        Cookie[] cookie = req.getCookies();
//        resp.addCookie(cookie);
//        LoginForm loginForm = LoginForm.builder()
//                .product_id(product_id)
//                .password("qwerty007")
//                .build();

//        Optional<String> optionalCookieValue = service.login(req.getAttribute("userLogin"));
//        if (optionalCookieValue.isPresent()) {
//            Cookie cookie = new Cookie("auth", optionalCookieValue.get());
//            resp.addCookie(cookie);
            List<Product> products = basketRepository.findProductsByName(name);
            String resultJson = mapper.writeValueAsString(products);
            resp.setStatus(200);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(resultJson);
//        } else {
//            resp.setStatus(403);
//        }


    }
}
