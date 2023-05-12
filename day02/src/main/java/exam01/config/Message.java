package exam01.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message) {
        System.out.println(message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 초기화 단계에서 실행 - 객세 생성, 의존성 주입 이후 실행
        System.out.println("afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        // ctx.close() 호출시 호출, 스프링 컨테이너 소멸 전 실행
        // 자원 해제
        System.out.println("destroy()");
    }
}
