package ru.itis.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.services.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        context.setAttribute("dataSource", dataSource);
        UsersService usersService = applicationContext.getBean("usersService", UsersService.class);
        context.setAttribute("usersService", usersService);
        LoginService loginService = applicationContext.getBean("loginService", LoginService.class);
        context.setAttribute("loginService", loginService);
        FeedbackService feedbackService = applicationContext.getBean("feedbackService", FeedbackService.class);
        context.setAttribute("feedbackService", feedbackService);
        RecordService recordService = applicationContext.getBean("recordService", RecordService.class);
        context.setAttribute("recordService", recordService);
        ComponentsService componentsService = applicationContext.getBean("componentsService", ComponentsService.class);
        context.setAttribute("componentsService", componentsService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}