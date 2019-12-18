package com.example.demo.skuList;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.constraints.Null;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 杨久鹏  查询商品
 *
 */
@RestController
@RequestMapping("/common")
public class SkuListController {

	@RequestMapping(value = "skuList", method = RequestMethod.GET)
	public Object getBypara1(@RequestParam(required = false) String goodsId) {

		Map<Integer, Sku> goods = new HashMap<Integer, Sku>();
		goods.put(1, new Sku(1, "手机", "100"));
		goods.put(2, new Sku(2, "电脑", "200"));
		goods.put(3, new Sku(3, "鼠标", "50"));
		goods.put(4, new Sku(4, "键盘", "60"));
		if (goodsId != null) {
			if (goodsId.matches("\\d+")) {
				try {
					Integer.parseInt(goodsId);
					if (Integer.parseInt(goodsId) > goods.size()) {
						return new ResultFail(201, "商品ID不存在");
					} else {
						return new ResultSuccess(200, "success", goods.get(Integer.parseInt(goodsId)));
					}
				} catch (Exception e) {
					return new ResultFail(400, "商品ID不正确");
				}
			} else {
				return new ResultFail(400, "商品ID参数类型不正确");
			}
		} else {
			return new ResultSuccess(200, "success", goods);
		}

	}

}
