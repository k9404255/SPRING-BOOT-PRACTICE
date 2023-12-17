package com.example.demo.practice2;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Test02Response {
	@Schema(description = "example string", required = true)
	String str;

	@Parameter(name = "example number", required = false, allowEmptyValue = true)
	BigDecimal number;

	@Schema(description = "example number", required = true)
	List<String> list;
}
