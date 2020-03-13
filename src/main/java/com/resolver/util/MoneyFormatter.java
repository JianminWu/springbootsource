package com.resolver.util;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;

public class MoneyFormatter implements Formatter<Money> {
  @Override
  public Money parse(String text, Locale locale) throws ParseException {
    if (StringUtils.isEmpty(text)) {
      return null;
    } else {
      return new Money(text);
    }
  }

  @Override
  public String print(Money object, Locale locale) {
    if (object == null) {
      return null;
    }
    return object.getAmount().toString();
  }
}
