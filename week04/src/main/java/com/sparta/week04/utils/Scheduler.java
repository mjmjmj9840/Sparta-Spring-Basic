package com.sparta.week04.utils;

import com.sparta.week04.models.ItemDto;
import com.sparta.week04.models.Product;
import com.sparta.week04.models.ProductRepository;
import com.sparta.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component // 스프링이 필요 시 자동으로 생성하는 클래스 목록에 추가
public class Scheduler {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final NaverShopSearch naverShopSearch;

    // 초, 분, 시, 일, 월, 주 순서
    @Scheduled(cron = "0 0 1 * * *")
    public void updatePrice() throws InterruptedException {
        System.out.println("가격 업데이트 실행");
        // 저장된 모든 관심상품을 조회
        List<Product> productList = productRepository.findAll();
        for (int i=0; i<productList.size(); i++) {
            // Naver 제한으로 1초에 한 상품씩 조회 가능
            TimeUnit.SECONDS.sleep(1);

            Product p = productList.get(i);
            String title = p.getTitle();

            String result = naverShopSearch.search(title);
            List<ItemDto> itemDtoList = naverShopSearch.fromJSONtoItems(result);
            ItemDto itemDto = itemDtoList.get(0);
            Long id = p.getId();

            productService.updateBySearch(id, itemDto);
        }
    }
}