package com.resolver.util;

import java.text.DecimalFormat;

public class MoneyUtil {

	private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";

	private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";

	private static final double MAX_VALUE = 9999999999999.99D;

	public static Money zero() {
		return new Money();
	}

	public static String format(Money money) {
		if (money == null) {
			throw new IllegalArgumentException("金额不能为null");
		}
		DecimalFormat fmt = new DecimalFormat("##,###,###,###,###.00");
		String result = fmt.format(money.getAmount().doubleValue());
		if (result.indexOf(".") == 0) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * 金额转大写，不能为负数金额
	 * @param money
	 * @return
	 */
	public static String getCHSNumber(Money money) {
		double v = money.getAmount().doubleValue();
		if (v < 0 || v > MAX_VALUE) {
			return "金额需在0-9999999999999.99之间";
		}
		long l = Math.round(v * 100);
		if (l == 0) {
			return "零元整";
		}
		String strValue = l + "";
		// i用来控制数
		int i = 0;
		// j用来控制单位
		int j = UNIT.length() - strValue.length();
		String rs = "";
		boolean isZero = false;
		for (; i < strValue.length(); i++, j++) {
			char ch = strValue.charAt(i);
			if (ch == '0') {
				isZero = true;
				if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
					rs = rs + UNIT.charAt(j);
					isZero = false;
				}
			} else {
				if (isZero) {
					rs = rs + "零";
					isZero = false;
				}
				rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
			}
		}
		if (!rs.endsWith("分") && !rs.endsWith("角")) {
			rs = rs + "整";
		}
		rs = rs.replaceAll("亿万", "亿");
		return rs;
	}

	/**
	 * 金额转大写，可以为负数金额
	 * @param m
	 * @return
	 */
	public static String getCHSIncludeMinus(Money m) {
		String chs = "";
		//如果金额<0
		if (m.compareTo(new Money(0)) < 0) {
			m = m.multiply(-1);
			chs = "(负数)" + getCHSNumber(m);
		} else {
			chs = getCHSNumber(m);
		}
		return chs;
	}

}