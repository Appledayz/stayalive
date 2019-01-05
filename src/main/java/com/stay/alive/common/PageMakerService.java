package com.stay.alive.common;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PageMakerService {
	public static PageMaker pageMakerService(PageMaker pageMaker) {
		pageMaker.setRowPerPage(6); // 한 페이지에서 보이는 레코드의 개수
		pageMaker.setPagePerBlock(3); // 한 블럭에서 보이는 페이지의 개수
		// 페이징에 필요한 값 계산하여 설정
		pageMaker.setStartRow();
		pageMaker.setLastPage();
		pageMaker.setCurrentBlock();
		pageMaker.setLastBlock();
		pageMaker.setStartPage();
		pageMaker.setEndPage();
		// 이전 페이지와 다음 페이지를 컨트롤하는 조건문
		if(pageMaker.getLastPage() < pageMaker.getPagePerBlock() + 1) {
			pageMaker.setPrevPage(false);
			pageMaker.setNextPage(false);
		} else if(pageMaker.getCurrentPage() > 0 && pageMaker.getCurrentPage() < pageMaker.getPagePerBlock() + 1) {
			pageMaker.setPrevPage(false);
			pageMaker.setNextPage(true);
		} else if(pageMaker.getLastBlock() == pageMaker.getCurrentBlock()) {
			pageMaker.setPrevPage(true);
			pageMaker.setNextPage(false);
		} else {
			pageMaker.setPrevPage(true);
			pageMaker.setNextPage(true);	
		}
		return pageMaker;
	}

}
