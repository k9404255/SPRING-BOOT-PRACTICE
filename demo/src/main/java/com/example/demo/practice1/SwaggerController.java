package com.example.demo.practice1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Swagger測試Controller")
@RequestMapping("/practice1")
public class SwaggerController {

	@PostMapping(value = "01")
	@Operation(summary = "測試方法一", description = "測試方法一 blah blah")
	public String test01() {
		return "Spring Boot!!";
	}

	@PostMapping(value = "02")
	@Operation(summary = "測試方法二", description = "測試方法二 blah blah")
	public Test02Response test02(@Valid @RequestBody Test02Request request) {
		Test02Response response = new Test02Response();
		response.setStr(request.getStr());
		response.setNumber(request.getNum());
		response.setList(request.getList());

		return response;
	}

	@GetMapping(value = "03")
	@Operation(summary = "測試方法三", description = "測試方法三 blah blah")
	public String test03() {
		return "Hello World!!";
	}

	@GetMapping("/{id}")
	public GetMethodResponse test04(@PathVariable("id") String id) {
		GetMethodResponse response = new GetMethodResponse();
		response.setResult(id);

		return response;
	}

	@GetMapping
	public GetMethodResponse test05(
			@Parameter(description = "param1", required = false, allowEmptyValue = true) @RequestParam(name = "param1", required = false) String param1) {
		GetMethodResponse response = new GetMethodResponse();
		response.setResult(param1);

		return response;
	}
}
