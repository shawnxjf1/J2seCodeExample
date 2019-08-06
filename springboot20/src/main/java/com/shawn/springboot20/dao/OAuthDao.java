package com.shawn.springboot20.dao;

import com.shawn.springboot20.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class OAuthDao {
    //FIXME 数据库加载<br>
//    @Autowired
    //private JdbcTemplate jdbcTemplate;

    public UserEntity getUserDetails(String username) {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        String userSQLQuery = "SELECT * FROM USERS WHERE USERNAME=?";
//        List<UserEntity> list = jdbcTemplate.query(userSQLQuery, new String[]{username},
//                (ResultSet rs, int rowNum) -> {
//
//                    UserEntity user = new UserEntity();
//                    user.setUsername(username);
//                    user.setPassword(rs.getString("PASSWORD"));
//                    return user;
//                });
//        if (list.size() > 0) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
//            grantedAuthoritiesList.add(grantedAuthority);
//            list.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
//            return list.get(0);
//        }
        return null;
    }
}
