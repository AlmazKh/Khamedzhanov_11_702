package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Product;
import ru.itis.models.User;
import ru.itis.repositories.*;
import ru.itis.services.BasketService;
import ru.itis.services.BasketServiceImpl;
import ru.itis.services.LoginService;
import ru.itis.services.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class BasketServlet extends HttpServlet {

    private LoginService loginService;
    private BasketService basketService;
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
        this.basketService = new BasketServiceImpl(basketRepository, authRepository);
        this.loginService = new LoginServiceImpl(authRepository, userRepository);
    }

    private User currentUser(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("auth")) {
                if (loginService.isExistByCookie(cookie.getValue())) {
                    return loginService.getIdByCookie(cookie.getValue());
                }
            }
        }
        return User.builder().name("******").build();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = currentUser(req);
        req.setAttribute("UserName", user.getName());
//        req.setAttribute("UserId", user.getId());
//        List<Product> products = basketService.getProductsByUserId(user.getId());
//        req.setAttribute("products", products );

        req.getRequestDispatcher("jsp/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long userId = 1l; //Long.valueOf(req.getParameter("user_id"));
        Long productId = Long.valueOf(req.getParameter("product_id"));
        User user = currentUser(req);
        Long userId = user.getId();

//       добавление создание корзины при регистрации
//        basketService.addBasket(userId, productId);
        basketService.addProduct(userId, productId);

        List<Product> products = basketService.getProductsByUserId(userId);

        String resultJson = mapper.writeValueAsString(products);
        resp.setStatus(200);
        resp.setContentType("application/json charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(resultJson);

//        PrintWriter writer = resp.getWriter();
//
//        String result = new Gson().toJson(products);
//        resp.setContentType("application/json; charset=UTF-8");
//        writer.print(result);

    }
}
