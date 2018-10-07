package id.co.mp.midleware.repositories;

import id.co.mp.midleware.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private static final Logger console = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<User> list() {
        StringBuilder queryBuilder = new StringBuilder();
        MapSqlParameterSource params = new MapSqlParameterSource();

        queryBuilder.append("select " +
                "   u.id            as id, " +
                "   u.email         as email, " +
                "   u.app           as app, " +
                "   u.nama          as nama, " +
                "   u.jabatan       as jabatan " +
                "from " +
                "   users u ");

        console.debug("query listUser: {}", queryBuilder.toString());
        return jdbcTemplate.query(queryBuilder.toString(), params, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return new User(
                        rs.getInt("id"),
                        rs.getString("emaill"),
                        rs.getString("nama"),
                        rs.getString("jabatan"),
                        rs.getString("app"));
            }
        });
    }

    public void save(User param) {
        String queryBuilder = "insert into users "
                + "     (email, password, nama, jabatan, app) "
                + " values "
                + "     (:email, :password, :nama, :jabatan, :app);";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", param.getEmail());
        paramMap.put("password", param.getPassword());
        paramMap.put("nama", param.getNama());
        paramMap.put("jabatan", param.getJabatan());
        paramMap.put("app", param.getApp());
        jdbcTemplate.update(queryBuilder, paramMap);
    }

    public void update(User param) {
        String queryBuilder = "update users " +
                "   set nama = :nama, " +
                "       jabatan = :jabatan, " +
                "       app = :app " +
                "   where " +
                "       id = :id ";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", param.getId());
        paramMap.put("nama", param.getNama());
        paramMap.put("jabatan", param.getJabatan());
        paramMap.put("app", param.getApp());
        jdbcTemplate.update(queryBuilder, paramMap);
    }

    public void changePasswd(User param) {
        String queryBuilder = "update users " +
                "   set password = :password " +
                "   where " +
                "       id = :id ";

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", param.getId());
        paramMap.put("password", param.getPassword());
        jdbcTemplate.update(queryBuilder, paramMap);
    }
}
