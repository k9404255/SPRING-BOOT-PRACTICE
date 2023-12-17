package com.example.demo.practice2;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class GetMethodResponse {
	@Parameter(name = "結果", required = true, allowEmptyValue = false)
	String result;
}
