package com.example.demo.practice1;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Test02Request {
	@Schema(description = "example string", example = "hello")
	@NotBlank
	private String str;
	
	@Schema(description = "example string2", example = "hello2")
	private String str2;

	@Parameter(name = "example number", description = "example description", example = "123")
	@NotNull
	private BigDecimal num;

	@Schema(description = "example number", required = true)
	@NotEmpty
	private List<String> list;
}
