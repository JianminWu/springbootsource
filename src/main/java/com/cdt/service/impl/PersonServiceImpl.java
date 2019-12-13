package com.cdt.service.impl;

import com.cdt.dao.PersonRepository;
import com.cdt.dto.PersonDto;
import com.cdt.entity.Person;
import com.cdt.validation.CRUDGroup;
import com.cdt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:15
 * @Function:
 * @Version 1.0
 */
@Service
@Validated
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Long create(PersonDto personDto) {
        Person person = personDto.to(Person.class);
        return personRepository.save(person).getId();
    }


    @Override
    public Long update(PersonDto personDto) {
        Person person = personDto.to(Person.class);
        return personRepository.save(person).getId();
    }

    @Override
    public PersonDto findById(Long id) {
        return personRepository.findById(id).get().to(PersonDto.class);
    }
}
