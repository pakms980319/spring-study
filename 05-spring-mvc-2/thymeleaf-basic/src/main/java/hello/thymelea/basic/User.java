package hello.thymelea.basic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String username;
	private int age;
}
