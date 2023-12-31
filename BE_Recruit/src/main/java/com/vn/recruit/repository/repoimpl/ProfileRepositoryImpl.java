package com.vn.recruit.repository.repoimpl;

import com.vn.recruit.entity.Profile;
import com.vn.recruit.entity.User;
import com.vn.recruit.repository.BaseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepositoryImpl extends BaseRepository {
    public Profile getProfileByUser(User user){
        String sql="SELECT * from profiles p WHERE p.user_id=?";
        Profile profile= (Profile) getJdbcTemplate().queryForObject(sql,new Object[]{user.getId()},new BeanPropertyRowMapper(Profile.class));
        return profile;

    }
}
