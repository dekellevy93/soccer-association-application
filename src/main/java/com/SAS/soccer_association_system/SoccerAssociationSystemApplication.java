package com.SAS.soccer_association_system;

import com.SAS.crudoperations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SoccerAssociationSystemApplication {

    private static ApplicationContext ctx;
    public static TransactionCRUD transDao;
    public static UsersCRUD usersDao;
    public static GameCRUD gameDao;
    public static TeamCRUD teamDao;
    public static LeagueCRUD leagueCRUD;

    public static void main(String[] args) {
        SpringApplication.run(SoccerAssociationSystemApplication.class, args);
        init();
    }


    /**
     * The function initialize all the schemas in the DB
     *
     * @return
     */
    public static void init() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        transDao = (TransactionCRUD) ctx.getBean("transDao");
        usersDao = (UsersCRUD) ctx.getBean("usersDao");
        gameDao = (GameCRUD) ctx.getBean("gameDao");
        teamDao = (TeamCRUD) ctx.getBean("teamDao");
        leagueCRUD = (LeagueCRUD) ctx.getBean("leagueDao");
    }

}