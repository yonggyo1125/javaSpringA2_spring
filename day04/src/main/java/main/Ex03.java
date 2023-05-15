package main;

import configs.AppCtx;
import models.emp.Emp;
import models.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Ex03 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        EmpDao empDao = ctx.getBean(EmpDao.class);
        //List<Emp> emps = empDao.gets();
        //emps.stream().forEach(System.out::println);
        Emp emp = empDao.get(7368);
        System.out.println(emp);

        ctx.close();
    }
}
