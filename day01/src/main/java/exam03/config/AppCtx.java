package exam03.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import exam03.models.member.*;

import java.time.format.DateTimeFormatter;

@Configuration
public class AppCtx {
    @Bean
    //@Qualifier("mdao1")
    public MemberDao memberDao() {


        return new MemberDao();
    }
    /*
    @Bean
    public MemberDao memberDao2() {


        return new MemberDao();
    }
    */
    @Bean
    public JoinService joinService() {
        return new JoinService();
    }
    /**
    @Bean
    public JoinValidator joinValidator() {

        //return new JoinValidator();
    }
    */
    @Bean
    public MemberInfoService memberInfoService() {

        return new MemberInfoService();
    }


    //@Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    }
}
