package com.example.masterRobot.service;

import com.example.masterRobot.entity.store_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.masterRobot.repository.storeItemRepository;

import java.util.List;

@Service
public class storeItemsService {

    @Autowired
    storeItemRepository repo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//        public List<store_items> list() {
//            return null;
//        }

        public void save(store_items storeItem) {
        }

        public store_items get(long id) {

            return repo.findById(id).get();
        }

        public void update(store_items storeItem) {
        }

        public void delete(long id) {
        }

        public List<store_items> list() {
        String sql = "SELECT * FROM store_items";

        List<store_items> listItems = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(store_items.class));
        System.out.println("store_items service "+listItems);
        return listItems;
        }


}
