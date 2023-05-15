package models.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT INTO EMP2 (EMPNO, ENAME, JOB) VALUES (?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, 1, "사원1", "STAFF");
        System.out.println(affectedRows);
    }
}
