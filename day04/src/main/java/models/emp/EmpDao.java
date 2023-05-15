package models.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT INTO EMP2 (EMPNO, ENAME, JOB) VALUES (?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, 2, "사원2", "STAFF");
        System.out.println(affectedRows);
    }

    public void delete(int no) {
        String sql = "DELETE FROM EMP2 WHERE EMPNO = ?";
        int affectedRows = jdbcTemplate.update(sql, no);
        System.out.println(affectedRows);
    }

    public List<Emp> gets() {
        String sql = "SELECT * FROM EMP";
       List<Emp> emps = jdbcTemplate.query(sql, this::mapper);

       return emps;
    }

    public Emp get(long EMPNO) {
        try {
            String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
            Emp emp = jdbcTemplate.queryForObject(sql, this::mapper, EMPNO);

            return emp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Emp mapper(ResultSet rs, int i) throws SQLException {
        Emp emp = new Emp();
        emp.setEMPNO(rs.getLong("EMPNO"));
        emp.setENAME(rs.getString("ENAME"));
        emp.setJOB(rs.getString("JOB"));

        return emp;
    }
}
