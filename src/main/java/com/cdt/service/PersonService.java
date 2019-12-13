package com.cdt.service;

import com.cdt.dto.PersonDto;
import org.springframework.validation.annotation.Validated;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:08
 * @Function:
 * @Version 1.0
 */
@Validated
public interface PersonService {

    Long create(PersonDto personDto);

    Long update(PersonDto personDto);

    PersonDto findById(Long id);
}
