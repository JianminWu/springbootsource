package com.cdt.dao;

import com.cdt.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:22
 * @Function:
 * @Version 1.0
 */
@Repository
public interface PersonRepository  extends JpaRepository<Person,Long> {
}
