package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Setter
// public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {
	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
	}

	private void call(String message) {
		System.out.println("call : " + url + " message = " + message);
	}

	private void connect() {
		System.out.println("connect : " + url);
	}

	public void disconnect() {
		System.out.println("close : " + url);
	}

	// @Override
	// public void destroy() throws Exception {
	// 	disconnect();
	// }
	//
	// @Override
	// public void afterPropertiesSet() throws Exception {
	// 	connect();
	// 	call("초기화 연결 메시지");
	// }

	@PostConstruct
	public void init() throws Exception {
		connect();
		call("초기화 연결 메시지");
	}

	@PreDestroy
	public void close() throws Exception {
		disconnect();
	}
}
