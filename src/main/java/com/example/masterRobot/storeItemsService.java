package com.example.masterRobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;

@Service
public class storeItemsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//        public List<store_items> list() {
//            return null;
//        }

        public void save(store_items storeItem) {
        }

        public store_items get(int id) {
            return null;
        }

        public void update(store_items storeItem) {
        }

        public void delete(int id) {
        }

        public List<store_items> list() {
        String sql = "SELECT * FROM store_items";

        List<store_items> listItems = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(store_items.class));
        return listItems;
        }
}
