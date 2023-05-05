package com.ritesh.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;

	@NotBlank
	@Size(min = 3, message = "name must be min of 3 characters!")
	private String name;

	@Email(message = "please, enter valid email!")
	private String email;

	@NotBlank
	@Size(min = 3, max = 10, message = "password must be 3 to 10 character!")
	private String password;

	@NotBlank(message = "please enter about!")
	private String about;
}
