package hello.item_service.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * FAST : 빠른 배송
 * NORMAL : 일반 배송
 * SLOW : 느림 배송
 * */
@AllArgsConstructor
@Getter
public class DeliveryCode {

	private String code;
	private String displayName;
}
